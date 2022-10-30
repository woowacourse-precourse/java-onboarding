package onboarding;

import java.util.Arrays;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        //String을 List로 변환
        List<String> list = Arrays.asList(answer.split(""));

        list = checkStr(list);

        return answer;
    }
    //List의 중복을 검사
    public static List<String> checkStr(List<String> list){
        int cnt = 0;
        while(true) {
            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i) == list.get(i + 1)) {
                    list.remove(i + 1);
                    list.remove(i);
                }
                else cnt = 1;
            }
            if(cnt == 1)
                break;
        }
        return list;
    }
}