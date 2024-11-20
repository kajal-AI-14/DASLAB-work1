/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAS;

class LinkedList {
    private Node top; 
    public static class Node {
        public int data;
        public Node next; 


        public Node(int data) {
            this.data = data;
            this.next = null; 
        }
    }
    public void insertFirst(int data) {
        Node newNode = new Node(data); // 
        newNode.next = top; 
        top = newNode; 
    }
    public Node deleteFirst() {
        if (top == null) { 
            System.out.println("Stack is empty. Cannot pop.");
            return null;
        }
        Node temp = top; 
        top = top.next; 
        return temp; 
    }

    public void displayList() {
        if (top == null) { 
            System.out.println("Stack is empty.");
            return;
        }
        Node current = top; 
        while (current != null) { 
            System.out.println(current.data); 
            current = current.next; 
        }
    }
}

class LinkedListStack {
    private LinkedList li = new LinkedList(); 

    
    public void push(int element) {
        li.insertFirst(element);
    }


    public void pop() {
        LinkedList.Node removedNode = li.deleteFirst();
        if (removedNode == null) { 
        }
    }
  public void displayStack() {
        System.out.println("Stack elements:");
        li.displayList();
    }
}

public class LLStackClient {
    public static void main(String[] args) {
        LinkedListStack stack = new LinkedListStack(); 


        stack.push(50);
        stack.push(70);
        stack.push(190);
        System.out.println("1. Stack after push operation:");
        stack.displayStack();

     
        System.out.println("\n2. Stack after pop operation:");
        stack.pop();
        stack.displayStack();
}
}