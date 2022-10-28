package onboarding;

import java.util.ArrayList;


public class Problem3 {
    public static int solution(int number) {

        int answer = count369(intToLst(number));
        return answer;
    }

    //  1부터 number만큼 문자로 더한 문자열 생성후 한 단위의 숫자배열로 변환하는 메서드
    public static ArrayList<Integer> intToLst(int number) {
        String lstToStr = "";
        for (int i = 1; i <= number; i++) {
            lstToStr += Integer.toString(i);
        }
        ArrayList<Integer> strToNumlist = new ArrayList<>();
        for (String sepNum : lstToStr.split("")) {
            strToNumlist.add(Integer.parseInt(sepNum));
        }
        return strToNumlist;
    }

    //  3,6,9 개수 세는 메서드
    public static int count369(ArrayList<Integer> intToLst) {
        int cnt = 0;
        for (int num : intToLst) {
            if (num == 3 || num == 6 || num == 9) {
                cnt ++;
            }
        }
        return cnt;
    }

}
