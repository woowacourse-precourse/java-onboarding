package onboarding;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Problem4 {
    public  String solution(String word) {
       String result = "";

       String[] array_word;
       String[] chager_word = {"Z","Y","X","W","V","U","T","S","R","Q","P","O","N","M","L","K","J","I","H","G","F","E","D","C","B","A"};

        Map<String,String> alpha = new HashMap<>();
        char[] alpabat = new char[26];

        for(int i = 0;i<alpabat.length;i++){
            alpha.put(Character.toString((char)('A' + i)),chager_word[i]);
        }

        array_word = word.split("");

        for(String c_word:array_word){
            boolean is_upp= Character.isUpperCase(c_word.charAt(0));

            String temp_result = alpha.get(c_word.toUpperCase());
            if(temp_result == null){
                temp_result = " ";
            } else if (!is_upp) {
                temp_result = temp_result.toLowerCase();

            }
            result = result.concat(temp_result);
        }
        return result;

    }
}
