//Time complexity: O(n/2 + n/2 + n/2) -> O(n). 
//Because:
//1. We find the mid using slow, fast and this is O(n/2)
//2. Then we find our second half of the list starting at mid.next (Why?) and we reverse it ~O(n/2)
//Ex: [0 1 2 3] -> mid: 2, first: [0 1 2], second: [3] because we can only weave in 1 number
// [0 1 2 3 4] -> mid: 2, first: [0 1 2], second: [3 4] because we can weave in 2 numbers
//3. We merge for the length of the second linked list ~O(n/2)
//Space complexity: O(1), everything is done within the original linked list
class Solution {

      //Definition for singly-linked list.
  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public void reorderList(ListNode head) { 
        //We can assume the first head will not be null (said in the constraints).

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode first = head;

        ListNode mid = slow;
        ListNode second = mid.next;
        mid.next = null; //Detach

        ListNode prev = null;
        while(second != null){ //Reverse second
            ListNode tmp = second.next;
            second.next = prev;
            prev = second;
            second = tmp;
        }

        second = prev;

        while(second != null)
        {
            ListNode Anext = head.next;
            ListNode Bnext = second.next;

            head.next = second;
            second.next = Anext;

            second = Bnext;
            head = Anext;
        }
    }
//First attempt, same time and space complexity just a little more inneficient:
    //     public void reorderList(ListNode head) { 
    //     int count = 0;
    //     ListNode countingHead = head;
    //     while(countingHead != null){
    //         countingHead = countingHead.next;
    //         count++;
    //     }

    //     if(count <= 2){
    //         return;
    //     }

    //     int indexToReverse = (count / 2);

    //     ListNode mid = head;
    //     for(int i = 0; i<indexToReverse; i++){
    //         mid = mid.next;
    //     }

    //     ListNode reverseHead = mid.next;
    //     mid.next = null;

    //     ListNode prev = null;
    //     while(reverseHead != null){
    //         ListNode next = reverseHead.next;
    //         reverseHead.next = prev;
    //         prev = reverseHead;
    //         reverseHead = next;
    //     }

    //     reverseHead = prev;

    //     while(reverseHead != null)
    //     {
    //         ListNode Anext = head.next;
    //         ListNode Bnext = reverseHead.next;

    //         head.next = reverseHead;
    //         reverseHead.next = Anext;

    //         reverseHead = Bnext;
    //         head = Anext;
    //     }
    // }
}



