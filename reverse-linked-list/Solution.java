 //Time complexity: O(n), where n is the length of the linked list
 //Space complexity: O(1), since we change where the existing elements point.
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode lastNode = null;
        ListNode currentNode = head;
        ListNode nextNode = null;

        while(currentNode != null){
            nextNode = currentNode.next;
            currentNode.next = lastNode;
            lastNode = currentNode;
            currentNode = nextNode;
        }
        
        return lastNode;
    }

      private class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
