package onboarding;

import java.util.*;

public class Problem6 {

    public static boolean validateEmail(String email) {
        return email != null && email.endsWith("@email.com") && !email.equals("@email.com");
    }

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        Map<String, List<Integer>> map = new HashMap<>();
        Set<String> set = new TreeSet<>(); // 중복을 제거하고 정렬된 결과를 원하기 때문에 TreeSet을 사용한다.

        for (int formIndex = 0; formIndex < forms.size(); formIndex++) {
            List<String> form = forms.get(formIndex);
            String email = form.get(0);
            String username = form.get(1);

            if (!validateEmail(email))
                continue;

            for (int i = 0; i < username.length() - 1; i++) {
                String adjacentString = String.format("%c%c",
                        username.charAt(i), username.charAt(i + 1));
                // 두 글자씩 끊어서 Map에 해당하는 Key List에
                // 현재 forms에서의 index를 저장한다.

                if (!map.containsKey(adjacentString))
                    map.put(adjacentString, new ArrayList<>());
                map.get(adjacentString).add(formIndex);
            }
        }

        map.forEach((k, v) -> {
            if (v.size() >= 2) { // 중복된 닉네임이 있다면
                for (int index : v) {
                    List<String> form = forms.get(index); // index를 이용해서
                    String email = form.get(0);
                    set.add(email); // 사용을 제한할 email을 TreeSet에 추가한다.
                }
            }
        });

        answer.addAll(set); // 정렬된 이메일 목록으로 결과를 받을 수 있다.
        return answer;
    }
}
