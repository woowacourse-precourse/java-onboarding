package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        Stack<Character> stack=new Stack<>();
        stack.push(cryptogram.charAt(0));
        Boolean overlap=false; // 중복 되고 있는 상황인지 확인하는 변수
        // cryptogram의 앞에서부터 한 글자씩 확인
        for(int i=1; i<cryptogram.length(); i++){
            if(!overlap){ // 중복되고 있는 상황이 아닐 경우
                if(!stack.isEmpty() && cryptogram.charAt(i)==stack.peek()) // 확인하는 문자가 이전 문자랑 같을 경우 -> 중복 시작
                {
                    if(i==cryptogram.length()-1) // 확인하는 문자가 마지막일 경우
                        stack.pop(); // 중복 시작 문자 스택에서 제거
                    overlap=true; // 중복 시작
                }
                else { // 중복 시작되는 경우가 아닐 경우
                    stack.push(cryptogram.charAt(i)); // 스택에 해당 문자를 넣어준다.
                }
            }
            else{ // 중복되고 있는 상황일 경우
                if(cryptogram.charAt(i)!=stack.peek()){ // 확인하는 문자가 중복 문자랑 다를 경우
                    stack.pop(); // 중복 시작 문자 스택에서 제거
                    overlap=false; // 중복 끝
                    i--; // 해당 문자를 다시 확인하기 위해 i를 1 빼준다.
                }
                else if (i==cryptogram.length()-1) { // 마지막 문자까지 중복일 경우
                    stack.pop(); // 중복 시작 문자 스택에서 제거
                }
            }
        }
        String answer = "";
        while(!stack.isEmpty())
            answer= stack.pop()+answer; // 스택에 있는 문자를 꺼내서 역순으로 합친 것이 정답
        return answer;
    }
}
