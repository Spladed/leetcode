package _2_add_two_numbers;

public class AddTwoNumbers {

    private static class ListNode {
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

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode flag = head;
        int carry = 0;
        while (l1 != null && l2 != null) {
            int val = l1.val + l2.val + carry;
            carry = val / 10;
            flag.next = new ListNode(val % 10);
            flag = flag.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int val = l1.val + carry;
            carry = val / 10;
            flag.next = new ListNode(val % 10);
            flag = flag.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            int val = l2.val + carry;
            carry = val / 10;
            flag.next = new ListNode(val % 10);
            flag = flag.next;
            l2 = l2.next;
        }

        if (carry != 0) {
            flag.next = new ListNode(carry);
        }

        return head.next;
    }

    private static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        add(head, l1, l2, 0);
        return head.next;
    }

    private static void add(ListNode result, ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null) {
            result.next = carry == 0 ? null : new ListNode(carry);
            return;
        }
        int val1 = l1 == null ? 0 : l1.val;
        int val2 = l2 == null ? 0 : l2.val;
        int val = val1 + val2 + carry;
        carry = val / 10;
        result.next = new ListNode(val % 10);
        add(result.next, l1 != null ? l1.next : null, l2 != null ? l2.next : null, carry);
    }

    public ListNode addTwoNumbers3(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode tail = head;
        int sign = 0;
        while (l1 != null || l2 != null) {
            int n1 = (l1 != null) ? l1.val : 0;
            int n2 = (l2 != null) ? l2.val : 0;
            int sum = n1 + n2 + sign;
            sign = sum / 10;
            tail.next = new ListNode(sum % 10);
            tail = tail.next;
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        if (sign > 0)
            tail.next = new ListNode(sign);
        return head.next;
    }

    public static void main(String[] args) {
        ListNode l1 = Build(new int[]{9, 9, 9, 9, 9, 9, 9});
        ListNode l2 = Build(new int[]{9, 9, 9, 9});
        // should be [8,9,9,9,0,0,0,1]
        ListNode result = addTwoNumbers(l1, l2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    private static ListNode Build(int[] input) {
        ListNode head = new ListNode();
        ListNode flag = head;
        for (int i : input) {
            flag.next = new ListNode(i);
            flag = flag.next;
        }
        return head.next;
    }

}
