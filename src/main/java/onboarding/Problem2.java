package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        // 제시된 문자열을 stack에 담으면서 중복된 문자열을 판단한다.
        Stack<Character> crstack = new Stack<>();
        // 길이가 최소 1인 문자열이 주어지므로 첫번째 문자를 stack에 넣는다.
        crstack.push(cryptogram.charAt(0));
        // flag : stack의 마지막 문자가 중복된 문자(삭제 필요)인 경우 true
        Boolean flag = false;
        Character temp;
        
        // 문자열 한 문자씩 탐색
        for (int i = 1; i < cryptogram.length(); i++){
            temp = cryptogram.charAt(i);
            // 탐색한 문자가 stack의 마지막 문자와 다른 경우
            if (temp != crstack.peek()){
                // flag가 true : stack의 마지막 문자가 중복된 문자여서 제거해야 하는 경우
                if (flag){
                    crstack.pop();
                    flag = false;
                    // 탐색한 문자를 중복된 문자를 지운 뒤의 stack 마지막 문자와 한 번 더 비교해야 함
                    // 같을 경우 stack 마지막 문자를 한 번 더 삭제해야 함, 이 경우 현재 탐색한 문자도 stack에 추가하면 안됨
                    if (temp == crstack.peek()){
                        crstack.pop();
                        continue;
                    }
                }
                crstack.push(temp);
            }
            // 같은 경우, 탐색한 문자는 push하지 않고 비교한 stack의 마지막 문자도 추후에 지워야 함
            else{
                flag = true;
            }
        }

        // 문자열을 다 탐색한 뒤 stack의 마지막 문자가 삭제되지 않은 경우
        if (!crstack.empty() && flag){
            crstack.pop();
        }

        // stack의 끝부터 한 문자씩 빼내어 answer의 맨 앞에 계속 추가
        while (!crstack.empty()){
            answer = crstack.pop() + answer;
        }

        return answer;
    }
}
