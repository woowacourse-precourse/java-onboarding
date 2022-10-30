package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        answer = Problem4.changeString(word);
        return answer;

    }

    public static String changeString(String word) {
        //A65 Z90 a97 z122 17
        // word + (평균 - word)*2
        String answer = "";
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == ' ') {
                answer += " ";
                continue;
            }
            if (word.charAt(i) <= 90 && word.charAt(i) >= 65) {  //대문자
                answer += (char) (word.charAt(i) + 2 * (77 - word.charAt(i)) + 1) + "";
            } else {

                answer += (char) (word.charAt(i) + 2 * (109 - word.charAt(i)) + 1) + "";
            }
        }
        return answer;
    }
}
