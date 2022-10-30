package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem4 {
    public static String solution(String word) {
        try {
            if (word.length() < 1 || word.length() > 1000)
                throw new Exception("문자의 길이가 잘못되었습니다");
        } catch (Exception e) {
            return e.getMessage();
        }

        String answer = "";
        int idx;
        //a ~ z까지 담고 있는 List를 만들자 대문자 소문자 각각
        List<Character> alphabetS = new ArrayList<>();
        List<Character> alphabetL = new ArrayList<>();
        for (int i = (int)'a'; i <= (int)'z'; i++){
            alphabetS.add((char)i);
        }
        for (int i = (int)'A'; i <= (int)'Z'; i++) {
            alphabetL.add((char)i);
        }
        /**
         * abcdefghijklmnopqrstuvwxyz
         * ABCDEFGHIJKLMNOPQRSTUVWXYZ
         */
        for (int i = 0; i < word.length(); i++) {
            if(alphabetS.contains(word.charAt(i))) {
                idx = alphabetS.indexOf(word.charAt(i));
                answer += String.valueOf(alphabetS.get(25 - idx));
            } else if (alphabetL.contains(word.charAt(i))) {
                idx = alphabetL.indexOf(word.charAt(i));
                answer += String.valueOf(alphabetL.get(25 - idx));
            } else
                answer += String.valueOf(word.charAt(i));
        }
        return answer;
    }
    /**
     * 알파벳 순서대로 했을 때 역순으로 대칭되는 값을 출력하자
     * 소문자 -> 소문자
     * 대문자 -> 대문자
     */
}
