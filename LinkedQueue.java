/**
A class that implements a queue of objects by using
a chain of linked nodes.
*/

public final class LinkedQueue<T> implements QueueInterface<T>
{
	private Node firstNode; // References node at front of queue
	private Node lastNode; // References node at back of queue
	private int numberOfEntries = 0;
	
	public LinkedQueue()
	{
		firstNode = null;
		lastNode = null;
	} // end default constructor
	
	public void enqueue(T newEntry)
	{
		Node newNode = new Node(newEntry, null);
		if (isEmpty())
			firstNode = newNode;
		else
			lastNode.setNextNode(newNode);
		lastNode = newNode;
		numberOfEntries++;
	} // end enqueue
	
	public T getFront()
	{
		assert !isEmpty();
		return (T) firstNode.getData();
	} // end getFront
	
	public T dequeue()
	{
		T front = getFront(); // Might throw EmptyQueueException
		// Assertion: firstNode != null
		firstNode.setData(null);
		firstNode = firstNode.getNextNode();
		if (firstNode == null)
			lastNode = null;
		numberOfEntries--;
		return front;
	} // end dequeue
	
	public boolean isEmpty()
	{
		return (firstNode == null) && (lastNode == null);
	} // end isEmpty
	
	public void clear()
	{
		firstNode = null;
		lastNode = null;
	} // end clear
	
	public T[] toArray()
	{
		// The cast is safe because the new array contains null entries
		@SuppressWarnings("unchecked")
		T[] result = (T[])new Object[numberOfEntries]; //Unchecked cast
		
		int index = 0;
		Node currentNode = firstNode;
		while ((index < numberOfEntries) && (currentNode != null))
		{
			result[index] = (T) currentNode.getData();
			index++;
			currentNode = currentNode.getNextNode();
		} // end while
		
		return result;
	} // end toArray
	
	private class Node<T> 
	{
		private T		 data; //entry in bag
		private Node<T>	 next; //link to next node

		private Node(T dataPortion)
		{
			this(dataPortion, null);
		} // end constructor

		private Node(T dataPortion, Node<T> nextNode) 
		{
			data = dataPortion;
			next = nextNode;
		} // end constructor

		private T getData()
		{
			return data;
		} // end getData

		private void setData(T newData)
		{
			data = newData;
		} // end setData

		private Node<T> getNextNode()
		{
			return next;
		} // end getNextNode
		
		private void setNextNode(Node<T> nextNode)
		{
			next = nextNode;
		} // end setNextNode
	} // end Node
} // end LinkedQueue