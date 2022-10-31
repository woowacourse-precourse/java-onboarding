package onboarding;

import java.util.Stack;

public class Problem2 {

    public static String solution(String cryptogram) {

        /*
        주어진 문자 cryptogram 에  대해 연속하는 중복 문자를 제거하는 기능 구현
        조건 - cryptogram 의 길이는 1이상 1000이하이다, 알파벳 소문자로만 이루어져 있다.
        1. Stack 사용
        2. cryptogram 에 CharAt으로 하나씩 접근, 값을 비교하여 제거
        3. 문자 내 연속 중복 문자가 없을때까지 반복실행
         */
        Stack<Character> characterStack = new Stack<>();
        char temp = ' ';
//        for (Character data : cryptogram.toCharArray()) {
//            if(!characterStack.isEmpty() && characterStack.peek().equals(data)){
//                temp = characterStack.peek();
//                characterStack.pop();
//            }else if(data.equals(temp)){
//                continue;
//            }else{
//                characterStack.push(data);
//            }
//        }

        for (char c : cryptogram.toCharArray()) {
            if (!characterStack.isEmpty() && characterStack.peek().equals(c)) {
                temp = characterStack.peek();
                characterStack.pop();
            } else if (temp != c) {
                characterStack.push(c);
                temp = ' ';
            }
        }

        String answer = "";
        if (characterStack.isEmpty()) {
            return answer;
        }

        for (Character character : characterStack) {
            answer += character;
        }
        return answer;
    }

}
