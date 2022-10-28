package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {

    public static List<String> solution(List<List<String>> forms) {
        Map<String, List<Integer>> containingFormIdxListByTwoGram = containingFormIdxListByTwoGram(forms);
        boolean[] isDuplicate = new boolean[forms.size()];
        for (var formIdxList : containingFormIdxListByTwoGram.values())
            if (formIdxList.size() > 1)
                for (var formIdx : formIdxList)
                    isDuplicate[formIdx] = true;

        List<String> answer = new ArrayList<>();
        for (int idx = 0; idx < forms.size(); ++idx)
            if (isDuplicate[idx])
                answer.add(forms.get(idx).get(0));

        return answer.stream()
                .distinct()
                .sorted(String::compareTo)
                .collect(Collectors.toList());
    }

    private static Map<String, List<Integer>> containingFormIdxListByTwoGram(List<List<String>> forms) {
        Map<String, List<Integer>> ret = new HashMap<>();
        for (int formIdx = 0; formIdx < forms.size(); ++formIdx) {
            Set<String> twoGramSet = getTwoGramSet(forms.get(formIdx).get(1));
            for (var twoGram : twoGramSet)
                ret.computeIfAbsent(twoGram, e -> new ArrayList<>()).add(formIdx);
        }
        return ret;
    }

    private static Set<String> getTwoGramSet(String string) {
        Set<String> ret = new HashSet<>();
        for (int i = 0; i < string.length() - 1; ++i)
            ret.add(string.substring(i, i + 2));
        return ret;
    }
}
