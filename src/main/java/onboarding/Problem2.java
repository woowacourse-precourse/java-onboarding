package onboarding;

import java.util.Stack;

public class Problem2 {

    private static String eraseDuplicate(String cryptogram){
        Stack<Character> S = new Stack<>();

        // 뒤에서부터 훑는다.
        for (int i = cryptogram.length() - 1; i >= 0; i--){
            Character currChar = cryptogram.charAt(i);

            // 비어 있다면 push
            if (S.empty())
                S.push(currChar);
            else{
                // 현재 top과 다르다면 push한다
                if (S.peek() != currChar){
                    S.push(currChar);
                }
                // 같다면, 다른 문자가 나올 때까지 스킵해야 한다.
                else{
                    // 우선 현재 stack top이 중복 문자임으로 제거한다.
                    S.pop();

                    // 다른 문자가 나올 때까지, 혹은 첫 문자에 도달할 때까지 skip한다.
                    while (i >= 0 && currChar == cryptogram.charAt(i)){
                        i--;
                    }
                    i++;    // 다음 for문을 위한 i++
                }
            }

        }

        // Stack으로부터 다시 String으로 만든다.
        String result = "";
        while (!S.empty()){
            result += S.pop();
        }

        return result;
    }
    public static String solution(String cryptogram) {
        return eraseDuplicate(cryptogram);
    }
}
