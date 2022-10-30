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
        }

        return new ArrayList<>(answer);
    }

    private static void slicedName(String name, ArrayList<String> slicedNameList) {
        for (int j = 0; j < name.length() - 1; j++) {
            String slicedName = name.substring(j, j + 2);
            slicedNameList.add(slicedName);
        }
    }
}
