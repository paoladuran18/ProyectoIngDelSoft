package businessLayer;

public class Prueba {

	public static void main(String[] args) {
		Category cat = new Category(1, "Ruedas", "varios tipos de ruedas");
		Product p = new Product(1, "motor", 20, 15.20, 30.40, "marca no se", cat);
		System.out.println(p.getCategory().getName());
		

	}

}
