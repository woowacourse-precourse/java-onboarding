package onboarding;

import java.util.LinkedList;
import java.util.List;
import  java.util.Scanner;
public class Problem2 {
    public static String solution(String cryptogram) {
        // answer 초기화
        String answer = "";

        // character형태인 list로 리스트 초기화
        List<Character> list = new LinkedList<>();

        // cryptogram안의 문자들을 char 형태로 list로 만들기 >
        for (int i = 0; i < cryptogram.length(); i ++) {
            list.add(cryptogram.charAt(i));
        }

        // 앞 단어와 뒤 단어가 같으면 > 전부 제거(remove)
        for (int i = 1; i < list.size(); i ++) {
            if(list.get(i-1).equals(list.get(i))) {
                list.remove(i);
                list.remove(i-1);

                // 중복 문자를 제거해주고 다시 초기화 시키기
                i=0;
            }
        }

        // 문자(char)들로 이루어진 리스트를 문자열로 바꾸는 코드
        for (int i = 0; i <list.size(); i ++) {
            answer += list.get(i);
        }
        return answer;
    }
}
