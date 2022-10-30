package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer="";
        if(checkLimit(cryptogram)) answer =removeDuplicate(cryptogram);
        return answer;
    }

    /*
    문제조건 사항 체크
     */
    private static boolean checkLimit(String cryptogram){
        //문자열 길이 1부터 1000까지
        if(cryptogram.length()>=1&&cryptogram.length()<=1000) return true;
        //문자열이 다 소문자 인지
        if (cryptogram.matches("^[a-z]*$")) return true;
        return false;
    }
    /*
    스택을 이용한 중첩단어 뺴기
     */
    private static String removeDuplicate(String str){
        // 기본 케이스: 문자열이 null이거나 비어 있는 경우
        if (str == null || str.equals("")) {
            return str;
        }
        Stack<Character> stack = new Stack<Character>();
        char ch[]=str.toCharArray();
        for(int i=0;i<str.length();i++){
            if(!stack.empty()&&stack.peek().equals(ch[i])){
                stack.pop();
            }else{
                stack.push(ch[i]);
            }
        }
        int n=stack.size();
        char ans[]=new char[n];
        while(!stack.empty()){
            ans[--n]=stack.pop();
        }
        return String.copyValueOf(ans);
    }
}
