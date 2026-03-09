class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevGroup = dummy;
        ListNode curr = head;

        while (true) {
            // Check if there are k nodes left
            ListNode temp = curr;
            int count = 0;
            while (temp != null && count < k) {
                temp = temp.next;
                count++;
            }
            if (count < k) break; // Less than k nodes, stop

            // Reverse k nodes
            ListNode prev = null;
            ListNode node = curr;
            for (int i = 0; i < k; i++) {
                ListNode nextNode = node.next;
                node.next = prev;
                prev = node;
                node = nextNode;
            }

            // Connect previous group to reversed part
            prevGroup.next = prev;
            curr.next = node; // curr is now the tail of reversed group

            // Move prevGroup and curr to next group
            prevGroup = curr;
            curr = node;
        }

        return dummy.next;
    }
}
