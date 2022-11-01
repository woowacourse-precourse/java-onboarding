package onboarding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Problem6 {

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        Map<String, List<String>> FragmentsMap = new HashMap<>();
        Set<String> nickNamesSet = new HashSet<>();

        makeFragmentsMap(forms, FragmentsMap);
        makeNickNameSet(FragmentsMap, nickNamesSet);
        convertSetToList(answer, nickNamesSet);
        sortNickNamesList(answer);
        return answer;
    }

    private static void sortNickNamesList(List<String> answer) {
        answer.sort(Comparator.naturalOrder());
    }

    private static void convertSetToList(List<String> answer, Set<String> nickNamesSet) {
        answer.addAll(nickNamesSet);
    }

    private static void makeNickNameSet(Map<String, List<String>> fragmentsMap,
        Set<String> nickNamesSet) {
        fragmentsMap.values().stream()
            .filter(emails -> emails.size() > 1)
            .forEach(nickNamesSet::addAll);
    }

    private static void makeFragmentsMap(List<List<String>> forms,
        Map<String, List<String>> nickNameFragmentsMap) {
        forms.forEach(form -> splitNickNames(nickNameFragmentsMap, form.get(0), form.get(1)));
    }

    private static void splitNickNames(Map<String, List<String>> nickNameFragmentsMap, String email,
        String nickName) {
        for (int i = 0; i < nickName.length() - 1; i++) {
            String nickNameFragment = "" + nickName.charAt(i) + nickName.charAt(i + 1);
            putValue(nickNameFragmentsMap, email, nickNameFragment);
        }
    }

    private static void putValue(Map<String, List<String>> nickNameFragmentsMap, String email,
        String nickNameFragment) {
        if (nickNameFragmentsMap.containsKey(nickNameFragment)) {
            List<String> emails = nickNameFragmentsMap.get(nickNameFragment);
            emails.add(email);
            nickNameFragmentsMap.put(nickNameFragment, emails);
            return;
        }
        nickNameFragmentsMap.put(nickNameFragment, new ArrayList<>(List.of(email)));
    }

}