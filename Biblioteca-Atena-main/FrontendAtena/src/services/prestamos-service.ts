import axios from 'axios';
import { API_BASE_URL } from './api-config';

const PRESTAMOS_API_URL = `${API_BASE_URL}/prestamos`;

interface PrestamosData {
  librosId: { id: number };
  cantidad: string;
  clientesId: { id: number };
  fechaPrestamo: Date;
  estado: string;
  fechaDevolucion: Date;
}

export const getAllPrestamos = async (): Promise<any> => {
  try {
    const { data } = await axios.get(PRESTAMOS_API_URL);
    return data;
  } catch (error) {
    console.error('Error al obtener prestamos:', error);
    throw error;
  }
};

export const findPrestamosById = async (id: number): Promise<any> => {
  try {
    const { data } = await axios.get(`${PRESTAMOS_API_URL}/${id}`);
    return data;
  } catch (error) {
    console.error(`Error al obtener prestamos ID ${id}:`, error);
    throw error;
  }
};

export const savePrestamos = async (prestamosData: PrestamosData): Promise<any> => {
  try {
    const { data } = await axios.post(PRESTAMOS_API_URL, prestamosData);
    return data;
  } catch (error) {
    console.error('Error al guardar prestamos:', error);
    throw error;
  }
};

export const updatePrestamos = async (prestamosData: PrestamosData, id: number): Promise<any> => {
  try {
    const { data } = await axios.put(`${PRESTAMOS_API_URL}/${id}`, prestamosData);
    return data;
  } catch (error) {
    console.error(`Error al actualizar prestamos ID ${id}:`, error);
    throw error;
  }
};

export const deletePrestamos = async (id: number): Promise<any> => {
  try {
    const { data } = await axios.delete(`${PRESTAMOS_API_URL}/${id}`);
    return data;
  } catch (error) {
    console.error(`Error al eliminar prestamos ID ${id}:`, error);
    throw error;
  }
};
