public class Magic_number {
    public static void main(String[] args) {
        int n=9;
        System.out.println(Nthnumber(n));
    }
    public static int Nthnumber(int n){
        int ans=0;
        int base=5;
        while(n>0){
            int last=n&1;
            n=n>>1;
            ans+=last*base;
            base=base*5;
        }
        return ans;
    }
}