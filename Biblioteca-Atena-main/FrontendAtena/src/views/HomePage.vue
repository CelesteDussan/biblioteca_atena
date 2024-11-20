<template>
  <ion-page>
    <ion-header>
      <ion-toolbar>
        <ion-title>Biblioteca Atena</ion-title>
      </ion-toolbar>
    </ion-header>
    <ion-content :fullscreen="true">
      <ion-grid>
        <ion-row>
          <CardComponent
            title="Clientes"
            description="Administrar clientes registrados en el sistema."
            buttonText="Gestionar Clientes"
            pageLink="/clientes"
            imageSrc="/src/image/Clientes.png"
          />
          <CardComponent
            title="Libros"
            description="Administrar libros disponibles en el sistema."
            buttonText="Gestionar Libros"
            pageLink="/libros"
            imageSrc="/src/image/Libros.png"
          />
          <CardComponent
            title="Prestamos"
            description="Administrar prestamos de libros prestados a clientes."
            buttonText="Gestionar Prestamos"
            pageLink="/prestamos"
            imageSrc="/src/image/Prestamos.png"
          />
        </ion-row>
      </ion-grid>
    </ion-content>
  </ion-page>
</template>

<script>
import { IonPage, IonHeader, IonToolbar, IonTitle, IonContent, IonGrid, IonRow } from '@ionic/vue';
import CardComponent from '@/components/CardComponent.vue';

export default {
  name: 'HomePage',
  components: {
    IonPage,
    IonHeader,
    IonToolbar,
    IonTitle,
    IonContent,
    IonGrid,
    IonRow,
    CardComponent
  }
};
</script>