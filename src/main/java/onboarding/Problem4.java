package onboarding;

public class Problem4 {

    private static final String spelling = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static Character convert(Character originalChar) {
        Integer position = spelling.indexOf(Character.toUpperCase(originalChar));
        Character convertCharacter = spelling.charAt((spelling.length()-1) - position);
        return convertCharacter;
    }

    public static String solution(String word) {
        String answer = "";
        return answer;
    }

}
