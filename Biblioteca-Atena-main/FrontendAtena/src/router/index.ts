import { createRouter, createWebHistory } from '@ionic/vue-router';
import { RouteRecordRaw } from 'vue-router';
import HomePage from '../views/HomePage.vue'
import ClientesPage from '@/views/ClientesPage.vue';
import LibrosPage from '@/views/LibrosPage.vue';
import PrestamosPage from '@/views/PrestamosPage.vue';

const routes: Array<RouteRecordRaw> = [
  {
    path: '/',
    redirect: '/home'
  },
  {
    path: '/home',
    name: 'Home',
    component: HomePage
  },
  {
    path: '/clientes',
    name: 'Clientes',
    component: ClientesPage
  },
  {
    path: '/libros',
    name: 'Libros',
    component: LibrosPage
  },
  {
    path: '/prestamos',
    name: 'Prestamos',
    component: PrestamosPage
  },
];

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes
});

export default router;
