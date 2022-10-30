package onboarding;

import java.util.HashMap;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        return answer;
    }

    // HashMap를 청개구리 사전으로 초기화 함수
    public static HashMap<char, char> initFrogTable() {
        HashMap<char, char> FrogTable = new HashMap<String, String>();
        for (char i = 'a', j = 'z'; i <= 'z'; i++, j--) {
            FrogTable.put(i, j);
        }
        for (char i = 'A', j = 'Z'; i <= 'Z'; i++, j--) {
            FrogTable.put(i, j);
        }
        return FrogTable;
    }

    // 주어진 문자를 청개구리 사전을 통해 변환하는 함수
    public static char convertChar(char s, HashMap<char, char> frogTable) {
        char changeString = s;
        if (frogTable.containsKey(s)) {
            changeString = frogTable.get(s);
        }
        return changeString;
    }


}
