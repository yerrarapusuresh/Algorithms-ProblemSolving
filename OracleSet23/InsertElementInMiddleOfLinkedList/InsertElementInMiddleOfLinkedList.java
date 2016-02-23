import java.util.Scanner;

public class InsertElementInMiddleOfLinkedList{
	static class Node{
		int data;
		Node next;
		public Node(int data, Node next){
			this.data = data;
			this.next = next;
		}
	}
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		Node head = null;
		int listLen = in.nextInt();
		for(int i = 0; i < listLen; i++)
			head = insert(head, in.nextInt());

		head = insertMiddle(head, in.nextInt());
		printList(head);
		
	}
	public static Node insertMiddle(Node head, int data){
		if(head == null)
			return new Node(data, null);
		Node slow, fast;
		slow = fast = head;
		while(true){
			if(fast.next != null && fast.next.next != null )
				fast = fast.next.next;
			else 
				break;
			slow = slow.next;

		}
		slow.next = new Node(data, slow.next);
		return head;
	}

	public static Node insert(Node head, int data){
		if(head == null)
			return new Node(data, null);
		Node temp = head;
		while(temp.next != null)
			temp = temp.next;
		temp.next = new Node(data, null);
		return head;

	}

	public static void printList(Node head){
		while(head != null){
			System.out.print(" "+head.data);
			head  = head.next;
		}
		System.out.println();
	}
}














