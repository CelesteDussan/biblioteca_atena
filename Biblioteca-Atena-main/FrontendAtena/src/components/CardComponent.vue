<template>
  <ion-col size="12" size-md="4">
    <ion-card class="text-center">
      <ion-card-header>
        <ion-img v-if="imageSrc" :src="imageSrc" class="card-image" />
        <ion-card-title>{{ title }}</ion-card-title>
      </ion-card-header>
      <ion-card-content>
        <p>{{ description }}</p>
        <ion-button expand="block" @click="navigateToPage">{{ buttonText }}</ion-button>
      </ion-card-content>
    </ion-card>
  </ion-col>
</template>

<script>
import {
  IonCol,
  IonCard,
  IonCardHeader,
  IonCardTitle,
  IonCardContent,
  IonButton,
  IonImg
} from '@ionic/vue';

export default {
  name: 'CardComponent',
  components: {
    IonCol,
    IonCard,
    IonCardHeader,
    IonCardTitle,
    IonCardContent,
    IonButton,
    IonImg
  },
  props: {
    title: {
      type: String,
      required: true
    },
    description: {
      type: String,
      required: true
    },
    buttonText: {
      type: String,
      required: true
    },
    pageLink: {
      type: String,
      required: true
    },
    imageSrc: { // Nueva propiedad para la imagen
      type: String,
      required: false
    }
  },
  methods: {
    navigateToPage() {
      this.$router.push(this.pageLink);
    }
  }
};
</script>

<style scoped>
.text-center {
  text-align: center;
}

.card-image {
  width: 100%;
  height: 300px; 
}
</style>
