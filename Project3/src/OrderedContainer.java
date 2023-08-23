/** Inherits same functionality as TwoEndContainer. When new objects 
 * are added, it sorts the structure. So it is natural sorted order. 
 * @author Adilet Kuroda
 */
public class OrderedContainer<E extends Comparable<E>> extends TwoEndsContainer<E> {
	
	@Override
	public void add(E element) {
		DLNode <E> node = new DLNode<>();
		node.setData(element);
		DLNode<E>current = front;
		int count = 0;
		if (numberOfElements == 0) {
			front = node;
			back = node;
			numberOfElements ++;
		}
		else {
			while ( current!= null) {
				count ++;
				E data = current.getData();
				if (element.compareTo(data) < 0) {
					if (count ==1) {
						front = node;
						node.setNext(current);
						current.setPrev(node);
						this.numberOfElements ++;
						break;
					}
					else if (count < this.numberOfElements) {
						while ((data.compareTo(element)<0) && count < this.numberOfElements){
							current = current.getNext();
							count ++;
							data = current.getData();
						}
						if (count < this.numberOfElements) {
							DLNode<E>previous = current.getPrev();
							previous.setNext(node);
							node.setNext(current);
							current.setPrev(node);
							node.setPrev(previous);
							this.numberOfElements ++;
							break;
						}
					}
		
				}
			if (count == this.numberOfElements) {
				if (element.compareTo(data) < 0) {
					DLNode<E>previous = current.getPrev();
					previous.setNext(node);
					node.setNext(current);
					current.setPrev(node);
					node.setPrev(previous);
					this.numberOfElements ++;
					break;
				}
				else {
					back = node;
					node.setPrev(current);
					current.setNext(node);
					this.numberOfElements ++;
					break;
				}
			}	
			current = current.getNext();
			
			
				
			}
		}		
	}

}

