package onboarding;

public class Problem4 {
    public static String solution(String input) {
        char[] word = input.toCharArray();

        for(int i =0; i<word.length ; i++){
            char ch = word[i];
            if('A'<= ch && ch<='Z'){
                word[i] = (char) ('Z'-(ch-'A'));
            }
        }

        return String.valueOf(word);
    }
}
