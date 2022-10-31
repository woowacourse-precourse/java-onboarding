package onboarding;

import java.util.ArrayList;

public class Problem4 {
    public static ArrayList<Character> frog(String word) {
        // 대문자 => 두 문자의 아스키코드를 더한 값이 항상 155로 같다.
        // 소문자 => 두 문자의 아스키코드를 더한 값이 항상 219로 같다.
        //참고: 공백 = 32 (대문자 A 97 - 소문자 a 65)
        // 알파벳 외의 문자는 변환하지 않는다.
        char[] charArr = word.toCharArray();
        ArrayList<Character> result = new ArrayList<Character>();
        for (int i = 0; i < charArr.length; i++) {
            if (Character.isUpperCase(charArr[i])) {
                char after = (char) Math.abs(155 - (int) (charArr[i]));
                result.add(after);
            } else if (Character.isLowerCase(charArr[i])) {
                char after = (char) Math.abs(219 - (int) (charArr[i]));
                result.add(after);
            } else if ((charArr[i]) == ((char) (32))) {
                result.add((charArr[i]));
            }
            else continue;
        }
        return result;
    }
    public static String solution(String word) {
        ArrayList<Character> result = frog(word);
        String answer = "";

        for(int i = 0;i< result.size();i++){
            answer += String.valueOf(result.get(i));
        }
        return answer;
    }
}