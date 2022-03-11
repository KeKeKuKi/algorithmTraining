package per.zzz.algorithm.doublePointer;

/**
 * @author 阿忠 2669918628@qq.com
 * @since 2022/3/11 9:45
 * <p>
 * 876. 链表的中间结点
 * 给定一个头结点为 head 的非空单链表，返回链表的中间结点。
 * 如果有两个中间结点，则返回第二个中间结点。
 * 返回后半部分链表
 */
public class LinkedListCenterNode {
    public ListNode middleNode(ListNode head) {
        ListNode l = head;
        int i = 1;
        while(head != null){
            if(i % 2 == 0){
                l = l.next;
            }
            head = head.next;
            i++;
        }
        return l;
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
