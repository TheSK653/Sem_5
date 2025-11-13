import java.util.ArrayList;

public class Kth_Largest_Element_in_an_Array {
    public static void main(String[] args) {
        Kth_Largest_Element_in_an_Array solution = new Kth_Largest_Element_in_an_Array();
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println(solution.findKthLargest(nums, k)); // Output: 5
    }
    public int findKthLargest(int[] nums, int k) {
        heap h = new heap();
        for (int num : nums) {
            h.add(num);
            if (h.size() > k) {
                h.remove();
            }
        }
        return h.get();
    }
    public class heap {
        private ArrayList<Integer> l1 = new ArrayList<>();

        public void add(int item) {
            l1.add(item);
            upheapify(l1.size() - 1);
        }

        private void upheapify(int ci) {
            int pi = (ci - 1) / 2;
            if (l1.get(ci) < l1.get(pi)) {
                swap(ci, pi);
                upheapify(pi);
            }
        }

        private void swap(int pi, int ci) {
            int pith = l1.get(pi);
            int cith = l1.get(ci);
            l1.set(pi, cith);
            l1.set(ci, pith);
        }

        public int remove() {
            swap(0, l1.size() - 1);
            int val = l1.remove(l1.size() - 1);
            downheapify(0);
            return val;
        }

        private void downheapify(int pi) {
            int lci = 2 * pi + 1;
            int rci = 2 * pi + 2;
            int mini = pi;
            if (lci < l1.size() && l1.get(lci) < l1.get(mini)) {
                mini = lci;
            }
            if (rci < l1.size() && l1.get(rci) < l1.get(mini)) {
                mini = rci;
            }
            if (mini != pi) {
                swap(pi, mini);
                downheapify(mini);
            }
        }

        public int get() {
            return l1.get(0);
        }

        public int size() {
            return l1.size();
        }

        public void display() {
            System.out.println(l1);
        }
    }
}
