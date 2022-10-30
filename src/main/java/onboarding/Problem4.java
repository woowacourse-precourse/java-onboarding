package onboarding;

import java.util.HashMap;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

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

    // 주어진 문자를 청개구리 사전을 통해 변환하는 함수
    public static String convertOneString(String s, HashMap<String, String> frogTable) {
        String changeString = s;
        if (frogTable.containsKey(s)) {
            changeString = frogTable.get(s);
        }
        return changeString;
    }
}
