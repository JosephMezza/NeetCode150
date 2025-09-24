
//Time complexity: O(n + m)
//Space complexity: O(1)

//Summary: (Trick)[Create the merged list starting with a single dummy node. This simplified null checks a lot.]
//Then create a head ListNode variable which points to merged. Now in the loop we break as soon as A or B are null, because
//then we can just append the rest of either one to merged after the loop!
//In the loop, if A.val < B.val, then we set the next link to A, and we move A to it's next link for the next itteration comparison.
//Then we move our merged to the next linked item we just attached.
//How does this not break the links in the original? It does, but we keep reference to the next using A and B before breaking the link
//eith merged.next. For example if we are at [1 (from B)] in our merged, and  now in the next itteration, A.val < B.val (1<3). Even though
//we switch what (1 (B)).next is referencing, we still have a reference to (3 (B)) with B.

//What would list1 and list2 look like in the end?
//They will still be pointing to their original ListNode! So for the case of:
//[1 2 4]
//[1 3 5]
//list1 : [1 ->1 2 3 4 5]
//list2 : [->1 1 2 3 4 5]

class Solution{
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode merged = new ListNode(-1); //dummy
        ListNode head = merged;

        ListNode A = list1;
        ListNode B = list2;

        while(A != null && B != null){
            if(A.val < B.val){
                merged.next = A;
                A = A.next;
            }
            else{
                merged.next = B;
                B = B.next;
            }
            merged = merged.next;
        }
        
        if(A == null){
            merged.next = B;
        }
        else{
            merged.next = A;
        }

        return head.next;
    }

    private class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}

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

//Time complexity: O(n + m), where n and m are the lengths of the original lists respectively.
//Space complexity: O(n + m), where n and m are the lengths of the original lists respectively.
//My first solution. Rough. Have null checks in my loop which can be avoided and I created a new ListNode each
//time to build merged the LinkedList.

// class Solution {
//     public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//         ListNode list = null;
//         ListNode head = null;

//         while(list1 != null || list2 != null){
//             ListNode nextNode = null;
//             if(list1 == null){
//                 nextNode = new ListNode(list2.val);
//                 list2 = list2.next;
//             }
//             else if(list2 == null){
//                 nextNode = new ListNode(list1.val);
//                 list1 = list1.next;
//             }
//             else if(list1.val < list2.val){
//                 nextNode = new ListNode(list1.val);
//                 list1 = list1.next;
//             }
//             else{
//                 nextNode = new ListNode(list2.val);
//                 list2 = list2.next;
//             }

//             if(head == null){
//                 head = nextNode;
//                 list = head;
//                 continue;
//             }

//             list.next = nextNode;
//             list = list.next;
//         }

//         return head;
//     }
// }