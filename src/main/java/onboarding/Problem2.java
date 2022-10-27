package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {

        List<Character> crypList = initList(cryptogram);
        List<Character> tmpList = new ArrayList<>(crypList);

        while (true) {
            int size = crypList.size();
            for (int i = 0; i < crypList.size() - 1; i++) {
                if (crypList.get(i) == crypList.get(i + 1)) {
                    tmpList.set(i, '*');
                    tmpList.set(i + 1, '*');
                }
            }
            tmpList.removeAll(Collections.singleton('*'));
            crypList = new ArrayList<>(tmpList);
            if (size == crypList.size()) break; // 변화가 없었다면 종료
        }

        return getAnswerStr(crypList);
    }

    private static String getAnswerStr(List<Character> crypList) {
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < crypList.size(); i++) {
            answer.append(crypList.get(i));
        }
        return answer.toString();
    }

    private static List<Character> initList(String str) {
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            list.add(str.charAt(i));
        }
        return list;
    }

}
