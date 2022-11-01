package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>(1000);

        // 닉네임 분리
        List<String> nickname = getNickname(forms);

        List<String> duplicate = new ArrayList<>();
        for (int i = 0; i < nickname.size(); i++) {
            String s = nickname.get(0);
            List<String> small = getSmallname(s);
            for (String a : nickname) {
                for (String b : small) {
                    if (a.contains(b) && !duplicate.contains(a)) {
                        duplicate.add(a);
                    }
                }
            }
        }

        for (List<String> form : forms) {
            for (String a : duplicate) {
                if (form.get(1).equals(a)) {
                    answer.add(form.get(0));
                }
            }
        }

        Collections.sort(answer);

        return answer;
    }

    static List<String> getNickname(List<List<String>> list) {
        List<String> nickname = new ArrayList<>();
        for (List<String> l : list) {
            nickname.add(l.get(1));
        }
        return nickname;
    }

    static List<String> getSmallname(String s) {
        List<String> a = new ArrayList<>(100);
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 2; j <= s.length(); j++) {
                a.add(s.substring(i, j));
            }
        }
        return a;
    }
}
