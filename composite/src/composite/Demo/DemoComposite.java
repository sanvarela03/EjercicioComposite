package composite.Demo;

import composite.model.Categoria;
import composite.model.Clasificacion;
import composite.model.hojas.Chimpanzee;
import composite.model.hojas.HouseCat;
import composite.model.hojas.HouseFly;
import composite.model.hojas.Human;
import composite.model.hojas.Lion;

public class DemoComposite {
	public static void main(String[] args) {
		Clasificacion animalia = new Clasificacion("Animalia", "Kingdom", null);

		Clasificacion chordate = new Clasificacion("Chordate", "Phylum", animalia);
		Clasificacion arthropoda = new Clasificacion("Arthopoda", "Phylum", animalia);

		animalia.agregarSubCategoria(chordate);
		animalia.agregarSubCategoria(arthropoda);

		Clasificacion mammal = new Clasificacion("Mammal", "Class", chordate);
		Clasificacion insect = new Clasificacion("Insect", "Class", arthropoda);

		chordate.agregarSubCategoria(mammal);
		arthropoda.agregarSubCategoria(insect);

		Clasificacion primate = new Clasificacion("Primate", "Order", mammal);
		Clasificacion carnivora = new Clasificacion("Carnivora", "Order", mammal);
		Clasificacion diptera = new Clasificacion("Diptera", "Order", insect);

		mammal.agregarSubCategoria(primate);
		mammal.agregarSubCategoria(carnivora);
		insect.agregarSubCategoria(diptera);

		Clasificacion hominidae = new Clasificacion("Hominidae", "Family", primate);
		Clasificacion pongidae = new Clasificacion("Pongidae", "Family", primate);
		Clasificacion felidae = new Clasificacion("Felidae", "Family", carnivora);
		Clasificacion muscidae = new Clasificacion("Muscidae", "Family", diptera);

		primate.agregarSubCategoria(hominidae);
		primate.agregarSubCategoria(pongidae);
		carnivora.agregarSubCategoria(felidae);
		diptera.agregarSubCategoria(muscidae);

		Clasificacion homo = new Clasificacion("Homo", "Genus", hominidae);
		Clasificacion pan = new Clasificacion("Pan", "Genus", pongidae);
		Clasificacion felis = new Clasificacion("Felis", "Genus", felidae);
		Clasificacion musca = new Clasificacion("Musca", "Genus", muscidae);

		hominidae.agregarSubCategoria(homo);
		pongidae.agregarSubCategoria(pan);
		felidae.agregarSubCategoria(felis);
		muscidae.agregarSubCategoria(musca);

		Clasificacion sapiens = new Clasificacion("Sapiens", "Species", homo);
		Clasificacion troglodytes = new Clasificacion("Troglodytes", "Species", pan);
		Clasificacion domestica = new Clasificacion("Domestica", "Species", felis);
		Clasificacion leo = new Clasificacion("Leo", "Species", felis);
		Clasificacion Domestica = new Clasificacion("Domestica", "Species", musca);

		homo.agregarSubCategoria(sapiens);
		pan.agregarSubCategoria(troglodytes);
		felis.agregarSubCategoria(domestica);
		felis.agregarSubCategoria(leo);
		musca.agregarSubCategoria(Domestica);

		Human human = new Human("Jhon", sapiens);
		Chimpanzee chimpanzee = new Chimpanzee("Lucy", troglodytes);
		HouseCat houseCat = new HouseCat("Garfield", domestica);
		Lion lion = new Lion("Aslan", leo);
		HouseFly houseFly = new HouseFly("Mooch", Domestica);

		sapiens.agregarSubCategoria(human);
		troglodytes.agregarSubCategoria(chimpanzee);
		domestica.agregarSubCategoria(houseCat);
		Domestica.agregarSubCategoria(houseFly);

		for (Categoria c : lion.getRamasSuperiores(lion)) {
			System.out.println(c.getNombre());
		}

	}
}
