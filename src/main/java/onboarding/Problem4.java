package onboarding;

import java.util.Arrays;

public class Problem4 {
    public static String solution(String word) {
        char[] upperAlphabets = new char[26];
        char[] lowerAlphabets = new char[26];
        char[] reverseUpperAlphabets = new char[26];
        char[] reverseLowerAlphabets = new char[26];

        for (int i = 0; i < 26; i++) {
            upperAlphabets[i] = (char)((int)'A' + i);
            lowerAlphabets[i] = (char)((int)'a' + i);
            reverseUpperAlphabets[i] = (char) ((int)'Z' - i);
            reverseLowerAlphabets[i] = (char) ((int)'z' - i);
        }

        String answer = "";
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            if (Character.isUpperCase(letter)) {
                int index = Arrays.asList(upperAlphabets).indexOf(letter);
                answer += reverseUpperAlphabets[index];
            } else if (Character.isLowerCase(letter)) {
                int index = Arrays.asList(lowerAlphabets).indexOf(letter);
                answer += reverseLowerAlphabets[index];
            } else {
                answer += letter;
            }

        }

//        System.out.println("upperAlphabets = " + Arrays.toString(upperAlphabets));
//        System.out.println("lowerAlphabets = " + Arrays.toString(lowerAlphabets));
//        System.out.println("reverseUpperAlphabets = " + Arrays.toString(reverseUpperAlphabets));
//        System.out.println("reverseLowerAlphabets = " + Arrays.toString(reverseLowerAlphabets));




        return answer;
    }
}
