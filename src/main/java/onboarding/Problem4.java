package onboarding;

import java.util.HashMap;
public class Problem4 {
    public static String solution(String word) {
        HashMap<String,String> map=new HashMap<>();
        myMapping(map);
        return "";
    }
    /**알파벳을 각기 매핑**/
    private static void myMapping(HashMap<String, String> map) {
        String forward="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String backward = "ZYXWVUTSRQPONMLKJIHGFEDCBA";
        for (int i = 0; i < forward.length(); i++) {
            map.put(String.valueOf(forward.charAt(i)), String.valueOf(backward.charAt(i))); /*매핑*/
        }
    }
}
