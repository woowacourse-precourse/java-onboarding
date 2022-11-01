package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        String frog_word="Z\tY\tX\tW\tV\tU\tT\tS\tR\tQ\tP\tO\tN\tM\tL\tK\tJ\tI\tH\tG\tF\tE\tD\tC\tB\tA";
        String[] arr_frog_word = frog_word.split("\t");

        Map<String,String> map_frog_word = new HashMap<>();

        for (int i = 0; i<arr_frog_word.length ;i++){
            map_frog_word.put(Character.toString((char)('A' + i)),arr_frog_word[i]);
        }

        String[] arr_word = word.split("");

        for (String curr_word : arr_word){
            String tmp_result = map_frog_word.get(curr_word.toUpperCase());
            boolean is_low = Character.isLowerCase(curr_word.charAt(0));

            if (tmp_result == null){
                tmp_result = " ";

            } else if (is_low) {
                tmp_result = tmp_result.toLowerCase();
            }
            answer = answer.concat(tmp_result);
        }

        return answer;
    }
}
