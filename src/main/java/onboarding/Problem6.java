package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {

        HashMap<String, List<String>> mapEmail = new HashMap<>();
        List<String> tmp = new ArrayList<>();

        for (int i = 0; i < forms.size(); i++) {
            String nickName = forms.get(i).get(1);
            String email = forms.get(i).get(0);

            // 순회하면서 nickName과 email 정리
            makeEmail(nickName, email, mapEmail);
        }

 
        List<String> answer = new ArrayList<>();

        return answer;
    }

    public static void makeEmail(String nickName, String email,  HashMap<String, List<String>> mapEmail) {

        for (int i = 0; i < nickName.length() - 1; i++) {
            String now = String.valueOf(nickName.charAt(i));
            String next = String.valueOf(nickName.charAt(i + 1));

            // mapEmail은 두 글자 조합을 key로 두고 생성
            String both = now + next;
            if (mapEmail.containsKey(both)) {
                mapEmail.get(both).add(email);
            } else {
                mapEmail.put(both, new ArrayList<>());
                mapEmail.get(both).add(email);
            }

        }
    }
}
