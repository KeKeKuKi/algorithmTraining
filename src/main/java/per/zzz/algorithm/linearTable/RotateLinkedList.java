package per.zzz.algorithm.linearTable;

/**
 * @author 阿忠 2669918628@qq.com
 * @since 2022/4/1 11:22
 */
public class RotateLinkedList {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0 || head.next == null){
            return head;
        }
        ListNode pos = head;
        ListNode end = head;
        int sum = 1;
        while (end.next != null){
            end = end.next;
            sum++;
        }
        k = k % sum;
        if(k == 0){
            return head;
        }
        for (int i = 0; i < sum - k - 1; i++) {
            pos = pos.next;
        }
        ListNode ans = pos.next;
        pos.next = null;
        end.next = head;
        return ans;
    }

    public class ListNode {
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


}
