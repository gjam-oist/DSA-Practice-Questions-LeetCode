/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node iter = head;
        Node front = head;
        // Adding Pseudo Nodes
        while(iter != null){
            front = iter.next;
            Node copy = new Node(iter.val);
            iter.next = copy;
            copy.next = front;
            iter = front;
        }
        // Assigning Random Pointers
        iter = head;
        while(iter != null){
            if(iter.random != null){
                iter.next.random = iter.random.next;
                
            }
            iter = iter.next.next;
        }
        // Seggregating the deepCopy and Original LinkedList
        iter = head;
        Node pseudoHead = new Node(0);
        Node temp = pseudoHead;
        
        while(iter != null){
            front = iter.next.next;
            temp.next = iter.next;
            temp = temp.next;
            iter.next = front;
            iter = front;
        }
        
        return pseudoHead.next;
    }
}
