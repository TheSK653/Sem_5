import java.util.*;
public class Alien_Dictionary {
    public String alienOrder(String[] words) {
        HashMap<Character, List<Character>> map = new HashMap<>();

        for (String word : words) {
            for (char c : word.toCharArray()) {
                if(!map.containsKey(c)) {
                    map.put(c, new ArrayList<>());
                }
            }
        }
        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];
            int len = Math.min(w1.length(), w2.length());
            for (int j = 0; j < len; j++) {
                char c1 = w1.charAt(j);
                char c2 = w2.charAt(j);
                if (c1 != c2) {
                    map.get(c1).add(c2);
                    break;
                }
            }
        }
        int[] in = new int[26];
        for (char c : map.keySet()) {
            for (char nbrs : map.get(c)) {
                in[nbrs - 'a']++;
            }
        }
        Queue<Character> q = new LinkedList<>();
        for (char c : map.keySet()) {
            if (in[c - 'a'] == 0) {
                q.add(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            char r = q.poll();
            sb.append(r);
            for (char nbrs : map.get(r)) {
                in[nbrs - 'a']--;
                if (in[nbrs - 'a'] == 0) {
                    q.add(nbrs);
                }
            }
        }
        return sb.length() == map.size() ? sb.toString() : "";
    }
    public static void main(String[] args) {
        Alien_Dictionary ad = new Alien_Dictionary();
        String[] words = {"hrn","hrf","er","enn","rfnn"};
        String order = ad.alienOrder(words);
        System.out.println(order);
    }
}
