package categor�a.view;

import java.util.Iterator;
import java.util.Scanner;

import categor�a.control.Categor�as;
import categor�a.entity.Categor�a;
import categor�a.entity.NoExisteCategor�a;
import producto.control.Productos;
import view.InputTypes;

public class Categor�asIO {
	private Categor�as categor�as;
	private Productos productos;
	private Scanner scanner;

	
	/****************************
	 * Constructor              *
	 ****************************/
	
	public Categor�asIO(Categor�as categor�as, Productos productos, Scanner scanner) {
		this.scanner = scanner;
		this.categor�as = categor�as;
		this.productos = productos;
	}

	
	/****************************
	 * Agregar categor�as        *
	 ****************************/
	
	public void add() {
		Categor�a categor�a = Categor�aIO.ingresar(scanner);
		try {
			categor�as.ingresar(categor�a);
		} catch (java.lang.ArrayIndexOutOfBoundsException e) {
			System.out.println("No existe espacio!");
		}
	}
	
	
	/****************************
	 * Eliminar categor�as       
	 * @throws NoExisteCategor�a *
	 ****************************/
	
	public void delete() throws NoExisteCategor�a {
		int codcategor�a = InputTypes.readInt("C�digo de categor�a: ", scanner);
		categor�as.eliminar(codcategor�a);
	}

	
	/****************************
	 * Listar categor�as         *
	 ****************************/
	
	public void list() {
		for (Iterator<Categor�a> i = categor�as.getCategor�as().iterator();
				i.hasNext();) {
			System.out.println(i.next());
		}
	}
	
	/****************************
	 * Listar productos por categor�a         
	 * @throws NoExisteCategor�a *
	 ****************************/
	
	public void listProducts() throws NoExisteCategor�a {
		int codCategor�a = InputTypes.readInt("C�digo de categor�a: ", scanner);
		System.out.println(categor�as.getCategor�as().get(categor�as.buscar(codCategor�a)));
		for (int i = 0; i < productos.getCantidad(); i++) {
			if (codCategor�a == productos.getProductos()[i].getCodCategor�a())
			System.out.println(productos.getProductos()[i]);
		}
		
	}
}
