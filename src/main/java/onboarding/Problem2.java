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

        char lastWord = ' '; // 중복 된 단어를 저장하기 위한 임시 변수
        for (int i = 0; i < cryptogram.length(); i++) {
            char word = cryptogram.charAt(i);
            if (word == lastWord) { // 만약 중복 된 단어와 현재 단어가 같은 경우 그대로 진행, 연속 된 모든 단어를 지우기 위함
                continue;
            }

            if (queue.isEmpty()) { // queue 가 비어있을 때 단어 삽입
                queue.offerLast(word);
                lastWord = ' ';
            } else {
                if (queue.peekLast() == word) { // queue 의 마지막 단어와 현재 단어가 같다면 queue 의 마지막 단어를 빼내어 변수에 저장
                    lastWord = queue.pollLast();
                } else { // 현재 단어를 queue 에 삽입하고, 단어가 다르기 때문에 lastWord 를 초기화 시켜준다.
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
