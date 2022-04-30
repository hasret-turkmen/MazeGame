class Node{
			private String data;  //Nodes will hold String inside
		private	Node next;
			
			public Node(String d) {
				data=d;
				next=null;
			}
			
			public String getData() {
				return data;
			}
			public void setData(String data) {
				this.data = data;
			}
			public Node getNext() {
				return next;
			}
			public void setNext(Node next) {
				this.next = next;
			}
			
			
		}	


