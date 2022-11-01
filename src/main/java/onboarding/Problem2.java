package onboarding;

import java.util.Stack;

/*
암호문을 좋아하는 괴짜 개발자 브라운이 이번에는 중복 문자를 이용한 새로운 암호를 만들었다. 예를 들어 "browoanoommnaon"이라는 암호문은 다음과 같은 순서로 해독할 수 있다.

"browoanoommnaon"
"browoannaon"
"browoaaon"
"browoon"
"brown"
 */
public class Problem2 {
    public static String solution(String cryptogram) {
        StringBuilder answer = new StringBuilder();
        Stack<Character> st = new Stack<>();
        for(char x : cryptogram.toCharArray()){
            if(st.isEmpty()) st.add(x);
            else if(st.peek()==x){
                st.pop();
            }else{
                st.add(x);
            }
        }
        for(int i=0; i<st.size(); i++){
            answer.append(Character.toString(st.elementAt(i)));
        }
        return answer.toString();
    }
}
