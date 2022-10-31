package onboarding;

public class Problem4 {

    private static final int minLength = 1;
    private static final int maxLength = 1000;

    public static String solution(String word) {
        isValidate(word);
        String answer = getConverseString(word);
        return answer;
    }

    private static char converseChar(char ch) {
        if(Character.isUpperCase(ch)){
            return (char)('Z'-(ch-'A'));
        }else if(Character.isLowerCase(ch))
            return (char)('z'-(ch-'a'));
        else
            return ch;
    }

    private static String getConverseString(String target) {
        StringBuilder result = new StringBuilder();
        for(int i=0;i<target.length();i++){
            char conversedChar=converseChar(target.charAt(i));
            result.append(conversedChar);
        }
        return result.toString();
    }

    private static void isValidate(String word) {
        if (word.length() < minLength || word.length() > maxLength) {
            throw new IllegalArgumentException("문자열의 길이가 1이상 1000이하 이어야합니다.");
        }
    }
}
