/** Two end Container: Adds front the back end and removes only 
 * from front end unless the element is provided 
 * @author Adiet Kuroda
 *
 */
public class TwoEndsContainer<E extends Comparable<E>> implements DataContainer<E>{

	
	protected DLNode <E> front;
	protected int numberOfElements;
	protected DLNode <E> back;
	
/** Default constructor 
 * 
 */
	public TwoEndsContainer() {
		front = null;
		back = null;
		numberOfElements =0;
		
	}

	@Override
	public void add(E newElement) {
		DLNode<E> node = new DLNode<E>(newElement);
		if (numberOfElements == 0) {
			front = node;
			back = node;
			
		}
		else {
			  DLNode<E> current = back;
			  current.setNext(node);
			  node.setPrev(current);
			  back = node;
		}
		numberOfElements ++;
		
	}

	@Override
	public E remove() {
		if (this.numberOfElements == 0) {
			throw new EmptyContainerException();
		}
		DLNode <E> current = front;
		E data = current.getData();
		if (this.numberOfElements == 1) {
			back = null;
			front = null;
			this.numberOfElements--;
			return data;
		}
		this.numberOfElements--;
		front = current.getNext();
		current.getNext().setPrev(null);
		return data;
	}

	@Override
	public boolean remove(E element) {
		if (this.numberOfElements == 0) {
			throw new EmptyContainerException();
		}
		boolean status = false;
		int count = 0;
		DLNode <E> current = front;
		
		while (count < this.numberOfElements) {
			count ++;
			
			E data = current.getData();
			if (data.equals(element)) {
				DLNode<E> previous = current.getPrev();
				
				DLNode<E> next = current.getNext();
			
				previous.setNext(next);
				next.setPrev(previous);
				
				
				this.numberOfElements --;
				return true;
			}
			current = current.getNext();
		
			
			
			
		}
		
		return status;
	}
		

	@Override
	public void clear() {
		if (this.numberOfElements == 0) {
			throw new EmptyContainerException();
		}
		while (this.numberOfElements > 0) {
			remove();
		}
	}

	@Override
	public E getFirst() {
		if (this.numberOfElements == 0) {
			throw new EmptyContainerException();
		}
		E data = front.getData();
		return data;
	}

	@Override
	public E getLast() {
		if (this.numberOfElements == 0) {
			throw new EmptyContainerException();
		}
		E data = back.getData();
		return data;
		
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		return numberOfElements;
	}

	@Override
	public boolean search(E key) {
		DLNode<E> current = front;
		while (current != null) {
			E data =  current.getData();
			if (data.equals(key)) {
				return true;
			}
			current = current.getNext();
			
		}
		return false;
	}

	@Override
	public boolean search(E key, DLNode<E> node) {
		DLNode<E>current = node;
		E data = current.getData();
		if (current.getNext() == null) {
			if (data.equals(key))
				return true;
			else
				return false;
		}
		else if (data.equals(key)) {
			return true;	
		}
		else {
			node = node.getNext();
			return search(key, node);
		}
	}
	

	@Override
	public boolean isEmpty() {
		if (numberOfElements == 0) {
			return true;
		}
		return false;
	}

	/**Getter
	 * @return the front: reference to head 
	 */
	public DLNode<E> getFront() {
		return front;
	}

	/**Setter 
	 * @param front the front to set 
	 */
	public void setFront(DLNode<E> front) {
		this.front = front;
	}
	@Override
	public String toString() {
		DLNode<E> current = front;
			StringBuilder str = new StringBuilder("[");
			
			while(current != null) {
				
				str.append(current.getData());
				current = current.getNext();
				if (current != null)
					str.append(", ");

			}
			str.append("]");
		
		return str.toString();
	}
	
	
}
