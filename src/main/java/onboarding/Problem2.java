package onboarding;

import java.util.Stack;
import java.util.stream.Collectors;

/*
* 요구사항 : 문자열이 주어지면, **연속하는 중복 문자들을 삭제**한 결과를 반환하는 기능
* */
public class Problem2 {

    // 연속중복문자변수의 기본값
    static final char DEFAULT_CHARACTER_VALUE = ' ';

    /*
    * 역할: 기능1(문자열을 한 글자씩 쪼개어 연속하는 중복문자가 아닌 글자만 Stack에 넣어 반환)
    * 입력: String(연속하는 중복문자들을 없애야 할 문자열)
    * 결과: Stack<Character> (연속하는 중복문자가 없이 입력문자열 순서대로 들어가 있는 문자 스택)
    * */
    static Stack<Character> removeContinuousCharacter(String cryptogram) {
        // 동작1. 문자를 저장하는 빈 Stack을 만들고, 중복되는 문자를 넣기위한 변수(기본값:"")를 선언한다.
        //    - 각각 Stack과 중복문자변수로 칭한다.
        Stack<Character> stack = new Stack<Character>();
        char reduplicatedCharacter = DEFAULT_CHARACTER_VALUE;

        // 동작2. 주어진 문자열을 문자 배열로 만들어서 첫 문자에서 끝 글자까지 반복
        for(char character : cryptogram.toCharArray()) {
            if(stack.empty()){
                stack.push(character);
                reduplicatedCharacter = DEFAULT_CHARACTER_VALUE;
                continue;
            }
            if(reduplicatedCharacter == character)
                continue;
            if(stack.peek() == character) {
                reduplicatedCharacter = stack.pop();
                continue;
            }
            stack.push(character);
        }

        // 동작3. 연속중복문자가 제거된 Stack 반환
        return stack;
    }

    /*
    * 역할: 기능2(기능#1의 결과인 Stack을 받아 원래 문자열의 순서대로 글자들을 재조합하여 반환)
    * 입력: String(연속하는 중복문자들을 없애야 할 문자열)
    * 결과: String(연속중복문자들이 제거된 문자열)
    * */
    public static String solution(String cryptogram) {
        //동작: 메소드#1을 실행결과(Stack)에 남아있는 문자들을 원래 문자열의 순서대로 글자들을 재조합하여 반환한다.
        return removeContinuousCharacter(cryptogram).stream()
                .map(String::valueOf).collect(Collectors.joining());
    }
}
