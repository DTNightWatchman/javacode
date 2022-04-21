package demo18;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static boolean func(String str1, String str2) {
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < str1.length(); i++) {
            if (map.containsKey(str1.charAt(i))) {
                int val = map.get(str1.charAt(i));
                val++;
                map.put(str1.charAt(i),val);
            } else {
                map.put(str1.charAt(i),1);
            }
        }
        Map<Character,Integer> map1 = new HashMap<>();
        for (int i = 0; i < str2.length(); i++) {
            if (map1.containsKey(str2.charAt(i))) {
                int val = map1.get(str2.charAt(i));
                val++;
                map1.put(str2.charAt(i),val);
            } else {
                map1.put(str2.charAt(i),1);
            }
        }
        Set<Map.Entry<Character,Integer>> set = map.entrySet();
        Set<Map.Entry<Character,Integer>> set1 = map1.entrySet();
        for (Map.Entry<Character,Integer> entry: set1) {
            if (!map.containsKey(entry.getKey())) {
                return false;
            }
            if (map.get(entry.getKey()) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sccanner = new Scanner(System.in);
        while (sccanner.hasNext()) {
            String str1 = sccanner.next();
            String str2 = sccanner.next();
            System.out.println(func(str1, str2)? "Yes":"No");
        }
    }

}
