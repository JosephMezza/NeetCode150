


//This solution is slightly different. It is the real implementation of Floyd's cycle detection.
//Slow and fast start at head, and before any comparisons we instantly change slow to head.next and
//fast to head.next.next.
//Gap after every iteration:
//Start: 0 (both head)
//1: 1 (slow = 1, fast = 2)
//2: 2 (slow = 2, fast = 4)
//etc..
//We itterate while fast != null and fast.next != null
//This is because we can end up with 2 scenarios:
//Ex: 1 2 3 -> Here after 1 iteration fast would become 3, so (fast.next != null) protects us
//Ex: 1 2 -> Here after 1 iteration fast would become null (right of 2) so (fast != null) protects us
class Solution {
      //Definition for singly-linked list.
  private class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
  
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                return true;
            }
        }
        return false;
    }
}
