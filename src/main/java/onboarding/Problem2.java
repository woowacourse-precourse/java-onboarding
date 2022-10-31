package onboarding;

import java.util.Stack;

/*
- 기능 구현사항 목록 -
1. 문자열을 배열화한다.
2. stack 생성후 첫번째 문자 넣어두기
3. 남은 배열을 돌면서 이번 문자가
   1) stack 마지막 원소와 같다면 pop
   2) 같지 않다면 add
4. stack 에 남아있는 문자들을 문자열로 만들어서 Return
 */
public class Problem2 {
    private static Stack<Character> decryption(char[] s){
        Stack<Character> decodedcCyptogram = new Stack<>();
        decodedcCyptogram.push(s[0]);
        for (int i = 1; i < s.length; i++) {
            if (decodedcCyptogram.peek() == s[i]) {
                decodedcCyptogram.pop();
                continue;
            }
            decodedcCyptogram.push(s[i]);
        }
        return decodedcCyptogram;
    }
    private static String stackToString (Stack<Character> decryptionStack){
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < decryptionStack.size(); i++) {
            temp.append(decryptionStack.elementAt(i));
        }
        return temp.toString();
    }
    public static String solution(String cryptogram) {
        char[] s = cryptogram.toCharArray();
        Stack<Character> decryptionStack = decryption(s);
        return stackToString(decryptionStack);

    }
}
