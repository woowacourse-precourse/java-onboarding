package onboarding;

import java.util.*;

public class Problem6 {

    public static List<String> solution(List<List<String>> forms) {
        Set<String> answer = new HashSet<>();
        HashMap<String, String> duplicatedNameMap = new HashMap<>();

        forms.forEach(crew -> {
            ArrayList<String> nameList = slicedName(crew.get(1));
            checkDuplication(answer, duplicatedNameMap, crew.get(0), nameList);
        });

        return new ArrayList<>(answer);
    }

    private static void checkDuplication(Set<String> answer, HashMap<String, String> duplicatedNameMap, String email, ArrayList<String> slicedNameList) {
        slicedNameList.forEach(duplicatedName -> {
            String duplicatedEmail = duplicatedNameMap.get(duplicatedName);
            isEmailNotNull(answer, email, duplicatedEmail);
            isEmailNull(duplicatedNameMap, email, duplicatedName, duplicatedEmail);
        });
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

    private static ArrayList<String> slicedName(String name) {
        ArrayList<String> slicedNameList = new ArrayList<>();
        for (int j = 0; j < name.length() - 1; j++) {
            String slicedName = name.substring(j, j + 2);
            slicedNameList.add(slicedName);
        }
        return slicedNameList;
    }
}
