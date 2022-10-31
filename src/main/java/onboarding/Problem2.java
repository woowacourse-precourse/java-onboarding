package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = cryptogram;
        //String을 List로 변환
        List<String> list = new ArrayList<String>(Arrays.asList(answer.split("")));

        list = checkStr(list);
        answer = listToString(list);

        return answer;
    }
    //List의 중복을 검사
    public static List<String> checkStr(List<String> list){
        int cnt = 0;
        while(true) {
            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i).equals(list.get(i + 1))) {
                    list.remove(i + 1);
                    list.remove(i);
                    cnt = 0;
                }
                else cnt ++;
            }
            if(cnt == list.size()-1 || list.size() == 0)
                break;
        }
        return list;
    }
    //List를 String으로 변환
    public static String listToString(List<String> list){
        String str = list.toString().replaceAll("[^a-z]", "");

        return str;
    }
}