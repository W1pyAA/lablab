<script setup>
import axios from "axios";
import { ref, onMounted } from "vue";

const phones = ref([]);
const errorMessage = ref(""); // Змінна для виводу помилки на екран
const isLoading = ref(true);  // Змінна для статусу завантаження

onMounted(() => {
  // Звертаємося до бекенду
  axios.get("http://localhost:9090/api/phones")
    .then(response => {
      // Якщо бекенд віддав дані успішно
      phones.value = response.data._embedded.phones;
      isLoading.value = false;
    })
    .catch(error => {
      // Якщо сталась помилка (CORS, вимкнений бекенд, неправильна адреса)
      console.error("Деталі помилки:", error);
      errorMessage.value = "Помилка зв'язку з бекендом! Перевір, чи запущений сервер на порту 9090 і чи дозволений CORS.";
      isLoading.value = false;
    });
});
</script>

<template>
  <div style="font-family: Arial, sans-serif; padding: 20px;">
    <h1>Каталог мобільних телефонів</h1>

    <p v-if="isLoading" style="font-size: 18px; color: #2980b9;">Завантаження даних...</p>

    <p v-if="errorMessage" style="font-size: 18px; color: #c0392b; font-weight: bold;">
      {{ errorMessage }}
    </p>

    <div v-if="!isLoading && !errorMessage" style="display: flex; gap: 20px; flex-wrap: wrap;">
      <div 
        v-for="(phone, index) in phones" 
        :key="phone.id || index" 
        style="border: 1px solid #ccc; padding: 15px; border-radius: 8px; background-color: #f9f9f9;"
      >
        <img 
          :src="phone.imageUrl" 
          alt="Фото" 
          style="max-width: 150px; height: auto; margin-bottom: 10px; display: block;" 
          v-if="phone.imageUrl"
        >
        <h2 style="margin: 0 0 10px 0; font-size: 20px;">{{ phone.brand }} {{ phone.model }}</h2>
        <p style="font-size: 18px; font-weight: bold; color: #2c3e50; margin: 0;">Ціна: {{ phone.price }} грн</p>
      </div>
    </div>
  </div>
</template>