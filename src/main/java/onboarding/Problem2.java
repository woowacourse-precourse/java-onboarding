package onboarding;

import java.util.*;

public class Problem2 {
    public static String solution(String cryptogram) {
//      cryptogram 받아서 단일 문자 list에 넣기
        ArrayList<String> lst = new ArrayList<String>();

        for (String s : cryptogram.split("")) {
            lst.add(s);
        }
        String answer = sameLang(lst);;
        return answer;
    }

}
