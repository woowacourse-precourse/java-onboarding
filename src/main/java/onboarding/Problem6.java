package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        DupeChecker dc = new DupeChecker(forms);
        List<Boolean> isdup_list = dc.check();

        for (int i = 0; i < forms.size(); i++) {
            if (isdup_list.get(i)) {
                answer.add(forms.get(i).get(0));
            }
        }
        Collections.sort(answer);
        // System.out.println(answer);
        return answer;
    }
}

class DupeChecker {
    private static List<List<String>> forms;

    public DupeChecker(List<List<String>> forms) {
        this.forms = forms;
    }

    static List<List<String>> makeBigramsList() {
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
        for (int i=0; i<forms.size(); i++) {
            isdupe_list.add(false);
        }
        return isdupe_list;
    }

    static List<Boolean> check() {
        List<List<String>> bigrams_list = makeBigramsList();
        List<Boolean> isdupe_list = setIsdupeList();
        for (int idx=0; idx<bigrams_list.size(); idx++) {
            if (isdupe_list.get(idx)) {
                continue;
            }
            // System.out.println(idx);
            List<String> bigrams = bigrams_list.get(idx);
            for (int inner=0; inner<bigrams.size(); inner++) {
                String bigram = bigrams.get(inner);
                // System.out.println(bigram);
                for (int next=idx+1; next<bigrams_list.size(); next++) {
                    // System.out.println(bigrams_list.get(next));
                    if (bigrams_list.get(next).contains(bigram)) {
                        isdupe_list.set(idx, true);
                        isdupe_list.set(next, true);
                        // System.out.println(isdup_list);
                    }
                }
            }
        }
        return isdupe_list;
    }
}
