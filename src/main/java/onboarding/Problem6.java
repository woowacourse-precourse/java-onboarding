package onboarding;

import java.util.*;
import java.util.function.BiPredicate;

import static problem6.Common.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        makeCommonList(forms, answer);

        return answer;
    }

    private static void makeCommonList(List<List<String>> forms, List<String> answer) {
        Set<List<String>> formSet = new HashSet<>();

        nestedRecursion(forms, (List<String> form1, List<String> form2) -> {
            if (form1.equals(form2) || formSet.contains(form1)) return true;
            if (isCommon(form1.get(1), form2.get(1))) addForm(formSet, form1, form2);
            return false;
        });

        formSet.forEach(form -> answer.add(form.get(0)));

        answer.sort((o1, o2) -> {
            String content1 = o1.substring(0, o1.length() - 10);
            String content2 = o2.substring(0, o2.length() - 10);

            return content1.compareTo(content2);
        });
    }

    private static void addForm(Set<List<String>> formSet, List<String> form1, List<String> form2) {
        formSet.add(form1);
        formSet.add(form2);
    }

    private static void nestedRecursion(List<List<String>> forms, BiPredicate<List<String>, List<String>> predicate) {
        for (List<String> form1 : forms) {
            for (List<String> form2 : forms) {
                if (predicate.test(form1, form2)) continue;
            }
        }
    }

}
