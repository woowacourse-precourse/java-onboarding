package onboarding;

public class Problem4 {
    public static boolean isAlpha(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

    public static char formatToFrogCharacter(char c) {
        if (isAlpha(c)) {
            int base;
            
            if (c >= 'a') 
                base = 'a';
            else
                base = 'A';

            return (char)((25 - (c - base)) % 26 + base); 
        } else {
            return c;
        }
    }
    
    public static String solution(String word) {
        String answer = "";
        return answer;
    }
}
