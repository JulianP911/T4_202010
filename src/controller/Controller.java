package controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import model.Comparendo;
import model.data_structures.MaxColaCP;
import model.data_structures.MaxHeapCP;
import model.logic.Modelo;
import view.View;

public class Controller {

	/* Instancia del Modelo*/
	private Modelo modelo;

	/* Instancia de la Vista*/
	private View view;

	/**
	 * Crear la vista y el modelo del proyecto
	 * @param capacidad tamaNo inicial del arreglo
	 */
	public Controller ()
	{
		view = new View();
		modelo = new Modelo();
	}

	public void run() 
	{
		Scanner lector = new Scanner(System.in);
		boolean fin = false;

		while( !fin ){
			view.printMenu();

			int option = lector.nextInt();
			switch(option){
			case 1:
				long start1 = System.currentTimeMillis();
				modelo.darMaxColaCP();
				long end1 = System.currentTimeMillis();

				long start2 = System.currentTimeMillis();
				modelo.darMaxHeapCP();
				long end2 = System.currentTimeMillis();

				view.printMessage("El numero de comparendos es de: " + modelo.darMaxColaCP().size() );
				view.printMessage("Tiempo de carga (seg) en MaxColaCP: " + (end1-start1)/1000.0);
				view.printMessage("Tiempo de carga (seg) en MaxHeapCP: " + (end2-start2)/1000.0);
				break;

			case 2:
				// Entrada de datos
				view.printMessage("Ingrese el tamaño de la mustra para los comparendos: ");
				int entrada1 = lector.nextInt();

				view.printMessage("Ingrese los tipos de servicio de los comparendos de la forma (e.j. MOTO,CARRO,BUS,ETC): ");
				String entrada2 = lector.next();
				String str1[] = entrada2.split(",");
				List<String> listaTipo1 = new ArrayList<String>();
				listaTipo1 = Arrays.asList(str1);

				// Tiempo de ejecucion
				long start3 = System.currentTimeMillis();
				MaxColaCP<Comparendo> colaPrioridad = modelo.darComparendosMasNorteYTipoCola(listaTipo1);
				long end3 = System.currentTimeMillis();

				// Informacion al usuario
				view.printMessage("Tiempo de ejecucion requerimiento: " + (end3-start3)/1000.0);

				view.printMessage("Los siguiente son los coparendos de la muestra y del tipo de servicio com MaxColaPC mas al norte:");

				Iterator<Comparendo> resultado1 = colaPrioridad.iterator();
				int i = 0;
				while(resultado1.hasNext() && i < entrada1)
				{
					Comparendo elemento = resultado1.next();
					view.printMessage(elemento.getObjective() + ", " + elemento.getTipo_servi() + ", " + elemento.getLatitud()+ ", " + elemento.getLongitud());
					i++;
				}
				break;

			case 3:
				view.printMessage("Ingrese el tamaño de la mustra para los comparendos: ");
				int entrada3 = lector.nextInt();


				view.printMessage("Ingrese los tipos de servicio de los comparendos de la forma (e.j. AUTOMÓVIL,MOTOCICLETA,CAMIONETA,ETC): ");
				String entrada4 = lector.next();
				String str2[] = entrada4.split(",");
				List<String> listaTipo2 = new ArrayList<String>();
				listaTipo2 = Arrays.asList(str2);

				// Tiempo de ejecucion
				long start4 = System.currentTimeMillis();
				MaxHeapCP<Comparendo> qPrioridad = modelo.darComparendosMasNorteYTipoHeap(listaTipo2);
				long end4 = System.currentTimeMillis();

				view.printMessage("Tiempo de ejecucion requerimiento: " + (end4-start4)/1000.0);

				view.printMessage("Los siguiente son los coparendos de la muestra y del tipo de servicio MaxHeapCP mas al norte:");
				
				Iterator<Comparendo> resultado2 = qPrioridad.iterator();
				int j = 0;
				while(resultado2.hasNext() && j < entrada3)
				{
					Comparendo elemento = resultado2.next();
					view.printMessage(elemento.getObjective() + ", " + elemento.getTipo_servi() + ", " + elemento.getLatitud()+ ", " + elemento.getLongitud());
					j++;
				}
				break;

			case 4:
				lector.close();
				fin = true;
				break;

			default: 
				view.printMessage("--------- \n Opcion Invalida !! \n---------");
				break;
			}
		}

	}	
}
