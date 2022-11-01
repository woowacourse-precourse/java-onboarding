package onboarding;

import java.util.ArrayList;

public class Problem4 {
    public static String solution(String word) {
        /*
        기능 목록
        1. A-Z, a-z 배열 생성
        2. 주어진 문자를 문자별로 저장
        3. 문자 별로 A-Z, a-z 배열 비교
        4. 포함되어 있다면 25-index 값을 새 index로 가지는 문자로 출력
        5. 예외 case 처리 (A-Z, a-z 외의 경우)
        */
        String answer = "";

        //A-Z, a-z 배열 생성
        ArrayList<Character> upperCase = new ArrayList<Character>(26);
        ArrayList<Character> lowerCase = new ArrayList<Character>(26);

        for(int i=0; i<26; i++) {
            //ASCII
            upperCase.add((char)(65+i));
        }

        for (int j=0; j<26; j++) {
            //ASCII
            lowerCase.add((char)(97+j));
        }

        System.out.print(upperCase);
        System.out.print(lowerCase);

        return answer;
    }
}
