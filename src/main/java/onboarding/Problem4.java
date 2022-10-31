package onboarding;

public class Problem4 {
    public static String solution(String word) {
        char[] chars = word.toCharArray();
        String upper = "ZYXWVUTSRQPONMLKJIHGFEDCBA";
        String lower = "zyxwvutsrqponmlkjihgfedcba";
        for (int i = 0; i < chars.length; i++) {
            if (Character.isUpperCase(chars[i])){
                int idx = chars[i] - 'A';
                chars[i] = upper.charAt(idx);
            }else if (Character.isLowerCase(chars[i])){
                int idx = chars[i] - 'a';
                chars[i] = lower.charAt(idx);
            }
        }
        return new String(chars);
    }
}
