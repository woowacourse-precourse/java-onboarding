package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        Set<String> set = new TreeSet<>();

        for (int i = 0; i < forms.size(); i++) {
            String[] nickArr = forms.get(i).get(1).split("");
            String[] emailArr = forms.get(i).get(0).split("@");

            List<String> list = new ArrayList<>();

            combination(list, nickArr, "", 0, 0);

            compare(forms, list, set, i);
        }

        answer = new ArrayList<>(set);

        return answer;
    }

    // 닉네임 조합 만드는 메서드
    static void combination(List<String> list, String[] nickArr, String str, int idx, int depth) {
        if (depth > 1) {
            list.add(str);
        }

        for (int i = idx; i < nickArr.length; i++) {
            combination(list, nickArr, str + nickArr[i], i + 1, depth + 1);
            if (str.length() > 0) {
                return;
            }
        }
    }

    // 조합을 다른 닉네임과 비교하는 메서드
    static void compare(List<List<String>> forms, List<String> list, Set<String> set, int i) {
        for (int j = i + 1; j < forms.size(); j++) {
            for (int k = 0; k < list.size(); k++) {
                if (forms.get(j).get(1).contains(list.get(k))) {
                    if(forms.get(j).get(0).split("@")[1].equals("email.com")) {
                        set.add(forms.get(j).get(0));
                    }
                    if(forms.get(k).get(0).split("@")[1].equals("email.com")) {
                        set.add(forms.get(k).get(0));
                    }
                }
            }
        }
    }
}
