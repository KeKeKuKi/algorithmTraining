package per.zzz.algorithm.linkedList;

/**
 * @author 阿忠 2669918628@qq.com
 * @since 2022/3/16 16:00
 * 21. 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class MergeSortLinkedList {
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode ans = new ListNode();
        ListNode head = ans;
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        if(list1.val > list2.val){
            ans.val = list2.val;
            list2 = list2.next;
        }else{
            ans.val = list1.val;
            list1 = list1.next;
        }
        while(true){
            if(list1 == null){
                ans.next = list2;
                return head;
            }else if(list2 == null){
                ans.next = list1;
                return head;
            }else{
                ans.next = new ListNode();
                if(list1.val <= list2.val){
                    ans.next.val = list1.val;
                    list1 = list1.next;
                }else{
                    ans.next.val = list2.val;
                    list2 = list2.next;
                }
                ans = ans.next;
            }

        }
    }

    public static class ListNode {
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
