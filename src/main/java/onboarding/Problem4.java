package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        answer = Problem4.changeString(word);
        return answer;

    }

    // 청개구리 사전대로 바꿔주는 메서드
    public static String changeString(String word) {
        //A65 Z90 a97 z122 17
        // word + (평균 - word)*2 +1
        String answer = "";
        for (int i = 0; i < word.length(); i++) {

            if (word.charAt(i) <= 90 && word.charAt(i) >= 65) {  //대문자
                answer += (char) (word.charAt(i) + 2 * (77 - word.charAt(i)) + 1) + "";
            } else if (word.charAt(i) <= 122 && word.charAt(i) >= 97) {

                answer += (char) (word.charAt(i) + 2 * (109 - word.charAt(i)) + 1) + "";
            } else {
                answer += (char) word.charAt(i);
            }
        }
        return answer;
    }
}
