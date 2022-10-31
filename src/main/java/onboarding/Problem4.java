package onboarding;

import problem4.LengthValidator;
import problem4.LetterConverter;

import static problem4.LengthValidator.*;
import static problem4.LetterConverter.*;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();

        try {
            getMirroredMessage(word, answer);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        return answer.toString();
    }

    private static void getMirroredMessage(String word, StringBuilder answer) {
        int wordLength = lengthValidate(word);
        for (int i = 0; i < wordLength; i++)
            answer.append(letterConvert(word.charAt(i)));
    }
}
