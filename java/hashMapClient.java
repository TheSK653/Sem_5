public class hashMapClient {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("India", 135);
        map.put("China", 150);
        map.put("US", 30);
        map.put("UK", 10);
        map.put("Russia", 20);
        System.out.println(map.get("India"));
        System.out.println(map.get("China"));
        System.out.println(map.get("US"));
        System.out.println(map.get("UK"));
        System.out.println(map.get("Russia"));
        System.out.println(map.remove("Russia"));
        System.out.println(map.get("Russia"));
        System.out.println(map.containsKey("India"));
        System.out.println(map.containsKey("Russia"));
        System.out.println(map.keySet());
        System.out.println(map.size());
    }
    
}
