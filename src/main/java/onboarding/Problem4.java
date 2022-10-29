package onboarding;

/*
1. 문자열을 순회한다.
2. 해당 문자가 알파벳 이외의 문자인경우, answer에 그대로 더한다.
2-1. 문자가 알파벳인지 판별하는 법 : 아스키코드표의 a-z, A-Z 범위 밖의 문자이면 알파벳이 아니다.
3. 대문자인 경우 'Z'-('해당문자'-'A') / 소문자인 경우 'z'-('해당문자'-'a')
 */
public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        char s;
        for (int i = 0; i < word.length(); i++) {
            s = word.charAt(i);
        }
        return answer;
    }
}
