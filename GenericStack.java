package cardGame;

import java.util.ArrayList;

/**
 * A stack Class that Defines methods from StackInterface
 * @author Nick Ruiz
 * @version 1.0
 */

public class GenericStack<E> implements StackInterface<E> {

	/**
	 * Creates an array list to be implemented for the stack
	 */
	private ArrayList<E> list;
	
	/** 
	 * The top of this stack
	 */
	private E top;
	

	/**
	 * Constructs an empty stack
	 */
	public GenericStack(){
		this.list = new ArrayList<E>();
	}

	/**
	 * Returns the number of objects in this stack
	 * @return An integer specifying the length of the stack
	 */
	public int getSize(){
		return this.list.size();
	}
	
	/**
	 * Retrieves a reference to the top element of the stack but does not change the stack.
	 * @return The item that was added most recently
	 * @throws StackException Throws StackException if the stack is empty.
	 */
	public E peek() throws StackException {
		if (!isEmpty()){
			return this.list.get(this.list.size()-1);
		}else{
			throw new StackException(" The stack is empty!");
		}
		
	}	
	
	/**
	 * Adds an item to the top of this stack.
	 * @param newItem The item to be added to the stack
	 * @throws StackException Some implementations may throw StackException when newItem cannot 
	 * 			be placed on the stack.
	 */			
	public void push(E newItem) throws StackException {
		this.list.add(newItem);		
	}
	
	/**
     * Removes the top item of this stack.
     * @return The item that was most recently added to this stack
     * @throws StackException Throws StackException if the stack is empty.
     */	
	public E pop() throws StackException{
		if (!isEmpty()){
			return this.list.remove(this.list.size() - 1);
		}else{
		 throw new StackException(" The stack is empty");
		}
	}
		
	 /**
	   * Determines whether the stack is empty.
	   * @return A boolean value specifying if this stack is empty
	   */
	public boolean isEmpty() {
		return this.list.isEmpty();
	}
	
}
