<template>
    <CrudComponent
      ref="crudComponent"
      title="Libros"
      :items="libros"
      :current-item="currentItem"
      @save="saveLibros"
      @delete="deleteLibros"
      @edit="editLibros"
    >
      <template #form>
        <ion-item>
          <ion-label position="floating">Titulo</ion-label>
          <ion-input v-model="currentItem.titulo"></ion-input>
        </ion-item>
        <ion-item>
          <ion-label position="floating">Autor</ion-label>
          <ion-input v-model="currentItem.autor"></ion-input>
        </ion-item>
        <ion-item>
          <ion-label position="floating">Categoria</ion-label>
          <ion-input v-model="currentItem.categoria"></ion-input>
        </ion-item>
      </template>
    </CrudComponent>
  </template>
  
  <script>
  import CrudComponent from '@/components/CrudComponent.vue';
  import { getAllLibros, saveLibros, updateLibros, deleteLibros } from '@/services/libros-service';
  import {
    IonItem,
    IonLabel,
    IonInput,
    IonButton,
    IonModal,
    IonHeader,
    IonToolbar,
    IonTitle,
    IonContent,
    IonPage,
    IonCard,
    IonCardHeader,
    IonCardTitle,
    IonCardContent,
    IonIcon
  } from '@ionic/vue';
  
  export default {
    name: 'LibrosPage',
    components: {
      CrudComponent,
      IonItem,
      IonLabel,
      IonInput,
      IonButton,
      IonModal,
      IonHeader,
      IonToolbar,
      IonTitle,
      IonContent,
      IonPage,
      IonCard,
      IonCardHeader,
      IonCardTitle,
      IonCardContent,
      IonIcon
    },
    data() {
      return {
        currentItem: {
          id: null,
          titulo: '',
          autor: '',
          categoria: '',
        },
        libros: []
      };
    },
    async mounted() {
      await this.loadLibros();
    },
    methods: {
      async loadLibros() {
        try {
          this.libros = await getAllLibros();
        } catch (error) {
          console.error('Error al cargar libros:', error);
          alert('Error al cargar la lista de libros');
        }
      },
      async saveLibros() {
        try {
          if (this.currentItem.id) {
            await updateLibros(this.currentItem,this.currentItem.id);
          } else {
            await saveLibros(this.currentItem);
          }
          await this.loadLibros();
          this.resetForm();
        } catch (error) {
          console.error('Error al guardar libros:', error);
          alert('Error al guardar el libros');
        }
      },
      async deleteLibros(id) {
        try {
          await deleteLibros(id);
          await this.loadLibros();
        } catch (error) {
          console.error('Error al eliminar libros:', error);
          alert('Error al eliminar el libros');
        }
      },
      editLibros(libros) {
        this.currentItem = { ...libros }; // Copiar los datos de libros a currentItem
        this.$refs.crudComponent.openEditModal(); // Llamar al método en CrudComponent para abrir el modal
      },
      resetForm() {
        this.currentItem = { id: null, titulo: '', autor: '', categoria: ''};
      }
    }
  };
  </script>
  
  <style scoped>
  .button-group {
    display: flex;
    justify-content: flex-end;
    gap: 6px;
    margin-top: 8px;
  }
  
  ion-item {
    --padding-start: 16px;
    --inner-padding-top: 0x; 
    --inner-padding-bottom: 0px;
  }
  
  ion-label {
    line-height: 0.2; 
  }
  </style>
  