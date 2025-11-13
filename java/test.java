import java.util.*;

public class test {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextInt();
        int[] p=new int[n];
        for (int i = 0; i < n; i++) {
            p[i]=sc.nextInt();
            sc.nextInt();
        }
        int w=sc.nextInt();

        sc.close();

        Arrays.sort(p);

        int[] dp=new int[n];
        Arrays.fill(dp,Integer.MIN_VALUE);
        int c=0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(dp[j]>=p[i]-w){
                    dp[i]=dp[j];
                }
            }
            if(dp[i]==Integer.MIN_VALUE){
                dp[i]=p[i];
                c++;
            }
        }
        System.err.println(c);
    }
}