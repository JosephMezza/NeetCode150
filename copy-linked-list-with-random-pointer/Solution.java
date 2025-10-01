//Time complexity: O(3n) -> O(n) This algorithm is split into 3 steps. 
//1. Build all new nodes and link them to their original.
//2. Link the new nodes to their new random counterparts. By using the original nodes .random, it will bring us to the
//original random node. Then, using the original random node's .next, we know it is linked to its new node couterpart.
//3. Link the original nodes back together.
//Time complexity: O(1) WOHOO! No hash map needed! We add the new nodes to the original list and on the third pass we
//split them into 2 separate lists.
class Solution {
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
    // Definition for a Node.
    public Node copyRandomList(Node head) {
        if(head == null){
            return head;
        }
        
        Node ogHead = head;

        while(head != null){
            Node ogNext = head.next;

            head.next = new Node(head.val);
            head.next.next = ogNext;

            head = ogNext;
        }

        head = ogHead;
        while(head != null){
            Node ogRand = head.random;

            if(ogRand != null){
                head.next.random = ogRand.next;
            }

            head = head.next.next;
        }

        head = ogHead;
        Node newHead = head.next;

        while(head != null){
            Node newNode = head.next;

            Node oldNext = newNode.next;

            head.next = oldNext;

            newNode.next = newNode.next != null ? newNode.next.next : null;

            head = head.next;
        }

        return newHead;
    }
}


// import java.util.HashMap;

// //Cleaned up. Instead of tracking the linked list in another list, we use the first itteration to create all of the copies.
// //Then, in the second itteration we link all of the copies together and then use the hashmap to return the copied head.
// class Solution {
//     // Definition for a Node.
// class Node {
//     int val;
//     Node next;
//     Node random;

//     public Node(int val) {
//         this.val = val;
//         this.next = null;
//         this.random = null;
//     }
// }

//     public Node copyRandomList(Node head) {
//         HashMap<Node, Node> hash = new HashMap<>();

//         Node ogHead = head;

//         while(head != null){
//             Node copy = new Node(head.val);
//             hash.put(head,copy);

//             head = head.next;
//         }

//         head = ogHead;
        
//         while(head != null){
//             Node copy = hash.get(head);
//             copy.next = hash.get(head.next);
//             copy.random = hash.get(head.random);
//             head = head.next;
//         }

//         return hash.get(ogHead);
//     }
// }


//Time complexity: O(2n) -> O(n) since we traverse n nodes of the linked list twice.
//Space complexity: O(2n) -> O(n) since we need a hashmap to store 2n nodes (old list and new).
// class Solution {
//     // Definition for a Node.
// class Node {
//     int val;
//     Node next;
//     Node random;

//     public Node(int val) {
//         this.val = val;
//         this.next = null;
//         this.random = null;
//     }
// }
//     public Node copyRandomList(Node head) {
//         HashMap<Node, Node> hash = new HashMap<>();

//         Node dummy = new Node(-1);
//         Node ogHead = head;
//         Node newHead = dummy;

//         while(head != null){
//             Node copy = new Node(head.val);
//             newHead.next = copy;
//             hash.put(head,copy);

//             head = head.next;
//             newHead = newHead.next;
//         }

//         newHead = dummy.next;
//         head = ogHead;

//         while(head != null){
//             if(head.random != null){
//             Node newRandom = hash.get(head.random);

//             newHead.random = newRandom;
//             }

//             head = head.next;
//             newHead = newHead.next;
//         }

//         return dummy.next;
//     }
// }
