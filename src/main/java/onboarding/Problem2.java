package onboarding;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Problem2 {
    public static String solution(String cryptogram) {
        Deque<Character> answer = new LinkedList<>();
        Queue<Character> temporary = new LinkedList<>();
        char[] charArr = cryptogram.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            char word = charArr[i] ;
            if(!answer.isEmpty()) {
                if (word == answer.peekLast()) {
                    if(!temporary.isEmpty()) {
                        temporary.poll();
                    }
                    temporary.offer(word);
                    answer.pollLast();
                }else if(!temporary.isEmpty() && temporary.peek() == word) {
                }else answer.offerLast(word);
            }else answer.offerLast(word);
        }

        int size = answer.size();
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < size; i++) {
            result.append(answer.pollFirst());
        }
        return String.valueOf(result);
    }
}
