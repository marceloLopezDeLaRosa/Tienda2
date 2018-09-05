package producto.control;

import producto.entity.Producto;

public class Productos {
	
	private Producto[] productos;
	private int cantidad;
	private int último;
	
	public Productos (int tamaño) {
		productos = new Producto[tamaño];
		cantidad = 0;
		último = -1;
	}
	
	public void ingresar(Producto producto) throws java.lang.ArrayIndexOutOfBoundsException {
		productos[++último] = producto;
		cantidad++;
	}
	
	public void eliminar(int codProducto) {
		int índice = buscar(codProducto);
		
		if (índice >= 0) {
			if (índice != último) {
				for (int i=índice; i<último;i++) {
//					Recorrer todos los elementos a partir de i
					productos[i] = productos[i+1];
				}
			}
			último--;
			cantidad--;
		}
		
	}
	
	private int buscar(int codProducto) {
		int índice = -1;
		int i=0;
		while(i <= último) {
			if (codProducto == productos[i].getCodProducto()) {
				índice = i;
				break;
			}
			i++;
		}
		return índice;
	}

	public int getCantidad() {
		return cantidad;
	}

	public Producto[] getProductos() {
		return productos;
	}
	
	

}
