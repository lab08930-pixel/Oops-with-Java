package src.org.oops.utils;

public class LinkedList<T> {
	
	Node<T> start;
	Node<T> end;
	Node<T> current;
	int maxCount;
	
	public void add(T data)
	{
		Node<T> tmpNode = new Node<>(data);
		
		if(start==null)
		{
			start = current = end = tmpNode;
		}
		else
		{
			 end.next = tmpNode;
			 tmpNode.previous = end;
			 end = tmpNode;
		}
		maxCount++;
	}
	public void delete(int index) throws LinkedListException
	{
		if((start==null) || index>maxCount-1 || index <0)
		{
			throw new LinkedListException("Invalid Index or no nodes");
			
		}
		else if(index==0)
		{
			start=start.next;
			start.previous=null;
		}
		else if(index==maxCount-1)
		{
			end=end.previous;
			end.next=null;
		}
		else
		{
			Node<T> tmpNode= start;
			for(int iTmp=0; iTmp<index; iTmp++, tmpNode= tmpNode.next);
			
			tmpNode.previous.next = tmpNode.next;
			tmpNode.next.previous= tmpNode.previous;
			
			tmpNode = null;
		}
		maxCount --;
	}
	public void insert(int index, T data)
	{
	   if(index < 0 || index > maxCount)
	        return;
	   
	   if(index == 0)
	    {
	        Node<T> tmpNode = new Node<>(data);
	        tmpNode.next = start;
	        start.previous = tmpNode;
	        start = tmpNode;
	        maxCount++;
	        return;
	    }
	    
	    if(index == maxCount)
	    {
	        add(data);
	        return;
	    }

	    Node<T> tmpNode = new Node<>(data);

	    Node<T> current = start;
	    for(int i = 0; i < index; i++, current = current.next);

	    Node<T> prevNode = current.previous;

	    prevNode.next = tmpNode;      // prev → new node
	    tmpNode.previous = prevNode;  // new node ← prev
	    tmpNode.next = current;       // new node → current
	    current.previous = tmpNode;   // new node ← current

	    maxCount++;
	}
	public T getNode(int index)	throws LinkedListException
	{
	    if(start == null || index > maxCount - 1 || index < 0)
	        throw new LinkedListException("Empty List");

	    Node<T> tmpNode = start;
	    for(int i = 0; i < index; i++, tmpNode = tmpNode.next);

	    current = tmpNode;
	    return current.data;
	}
	public T getFirst() throws LinkedListException
	{
		if(start==null)
		{
			throw new LinkedListException("Empty List");
		}
		
		current=start;
		return current.data;
	}
	public T getLast() throws LinkedListException
	{
		if(start==null)
		{
			throw new LinkedListException("Empty List");
		}
		current=end;
		return current.data;
	}
	
	public T getPrevious() throws LinkedListException
	{
		if (start==null || current == start)
			throw new LinkedListException("Empty List");
		current = current.previous;
			return current.data;
	}
	public T getNext() throws LinkedListException
	{
		if (start == null || current == end)
			throw new LinkedListException("Already At Exception");
		current = current.next;
			return current.data;
	}
	public int getMaxCount()
	{
		return maxCount;
	}
}
