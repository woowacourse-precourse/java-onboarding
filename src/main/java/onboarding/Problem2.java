package onboarding;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 생각 정리
 * 기존에는 visit isDuplicate배열을 만들어서 썼었다.
 *  이렇게 해버리면 새로운 String을 만드는 비용이 decrypt한번 할때마다 들기때문에 비효율적이라고 생각.
 *  새로운 방법을 고민해보자.
 * Queue 두개로 처리해보면 좋을듯.
 * 두개 번갈아가면서 쓰면 될거같다.
 * 하나는 새로운 문자열 받는 용도(before)
 * 하나는 기존 문자열 담겨있고 하나씩 빼도록 하는 용도(after)
 * 기능 명세
 * 1. before queue에 기존 문자열 담기
 * 2. 문자열 빼면서 뒷문자 중복문자면 둘다 제외
 * 3. 중복문자 아닌경우에만 after queue로
 */
public class Problem2 {
    public static String solution(String cryptogram) {
        String answer;
        Queue<Character> before = new ArrayDeque<>();
        Queue<Character> after = new ArrayDeque<>();

        for(int i=0; i<cryptogram.length(); i++)
            before.add(cryptogram.charAt(i));

        while(!before.isEmpty()){
            int sizeBeforeDecrypt = before.size();
            after = new ArrayDeque<>();
            decrypt(before, after);
            if(sizeBeforeDecrypt==after.size())break;
            before = after;
        }

        answer = createAnswer(after);
        return answer;
    }

    public static String createAnswer(Queue<Character> after) {
        StringBuilder sb = new StringBuilder();
        while(!after.isEmpty()){
            sb.append(after.poll());
        }

        return sb.toString();
    }

    public static void decrypt(Queue<Character> before, Queue<Character> after) {
        while(!before.isEmpty()){
            char temp = before.poll();
            insertOrDelete(temp, before, after);
        }
    }

    public static void insertOrDelete(char currentChar, Queue<Character> before, Queue<Character> after){
        if(before.isEmpty()){
            after.add(currentChar);
            return;
        }

        char nextChar = before.peek();

        //insert
        if(currentChar!=nextChar){
            after.add(currentChar);
            return;
        }

        //delete
        while(!before.isEmpty() && before.peek()==currentChar)
            before.poll();
    }
}
