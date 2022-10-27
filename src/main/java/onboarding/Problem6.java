package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Problem6 {
    public static void main(String[] args) {

    }

    public static List<String> solution(List<List<String>> forms) {
        HashMap<String, Integer> userTwoLetterList = new HashMap<>();
        Set<String> DuplicateNameList = new HashSet<>();
        List<String> answer = new ArrayList<>();
        for (List<String> form : forms) {
            makeTwoLetterList(form.get(1), userTwoLetterList);
        }
        for (Map.Entry<String, Integer> entry : userTwoLetterList.entrySet()) {
            makeDuplicateNameList(DuplicateNameList, entry);
        }
        for (List<String> form : forms) {
            makeWarningList(answer, DuplicateNameList, form);
        }
        return answer;
    }

    public static void makeTwoLetterList(String nickName, HashMap<String, Integer> twoLetterList) {
        String[] splitNickName = nickName.split("");
        for (int i = 0; i < splitNickName.length-1; i++) {
            String userTwoLetter = splitNickName[i]+splitNickName[i+1];
            twoLetterList.put(userTwoLetter, twoLetterList.getOrDefault(userTwoLetter, 0) + 1);
        }
    }
    public static void makeDuplicateNameList(Set<String> duplicateList, Map.Entry<String, Integer> entry) {
        if (entry.getValue() > 1) {
            duplicateList.add(entry.getKey());
        }
    }
    public static void makeWarningList(List<String> warningList, Set<String> duplicateList, List<String> form) {
        for (String s : duplicateList) {
            if (form.get(1).contains(s)) {
                warningList.add(form.get(0));
            }
        }
    }
}
