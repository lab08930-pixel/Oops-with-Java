package src.org.oops.utils;

class Node<T> {
	T data;
	
	Node<T> previous;
	Node<T> next;
	
	public Node(T tmp) 
	{
		data = tmp;
	}
}
