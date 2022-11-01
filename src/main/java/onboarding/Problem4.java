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

        //주어진 문자 word를 저장
        char[] arrayWord  =new char[word.length()];

        for(int i=0; i<26; i++) {
            //ASCII
            upperCase.add((char)(65+i));
        }

        for (int j=0; j<26; j++) {
            //ASCII
            lowerCase.add((char)(97+j));
        }

        for(int w=0; w<arrayWord.length; w++) {
            //char 배열 형태로 word 문자 저장
            arrayWord[w] = (word.charAt((w)));

            if(upperCase.contains(arrayWord[w])) {
                //wIndex : 원래 문자의 A-Z 배열 내 Index
                int wIndex = upperCase.indexOf(arrayWord[w]);
                //newIndex : A-Z 배열내 반대 Index
                int newIndex = 25-wIndex;
                Character newWord = upperCase.get(newIndex);
                answer += newWord;
            } else if(lowerCase.contains(arrayWord[w])) {
                //wIndex : 원래 문자의 a-z 배열 내 Index
                int wIndex = lowerCase.indexOf(arrayWord[w]);
                int newIndex = 25-wIndex;
                Character newWord = lowerCase.get(newIndex);
                answer += newWord;
            } else {
                //A-Z, a-z에도 포함되지 않는다면 문자를 그대로 저장
                answer += arrayWord[w];
            }
        }
        return answer;
    }
}
