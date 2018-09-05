package view;

import java.util.Scanner;

import categor�a.control.Categor�as;
import categor�a.view.Categor�asIO;
import producto.control.Productos;
import producto.view.ProductosIO;
import view.InputTypes;

public class Men� {

	/****************************
	 * Encabezado del men� *
	 ****************************/

	public static int encabezado(Scanner scanner) {
		int opcion;

		while (true) {
			System.out.println("Ingrese una opcion: ");
			System.out.println("------------------- ");
			System.out.println("1. Categor�a");
			System.out.println("2. Producto ");
			System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("�Su opci�n? ", scanner);

			if (opcion >= 0 && opcion <= 2) {
				return opcion;
			}
		}
	}

	/****************************
	 * Opciones del men� *
	 ****************************/

	public static void men�(Scanner scanner) {
		boolean salir = false;
		
		Categor�as categor�as = new Categor�as();
		Productos productos = new Productos(10);

		Categor�asIO categor�asIO = new Categor�asIO(categor�as, productos, scanner);
		ProductosIO productosIO = new ProductosIO(productos, categor�as, scanner);
		
		while (!salir) {
			switch (encabezado(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				categor�a.view.Men�.men�(scanner, categor�asIO);
				break;
			case 2:
				producto.view.Men�.men�(scanner, productosIO);
				break;
		
			}
		}
	}
}
