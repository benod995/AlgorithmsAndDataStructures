import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class dbManagement {

	//--------------------------------------------------
	// Attribute
	//--------------------------------------------------
	private myList<myPlayer> items; //See the use of a dynamic data structure: ArrayList
	//--------------------------------------------------
	// Constructor
	//--------------------------------------------------
	public dbManagement(int mode){
		if (mode == 1 ){
			items = new myListArrayList();
		}
		else if (mode == 2){
			items = new myListLinkedList();
		}
		else if (mode ==3){
			items = new myListDoubleLinkedList();
		}
	}
	
	//-------------------------------------------------------------------
	// Extended Operation 1. --> Load a MyList from file: load_file
	//-------------------------------------------------------------------
	public void load_file(String s){				

		try {
			//1. We create the file variable
			File my_file = new File(s);
			Scanner sc = new Scanner(my_file);

			//2. We empty the list
			int size = items.my_get_length();
			for (int i = 0; i < size; i++)
				items.my_remove_element(0);

			//3. We fill MyList with the content of the file
			int count = 0;
			while (sc.hasNext()){
				myPlayer player = new myPlayer(sc.next(), sc.nextInt());
				items.my_add_element(count, player);
				count = count + 1;
			}

			//4. We close the scanner
			sc.close();

			System.out.println("Load Operation Completed");
		} 
		catch (Exception e) {
			System.out.println("Sorry but there is not such file");
		}	
	}

	//-------------------------------------------------------------------
	// Extended Operation 2. --> Display MyFile content: show_elements
	//-------------------------------------------------------------------
	public void show_elements(){
		for (int x=0; x< items.my_get_length(); x++){
			myPlayer y = items.my_get_element(x);
			y.print_info();
		}
		System.out.println("There are " + items.my_get_length() + " players in the database");

	}

	//-------------------------------------------------------------------
	// Extended Operation 3. --> Check if element is in MyList: find_element
	//-------------------------------------------------------------------
	public int find_element(String s){
		int i = -1;
		boolean found = false;
		for(int z=0; z< items.my_get_length() && found == false; z++){
			myPlayer x = items.my_get_element(z);
			if (x.get_name().equals(s)){
				found =true;
				i=z;
			}

		}
		return i;
	}

	//-------------------------------------------------------------------
	// Extended Operation 4. --> Show info of element in MyList: show_info
	//-------------------------------------------------------------------
	public void show_info(String s){

		for(int a=0; a< items.my_get_length(); a++){
			myPlayer p = items.my_get_element(a);

			if (p.get_name().equals(s)){
				System.out.println("Player Name: " + s + " \nGoals Scored: " + p.get_goals());
			}
		}

	}


	//-------------------------------------------------------------------
	// Extended Operation 5. --> Add new element to MyList: add_by_keyboard
	//-------------------------------------------------------------------
	public void add(String s, int i){
		myPlayer x = new myPlayer(s,i);
		items.my_add_element(items.my_get_length(),x);

	}

	//-------------------------------------------------------------------
	// Extended Operation 6. --> Update element of MyList: update
	//-------------------------------------------------------------------
	public void update(String s, int g){
		for (int x = 0; x< items.my_get_length(); x++){
			myPlayer p = items.my_get_element(x);

			if (p.get_name().equals(s)){
				items.my_get_element(x);
				p.set_name(s);
				p.set_goals(g);
			}

		}
	}

	//-------------------------------------------------------------------
	// Extended Operation 7. --> Remove element of MyList: remove_element
	//-------------------------------------------------------------------
	public void remove(String s){
		boolean found = false;
		for (int x = 0; x< items.my_get_length() && found == false; x++){
			myPlayer p = items.my_get_element(x);

			if (p.get_name().equals(s)){
				items.my_remove_element(x);
				found = true;
			}
		}
	}

	//-------------------------------------------------------------------
	// Extended Operation 8. --> sort elements of MyList: bubble_sort
	//-------------------------------------------------------------------
	public void bubble_sort(){
		boolean answer = false;
		while (answer == false) {
			answer = true;
			for (int i = 0; i < items.my_get_length() - 1; i++) {

				myPlayer p = items.my_get_element(i);
				myPlayer c = items.my_get_element(i + 1);
				if (p.smaller(c)) {
					items.my_remove_element(i);
					items.my_remove_element(i);
					
					items.my_add_element(i, c);
					items.my_add_element(i+1, p);
					answer = true;
				}
			} 
		}
	}



	//-------------------------------------------------------------------
	// Extended Operation 9. --> Write a MyList to file: write_file
	//-------------------------------------------------------------------
	public void write_file(String s){
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(s);

		}catch (Exception e){
			System.out.println("You have not entered a valid file name!");
		}

		for(int i=0; i<items.my_get_length();i++)
		{

			pw.println(items.my_get_element(i).get_name() +" "+ items.my_get_element(i).get_goals());

		}
		pw.close ();    
		System.out.println("Your file has been saved!");

	}
	
}
