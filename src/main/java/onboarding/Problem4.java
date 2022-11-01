package onboarding;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Problem4 {

    public static String solution(String word) {

        String answer = "";

        String[] wordArray;
        String[] wordChange = {"Z","Y","X","W","V","U","T","S","R","Q","P","O","N","M","L","K","J","I","H","G","F","E","D","C","B","A"};

        Map<String, String> A = new HashMap<>();

        char[] alpabat = new char[26];

        for (int i = 0; i<alpabat.length;i++){
            A.put(Character.toString((char)('A'+i)),wordChange[i]);
        }

        wordArray = word.split("");

        for(String a : wordArray){
            boolean upper = Character.isUpperCase(a.charAt(0));

            String result = A.get(a.toUpperCase());
            if(result == null){
                result = " ";
            } else if(!upper){
                result = result.toLowerCase();
            }

            answer = answer.concat(result);
        }
        return answer;
    }
}
