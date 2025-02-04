package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {

		
		DepartmentDao depDao = DaoFactory.createDepartmentDao();

		Scanner sc = new Scanner(System.in);
		
		System.out.println("=== TEST 1: department findyById ====");
		
		Department dep = depDao.findById(2);

		System.out.println(dep);
		
		System.out.println("\n === TEST 2: department findByAll ===");
		
		List<Department> list = depDao.findAll();
		
		for(Department depa : list) {
			System.out.println(depa);
		}
		
		System.out.println("\n === TEST 3: department insert =====");
		
		Department depa = new Department(null, "Artes");
		depDao.insert(depa);
		System.out.println("Inser! New id:  " +depa.getId());
		
		System.out.println("\n === TEST 4: department update =====");
		
		depa.setId(9);
		depa.setName("Licitação");
		depDao.update(depa);
		
		System.out.println("Update complet ");
		
		System.out.println("\n === TEST 5: department delete =====");
		
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		depDao.deleteById(id);
		System.out.println("Delete completed");
		
		sc.close();
	}

}
