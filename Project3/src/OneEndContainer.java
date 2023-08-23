import java.util.Iterator;

/**
 * @author Adilet Kuroda 
 *
 */
public class OneEndContainer<E extends Comparable<E>> implements DataContainer<E>, Iterator<E>{
	protected DLNode<E> front;
	private int numberOfElements;
	private DLNode<E> current  = front;
/**
 * Default constructor: Initialize to default value 
 */
	OneEndContainer(){
		front = null;
		numberOfElements =0;
	}
	
	@Override
	public boolean hasNext() {
		boolean status = (current != null);
		return status;
	}

	@Override
	public E next() {
		E data = current.getData();
		current = current.getNext();
		return data;
	}
	
	
	@Override 
	public void add(E newElement) {
		DLNode<E> node = new DLNode<>();
		node.setData(newElement);
		node.setNext(front);
		front = node;
		numberOfElements ++;
		if (node.getNext() != null) {
			node.getNext().setPrev(node);
			
		}
		
	}
	
	

	@Override
	public E removed() {
		if 	(numberOfElements <=0) {
			throw new EmptyContainerException();
		}
		
		else if(numberOfElements == 1) {	
			DLNode <E> current = front;
			this.numberOfElements --;
			front = null;
			return (E) current.getData();
		}
		else{
			DLNode<E> current = front;
			this.numberOfElements --;
			E removed = (E) current.getData();
			front = current.getNext();
			return removed;
		}
	}

	@Override
	public boolean remove(E element) {
		if 	(numberOfElements <=0) {
			throw new EmptyContainerException();
		}
		DLNode<E> current = front;
		boolean status = false;
		while (current != null) {
			E data  = (E) current.getData();
			if (data.equals(element)) {
				status = true;
				this.numberOfElements --;
				if (current.getPrev() == null) {
					front = current.getNext();
					return status;
				}
				else if (current.getNext() == null) {
					current = null;
				}		
				else {
					current.getPrev().setNext(current.getNext());
					current.getNext().setPrev(current.getPrev());
					//System.out.println("Fix Me: Remove One end");
					return status;
			    }
			}
			current = current.getNext();
			
		}
		return status;
	}


	@Override
	public void clear() {
		if 	(numberOfElements <=0) {
			throw new EmptyContainerException();
		}
		
		while(front != null) {
			remove();
		}
			
		
	}

	@Override
	public E getFirst() {
		if (this.numberOfElements == 0) {
			throw new EmptyContainerException();
		}
		if (front != null) {
			E first = (E)front.getData();
			return first;
		}
		return null;
	}

	@Override
	public E getLast() {
		if (this.numberOfElements == 0) {
			throw new EmptyContainerException();
		}
		DLNode<E> current = front;
		while (current.getNext() != null) {
			current = current.getNext();
		}
		E data = (E) current.getData();
		return data;
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		return this.numberOfElements;
	}

	@Override
	public boolean search(E key) {
		DLNode<E> current = front;
		while (current != null) {
			E data = (E) current.getData();
			if (data.equals(key)) {
				return true;
			}
			current = current.getNext();
		}
		return false;
	}

	@Override
	public boolean search(E key, DLNode<E> node) {
		DLNode<E> current = node;
		E data =(E) current.getData();
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
		if (front == null && this.numberOfElements <=0)
			return true;
		return false;
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