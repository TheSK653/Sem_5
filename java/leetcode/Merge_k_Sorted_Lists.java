
import java.util.*;

public class Merge_k_Sorted_Lists {

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

    class Solution {

        public ListNode mergeKLists(ListNode[] lists) {
            PriorityQueue<ListNode> pq = new PriorityQueue<>((ListNode o1, ListNode o2) -> o1.val - o2.val);
            ListNode Dummy = new ListNode();
            ListNode temp = Dummy;
            for (ListNode list : lists) {
                if (list != null) {
                    pq.add(list);
                }
            }
            while (!pq.isEmpty()) {
                ListNode r = pq.poll();
                Dummy.next = r;
                Dummy = Dummy.next;
                if (r.next != null) {
                    pq.add(r.next);
                }

            }
            return temp.next;

        }
    }
    public static void main(String[] args) {
        Merge_k_Sorted_Lists outer = new Merge_k_Sorted_Lists();
        Solution sol = outer.new Solution();

        // Example lists: [1,4,5], [1,3,4], [2,6]
        ListNode l1 = outer.new ListNode(1, outer.new ListNode(4, outer.new ListNode(5)));
        ListNode l2 = outer.new ListNode(1, outer.new ListNode(3, outer.new ListNode(4)));
        ListNode l3 = outer.new ListNode(2, outer.new ListNode(6));

        ListNode[] lists = new ListNode[]{l1, l2, l3};
        ListNode merged = sol.mergeKLists(lists);

        // Print merged list
        System.out.print("Merged: ");
        ListNode cur = merged;
        while (cur != null) {
            System.out.print(cur.val);
            if (cur.next != null) System.out.print("->");
            cur = cur.next;
        }
        System.out.println();
    }
}
