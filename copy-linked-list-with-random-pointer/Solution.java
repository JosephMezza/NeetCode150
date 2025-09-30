
import java.util.HashMap;

//Cleaned up. Instead of tracking the linked list in another list, we use the first itteration to create all of the copies.
//Then, in the second itteration we link all of the copies together and then use the hashmap to return the copied head.
class Solution {
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

    public Node copyRandomList(Node head) {
        HashMap<Node, Node> hash = new HashMap<>();

        Node ogHead = head;

        while(head != null){
            Node copy = new Node(head.val);
            hash.put(head,copy);

            head = head.next;
        }

        head = ogHead;
        
        while(head != null){
            Node copy = hash.get(head);
            copy.next = hash.get(head.next);
            copy.random = hash.get(head.random);
            head = head.next;
        }

        return hash.get(ogHead);
    }
}


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
