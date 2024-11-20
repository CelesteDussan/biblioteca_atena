<template>
  <CrudComponent
    ref="crudComponent"
    title="Clientes"
    :items="clientes"
    :current-item="currentItem"
    @save="saveClientes"
    @delete="deleteClientes"
    @edit="editClientes"
  >
    <template #form>
      <ion-item>
        <ion-label position="floating">Nombre</ion-label>
        <ion-input v-model="currentItem.nombre"></ion-input>
      </ion-item>
      <ion-item>
        <ion-label position="floating">Cedula</ion-label>
        <ion-input v-model="currentItem.cedula"></ion-input>
      </ion-item>
      <ion-item>
        <ion-label position="floating">Telefono</ion-label>
        <ion-input v-model="currentItem.telefono"></ion-input>
      </ion-item>
      <ion-item>
        <ion-label position="floating">Email</ion-label>
        <ion-input v-model="currentItem.email"></ion-input>
      </ion-item>
    </template>
  </CrudComponent>
</template>

<script>
import CrudComponent from '@/components/CrudComponent.vue';
import { getAllClientes, saveClientes, updateClientes, deleteClientes } from '@/services/clientes-service';
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
  name: 'ClientesPage',
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
        cedula: '',
        nombre: '',
        email: '',
        telefono: ''
      },
      clientes: []
    };
  },
  async mounted() {
    await this.loadClientes();
  },
  methods: {
    async loadClientes() {
      try {
        this.clientes = await getAllClientes();
      } catch (error) {
        console.error('Error al cargar clientes:', error);
        alert('Error al cargar la lista de clientes');
      }
    },
    async saveClientes() {
      try {
        if (this.currentItem.id) {
          await updateClientes(this.currentItem,this.currentItem.id);
        } else {
          await saveClientes(this.currentItem);
        }
        await this.loadClientes();
        this.resetForm();
      } catch (error) {
        console.error('Error al guardar clientes:', error);
        alert('Error al guardar el clientes');
      }
    },
    async deleteClientes(id) {
      try {
        await deleteClientes(id);
        await this.loadClientes();
      } catch (error) {
        console.error('Error al eliminar clientes:', error);
        alert('Error al eliminar el clientes');
      }
    },
    editClientes(clientes) {
      this.currentItem = { ...clientes }; // Copiar los datos de clientes a currentItem
      this.$refs.crudComponent.openEditModal(); // Llamar al método en CrudComponent para abrir el modal
    },
    resetForm() {
      this.currentItem = { id: null, cedula: '', nombre: '', email: '', telefono: '' };
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
