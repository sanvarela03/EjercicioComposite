package composite.model;

import java.util.ArrayList;

public abstract class Categoria {
	protected String nombre;
	
	protected Categoria superCategoria;
	protected ArrayList<Categoria> ramasSuperiores;
	
	
	public Categoria(String nombre, Categoria superCategoria) {
		this.nombre = nombre;
		
		this.superCategoria = superCategoria;
		this.ramasSuperiores = new ArrayList<>();
	}
	public String getNombre() {
		return nombre;
	}

	public Categoria getSuperCategoria() {
		return superCategoria;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setSuperCategoria(Categoria superCategoria) {
		this.superCategoria = superCategoria;
	}
	public ArrayList<Categoria> getRamasSuperiores(Categoria categoria) {
		encontrarRamasSuperiores(categoria);
		return ramasSuperiores;
	}
	public void setRamasSuperiores(ArrayList<Categoria> ramasSuperiores) {
		this.ramasSuperiores = ramasSuperiores;
	}
	private Categoria  encontrarRamasSuperiores(Categoria categoria) {
		
		if(categoria.getSuperCategoria()!=null) {
			ramasSuperiores.add(categoria);
			return encontrarRamasSuperiores(categoria.getSuperCategoria());
		}else {
			ramasSuperiores.add(categoria);
			return categoria;
		}

	}
}
