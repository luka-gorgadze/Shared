import java.util.NoSuchElementException;

public class LinkedList {
	private Node first;

	public void add(int newValue) {
		Node newNode = new Node();
		newNode.value = newValue;
		if (first == null) {
			first = newNode;
			return;
		}
		newNode.next = first;
		first = newNode;
	}

	public int removeLastAdded() {
		if (first == null) {
			throw new NoSuchElementException();
		}
		Node currentNode = first;
		first = first.next;
		return currentNode.value;
	}

	public void removeAllGreater(int value) {
		if (first == null) {
			return;
		}
		Node previous = first;
		Node current = first.next;
		while (current != null) {
			if (current.value > value) {
				previous.next = current.next;
			}
			previous = previous.next;
			current = previous.next;
		}
		if (first.value > value) {
			first = first.next;
		}
	}

	private static class Node {
		private int value;
		private Node next;
	}

	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList();
		linkedList.add(3);
		linkedList.add(5);
		linkedList.add(4);
		linkedList.add(1);
		linkedList.add(2);
		linkedList.add(0);
		linkedList.add(6);
		linkedList.removeAllGreater(4);
		System.out.println(linkedList.removeLastAdded());
		System.out.println(linkedList.removeLastAdded());
		System.out.println(linkedList.removeLastAdded());
		System.out.println(linkedList.removeLastAdded());
		System.out.println(linkedList.removeLastAdded());
	}
}