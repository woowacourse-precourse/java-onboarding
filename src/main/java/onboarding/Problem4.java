package onboarding;

import java.util.ArrayList;

public class Problem4 {
    public static String solution(String word) {
        char[] letters = word.toCharArray();
        ArrayList new_letter = new ArrayList<>();
        for(int i = 0; i < letters.length; i++){
            int ascii = (int) letters[i];
            char c;
            int convert;
            if(ascii >= 65 && ascii <= 90){
                c = (char)(155-ascii);
                new_letter.add(String.valueOf(c));
            } else if (ascii >= 97 && ascii <= 122) {
                c = (char)(219-ascii);
                new_letter.add(String.valueOf(c));
            }
            else {
                new_letter.add(String.valueOf(letters[i]));
            }
        }
    return String.join("", new_letter);
    }

    public static void main(String[] args) {
        String word = "I love you";
        System.out.println(solution(word));
    }
}
