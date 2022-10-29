package onboarding;

public class Problem4 {
    public static String solution(String word) {
        int length = word.length();
        if(!(0 < length && length < 1001)) return "";

        StringBuilder stringBuilder = new StringBuilder();

        for(int i = 0; i < word.length(); i++) {
            char now = word.charAt(i);
            stringBuilder.append(getReverseCharacter(now));
        }
        return stringBuilder.toString();
    }

    private static char getReverseCharacter (char target) {
        if(64 < target &&  target < 91) return (char) (90 - (target - 65));
        if(96 < target && target < 123) return (char) (122 - (target - 97));
        return target;
    }
}
