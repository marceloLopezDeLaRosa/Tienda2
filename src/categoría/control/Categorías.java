package categoría.control;

import java.util.ArrayList;
import java.util.Iterator;

import categoría.entity.Categoría;
import categoría.entity.NoExisteCategoría;

public class Categorías {

	private ArrayList<Categoría> categorías;

	public Categorías() {
		categorías = new ArrayList<Categoría>();
	}

	/****************************
	 * Ingresar una Categoría    *
	 ****************************/
	
	public void ingresar(Categoría categoría) throws  java.lang.ArrayIndexOutOfBoundsException{
		categorías.add(categoría);
	}

	/****************************
	 * Eliminar una Categoría     
	 * @throws NoExisteCategoría *
	 ****************************/
	
	public void eliminar(int codCategoría) throws NoExisteCategoría {
		int índice;
		índice = buscar(codCategoría);
		categorías.remove(índice);
	}
	
	
	/****************************
	 * Buscar  índice	 		*
	 *  Categoría     			
	 * @throws NoExisteCategoría *
	 ****************************/

	public int buscar(int codCategoría) throws NoExisteCategoría {
		Categoría categoría = null;
		int índice = -1;
		for (Iterator<Categoría> iterator = categorías.iterator();iterator.hasNext();) {
			categoría = iterator.next();
			if (codCategoría == categoría.getCodCategoría()) {
				índice = categorías.indexOf(categoría);
			}
		}
			if (índice == -1) {
				throw new NoExisteCategoría();
			}
			return índice;
	}
	
	/****************************
	 * Devuelve el vector de    * 
	 * Categorías                *
	 ****************************/

	public ArrayList<Categoría> getCategorías() {
		return categorías;
	}
	
	
}
