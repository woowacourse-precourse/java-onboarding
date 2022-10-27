package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }

    public static Stack<Character> deleteDuplicateWordsInRow(String cryptogram) {
        Stack<Character> words=new Stack<>();
        boolean isTopDuplicate=false;
        words.push(cryptogram.charAt(0)); //첫 문자는 바로 push
        for(int i = 1; i < cryptogram.length(); i++) {
            char nowChar=cryptogram.charAt(i);
            if(nowChar==words.peek()) {
                //중복이라면
                isTopDuplicate=true;
                continue; //이번 문자는 stack 에 삽입하지 않고 다음 문자를 체크한다
            }
            //여기서부터는 top 이랑 같지 않은 다른 문자일 경우 처리
            if(isTopDuplicate) {
                //지금까지 내내 중복된 문자 나오다가, 이번에 처음으로 중복이 아닌 문자가 나온 것
                words.pop();
                //그런데, pop 하고 그 다음 peek 가 같은 문자라면? -> 또 제거!
                if(nowChar==words.peek()) {
                    continue;
                }
            }
            words.push(nowChar);
            isTopDuplicate = false; //이제 중복 아닌 수 등장이므로 false 로 변경
        }

        //for 문이 다 끝난  후, stack 의 top 에 있는게 duplicate 라면? -> stack 에서 제거
        if(isTopDuplicate) {
            words.pop();
        }
        return words;
    }
}
