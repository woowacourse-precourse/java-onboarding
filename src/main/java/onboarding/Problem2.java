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
            //(수정) 둘이상 중복인경우 모두 없앨 수 있도록 했다!
            for (int i=a.size()-1 ; i>-1 ; i--){
                int c = a.get(i);
                char b = list.get(a.get(i));
                while (true){
                    if (list.size() == 0)
                        break;
                    else if (b == list.get(c))
                        list.remove(c);
                    else
                        break;
                }

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
