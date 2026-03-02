import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'

export default defineConfig({
  plugins: [vue()],
  base: '/Lab2-1.0-SNAPSHOT/',
  build: {
    outDir: 'dist',
    emptyOutDir: true
  },
  server: {
    proxy: {
      '/api': {
        target: 'http://localhost:9090/Lab2-1.0-SNAPSHOT',
        changeOrigin: true,
        secure: false
      }
    }
  }
})