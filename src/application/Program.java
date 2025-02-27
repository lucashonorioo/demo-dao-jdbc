package application;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();

		
		System.out.println("=== TEST 1: seller findyById ====");
		
		
		Seller seller = sellerDao.findById(3);
		
		System.out.println(seller);
		
		
		System.out.println("\n ===== TEST 2: seller findyByDeparment =====");
		
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		
		for(Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n ===== TEST 3: seller findyByAll =====");
		
		list = sellerDao.findAll();
		
		for(Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n ===== TEST 4: seller insert =====");
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New id = " + newSeller.getId());
		
		System.out.println("\n ===== TEST 5: seller update =====");
		seller = sellerDao.findById(1);
		seller.setName("Martha Weine");
		sellerDao.update(seller);
		System.out.println("Update completed");
		
		System.out.println("\n ===== TEST 6: seller delete =====");
		System.out.print("Enter id for delete test: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Delete completed");
		
		sc.close();
	}
}
