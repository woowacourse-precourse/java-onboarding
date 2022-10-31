package onboarding.pkgProblem2;

import java.util.Stack;

public class decryptionService {

    /* ---------------- Public operations -------------- */

    /**
     * Stack을 이용한 중복문자 복호화
     * 가장 상단에 있는 data와 array의 다음 Data가 같으면 가장 상단에 있는 data pop
     * @param cryptogram - 암호화된 문자열
     * @return
     */
    public String decryption(String cryptogram){
        Stack<Character> stk = new Stack<>();

        for(char c : cryptogram.toCharArray()){
            if(!stk.isEmpty() && stk.peek() == c)
                stk.pop();
            else
                stk.push(c);
        }

        StringBuilder sb = new StringBuilder();
        while(!stk.isEmpty()){
            sb.append(stk.pop());
        }
        return sb.reverse().toString(); //Stack 특성상 문자열이 뒤집히므로 Reverse 메소드 이용
    }
}
