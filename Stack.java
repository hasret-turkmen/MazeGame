
public class Stack {
	private Node top = null;
	private int size = 0;

	//Stack will hold Strings since I print them as one word
	class Node {
		String item;  
		Node next;
	}

	boolean isEmpty() {
		return top == null;
	}

	void push(String waysCanGo) {
		Node oldfirst = top;
		top = new Node();
		top.item = waysCanGo;
		top.next = oldfirst;
		size++;
	}

	public String pop() {
		Node item = top;
		top = top.next;
		item.next = null;
		if (size > 0)
			size--;
		return item.item;

	}
	public int compare(String s1, String s2) 
	{ return s1.length() - s2.length(); }

	Node get(int i) {
		Node tmp = top;
		for (int k = 0; k < i; k++)
			tmp = tmp.next;
		return tmp;
	}

	int size() {
		int theSize = size;
		return theSize;

	}

	String peek() { // returns the latest top
		return this.top.item;
	}

	void PrintStack(Stack stack) // prints the stack from bottom to top
	{
		if (stack.isEmpty())
			return;
		String p = stack.peek();
		stack.pop();
		PrintStack(stack);
		System.out.print(p);
		System.out.println();
		// Pushes the same element onto the stack
		int a=1;
		String s = "";
		s += a + ") ";
		stack.push(s+p);
	}
}
