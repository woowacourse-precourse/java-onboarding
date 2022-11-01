package onboarding;

import java.util.ArrayList;

public class Problem4 {
    public static String solution(String word) {
        int count =0;
        ArrayList<Integer> upperPlace = new ArrayList<Integer>();
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        while (count < word.length()){
            char chara = word.charAt(count);
            if (Character.isUpperCase(chara)){
                upperPlace.add(count);
            }
            count++;
        }
        String wordLower = word.toLowerCase();
        
        String answer = "";
        
        for(int i = 0; i < wordLower.length(); i++){
            if(alphabet.indexOf(wordLower.charAt(i)) == -1){
                answer += " ";
                continue;
            }
            if(upperPlace.contains(i)){
                answer += alphabet.toUpperCase().charAt(25 - alphabet.indexOf(wordLower.charAt(i)));
            }
            else{
                answer += alphabet.charAt(25 - alphabet.indexOf(wordLower.charAt(i)));
            }
        }
        
        for(int n : upperPlace){
            char up = answer.toUpperCase().charAt(n);
            answer.replace(answer.charAt(n), up);
        }
        
        return answer;
    }
}
