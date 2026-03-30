package org.example;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ProductService {
    private final String filePath;
    private final Gson gson = new Gson();

    public ProductService(String filePath) {
        this.filePath = filePath;
        File file = new File(filePath);
        if (!file.exists()) {
            saveData(new ArrayList<>());
        }
    }

    public List<CleaningProduct> getAll() {
        try (Reader reader = new FileReader(filePath)) {
            Type listType = new TypeToken<ArrayList<CleaningProduct>>(){}.getType();
            List<CleaningProduct> list = gson.fromJson(reader, listType);
            return list != null ? list : new ArrayList<>();
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    public void add(CleaningProduct product) {
        List<CleaningProduct> list = getAll();
        product.setId(list.stream().mapToInt(CleaningProduct::getId).max().orElse(0) + 1);
        list.add(product);
        saveData(list);
    }
    public void update(CleaningProduct updatedProduct) {
        List<CleaningProduct> list = getAll();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == updatedProduct.getId()) {
                list.set(i, updatedProduct);
                break;
            }
        }
        saveData(list);
    }

    public void delete(int id) {
        List<CleaningProduct> list = getAll();
        list.removeIf(p -> p.getId() == id);
        saveData(list);
    }

    private void saveData(List<CleaningProduct> list) {
        try (Writer writer = new FileWriter(filePath)) {
            gson.toJson(list, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}