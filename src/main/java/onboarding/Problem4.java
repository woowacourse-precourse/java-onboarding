package onboarding;

public class Problem4 {
    public static String solution(String word) {
        // 아스키 코드를 활용한 문제 풀기
        String answer = "";
        // 1) 문자열 길이 만큼 진행
        for (int i=0; i<word.length();i++) {
            // 1) 문자 1개씩 받으면서 아스키코드를 활용하여 Int로 치환
            char tmpChar = word.charAt(i);
            // 2) a~z나 A~Z일 때 값 변경 (z에서 특정 문자열을 빼게 되면 Reverse가 된다)
            if ((int)tmpChar>=97 && (int)tmpChar<=122) {
                tmpChar = (char) (122 - (int) tmpChar + 97);
            } else if ((int)tmpChar>=65 && (int)tmpChar<=90) {
                tmpChar = (char) (90 - (int) tmpChar + 65);
            }
            answer+=tmpChar;
        }
        return answer;
    }
}
