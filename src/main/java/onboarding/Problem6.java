package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<List<String>> prevL = new ArrayList<>(forms);
        List<String> answer = Collections.emptyList();

        while (true) {
            List<List<String>> nextL = new ArrayList<>();
            String cmpe = prevL.get(0).get(0);  // prevL 리스트의 첫 번째 교육생의 닉네임
            String cmpk = prevL.get(0).get(1);  // prevL 리스트의 첫 번째 교육생의 이메일
            boolean isSameNick = false;

            // 첫 번째 교육생의 닉네임을 나머지 교육생의 닉네임과 비교합니다.
            for (int i = 1; i < prevL.size(); i++) {
                String email = prevL.get(i).get(0);
                String knick = prevL.get(i).get(1);
            }
        }
    }
}
