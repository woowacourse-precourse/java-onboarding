package onboarding;

import java.util.Stack;

/*
기능 구현 사항
1. stack 이용한 중복 문자 제거
2.
*/

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        System.out.println(deleteDuplicatedChar(cryptogram.toCharArray()));
        return answer;
    }

    public static String deleteDuplicatedChar(char[] cryptogramCharArray) {
        Stack<Character> characterStack = new Stack<>();
        int index = 0;
        while(index < cryptogramCharArray.length){

            if(characterStack.isEmpty()){
                characterStack.push(cryptogramCharArray[index]);
                index++;
            }
            else{
                char before = characterStack.peek();
                if(cryptogramCharArray[index] != before){
                    characterStack.push(cryptogramCharArray[index]);
                    index++;
                }
                else{
                    while(index < cryptogramCharArray.length && cryptogramCharArray[index] == before){
                        index++;
                    }
                    characterStack.pop();
                }
            }
            System.out.println(characterStack.toString());
        }


        return characterStack.toString();

    }
}