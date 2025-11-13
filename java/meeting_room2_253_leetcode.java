import java.util.Arrays;
import java.util.PriorityQueue;

public class meeting_room2_253_leetcode {
    public static void main(String[] args) {
        int [][] intervals={{10,30},{5,10},{15,20},{2,6},
                            {12,18},{19,25},{1,5},{3,5}};
        System.out.println(Meeting_room(intervals));
    }

    public static int Meeting_room(int [][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] >= pq.peek()[1]) {
                pq.poll();
                pq.add(intervals[i]);
            }
            else{
                pq.add(intervals[i]);
            }
        }
        return pq.size();
    }
}