package onboarding;


import java.util.*;


/**
 * <p>
 * 암호문을 좋아하는 괴짜 개발자 브라운이 이번에는 중복 문자를 이용한 새로운 암호를 만들었다. 예를 들어 "browoanoommnaon"이라는 암호문은 다음과 같은 순서로 해독할 수 있다.
 * </p><br/>
 * 1. "browoanoommnaon"<p>
 * 2. "browoannaon"<p>
 * 3. "browoaaon"<p>
 * 4. "browoon"<p>
 * 5. "brown"<p>
 * </p>
 * 임의의 문자열 cryptogram이 매개변수로 주어질 때, 연속하는 중복 문자들을 삭제한 결과를 return 하도록 solution 메서드를 완성하라.
 * </p>
 */
public class Problem2 {
    public static String solution(String cryptogram) {
        List<String> nameList = List.of(cryptogram.split(""));
        Stack<String> stack = new Stack<>();
        for (String s : nameList) {
            if (stack.isEmpty()) {
                stack.push(s);
            } else {
                if (stack.lastElement().equals(s)) {
                    stack.pop();
                } else {
                    stack.push(s);
                    nameList = new ArrayList<>(stack);
                }
            }
        }
        List<String> result = new ArrayList<>(stack);
        return String.join("", result);
    }
}
