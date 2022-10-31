package onboarding;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 기능명세
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
