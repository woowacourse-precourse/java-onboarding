package onboarding;


import java.util.Stack;

public class Problem2 {

    public static String solution(String cryptogram) {
        String answer = crypto(cryptogram);
        return answer;
    }

    private static String crypto(String cryptogram) {
        //연속되는 중복 문자 모두삭제
        StringBuilder sb = new StringBuilder();
        Stack<Character> s = new Stack();
        for(int i=0; i<cryptogram.length(); i++){
            char t = cryptogram.charAt(i);
            s.add(t);
            if(i+1<cryptogram.length() && t==cryptogram.charAt(i+1)) continue;
            while(s.size()>=2 && s.get(s.size()-1)==s.get(s.size()-2)){
                char temp = s.pop();
                while(!s.isEmpty()&& temp==s.get(s.size()-1)){
                    s.pop();
                }
            }
        }
        for(char c : s){
            sb.append(c);
        }
        return sb.toString();
    }

}