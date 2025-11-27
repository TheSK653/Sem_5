public class Count_Set_Bit {
  public static void main(String[] args) {
    int n=84;
    System.out.println(Count_SetBit(n));
  }
  public static int Count_SetBit(int n)
  {
    int ans=0;
    while(n>0)
    {
      if((n&1) !=0)
      {
        ans++;
      }
      n >>=1;  // n = n>>1
    }
    return ans;
  }
  
}