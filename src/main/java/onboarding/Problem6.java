package onboarding;

import java.util.*;

public class Problem6 {

    public static List<String> solution(List<List<String>> forms) {
        Set<String> answer = new HashSet<>();
        HashMap<String, String> duplicatedNameMap = new HashMap<>();

        ArrayList<String> slicedNameList;
        for (int i = 0; i < forms.size(); i++) {
            String email = forms.get(i).get(0);
            String name = forms.get(i).get(1);
            slicedNameList = new ArrayList<>();
            slicedName(name, slicedNameList);
            checkDuplication(answer, duplicatedNameMap, email, slicedNameList);
        }

        return new ArrayList<>(answer);
    }

    private static void checkDuplication(Set<String> answer, HashMap<String, String> duplicatedNameMap, String email, ArrayList<String> slicedNameList) {
        for (int k = 0; k < slicedNameList.size(); k++) {
            String duplicatedName = slicedNameList.get(k);
            String duplicatedEmail = duplicatedNameMap.get(duplicatedName);
            isEmailNotNull(answer, email, duplicatedEmail);
            isEmailNull(duplicatedNameMap, email, duplicatedName, duplicatedEmail);
        }
    }

    private static void isEmailNotNull(Set<String> answer, String email, String duplicatedEmail) {
        if (duplicatedEmail != null) {
            answer.add(email);
            answer.add(duplicatedEmail);
        }
    }

    private static void isEmailNull(HashMap<String, String> duplicatedNameMap, String email, String duplicatedName, String duplicatedEmail) {
        if (duplicatedEmail == null) {
            duplicatedNameMap.put(duplicatedName, email);
        }
    }

    private static void slicedName(String name, ArrayList<String> slicedNameList) {
        for (int j = 0; j < name.length() - 1; j++) {
            String slicedName = name.substring(j, j + 2);
            slicedNameList.add(slicedName);
        }
    }
}
