package jdbc_wejm5_simple_maven;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class PersonMain {
	public static void main(String[] args){
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("Enter the id");
		int id=scanner.nextInt();
		
		System.out.println("Enter the name");
		String name=scanner.next();
		
		System.out.println("Enter the phone");
		long phone=scanner.nextLong();
		
		PersonCrud crud= new PersonCrud();
		
		try {
			crud.savePerson(id, name, phone);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
