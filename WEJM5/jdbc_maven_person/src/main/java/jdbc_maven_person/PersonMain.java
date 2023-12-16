package jdbc_maven_person;

import java.util.Scanner;

public class PersonMain {
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		Person person = new Person();
		PersonCrud crud = new PersonCrud();
		boolean condition = true;
		do {

			System.out.println(
					"Enter your choice \n1.Save Person \n2.Update Person \n3.Delete Person \n4.Get person by Id \n5.Get all Person \n6.Exit");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1: {
				System.out.println("Enter id");
				int id = scanner.nextInt();
				System.out.println("Enter Name");
				String name = scanner.next();
				System.out.println("Enter Phone Number");
				long phone = scanner.nextLong();

				person.setId(id);
				person.setName(name);
				person.setPhone(phone);

				crud.savePerson(id, name, phone);
			}

				break;
			case 2: {
				System.out.println("Enter id");
				int id = scanner.nextInt();
				System.out.println("Enter Name");
				String name = scanner.next();
				System.out.println("Enter Phone Number");
				long phone = scanner.nextLong();

				person.setId(id);
				person.setName(name);
				person.setPhone(phone);

				crud.updatePerson(person);

			}
				break;
			case 3: {
				System.out.println("Enter id");
				int id = scanner.nextInt();

				crud.deletePerson(id);
			}
				break;
			case 4: {
				System.out.println("Enter id");
				int id = scanner.nextInt();

				crud.fetchPerson(id);
			}
				break;
			case 5: {

				crud.fetchAllPerson(person);
			}
				break;
			default:
				condition = false;
				break;
			}
		} while (condition == true);
	}
}
