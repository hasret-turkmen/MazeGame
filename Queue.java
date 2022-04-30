
public class Queue {
	Node first;
	Node last;
	
	public Queue() {
		first=null;
		last=null;
	}
	class Node
	{
	String item;
	Node next;
	}
	
	public boolean isEmpty()
	{ return first == null; }
	
	public String dequeue()
	{
	String item = first.item;
	first = first.next;
	if (isEmpty()) last = null;
	return item;
	}
	Node get(int i) {
		Node tmp = first;
		for (int k = 0; k < i; k++)
			tmp = tmp.next;
		return tmp;
	}

	
	public void enqueue(String item)
	{
	Node oldlast = last;
	last = new Node();
	last.item = item;
	last.next = null;
	if (isEmpty()) first = last;
	else oldlast.next = last;
	}
	static void PrintQueue(Queue a)
	{
		while(!a.isEmpty()) {
		System.out.println( a.dequeue());
	}}
	
}
