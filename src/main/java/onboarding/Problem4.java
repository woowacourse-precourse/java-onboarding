package onboarding;

public class Problem4 {
    /* 기능 단위
     * 1. 소문자인지, 대문자인지 확인 (isLowerCase, isUpperCase)
     * 2. 문자를 변환하는 기능 (reverseWord)
     * */

    private static String reverseWord(char word) {
        int n = (int) word;
        if(isLowerCase(n)) {
            n = 90 - (n - 65);
            return String.valueOf((char) n);
        } else if (isUpperCase(n)) {
            n = 122 - (n - 97);
            return String.valueOf((char) n);
        }
        return Character.toString(word);
    }

    private static boolean isLowerCase(int n) {
        return n >= 65 && n <= 90;
    }

    private static boolean isUpperCase(int n) {
        return n >= 97 && n <= 122;
    }
    public static String solution(String word) {
        String answer = "";
        String[] wordArray = word.split("");
        for(int i=0; i < word.length(); i++) {
            char ch = word.charAt(i);
            wordArray[i] = reverseWord(ch);
        }
        answer = String.join("", wordArray);
        System.out.println("answer: " + answer);
        return answer;
    }
}
