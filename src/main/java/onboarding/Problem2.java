package onboarding;

import java.util.Stack;

/*
기능 구현 사항
1. stack 이용한 중복 문자 제거
2. stack을 String 으로 반환
*/

public class Problem2 {
    public static String solution(String cryptogram) {
        return deleteDuplicatedChar(cryptogram.toCharArray());
    }

    public static String deleteDuplicatedChar(char[] cryptogramCharArray) {
        Stack<Character> characterStack = new Stack<>();
        int index = 0;
        while (index < cryptogramCharArray.length) {

            if (characterStack.isEmpty()) {
                characterStack.push(cryptogramCharArray[index]);
                index++;
            } else {
                char before = characterStack.peek();
                if (cryptogramCharArray[index] != before) {
                    characterStack.push(cryptogramCharArray[index]);
                    index++;
                } else {
                    while (index < cryptogramCharArray.length && cryptogramCharArray[index] == before) {
                        index++;
                    }
                    characterStack.pop();
                }
            }
        }


        return stackToString(characterStack);

    }

    public static String stackToString(Stack<Character> characterStack) {
        StringBuilder sb = new StringBuilder();
        for (char character :
                characterStack) {
            sb.append(character);
        }
        return sb.toString();
    }
}