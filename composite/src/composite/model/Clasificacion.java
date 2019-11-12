package composite.model;

import java.util.ArrayList;

public class Clasificacion extends Categoria{
	
	private ArrayList<Categoria> subCategorias;
	protected String nivel;

	public Clasificacion(String nombre, String nivel, Categoria superCategoria) {
		super(nombre, superCategoria);
		this.nivel=nivel;
		this.subCategorias = new ArrayList<>();
	}
	
	public void agregarSubCategoria(Categoria categoria) {
		subCategorias.add(categoria);
	}
	
	public ArrayList<Categoria> getSubCategorias(){
		return this.subCategorias;
	}
}
