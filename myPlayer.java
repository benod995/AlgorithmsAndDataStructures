
public class myPlayer {

	//--------------------------------------------------
	// 0.Attributes
	//--------------------------------------------------
	private String name;
	private int goals;
	
	//--------------------------------------------------
	// 0. Constructor
	//--------------------------------------------------
	public myPlayer(String s, int i){
		this.name = s;
		this.goals = i;
	}
	
	//--------------------------------------------------
	// 1. Get methods
	//--------------------------------------------------
	public String get_name(){
		return this.name;
	}
	
	public int get_goals(){
		return this.goals;
	}
		
	//--------------------------------------------------
	// 2. Set methods
	//--------------------------------------------------
	public void set_name(String s){
		this.name = s;
	}

	public void set_goals(int i){
		this.goals = i;
	}

	//--------------------------------------------------
	// 3. Print Info
	//--------------------------------------------------
	public void print_info(){
		System.out.println("Name : " + this.get_name() + ", Goals : " + this.get_goals());
	}

	//--------------------------------------------------
	// 4. Compare to see if a player is 'smaller' than another
	//--------------------------------------------------
	public boolean smaller(myPlayer player){
		//We order the players by decreasing number of goals and, in case of tie, by the order set on their string names.
		boolean small = true;
				
		//2. Sort the two elements 
		if (this.get_goals() == player.get_goals()){
			if ((this.get_name()).compareTo(player.get_name()) > 0)
				small = false;
		}
		else{ //If this scored more goals than player
			if (this.get_goals() < player.get_goals())
				small = false;
		}
		//3. Return the result
		return small;
	}	
	
}
