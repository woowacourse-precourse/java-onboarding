package onboarding;

import java.util.*;

/**
 * [풀이방법]
 * queue 에 넣으면서 확인하고 같으면 poll, 다르면 offer
 * -> 수정 -> 같은 단어가 2번이상 반복될 때 예외 발생
 * 같은 단어가 2번이상 반복될 때 그 단어를 저장해두고 한번에 지워버리는 방식으로 코드 구성
 *
 * 1. 마지막 단어를 저장할 변수 선언, queue 가 비어있으면 offer
 * 2. 중복인지 확인할 단어와 queue 의 마지막 단어가 같으면 그대로 진행
 * 3. 중복인 단어가 나오면 lastWord 에 중복인 단어를 넣어주고, 비교할 단어와 같으면 그대로 진행
 * 4. 그대로 진행하다 다른 단어가 나오면 lastWord 비워주고, 다른 단어는 queue 에 넣어줌
 **/
public class Problem2 {
    public static String solution(String cryptogram) {
        StringBuilder sb = new StringBuilder();

        Deque<Character> queue = new ArrayDeque<>();

        char lastWord = ' ';
        for (int i = 0; i < cryptogram.length(); i++) {
            char word = cryptogram.charAt(i);
            if (word == lastWord) {
                continue;
            }

            if (queue.isEmpty()) {
                queue.offerLast(word);
                lastWord = ' ';
            } else {
                if (queue.peekLast() == word) {
                    lastWord = queue.pollLast();
                } else {
                    queue.offerLast(word);
                    lastWord = ' ';
                }
            }
        }

        while (!queue.isEmpty()) {
            sb.append(queue.pollFirst());
        }

        return sb.toString();
    }
}
