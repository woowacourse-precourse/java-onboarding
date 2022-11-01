package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {

        List<List<String>> list = new ArrayList<>();
        List<String> answer = new ArrayList<>();

        forms.forEach((form) -> {
            String email = form.get(0);
            String nickname = form.get(1);
            for (int i = 0; i < nickname.length()-1; i++) {
                String substring = nickname.substring(i, i + 2);
                List<String> isExist = new ArrayList<>();

                list.forEach(el -> {
                    if (Objects.equals(el.get(1), substring)) {
                        if (!answer.contains(el.get(0))) {
                            answer.add(el.get(0));
                        }
                        if (!answer.contains(email)) {
                            answer.add(email);
                        }
                        isExist.add("ok");
                    }
                });

                if (isExist.size() == 0) {
                    list.add(Arrays.asList(email, substring));
                }

            }
        });

        answer.sort(Comparator.naturalOrder());

        return answer;
    }
}
/*
[제이, 이엠, 제이, 이슨, 워니, 엠제, 제이, 이제, 제엠]
 */