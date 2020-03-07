package view;

import model.logic.Modelo;

public class View 
{
	    /**
	     * Metodo constructor
	     */
	    public View()
	    {
	    	
	    }
	    
		public void printMenu()
		{
			System.out.println("1. Cargar Muestra de Datos");
			System.out.println("2. Requerimiento #1 - Mostrar los N comparendos que ocurrieron más al norte (basada en la latitud) y que involucraron un tipo de vehículo que está incluido en una lista (con una MaxColaCP).");
			System.out.println("3. Requerimiento #2 - Mostrar los N comparendos que ocurrieron más al norte (basada en la latitud) y que involucraron un tipo de vehículo que está incluido en una lista (con una MaxHeapCP).");
			System.out.println("4. Cerrar");
		}

		public void printMessage(String mensaje) {

			System.out.println(mensaje);
		}		
		
		public void printModelo(Modelo modelo)
		{
			System.out.println(modelo);
		}
}
