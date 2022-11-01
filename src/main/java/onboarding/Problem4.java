package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        for (int i=0; i < word.length(); i++){ // 아스키 문자를 활용하였음
            int spell = word.charAt(i);
            if (spell <= 90 && spell >= 65) { // 대문자일때
                char midian_spell = (char) (155 - spell);
                answer += Character.toString(midian_spell);
            } else if (spell <= 122 && spell >= 97){ // 소문자일때
                char midian_spell = (char) (219 - spell);
                answer += Character.toString(midian_spell);
            } else {
                char midian_spell = (char) spell; // 문자가 아닐때는 그대로
                answer += Character.toString(midian_spell);
            }
        }


        return answer;
    }
}
