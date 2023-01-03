class ListNode {
   int val;
   ListNode next;

   ListNode() {
   }

   ListNode(int val) {
      this.val = val;
   }

   ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
   }
}

public class App {
   public ListNode middleNode(ListNode head) {

      ListNode slow = head;

      while (head != null && head.next != null) {
         slow = slow.next;
         head = head.next.next;
      }

      return slow;
   }
}