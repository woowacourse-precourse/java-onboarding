package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem3 {
    public static int solution(int number) {

        int answer = 0;
        return answer;
    }

    //  1부터 number만큼 문자로 더한 문자열 생성후 한 단위의 숫자배열로 변환하는 메서드
    public static ArrayList<Integer> intToLst(int number) {
        String lstToStr = "";
        for (int i = 0; i < number; i++) {
            lstToStr += Integer.toString(i);
        }
        ArrayList<Integer> strToNumlist = new ArrayList<>();
        for (String sepNum : lstToStr.split("")) {
            strToNumlist.add(Integer.parseInt(sepNum));
        }
        return strToNumlist;
    }

    //  3,6,9 개수 세는 메서드

}
