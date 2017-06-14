package cardGame;

/**
 * Specifications of common operations of a stack. 
 * @author Nick Ruiz
 * @version 1.0
 */
public interface StackInterface<E> {
	
	 /**
	  * Returns an integer specifying the length of this stack
	  * @return An integer specifying the length of the stack
	  */
	  public int getSize();
	  
	  /**
	   * Retrieves the top of a stack.
	   * Precondition: None.
	   * Postcondition: If the stack is not empty, the item that was added most recently is returned. 
	   * The stack is unchanged.
	   * @return The item that was added most recently
	   * @throws StackException Throws StackException if the stack is empty.
	   */
	  public E peek() throws StackException;
	  
	  /**
	   * Adds an item to the top of a stack.
	   * Precondition: newItem is the item to be added.
	   * Postcondition: If insertion is successful, newItem is on the top of the stack.
	   * @param newItem The item to be added to the stack
	   * @throws StackException Some implementations may throw StackException when newItem cannot 
	   *                        be placed on the stack.
	   */
	  public void push(E newItem) throws StackException;
	  
	  /**
       * Removes the top of a stack.
       * Precondition: None.
       * Postcondition: If the stack is not empty, the item that was added most recently is removed
       *                from the stack and returned.
       * @return The item that was most recently added to this stack
       * @throws StackException Throws StackException if the stack is empty.
       */
	  public E pop() throws StackException;
	  
	  /**
	   * Determines whether the stack is empty.
	   * Precondition: None.
	   * Postcondition: Returns true if the stack is empty; otherwise returns false.
	   * @return A boolean value specifying if this stack is empty
	   */
	  public boolean isEmpty();
 	 
	}

	
