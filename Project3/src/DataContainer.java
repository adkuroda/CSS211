
/**
 * @author Adilet Kuroda
 *
 */
public interface DataContainer<E extends Comparable<E>> {

/** Adds given elements to a container 
 * @param newElement to be added to existing container 
 */
	public abstract void add(E newElement);
/** Removes an element from container. Throws an EmptyContainerException 
 * if the container is empty. 
 * @return an element that is removed 
 */
	public E removed();
	
/** removes a specific element. Throws an EmptyContainerException exception if 
 * the container is empty. 
 * @param element: element that needs to be removed 
 * @return rue if the operation is successful. If the element to be 
 * removed does not exist in the container, it will return false
 */
	public boolean remove(E element);
/**  removes all elements in the data container. Throws EmptyContainerException
 * if the container is empty
 */
	public void clear();
/** Gets first element that would be removed by remove() method. Throws EmptyContainerException
 * if the container is empty. 
 * @return first Element 
 * @ see remove();
 */
	public E getFirst();
/** Gets last element that would be removed by remove() method. Throws EmptyContainerException
* if the container is empty. 
* @return last Element 
* @ see remove();
*  */
	public E getLast();
/** Determines if the container is full or not 
 * @return true if the container is full, else false
 */
	public boolean isFull();
/** Determines how many elements container has 
 * @return number representing size of an container 
 */
	public int size ( );
	
/** Determines if the Element key exist in a container 
 * @param key an element that is  being searched 
 * @return true if key exist, else false. 
 */
	public boolean search(E key);
/** Recursive search for the a element key from position node. 
 * @param key an element that is being searched 
 * @param node a node that search should start 
 * @return 
 */
	public boolean search(E key, DLNode<E> node);
/** Determines if the container is empty or full 
 * @return true if empty else false 
 */
	public boolean isEmpty();

}