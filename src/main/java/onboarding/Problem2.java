package onboarding;

import java.awt.*;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        ArrayList<Character> list = new ArrayList<Character>();
        //하나씩 쪼개기 넥슬라이스!
        for (int i=0 ; i<cryptogram.length() ; i++){
            list.add(cryptogram.charAt(i));
        }

        while (true) {
            //중복찾기
            List<Integer> a = new ArrayList<>();
            for (int i=0 ; i<list.size()-1; i++){
                if (list.get(i) == list.get(i+1)) {
                    a.add(i);
                }
            }
            //중복 없으면 반복문 중단 제발 무한루트 끊어주세요
            if (a.size()==0){
                break;
            }
            //중복찾은거 차례대로 없애기 list 특성상 뒷번호부터 해야함 안그럼 망함
            for (int i=a.size()-1 ; i>-1 ; i--){
                int b = a.get(i);
                list.remove(b+1);
                list.remove(b);
            }
        }

        String answer = "answer";
        //다중복이어서 하나도 없을경우
        if (list.size() == 0 ){
            answer = "";
        }
        //하나라도 있다! 그럼 그냥 싹다 걸리는거여~
        else {
            String c = "";
            //이런 포문도 기억하자!! 파이썬에서 썻던거랑 비슷해서 손에 익는다
            for (Character item : list) {
                c += item;
            }
            answer = c;
        }
        return answer;
    }
}
