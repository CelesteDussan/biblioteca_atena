import axios from 'axios';
import { API_BASE_URL } from './api-config';

const CLIENTES_API_URL = `${API_BASE_URL}/clientes`;

// Opcional: define una interfaz para clientesData si tienes una estructura conocida
interface ClientesData {
  cedula: string;
  nombre: string;
  telefono: string;
  email: string;
  // Añade aquí otras propiedades según la estructura de clientesData
}

export const getAllClientes = async (): Promise<any> => {
  try {
    const { data } = await axios.get(CLIENTES_API_URL);
    return data;
  } catch (error) {
    console.error('Error al obtener clientes:', error);
    throw error;
  }
};

export const findClientesById = async (id: number): Promise<any> => {
  try {
    const { data } = await axios.get(`${CLIENTES_API_URL}/${id}`);
    return data;
  } catch (error) {
    console.error(`Error al obtener clientes ID ${id}:`, error);
    throw error;
  }
};

export const saveClientes = async (clientesData: ClientesData): Promise<any> => {
  try {
    const { data } = await axios.post(CLIENTES_API_URL, clientesData);
    return data;
  } catch (error) {
    console.error('Error al guardar clientes:', error);
    throw error;
  }
};

export const updateClientes = async (clientesData: ClientesData, id: number): Promise<any> => {
  try {
    const { data } = await axios.put(`${CLIENTES_API_URL}/${id}`, clientesData);
    return data;
  } catch (error) {
    console.error(`Error al actualizar clientes ID ${id}:`, error);
    throw error;
  }
};

export const deleteClientes = async (id: number): Promise<any> => {
  try {
    const { data } = await axios.delete(`${CLIENTES_API_URL}/${id}`);
    return data;
  } catch (error) {
    console.error(`Error al eliminar clientes ID ${id}:`, error);
    throw error;
  }
};