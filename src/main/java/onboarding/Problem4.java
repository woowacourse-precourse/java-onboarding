package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem4 {
    /**
     * Goal: Given a string, replace all its alphabetical characters according to the table and leave other characters
     * as they are
     * How:
     *     1. Loop through each character of the string
     *     2. Use ascii table to convert each char to decimal and check if it is in the alphabet
     *     3. If it is an alphabetical char add the corresponding replacement to the resulting string
     *     Otherwise add the same char
     *
     * @param word A string containing alphabetical characters and other characters
     * @return A string with alphabetical characters replaced with its corresponding replacements
     */
    public static String solution(String word) {
        StringBuilder reversed = new StringBuilder();
        int ascii = 0;
        for (char character : word.toCharArray()) {
            if(character >= 'a' && character <= 'z') {
                ascii = character;
                ascii = 97 + 122 - ascii;
                reversed.append((char) ascii);
            }
            else if (character >= 'A' && character <= 'Z') {
                ascii = character;
                ascii = 65 + 90 - ascii;
                reversed.append((char) ascii);
            }
            else {
                reversed.append(character);
            }
        }
        String result = reversed.toString();
        return result;

    }
}
