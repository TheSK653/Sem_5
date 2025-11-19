import java.util.*;

public class Alien_Dictionary {

    public String alienOrder(String[] words) {
        HashMap<Character, List<Character>> map = new HashMap<>();
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                if (!map.containsKey(ch)) {
                    map.put(ch, new ArrayList<>());
                }
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String s1 = words[i];
            String s2 = words[i + 1];

            if (s1.startsWith(s2) && s1.length() > s2.length()) { 		// not lexigoraphically sorted
                return "";
            }

            for (int j = 0; j < Math.min(s1.length(), s2.length()); j++) {
                if (s1.charAt(j) != s2.charAt(j)) {
                    map.get(s1.charAt(j)).add(s2.charAt(j));
                    break;
                }
            }
        }

        int[] indegree = new int[26];
        for (char ch : map.keySet()) {
            for (char nbr : map.get(ch)) {
                indegree[nbr - 'a']++;
            }
        }

        Queue<Character> q = new LinkedList<>();
        for (char ch : map.keySet()) {
            if (indegree[ch - 'a'] == 0) {
                q.add(ch);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            char rem = q.poll();
            sb.append(rem);

            for (char nbr : map.get(rem)) {
                indegree[nbr - 'a']--;
                if (indegree[nbr - 'a'] == 0) {
                    q.add(nbr);
                }
            }
        }

        return sb.length() == map.size() ? sb.toString() : "";
    }

    public static void main(String[] args) {
        String[] words = {"wrt", "wrf", "er", "ett", "rftt"};
        Alien_Dictionary obj = new Alien_Dictionary();
        String ans = obj.alienOrder(words);
        System.out.println(ans);
    }

}
