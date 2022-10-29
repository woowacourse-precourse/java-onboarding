package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }
    // string을 리스트로 만든다.
    // 리스트를 돌리면서 겹치는 부분을 제거한다.


    public static List<Character> getList(String cryptogram){
        List<Character> cryptoList = new ArrayList<>();
        for(int i=0; i<cryptogram.length(); i++){
            cryptoList.add(cryptogram.charAt(i));
        }
        return cryptoList;
    }

}

