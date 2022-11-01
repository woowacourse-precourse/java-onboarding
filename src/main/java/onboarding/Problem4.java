package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder sb = new StringBuilder();
        for (char c : word.toCharArray()) {
            sb.append(changeWord(c));
        }
        return sb.toString();
    }

    public static char changeWord(char c) {
        //아스키 값을 이용해 전환
        //대문자인 경우 155(A+Z) 에서 입력값을 뺌
        if (c >= 65 && c <= 90) {
            return (char)(155 - c);
        }
        //소문자인 경우 219(a+z) 에서 입력값을 뺌
        if (c >= 97 && c <= 122) {
            return (char) (219 - c);
        }
        return c;
    }
}
