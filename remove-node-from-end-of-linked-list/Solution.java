//Here, we initialize out left pointer at the dummy node, and our right 1 ahead.
//We keep left and right separated by n+1 nodes, so that when right reaches the end,
//our left is on the pointer BEFORE the one being removed so we can do left.next = left.next.next;
class Solution {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);

        ListNode left = dummy;
        ListNode right = head;

        for(int i=0; i<n; i++){
            right = right.next;
        }

        while(right != null){
            right = right.next;
            left = left.next;
        }

        left.next = left.next.next;

        return dummy.next;
    }
}



//This uses 2 pointer is it is optimal! But it can be cleaned up a bit.
//The way I did it here is using a previous ListNode, but there is a way do solve it without it.
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

// class Solution {
//     public ListNode removeNthFromEnd(ListNode head, int n) {
//         ListNode dummy = new ListNode(-1, head);

//         ListNode left = head;
//         ListNode prev = dummy;

//         for(int i = 0; i<n; i++){
//             head = head.next;
//         }

//         ListNode right = head;

//         while(right != null){
//             left = left.next;
//             right = right.next;
//             prev = prev.next;
//         }

//         prev.next = left.next;

//         return dummy.next;
//     }
// }


//Time complexity: O(2n), where n is the length of the list.
//Space complexity: O(1), we create a single dummy ListNode, and then create pointers to the original nodes
//The dummy node is useful when deleting the first not since prev will start at the dummy instead of null.
//This can be improved.. still thinking of the single pass.
// class Solution {
//       public class ListNode {
//       int val;
//       ListNode next;
//       ListNode() {}
//       ListNode(int val) { this.val = val; }
//       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//   }

//     public ListNode removeNthFromEnd(ListNode head, int n) {
//         ListNode dummy = new ListNode(-1, head);

//         int totalCount = 0;
//         while(head != null){
//             head = head.next;
//             totalCount++;
//         }

//         int stepsToMove = totalCount - n;
//         ListNode prev = dummy;
//         head = dummy.next;

//         for(int i=0; i<stepsToMove; i++){
//             prev = head;
//             head = head.next;
//         }

//         prev.next = head.next;

//         return dummy.next;
//     }
// }
