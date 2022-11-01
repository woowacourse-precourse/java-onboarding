package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        /*
        기능 목록
        1. 각 문자별로 배열에 저장
        2. 문자 별로 index 'i'와 'i+1'이 같은 문자인 경우 탐색
        3. 2번 케이스 발생 시 index 'i', 'i+1' 문자 삭제 및 처음부터 재 탐색
        4. 2번 케이스 미 발생 시 탐색 종료, 문자 출력
        */
        String answer = "answer";

        //문자 별 배열에 저장
        ArrayList<Character> charList = new ArrayList<Character>();
        for (int i=0; i<cryptogram.length(); i++) {
            Character temp = cryptogram.charAt(i);
            charList.add(temp);
        }

        for (int j=0; j<charList.size()-1; j++) {
            Character currentChar = charList.get(j);
            Character nextChar = charList.get(j+1);
            // index 'i' == 'i+1'인 경우
            if(currentChar == nextChar) {
                charList.remove(j);
                charList.remove(j+1);
            }
        }

        System.out.print(charList);

        return answer;
    }
}
