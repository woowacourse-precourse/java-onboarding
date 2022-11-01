package onboarding;

import java.util.Stack;
/*
 * @version 1.0.0 2022년 11월 1일
 * @author DongWooE
 */
public class Problem2 {
    /* 중복여부를 판단하기 위한 인스턴스 변수 */
    private Stack<Character> stack = new Stack<Character>();
    /*
     * Problem 2의 메인 메소드
     * @param cyptogram 암호문
     * @return 중복된 문자가 삭제된 최종 결과값
     */
    public static String solution(String cryptogram) {
        Problem2 p2 = new Problem2();
        p2.putIntoStack(cryptogram);
        String result = p2.transToString();
        return result;
    }
    /*
     * Stack에 암호문 각 문자를 넣어가며 중복여부를 판단하며 stack에 넣는 메소드
     * @param cyptogram 암호문
     */
    private void putIntoStack(String cryptogram){
        for(char c : cryptogram.toCharArray()){
            if(stack.empty()) stack.push(c);
            else if(stack.peek() != c) stack.push(c);
            else{
                while(!stack.empty() && stack.peek() == c)  stack.pop();
            }
        }
    }
    /*
     * Stack의 값들을 String으로 변환하는 메소드
     * @return 최종 변환 완료된 문자열
     */
    private String transToString(){
        StringBuilder sb = new StringBuilder();
        while(!stack.empty()){
            sb.append(stack.peek());
            stack.pop();
        }
        return sb.reverse().toString();
    }
}
