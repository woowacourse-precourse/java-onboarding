package onboarding;

public class Problem4 {
    public static String solution(String word) {
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
}
