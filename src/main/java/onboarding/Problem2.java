package onboarding;

import java.util.LinkedList;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {

        //문자열을 리스트로 만드는 함수
        List<String> list = new LinkedList<>(List.of(cryptogram.split("")));
        //원래 리스트의 길이를 기억하는 변수
        int originalSize = list.size();

            for (int i = 1; i <list.size(); i++) {
                String now = list.get(i);
                String prev = list.get(i - 1);
                //만약 현재 글자와 이전 글자가 같을 경우
                if (now.equals(prev)) {
                    list.remove(i);
                    list.remove(i - 1);
                    //반복을 0으로 초기화 시켜 제외된 수를 제외하고 계산해. 다시 반복한다.
                    i = 0;
                }
            }

        //최종적으로 완성된 리스트를 문자열로 반환한다.
        StringBuffer sb = new StringBuffer();
        for(String s:list)sb.append(s);
        return sb.toString();
    }
}
