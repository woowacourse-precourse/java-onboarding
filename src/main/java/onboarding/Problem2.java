package onboarding;

import java.util.Stack;

/**
 * 1. 한글자씩 잘라서 배열에 담는다.
 * 2. for문을 돌리며 하나씩 새로운 배열에 담는데 만약 지금 글자와 다음글자가 같다면 다음글자는 뛰어넘는다.
 * 3. 중복된 글자가 있으면 count를 올린다.
 * 4. count가 0인경우 종료 후 배열 출력
 * 
 * @author 2songyi
 *
 */
public class Problem2 {
    public static String solution(String cryptogram) {
       
        
        Stack<Integer> stack = new Stack<>();
        int length = cryptogram.length();
        // char로 만든 후 배열에 담는다.
        for (int i = 0; i < cryptogram.length(); i++) {
        	
        	if (!stack.empty() && cryptogram.charAt(stack.peek()) == cryptogram.charAt(i)) {
        		while (i < length && cryptogram.charAt(stack.peek()) == cryptogram.charAt(i)) {
        			i++;
        		}
        		stack.pop();
        		i--;
        		continue;
        	}
        	stack.push(i);
        }
        
        StringBuilder answer = new StringBuilder();
        for (int i : stack) {
        	answer.append(cryptogram.charAt(i));
        }

        return answer.toString();
    }
    
//    public static void main(String[] args) {
//		System.out.println(solution("browoanoommnaon"));
//	}
}
