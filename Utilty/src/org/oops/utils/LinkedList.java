package org.oops.utils;

public class LinkedList {
	
	Node start;
	Node end;
	Node current;
	public int maxCount;
	
	public void add(Object data)
	{
		Node tmpNode = new Node(data);
		
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
	public void delete(int index)
	{
		if((start==null) || index>maxCount-1)
		{
			return;
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
			Node tmpNode= start;
			for(int iTmp=0; iTmp<index; iTmp++, tmpNode= tmpNode.next);
			
			tmpNode.previous.next = tmpNode.next;
			tmpNode.next.previous= tmpNode.previous;
			
			tmpNode = null;
		}
		maxCount --;
	}
	public void insert(int index, Object data)
	{
	   if(index < 0 || index > maxCount)
	        return;
	   
	   if(index == 0)
	    {
	        Node tmpNode = new Node(data);
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

	    Node tmpNode = new Node(data);

	    Node current = start;
	    for(int i = 0; i < index; i++, current = current.next);

	    Node prevNode = current.previous;

	    prevNode.next = tmpNode;      // prev → new node
	    tmpNode.previous = prevNode;  // new node ← prev
	    tmpNode.next = current;       // new node → current
	    current.previous = tmpNode;   // new node ← current

	    maxCount++;
	}
	public Object getNode(int index)
	{
	    if(start == null || index > maxCount - 1 || index < 0)
	        return null;

	    Node tmpNode = start;
	    for(int i = 0; i < index; i++, tmpNode = tmpNode.next);

	    current = tmpNode;
	    return current.data;
	}
	public Object getFirst()
	{
		if(start==null)
		{
			return null;
		}
		current=start;
		return current.data;
	}
	public Object getLast()
	{
		if(start==null)
		{
			return null;
		}
		current=end;
		return current.data;
	}
	
	public Object getPrevious() 
	{
		if (start==null || current == start)
			return null;
		current = current.previous;
			return current.data;
	}
	public Object getNext() {
		if (start == null || current == end)
			return null;
		current = current.next;
			return current.data;
	}
	public Object getMaxCount()
	{
		return maxCount;
	}
}
