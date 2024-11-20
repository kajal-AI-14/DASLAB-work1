/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAS;

public class StackArray {
    private int arr[];
    private int size;
    private int index = 0;

    public StackArray(int size) {
        this.size = size;
        arr = new int[size];
    }

    public void push(int element) {
        if (isFull()) {
            System.out.println("Stack is full");
            return;
        }
        arr[index] = element;
        index++;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is Empty");
            return -1; 
        }
        return arr[--index];
    }

    public boolean isEmpty() {
        return index == 0;
    }

    public boolean isFull() {
        return index == size;
    }

    public int getSize() {
        return index;
    }
}

class StackClient {
    public static void main(String[] args) {
        StackArray stack = new StackArray(5);
        stack.push(8);
        stack.push(11);
        stack.push(13);
        stack.push(20);
        stack.push(11);

        System.out.println("1. Size of stack after push operation: " + stack.getSize());

        System.out.print("2. Pop elements from stack: ");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }

        System.out.println("\n3. Size of stack after pop operation: " + stack.getSize());
    }
}


