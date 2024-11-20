import axios from 'axios';
import { API_BASE_URL } from './api-config';

const LIBROS_API_URL = `${API_BASE_URL}/libros`;

interface LibrosData {
  titulo: string;
  autor: string;
  categoria: number;
}

export const getAllLibros = async (): Promise<any> => {
  try {
    const { data } = await axios.get(LIBROS_API_URL);
    return data;
  } catch (error) {
    console.error('Error al obtener libros:', error);
    throw error;
  }
};

export const findLibrosById = async (id: number): Promise<any> => {
  try {
    const { data } = await axios.get(`${LIBROS_API_URL}/${id}`);
    return data;
  } catch (error) {
    console.error(`Error al obtener libros ID ${id}:`, error);
    throw error;
  }
};

export const saveLibros = async (librosData: LibrosData): Promise<any> => {
  try {
    const { data } = await axios.post(LIBROS_API_URL, librosData);
    return data;
  } catch (error) {
    console.error('Error al guardar libros:', error);
    throw error;
  }
};

export const updateLibros = async (librosData: LibrosData, id: number): Promise<any> => {
  try {
    const { data } = await axios.put(`${LIBROS_API_URL}/${id}`, librosData);
    return data;
  } catch (error) {
    console.error(`Error al actualizar libros ID ${id}:`, error);
    throw error;
  }
};

export const deleteLibros = async (id: number): Promise<any> => {
  try {
    const { data } = await axios.delete(`${LIBROS_API_URL}/${id}`);
    return data;
  } catch (error) {
    console.error(`Error al eliminar libros ID ${id}:`, error);
    throw error;
  }
};
