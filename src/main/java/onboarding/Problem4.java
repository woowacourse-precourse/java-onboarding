package onboarding;

public class Problem4 {
    public static String solution(String word) {
        char[] wordCharArray = word.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char wordChar : wordCharArray){
            if (Character.isLowerCase(wordChar))
                sb.append(getChangeLower(wordChar));
            else if (Character.isUpperCase(wordChar))
                sb.append(getChangeUpper(wordChar));
            else
                sb.append(wordChar);
        }
        return sb.toString();
    }

    private static char getChangeLower(char c){
        return (char)('a' + 'z' - c);
    }

    private static char getChangeUpper(char c){
        return (char)('A' + 'Z' - c);
    }
}
