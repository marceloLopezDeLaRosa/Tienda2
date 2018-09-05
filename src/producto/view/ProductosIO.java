package producto.view;
import java.util.Scanner;

import categor�a.control.Categor�as;
import categor�a.entity.NoExisteCategor�a;
import producto.control.Productos;
import producto.entity.Producto;
import view.InputTypes;

public class ProductosIO {
	private Productos productos;
	private Scanner scanner;
	private Categor�as categor�as;
	
	
	/****************************
	 * Constructor              *
	 ****************************/
	
	public ProductosIO(Productos productos, Categor�as categor�as, Scanner scanner) {
		this.scanner = scanner;
		this.categor�as = categor�as;
		this.productos = productos;
	}

	
	/****************************
	 * Agregar productos        
	 * @throws NoExisteCategor�a *
	 ****************************/
	
	public void add() throws NoExisteCategor�a {
		Producto producto;
		producto = ProductoIO.ingresar(scanner, categor�as);
		productos.ingresar(producto);
	}
	
	
	/****************************
	 * Listar productos         
	 * @throws NoExisteCategor�a *
	 ****************************/
	
	public void list( )  {
		int codCategor�a=0;
		int �ndiceCategor�a = 0;
		
		for(int i=0; i < productos.getCantidad(); i++) {
			System.out.println(productos.getProductos()[i]);
			codCategor�a = productos.getProductos()[i].getCodCategor�a();
			try {
				�ndiceCategor�a = categor�as.buscar(codCategor�a);
				System.out.println(categor�as.getCategor�as().get(�ndiceCategor�a));
			} catch (NoExisteCategor�a e) {
				e.printStackTrace();
			}
		}
	}

	
	/****************************
	 * Eliminar productos       *
	 ****************************/
	
	public void delete() {
		int codProducto = InputTypes.readInt("C�digo de producto: ", scanner);
		productos.eliminar(codProducto);
	}


}
