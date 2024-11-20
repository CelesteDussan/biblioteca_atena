<template>
  <CrudComponent
    ref="crudComponent"
    title="Prestamos"
    :items="processedPrestamos"
    :current-item="currentItem"
    @save="savePrestamos"
    @delete="deletePrestamos"
    @edit="editPrestamos"
  >
    <template #form>
      <ion-item>
        <ion-label position="floating">Estado</ion-label>
        <ion-select v-model="currentItem.estado" interface="popover">
          <ion-select-option
            v-for="option in estadoOptions"
            :key="option"
            :value="option"
          >
            {{ option }}
          </ion-select-option>
        </ion-select>
      </ion-item>
      <ion-item>
        <ion-label position="floating">Libros</ion-label>
        <ion-select v-model="currentItem.librosId.id" interface="popover">
          <ion-select-option
            v-for="libros in libros"
            :key="libros.id"
            :value="libros.id"
          >
            {{ libros.titulo }}
          </ion-select-option>
        </ion-select>
      </ion-item>
      <ion-item>
        <ion-label position="floating">Cantidad</ion-label>
        <ion-input v-model="currentItem.cantidad" type="number"></ion-input>
      </ion-item>
      <ion-item>
        <ion-label position="floating">Clientes</ion-label>
        <ion-select v-model="currentItem.clientesId.id" interface="popover">
          <ion-select-option
            v-for="clientes in clientes"
            :key="clientes.id"
            :value="clientes.id"
          >
            {{ clientes.nombre }}
          </ion-select-option>
        </ion-select>
      </ion-item>
      <ion-item>
        <ion-label position="floating">Fecha Prestamo</ion-label>
        <ion-datetime
          v-model="currentItem.fechaPrestamo"
          display-format="YYYY-MM-DD"
          placeholder="Selecciona una fecha"
        ></ion-datetime>
      </ion-item>
      <ion-item>
        <ion-label position="floating">Fecha Devolucion</ion-label>
        <ion-datetime
          v-model="currentItem.fechaDevolucion"
          display-format="YYYY-MM-DD"
          placeholder="Selecciona una fecha"
        ></ion-datetime>
      </ion-item>
    </template>
  </CrudComponent>
</template>

<script>
import CrudComponent from '@/components/CrudComponent.vue';
import { getAllPrestamos, savePrestamos, updatePrestamos, deletePrestamos } from '@/services/prestamos-service';
import { getAllClientes } from '@/services/clientes-service';
import { getAllLibros } from '@/services/libros-service';
import {
  IonItem,
  IonLabel,
  IonInput,
  IonButton,
  IonSelect,
  IonSelectOption,
  IonDatetime,
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
  name: 'PrestamosPage',
  components: {
    CrudComponent,
    IonItem,
    IonLabel,
    IonInput,
    IonButton,
    IonSelect,
    IonSelectOption,
    IonDatetime,
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
          librosId: { id: null },
          cantidad: null,
          clientesId: { id: null },
          fechaPrestamo: null,
          estado: null,
          fechaDevolucion: null
        },
        Prestamos: [],
        clientes: [],
        libros: [],
        processedPrestamos: [], // Lista procesada para mostrar en CrudComponent
        estadoOptions: ["Prestamo", "Devolucion"] // Opciones para el campo estado
      };
    },
    async mounted() {
      await this.loadPrestamos();
      await this.loadClientes();
      await this.loadLibros();
    },
    methods: {
      async loadPrestamos() {
        try {
          const prestamosData = await getAllPrestamos();

          // Procesar la data para que solo contenga los campos necesarios
          this.processedPrestamos= prestamosData.map((item, index) => ({
            id: item.id,
            estado: item.estado,
            librosId: item.librosId,
            cantidad: item.cantidad,
            clientesId: item.clientesId,
            fechaPrestamo: item.fechaPrestamo,
            fechaDevolucion: item.fechaDevolucion
          }));
        } catch (error) {
          console.error('Error al cargar prestamos del cliente:', error);
          alert('Error al cargar la lista de prestamos del cliente');
        }
      },
      async loadClientes() {
        try {
          this.clientes = await getAllClientes();
        } catch (error) {
          console.error('Error al cargar clientes:', error);
          alert('Error al cargar la lista de clientes');
        }
      },
      async loadLibros() {
        try {
          this.libros = await getAllLibros();
        } catch (error) {
          console.error('Error al cargar libros:', error);
          alert('Error al cargar la lista de libros');
        }
      },
      async savePrestamos() {
        try {
          if (this.currentItem.id) {
            await updatePrestamos(this.currentItem, this.currentItem.id);
          } else {
            await savePrestamos(this.currentItem);
          }
          await this.loadPrestamos();
          this.resetForm();
        } catch (error) {
          console.error('Error al guardar prestamos del cliente:', error);
          alert('Error al guardar los prestamos del cliente');
        }
      },
      async deletePrestamos(id) {
        try {
          await deletePrestamos(id);
          await this.loadPrestamos();
        } catch (error) {
          console.error('Error al eliminar prestamos del cliente:', error);
          alert('Error al eliminar los prestamos del cliente');
        }
      },
      editPrestamos(prestamos) {
        this.currentItem = { ...prestamos};
        this.$refs.crudComponent.openEditModal();
      },
      resetForm() {
        this.currentItem = { id: null, librosId: { id: null }, cantidad: null, clientesId: { id: null }, fechaPrestamo: null, estado: null, fechaDevolucion: null };

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
    --inner-padding-top: 0px;
    --inner-padding-bottom: 0px;
  }
  
  ion-label {
    line-height: 0.2;
  }
  </style>
  