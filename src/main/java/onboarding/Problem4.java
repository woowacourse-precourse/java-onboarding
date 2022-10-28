package onboarding;

public class Problem4 {
    private static Character lowerChange(char ch){
        // a to z, b to x... 모두 두 문자의 아스키코드 값을 더하면 219가 된다.
        // 따라서 219에서 현재 문자의 아스키코드 값을 뺴면 변환 후 문자의 아스키코드 값이 된다.
        return (char)(219 - ch);
    }

    private static Character upperChange(char ch){
        // A to Z, B to X... 모두 두 문자의 아스키코드 값을 더하면 155가 된다.
        // 따라서 155에서 현재 문자의 아스키코드 값을 뺴면 변환 후 문자의 아스키코드 값이 된다.
        return (char)(155 - ch);
    }

    public static String solution(String word) {
        String answer = "";
        return answer;
    }
}
