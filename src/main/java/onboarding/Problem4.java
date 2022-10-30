package onboarding;

import java.util.HashMap;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        initFrogTable();
        return answer;
    }

    // HashMap를 청개구리 사전으로 초기화 함수
    public static HashMap<String, String> initFrogTable() {
        HashMap<String, String> FrogTable = new HashMap<String, String>();
        for (char i = 'a', j = 'z'; i <= 'z'; i++, j--) {
            FrogTable.put(Character.toString(i), Character.toString(j));
        }
        for (char i = 'A', j = 'Z'; i <= 'Z'; i++, j--) {
            FrogTable.put(Character.toString(i), Character.toString(j));
        }
        return FrogTable;
    }
}
