package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
    }
    static char reverseAlpha(char c) {
        String upperAlpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String revUpperAlpha = "ZYXWVUTSRQPONMLKJIHGFEDCBA";
        String lowerAlpha = "abcdefghijklnmopqrstuvwxyz";
        String revLowerAlpha = "zyxwvutsrqponmlkjihgfedcba";

        if (Character.isUpperCase(c)) {
            int index = upperAlpha.indexOf(c);
            return revUpperAlpha.charAt(index);
        } else {
            int index = lowerAlpha.indexOf(c);
            return revLowerAlpha.charAt(index);
        }
    }
    public static void main(String args[]) {
        System.out.println(reverseAlpha('A'));
    }
}
