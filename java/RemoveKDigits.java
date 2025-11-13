import java.util.Stack;

public class RemoveKDigits {

    public static String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();

        for (char digit : num.toCharArray()) {
            // While there are digits to remove (k > 0), the stack is not empty,
            // and the top of the stack is greater than the current digit,
            // pop from the stack. This ensures we keep a non-decreasing sequence.
            while (!stack.isEmpty() && k > 0 && stack.peek() > digit) {
                stack.pop();
                k--;
            }

            // Push the current digit onto the stack, avoiding leading zeros
            // unless it's the only digit.
            if (!stack.isEmpty() || digit != '0') {
                stack.push(digit);
            }
        }

        // If there are still digits to remove (k > 0), remove them from the end
        // of the stack (which represents the largest digits in the current smallest number).
        while (!stack.isEmpty() && k > 0) {
            stack.pop();
            k--;
        }

        // If the stack is empty after removals, it means all digits were removed,
        // so the smallest number is "0".
        if (stack.isEmpty()) {
            return "0";
        }

        // Build the result string from the stack.
        // The digits are in reverse order in the stack, so we need to reverse them.
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String num1 = "1432219";
        int k1 = 3;
        System.out.println("Original: " + num1 + ", k: " + k1 + ", Smallest: " + removeKdigits(num1, k1)); // Output: 1219

        String num2 = "10200";
        int k2 = 1;
        System.out.println("Original: " + num2 + ", k: " + k2 + ", Smallest: " + removeKdigits(num2, k2)); // Output: 200

        String num3 = "10";
        int k3 = 2;
        System.out.println("Original: " + num3 + ", k: " + k3 + ", Smallest: " + removeKdigits(num3, k3)); // Output: 0

        String num4 = "142299";
        int k4 = 3;
        System.out.println("Original: " + num4 + ", k: " + k4 + ", Smallest: " + removeKdigits(num4, k4)); // Output: 0
    }
}