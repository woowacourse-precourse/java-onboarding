package onboarding;

import java.util.Stack;

public class Problem2 {

    /**
     * 중복 문자를 제거하여 암호문을 생성하는 함수
     * @param cryptogram : 초기 입력 받은 암호
     * @return 최종 완성된 해독문
     */
    public static String decodeCryptogram(String cryptogram){
        char compareChar = ' ';
        String finalCryptogram = "";

        Stack<Character> cypherStack = new Stack<>();
        cypherStack.add(cryptogram.charAt(0));

        for (int i =1; i<cryptogram.length(); i++){
            if((!cypherStack.empty())&&cypherStack.peek().equals(cryptogram.charAt(i))) {
                compareChar = cypherStack.pop();
            }else{
                if(!(cryptogram.charAt(i)==compareChar)) {
                    compareChar = cryptogram.charAt(i);
                    cypherStack.push(cryptogram.charAt(i));
                }
            }
        }

        for (char cyp : cypherStack){
            finalCryptogram+= cyp;
        }

        return finalCryptogram;
    }

    public static String solution(String cryptogram) {
        String answer = "";

        answer = decodeCryptogram(cryptogram);

        return answer;
    }
}
