package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        DupeChecker dc = new DupeChecker(forms);
        List<Boolean> isdup_list = dc.check();
        for (int i = 0; i < forms.size(); i++) {
            if (isdup_list.get(i)) {
                String email = forms.get(i).get(0);
                if (answer.contains(email)) {
                    continue;
                }
                answer.add(email);
            }
        }
        Collections.sort(answer);
        return answer;
    }
}

class DupeChecker {
    private static List<List<String>> forms;

    public DupeChecker(List<List<String>> forms) {
        this.forms = forms;
    }

    private static List<List<String>> makeBigramsList() {
        List<List<String>> bigrams_list = new ArrayList<>();
        for (List<String> form : forms) {
            String str = form.get(1);
            List<String> list = new ArrayList<>();
            int i = 0;
            while (i < str.length() - 1) {
                String sub_str = str.substring(i, i+2);
                list.add(sub_str);
                i += 1;
            }
            bigrams_list.add(list);
        }
        return bigrams_list;
    }

    private static List<Boolean> setIsdupeList() {
        List<Boolean> isdupe_list = new ArrayList<>();
        for (int i = 0; i < forms.size(); i++) {
            isdupe_list.add(false);
        }
        return isdupe_list;
    }

    static List<Boolean> check() {
        List<List<String>> bigrams_list = makeBigramsList();
        List<Boolean> isdupe_list = setIsdupeList();
        for (int cur = 0; cur < bigrams_list.size(); cur++) {
            if (isdupe_list.get(cur)) {
                continue;
            }
            List<String> bigrams = bigrams_list.get(cur);
            for (String bigram : bigrams) {
                for (int next = cur + 1; next < bigrams_list.size(); next++) {
                    if (bigrams_list.get(next).contains(bigram)) {
                        isdupe_list.set(cur, true);
                        isdupe_list.set(next, true);
                    }
                }
            }
        }
        return isdupe_list;
    }
}
