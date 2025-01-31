package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Department obj = new Department(1, "Books");
		
		SimpleDateFormat  sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		Date birthDate = sdf.parse("06/05/1995 15:26:00");
		
		System.out.println(obj);
		
		Seller seller = new Seller(21, "bob", "bob@gmail.com", birthDate, 1000.0, obj);

		System.out.println(seller);
		
	}

}
