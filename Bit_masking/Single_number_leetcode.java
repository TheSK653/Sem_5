public class Single_number_leetcode {
  public static void main(String[] args) {
    int [] nums={4,1,2,1,2};
    int xor = 0;
    for(int i=0;i<nums.length;i++)
    {
      xor = xor ^ nums[i];
    } 
    System.out.println(xor);
  }
  
}