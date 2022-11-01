package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<List<String>> prevL = new ArrayList<>(forms);
        List<String> answer = new ArrayList<>();

        while (true) {
            List<List<String>> nextL = new ArrayList<>();
            String cmpe = prevL.get(0).get(0);  // prevL 리스트의 첫 번째 교육생의 닉네임
            String cmpk = prevL.get(0).get(1);  // prevL 리스트의 첫 번째 교육생의 이메일
            boolean isSameNick = false;

            // 첫 번째 교육생의 닉네임을 나머지 교육생의 닉네임과 비교합니다.
            for (int i = 1; i < prevL.size(); i++) {
                String email = prevL.get(i).get(0);
                String knick = prevL.get(i).get(1);

                // 비교 대상 교육생의 넥네임이 2글자 이상 같은 경우, 결과 리스트에 삽입합니다.
                if (findSameNick(cmpk, knick)) {
                    isSameNick = true;
                    answer.add(email);
                }
                else // 반대의 경우, nextL 리스트에 삽입합니다.
                    nextL.add(new ArrayList<>(Arrays.asList(email, knick)));
            }
            if (isSameNick) answer.add(cmpe);
            if (nextL.size() <= 1) break;
            prevL = nextL;
        }
        Collections.sort(answer);
        return answer;
    }
    static boolean findSameNick (String a, String b) {
        int len = a.length();

        for (int i = 0; i < len - 1; i++) {
            String s = a.substring(i, i + 2);
            if (b.contains(s)) return true;
        }
        return false;
    }
}
