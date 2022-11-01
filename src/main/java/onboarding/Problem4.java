package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
    }

    private static int getAsciiNumberOfzIsLowerCaseElseZ(char c){
        if(Character.isUpperCase(c)) return 'Z';

        return 'z';
    }

    private static String convertToTreeFrogLanguage(char c){
        return String.valueOf((char)(2*getAsciiNumberOfzIsLowerCaseElseZ(c)-c-25));
    }


}
