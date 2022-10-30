package onboarding;

import java.util.*;

public class Problem4 {
    public static String solution(String word) {

        Map<String, String> map = new HashMap<String, String>();
        mappingReversingChar(map);
        String answer = "";
        return answer;
    }

    /**
     * Function for Mapping a Reversing Char
     * */
    private static void mappingReversingChar(Map<String, String> map) {
        List<String> origin =
                new ArrayList<>(Arrays.asList("A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R",
                        "S","T","U","V","W","X","Y","Z"));

        for (int i = 0; i < origin.size(); i++) {
            map.put(origin.get(i), origin.get(origin.size()-1-i));
            map.put(origin.get(i).toLowerCase(), origin.get(origin.size()-1-i).toLowerCase());
        }
    }
}
