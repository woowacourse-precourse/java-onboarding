package onboarding;

public class Problem4 {
    private static boolean isCap(char c){
        return (c >= 0x41 && c <= 0x5A);//A to Z
    }

    private static boolean isalpha(char c){
        return ((c >= 0x41 && c <= 0x5A) || (c >= 0x61 && c <= 0x7A));//(A to Z) or (a to z)
    }

    private static char encrypt(char c){
        if (isCap(c))
            return (char)('A' + 'Z' - c);
        else
            return (char)('a' + 'z' - c);
    }

    public static String solution(String word) {
        StringBuilder answer = new StringBuilder("");

        for(int i = 0; i < word.length();i++) {
            char c = word.charAt(i);

            if (isalpha(c))
                answer.append(encrypt(c));
            else
                answer.append(c);
        }
        return answer.toString();
    }
}
