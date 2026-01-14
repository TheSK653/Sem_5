public class SubsequenceWithoutRecurtion {
    public static void main(String[] args) {
        String str = "abc";
        SubSequence(str);
    }

    private static void SubSequence(String str) {
        int n = str.length();
        for (int i = 0; i < (1 << n); i++) {
            pattern(str, i);
        }
    }

    private static void pattern(String str, int i) {
        int idx = 0;
        String ans = "";
        while (i > 0) {
            if ((i & 1) == 1) {
                ans += str.charAt(idx);
            }
            i >>= 1;
            idx++;
        }
        System.out.println(ans);
    }
}