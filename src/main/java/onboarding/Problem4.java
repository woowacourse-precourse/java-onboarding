package onboarding;

import java.util.ArrayList;

public class Problem4 {
    public static int change(int charIndex){
        if(Character.isUpperCase(charIndex)){
            charIndex = 155-charIndex; // 대문자일 경우
        }else charIndex = 219-charIndex; // 소문자일 경우
        return charIndex;
    }

    public static String check(String word){
        ArrayList<Character> cArr = new ArrayList<>();
        for(int i = 0; i < word.length(); i++){
            int index = word.charAt(i);
            if(index >= 65 && index <= 122){ // 알파벳인지 아닌지
                cArr.add((char)change(index));
            } else cArr.add((char)index);
        }
        return charToString(cArr);
    }

    public static String charToString(ArrayList cArr){
        StringBuilder result = new StringBuilder();
        for(Object c : cArr){
            result.append(c);
        } return result.toString();
    }

    public static String solution(String word) {
        String answer = check(word);
        return answer;
    }
}
