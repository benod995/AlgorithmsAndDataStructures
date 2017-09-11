
public class myListDoubleLinkedList<T> implements myList<T> {

	//--------------------------------------------------
	// Attributes
	//--------------------------------------------------
	private myNode<T> head;
	private myNode<T> tail;
	private int count;
	//-------------------------------------------------------------------
	// Basic Operation --> Create an empty myList: my_create_empty
	//-------------------------------------------------------------------
	//public myList my_create_empty(){}

	public myListDoubleLinkedList(){
		this.head=null;
		this.tail=null;
		this.count =0;
	}

	//-------------------------------------------------------------------
	// Basic Operation --> Get number of integers in myList: my_get_length
	//-------------------------------------------------------------------	
	public int my_get_length(){
		return this.count;
	}

	//-------------------------------------------------------------------
	// Basic Operation --> Get integer of myList at a concrete index: my_get_element
	//-------------------------------------------------------------------
	public T my_get_element(int index) throws myException{
		//1. We look for the element
		//If it is in the second half of the list
		myNode<T> searchNode;
		if (index/2 > count){
			searchNode = tail;
			for (int i=count; index>count; i++){
				searchNode = searchNode.getLeft();
			}

			T element = searchNode.getInfo();
			return element;
		}
		//If the element is in the first half of the list
		else if (index/2 <= count){
			searchNode = head;
			for (int i=0; i<index; i++){
				searchNode = searchNode.getRight();
			}

			T element = searchNode.getInfo();
			return element;
		}
		else
			throw new myException("Invalid Index. The ADT does not have such an Index Position");				
	}

	//-------------------------------------------------------------------
	// Basic Operation --> Add integer to myList at a concrete index: my_add_element 

	//-------------------------------------------------------------------
	public void my_add_element(int index, T element) throws myException{

		//1. We look for the element
		myNode<T> current = this.head;
		myNode<T> previous = null;
		int count = 0; 

		while ((current != null) && (count < index)){
			previous = current;
			current = current.getRight();
			count = count + 1;
		}

		//2.1. If the index is a valid one
		if (count == index){
			//2.1.1. We Create the new node
			myNode<T> new_node = new myNode<T>(element);

			//2.1.2. We adjust the previous pointer
			if (previous == null){
				this.head = new_node;
			}

			else{
				previous.setRight(new_node);
				//current.setLeft(new_node);
			}
			
			//2.1.3. We adjust the successor pointer
			new_node.setRight(current);		
			new_node.setLeft(previous);
			this.count++;
			if (this.count >= 2){
			setLastElementToTail();	
			}

		}		//2.2. If the index is a wrong one
		else
			throw new myException("Invalid Index. The ADT does not have such an Index Position");	

	}
	//Sets last element to tail
	private void setLastElementToTail(){
		myNode <T> current = head;
		myNode <T> previous = null;
		
		while (current != null){
			previous = current;
			current = current.getRight();
		}
		tail = previous;
		tail.setLeft(previous.getLeft());
		tail.setRight(null);
		
	}
	//-------------------------------------------------------------------
	// Basic Operation --> Remove index of myList: my_remove_element 
	//-------------------------------------------------------------------	
	public void my_remove_element(int index) throws myException{

		//1. We look for the element
		myNode<T> current = this.head;
		myNode<T> previous = this.tail;
		//If the head needs to be removed
		if (index == 0){
			current = current.getRight();
			head = current;
			head.setLeft(null);
			this.count --;
		//If the tail needs to be removed
		}else if (index == this.count-1){
			previous = previous.getLeft();
			tail = previous;
			tail.setRight(null);
			this.count --;
		//If an element in the bottom half needs to be reomved
		}else if (index/2 <= this.count){
			for (int i=0; i<index; i++){
				previous = current;
				current = current.getRight();
			}
			current = current.getRight();
			current.setLeft(previous);
			previous.setRight(current);
			this.count --;
			
		}else if (index/2 > this.count){
			for (int i = count; i>=index; i--){
				current = previous;
				previous = previous.getLeft();
			}
			previous = previous.getLeft();
			current.setLeft(previous);
			previous.setRight(current);
			this.count --;
		}
		//2.2. If the index is a wrong one
		else
			throw new myException("Invalid Index. The ADT does not have such an Index Position");						
	}

}
