package onboarding;

import java.util.*;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        String[] array_word;
        String[] change_word ={"Z","Y","X","W","V","U","T","S","R","Q","P","O","N","M","L","K","J","I","H","G","F","E","D","C","B","A"};

        Map<String, String> alpha = new HashMap<>();

        char[] alphabat = new char[26];

        for(int i=0;i<alphabat.length;i++){
            alpha.put(Character.toString((char) ('A'+i)),change_word[i]);

        }
        array_word=word.split("");

        for (String c_word: array_word){
            boolean up= Character.isUpperCase(c_word.charAt(0));

            String temp= alpha.get(c_word.toUpperCase());
            if(temp==null){
                temp=" ";
            } else if (!up) {
                temp=temp.toLowerCase();
            }
            answer=answer.concat(temp);
        }
        return answer;
    }
}
