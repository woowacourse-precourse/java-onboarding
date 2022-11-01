package onboarding;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        String[] arrayword;
        String[] changeword = {"Z", "Y","X","W","V","U","T","S","R","Q","P","O","N","M","L","K","J","I","H","G","F","E","D","C", "B","A"};

        Map<String, String> alpha = new HashMap<>();

        char[] alpabat = new char[26];

        for(int i = 0; i < alpabat.length; i++){
            alpha.put(Character.toString((char)('A'+i)), changeword[i]);
        }

        arrayword = word.split("");

        for (String cword : arrayword){
            boolean isupp = Character.isUpperCase(cword.charAt(0));

            String tempresult = alpha.get(cword.toUpperCase());
            if(tempresult == null){
                tempresult = " ";
            }else if(!isupp){
                tempresult = tempresult.toLowerCase();
            }
            answer = answer.concat(tempresult);
        }
        return answer;
    }
}
