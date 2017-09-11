
import java.util.Scanner;

public class myMain_A01_Part2 {

	//-------------------------------------------------------------------
	// 1. Ask user for an option: select_db_manager
	//-------------------------------------------------------------------
	public static int select_db_manager(Scanner sc){
		int option = 0;
			
		System.out.println("------------------------------------");
		System.out.println("	Concrete List Implementation	");
		System.out.println("------------------------------------");
		System.out.println("1. Array List");
		System.out.println("2. Linked List");
		System.out.println("3. Double Linked List");
		
		boolean selected = false;
		
		while (selected == false){
			System.out.println("Please enter an option");
			try {
				option = sc.nextInt();
				sc.nextLine();
				if ((option >= 1) && (option <= 3))
					selected = true;
				else
					System.out.println("Sorry but the option must be 1..3");
				
			}
			catch (Exception e) {
				System.out.println("Sorry you did not enter a valid option");
				sc.next();
			}		
		}
				
		return option;
	}	
	
	//-------------------------------------------------------------------
	// 2. Ask user for an option: select_option
	//-------------------------------------------------------------------
	public static int select_option(Scanner sc){
		int option = 0;
			
		System.out.println("------------------------------------");
		System.out.println("			    MENU				");
		System.out.println("------------------------------------");
		System.out.println("1. Load database from file");
		System.out.println("2. Display database content");
		System.out.println("3. Check if element is in database");
		System.out.println("4. Show element info");
		System.out.println("5. Add element to database");
		System.out.println("6. Update element of database");
		System.out.println("7. Remove element from database");
		System.out.println("8. Sort the elements of the database");
		System.out.println("9. Save database to file");
		System.out.println("0. Exit");
		
		boolean selected = false;
		
		while (selected == false){
			System.out.println("Please enter an option");
			try {
				option = sc.nextInt();
				sc.nextLine();
				if ((option >= 0) && (option <= 9))
					selected = true;
				else
					System.out.println("Sorry but the option must be 0..9");
				
			}
			catch (Exception e) {
				System.out.println("Sorry you did not enter a valid option");
				sc.next();
			}		
		}
				
		return option;
	}

	//-------------------------------------------------------------------
	// 3. Interactive session with the user: interactive_session
	//-------------------------------------------------------------------
	public static void interactive_session(){
		//1. We create the database manager 'database', and we select a concrete implementation for its attribute myList: ArrayList, LinkedList or DoubleLinkedList
		Scanner sc = new Scanner(System.in);				
		boolean finish = false;
		String input;
		int mode = select_db_manager(sc);

		dbManagement m = new dbManagement(mode);
					
		//2. While the user wants to continue the session
		while (finish == false){

			//2.1. We clear the screen
			for (int i = 0; i < 100; i++)
				System.out.println();
			
			//2.2. Ask for the next operation to be performed
			int option = select_option(sc);
			
			//2.3. Perform the operations
			switch (option){
			case 1: //Load from file 
				//We get the file to be read from
				System.out.println("Please enter the name of the file to be read");
				input = sc.nextLine();

				//We perform the operation
				m.load_file(input);
				
				System.out.println("Press any key to continue");
				sc.nextLine();
				break;

			case 2: //Display Elements
				m.show_elements();
				
				System.out.println("Press any key to continue");
				sc.nextLine();
				break;
				
			case 3: //Check if element belongs to the list
				System.out.println("Please enter the name of the player");
				input = sc.nextLine();
				int i = m.find_element(input);
				
				if (i == -1)
					System.out.println("The player is not in the list");
				else
					System.out.println("The player is in the list");
				
				System.out.println("Check Operation Completed");
				
				System.out.println("Press any key to continue");
				sc.nextLine();				
				break;
				
			case 4: //Show player details
				System.out.println("Please enter the name of the player");
				input = sc.nextLine();
				m.show_info(input);

				System.out.println("Press any key to continue");
				sc.nextLine();				
				break;
				
			case 5: //Add a new player 
				try{
					System.out.println("Please enter the name of the player");
					String n = sc.next();
					System.out.println("Please enter the goals of the player");
					int g = sc.nextInt();
					sc.nextLine();

					m.add(n, g);				
				}
				catch (Exception e) {
					System.out.println("Sorry but the details entered are not correct");
					sc.nextLine();
				}	

				System.out.println("Press any key to continue");
				sc.nextLine();				
				break;
				
			case 6: //Update a player
				try{
					System.out.println("Please enter the name of the player");
					String n = sc.next();
					System.out.println("Please enter the goals of the player");
					int g = sc.nextInt();
					sc.nextLine();

					m.update(n, g);				
				}
				catch (Exception e) {
					System.out.println("Sorry but the details entered are not correct");
					sc.nextLine();
				}					
				
				System.out.println("Press any key to continue");
				sc.nextLine();
				break;
				
			case 7: //Remove a player 
				System.out.println("Please enter the name of the player");
				input = sc.nextLine();
				m.remove(input);

				System.out.println("Press any key to continue");
				sc.nextLine();				
				break;
		
			case 8: //Sort the elements 
				m.bubble_sort();

				System.out.println("Press any key to continue");
				sc.nextLine();				
				break;
				
			case 9: //Write to file 
				//We get the file to be read from
				System.out.println("Please enter the name of the file to be read");
				input = sc.nextLine();
				
				//We perform the operation
				m.write_file(input);

				System.out.println("Press any key to continue");
				sc.nextLine();				
				break;

			default: 
				finish = true;
				break;
			}
		}
	}
	
	//-------------------------------------------------------------------
	// MAIN
	//-------------------------------------------------------------------
	public static void main(String[] args) {
		interactive_session();	
	}
		
}
