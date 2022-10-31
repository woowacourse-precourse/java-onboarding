package onboarding;

import java.util.Objects;
import java.util.Stack;

public class Problem2 {

    /**
     * 중복된 문자들을 없애 문자열을 해독합니다.
     *
     * @param cryptogram 입력으로 주어진 문자열입니다.
     * @return 해독된 문자열입니다.
     * */
    private static String decrypt(String cryptogram) {
        boolean needNextStep = true;
        int previousLength = cryptogram.length();
        while (needNextStep) {
            needNextStep = false;
            cryptogram = removeRepeatingLetters(cryptogram);
            if (cryptogram.length() != previousLength) {
                previousLength = cryptogram.length();
                needNextStep = true;
            }
        }
        return cryptogram;
    }

    /**
     * 중복된 문자들를 한 단계 제거합니다.
     *
     * @param cryptogram 해독할 문자열입니다.
     * @return 중복 문자들이 한 번 제거된 문자열입니다.
     * */
    private static String removeRepeatingLetters(String cryptogram) {
        Stack<Character> letters = new Stack<>();
        char previousLetter = ' ';
        boolean popped = false;
        for (int i = 0; i < cryptogram.length(); i++) {
            char currentLetter = cryptogram.charAt(i);
            if (currentLetter == previousLetter) {
                if (popped == false) {
                    popped = true;
                    letters.pop();
                }
                continue;
            }
            letters.add(currentLetter);
            previousLetter = currentLetter;
            popped = false;
        }
        return stringify(letters);
    }

    /**
     * 스택에 저장된 문자들을 하나의 문자열로 합칩니다.
     *
     * @param letters 문자가 저장된 스택입니다.
     * @return 스택에 포함된 문자를 모두 합친 문자열입니다.
     * */
    private static String stringify(Stack<Character> letters) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char letter: letters) {
            stringBuilder.append(letter);
        }
        return stringBuilder.toString();
    }

    /**
     * Problem2의 솔루션 코드입니다.
     *
     * @param cryptogram 해독에 사용될 문자열 입니다.
     * @return 해독된 문자열입니다.
     * */
    public static String solution(String cryptogram) {

        String answer = decrypt(cryptogram);
        return answer;
    }
}


