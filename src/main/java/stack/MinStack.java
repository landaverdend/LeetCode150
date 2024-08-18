package stack;

class Node {
    int val;
    Node next;

    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }
}

class MinStack {

    Node head;

    // how to keep track if we pop the current min?
    // Answer: use a separate running stack to keep track of all mins....
    Node min;


    public MinStack() {

    }

    public void push(int val) {
       Node n = new Node(val, head);
       head = n; // set the head to new node.

        // keep a separate stack of the min nodes.
        if (min == null) {
            min = new Node(val, null);
        }
        else if (n.val <= min.val) {
            min = new Node(n.val, min);
        }
    }

    public void pop() {
        if (head != null) {
            int val = head.val;
            if (val == min.val) {
                min = min.next;
            }
            // move head ptr
            head = head.next;
        }
    }

    public int top() {
       return head.val;
    }

    public int getMin() {
        return min.val;
    }
}
