package businessLayer;

import java.util.ArrayList;
import java.util.Iterator;

public class Prueba {

	public static void main(String[] args) throws Exception {

		Customer c = new Customer();
		ArrayList<Customer> f = c.consult();
		Iterator i = f.iterator();
		int j = 0;
		while(i.next() != null)
		{
			System.out.println(f.get(j).getId() + " " + 
		f.get(j).getName() + " " + f.get(j).getLastname() + " " + f.get(j).getDirection() + " " + f.get(j).getPhon());
			j++;
		}
		

	}

}
