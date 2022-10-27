package onboarding;

public class Problem4 {

    //대문자 변경
    private static char changeUpper(char upper) {
        int iUpper = (int) upper;
        int iResult = 0;
        iResult = 65 + (90 - iUpper);
        return (char) iResult;
    }

    //소문자 변경
    private static char changeLower(char lower) {
        int iLower = (int) lower;
        int iResult = 0;
        iResult = 97 + (122 - iLower);
        return (char) iResult;
    }


    public static String solution(String word) {
        String answer = "";

        for (int i = 0; i < word.length(); i++) {
            if (Character.isUpperCase(word.charAt(i))) {
                //대문자면 대문자변환
                answer += changeUpper(word.charAt(i));
            } else if (Character.isLowerCase(word.charAt(i))) {
                //소문자면 소문자변환
                answer += changeLower(word.charAt(i));
            } else {
                //알파벳 외의 문자는 그대로 더하기
                answer += word.charAt(i);
            }
        }

        return answer;
    }
}
