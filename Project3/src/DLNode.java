
/**
 * @author Adilet Kuroda
 * 
 */
public class DLNode <E extends Comparable<E>> {
	protected DLNode <E> previous;
	protected DLNode <E> next;
	protected E data;
	
/** Default constructor. Initialize the fields to default value
 */
	public DLNode() {
		this.previous = null;
		this.next = null;
		this.data = null;
		
	}
/** Constructor 
 * @param Generic type data that is being stored 
 */
	public DLNode(E Data) {
		this.previous = null;
		this.next = null;
		this.data = Data;
	}

	/** Returns value that is stored on node 
	 * @return the data  a value of a node 
	 */
	public E getData() {
		return this.data;
	}

	/** Setter 
	 * @param data that stored in a node 
	 */
	public void setData(E data) {
		this.data = data;
	}

	/** Getter 
	 * @return the previous reference of a node that is pointing to previous one 
	 */
	public DLNode<E> getPrev() {
		return previous;
	}

	/** Setter
	 * @param previous value where the previous node should point  
	 */
	public void setPrev(DLNode<E> previous) {
		this.previous = previous;
	}

	/** Getter
	 * @return the next reference of a node that is pointing to next node
	 */
	public DLNode<E> getNext() {
		return next;
	}

	/**Setter
	 * @param next is a value that note will point 
	 */
	public void setNext(DLNode<E> next) {
		this.next = next;
	}
/** String Representation of an object 
 * 
 */
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append(this.getData());
		return str.toString();
	}



}
