<template>
  <div class="container">
    <h1>Побутова хімія (CRUD)</h1>

    <div class="form-section">
      <h3>{{ isEditing ? 'Редагувати товар' : 'Додати новий товар' }}</h3>
      <input v-model="form.name" placeholder="Назва" />
      <input v-model="form.brand" placeholder="Бренд" />
      <input v-model="form.purpose" placeholder="Призначення" />
      <input v-model="form.price" type="number" placeholder="Ціна" />
      <input v-model="form.volume" placeholder="Об'єм" />
      <button @click="saveProduct">{{ isEditing ? 'Оновити' : 'Додати' }}</button>
      <button v-if="isEditing" @click="cancelEdit" class="cancel-btn">Скасувати</button>
    </div>

    <div class="products-grid">
      <div v-for="product in products" :key="product.id" class="product-card">
        <h2>{{ product.name }}</h2>
        <p><strong>Бренд:</strong> {{ product.brand }}</p>
        <p><strong>Призначення:</strong> {{ product.purpose }}</p>
        <p><strong>Об'єм:</strong> {{ product.volume }}</p>
        <p class="price">{{ product.price }} грн</p>
        <div class="actions">
          <button @click="editProduct(product)" class="edit-btn">Редагувати</button>
          <button @click="deleteProduct(product.id)" class="delete-btn">Видалити</button>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'

const products = ref([])
const API_URL = '/Lab2-1.0-SNAPSHOT/api/products' // Зміни на Lab2, якщо архів називається Lab2

const form = ref({ id: null, name: '', brand: '', purpose: '', price: null, volume: '' })
const isEditing = ref(false)

const fetchProducts = async () => {
  const res = await fetch(API_URL)
  products.value = await res.json()
}

const saveProduct = async () => {
  const method = isEditing.value ? 'PUT' : 'POST'
  await fetch(API_URL, {
    method: method,
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(form.value)
  })
  form.value = { id: null, name: '', brand: '', purpose: '', price: null, volume: '' }
  isEditing.value = false
  fetchProducts()
}

const deleteProduct = async (id) => {
  await fetch(`${API_URL}?id=${id}`, { method: 'DELETE' })
  fetchProducts()
}

const editProduct = (product) => {
  form.value = { ...product }
  isEditing.value = true
}

const cancelEdit = () => {
  form.value = { id: null, name: '', brand: '', purpose: '', price: null, volume: '' }
  isEditing.value = false
}

onMounted(() => fetchProducts())
</script>

<style scoped>
/* Стилі для всього контейнера сторінки */
.container {
  max-width: 1000px;
  margin: 0 auto;
  padding: 40px 20px; /* Трохи більше відступів зверху */
  font-family: Arial, sans-serif;
  color: #333; /* Явно встановлюємо темний колір для всього тексту */
  text-align: center; /* Центруємо вміст, як на твоїх скріншотах */
}

/* Стиль для головного заголовка */
h1 {
  color: #2c3e50;
  margin-bottom: 30px;
}

/* Стилі для карток товарів */
.product-card {
  border: 2px solid #007bff; /* Синє обведення, як на твоїх скріншотах */
  border-radius: 8px;
  padding: 20px;
  background-color: #f9f9f9; /* Світло-сірий фон для контрасту */
  box-shadow: 0 4px 6px rgba(0,0,0,0.1);
  display: inline-block; /* Щоб картка не розтягувалася на всю ширину */
  text-align: left; /* Текст всередині картки - по лівому краю */
}

.product-card h2 {
  font-size: 1.5rem;
  color: #007bff;
  margin-top: 0;
  margin-bottom: 15px;
}

.product-card p {
  margin: 10px 0;
  font-size: 1.1rem;
}

.price {
  font-size: 1.6rem;
  font-weight: bold;
  color: #28a745;
  margin-top: 20px;
}

/* Додатковий стиль, щоб прибрати будь-які глобальні темні фони (наприклад, від Vite) */
:global(body) {
  background-color: white !important;
  color: black !important;
}
</style>