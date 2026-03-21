<script setup>
import axios from "axios";
import { ref, onMounted } from "vue";

const phones = ref([]);

onMounted(() => {
  axios.get("http://localhost:9090/api/phones")
    .then(response => {
      phones.value = response.data;
    })
    .catch(error => console.error("Помилка завантаження", error));
});
</script>

<template>
  <div style="font-family: Arial, sans-serif; padding: 20px;">
    <h1>Каталог мобільних телефонів</h1>
    <div style="display: flex; gap: 20px; flex-wrap: wrap;">
      <div v-for="phone in phones" :key="phone.id" style="border: 1px solid #ccc; padding: 15px; border-radius: 8px; width: 250px; text-align: center;">
        <img :src="phone.imageUrl" alt="Фото" style="max-width: 150px; height: auto; margin-bottom: 10px;" v-if="phone.imageUrl"/>
        <h2 style="margin: 0 0 10px 0;">{{ phone.brand }} {{ phone.model }}</h2>
        <p style="font-size: 18px; font-weight: bold; color: #2c3e50;">Ціна: {{ phone.price }} грн</p>
      </div>
    </div>
  </div>
</template>