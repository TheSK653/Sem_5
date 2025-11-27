public class LeftShift {
    public static void main(String[] args) {
        int n=13;
        System.out.println(n<<1);
        int n1=-13;
        System.out.println(n1<<1);
        // byte b=-128;
        // b = (byte) (b<<1);
        n = Integer.MIN_VALUE<<1;
        System.out.println(n);
    }
}
