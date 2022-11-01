package onboarding;

import java.util.ArrayList;

public class Problem4 {

    public static int change(int charIndex){
        if(Character.isUpperCase(charIndex)){
            charIndex = 155-charIndex;
        }else charIndex = 219-charIndex;
        return charIndex;
    }

    public static String check(String word){
        ArrayList<Character> cArr = new ArrayList<>();
        for(int i = 0; i < word.length(); i++){
            int index = word.charAt(i);
            if(index >= 65 && index <= 122){
                cArr.add((char)change(index));
            } else cArr.add((char)index);
        }
        return charToString(cArr);
    }

    public static String charToString(ArrayList cArr){
        String result = "";
        for(int i = 0; i < cArr.size(); i++){
            result += cArr.get(i).toString();
        }
        return result;
    }

    public static String solution(String word) {
        String answer = check(word);
        return answer;
    }
}
