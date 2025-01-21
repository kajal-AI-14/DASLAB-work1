/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LABTASK;

/**
 *
 * @author HP
 */
class Vertex {
    String label;
    boolean isVisited;
    Vertex[] neighbours;

    public Vertex(String label) {
        this.label = label;
        this.isVisited = false;
    }

    public void addNeighbours(Vertex[] neighbours) {
        this.neighbours = neighbours;
    }
}

class Edge {
    Vertex start;
    Vertex end;

    public Edge(Vertex start, Vertex end) {
        this.start = start;
        this.end = end;
    }
}

class LinkedListStack {
    LinkedList list = new LinkedList();

    public void push(Vertex element) {
        list.insertFirst(element);
    }

    public void pop() {
        list.deleteFirst();
    }

    public Vertex peek() {
        return list.front.data;
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
}

class LinkedList {
    Node front;
    Node rear;

    static class Node {
        Vertex data;
        Node next;

        public Node(Vertex data) {
            this.data = data;
            this.next = null;
        }
    }

    public boolean isEmpty() {
        return (front == null);
    }

    public void insertFirst(Vertex element) {
        Node newNode = new Node(element);
        newNode.next = front;
        front = newNode;

        if (rear == null) {
            rear = newNode;
        }
    }

    public void deleteFirst() {
        if (isEmpty()) {
            System.out.println("List is empty");
            return;
        }
        front = front.next;

        if (front == null) {
            rear = null;
        }
    }

    public void displayList() {
        Node current = front;
        while (current != null) {
            System.out.print(current.data.label + " ");
            current = current.next;
        }
        System.out.println();
    }
}

class Graph {
    private int v;
    Edge[] edgeList;

    public Graph(int v) {
        this.v = v;
    }

    public Vertex createVertex(String label) {
        return new Vertex(label);
    }

    public Edge createEdge(Vertex start, Vertex end) {
        return new Edge(start, end);
    }

    public void createEdgeList(Edge[] edges) {
        edgeList = new Edge[edges.length];
        System.arraycopy(edges, 0, edgeList, 0, edges.length);
    }

    public void printGraphDF(LinkedListStack stack) {
        if (stack.isEmpty()) {
            return;
        }

        Vertex current = stack.peek();
        current.isVisited = true;

        System.out.println(current.label);

        stack.pop();

        if (current.neighbours != null) {
            for (Vertex neighbour : current.neighbours) {
                if (!neighbour.isVisited) {
                    stack.push(neighbour);
                }
            }
        }

        printGraphDF(stack);
    }
}

public class GraphDriver {
    public static void main(String[] args) {
        Graph graph = new Graph(5);
        Vertex a, b, c, d, e;

        a = graph.createVertex("A");
        b = graph.createVertex("B");
        c = graph.createVertex("C");
        d = graph.createVertex("D");
        e = graph.createVertex("E");

        a.addNeighbours(new Vertex[]{b, d});
        b.addNeighbours(new Vertex[]{a, c});
        c.addNeighbours(new Vertex[]{b});
        d.addNeighbours(new Vertex[]{a, e});
        e.addNeighbours(new Vertex[]{d});

        LinkedListStack stack = new LinkedListStack();
        stack.push(a);

        System.out.println("Printing Graph: Depth First Traversal");
        graph.printGraphDF(stack);
    }
}

