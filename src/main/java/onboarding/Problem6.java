package onboarding;

import java.util.*;

public class Problem6 {

    public static List<String> solution(List<List<String>> forms) {
        Set<Integer> indexSet = findDuplicateStudents(forms);

        List<String> answer = getDuplicateStudentList(forms, indexSet);
        Collections.sort(answer);

        return answer;
    }

    private static Set<Integer> findDuplicateStudents(List<List<String>> forms) {
        Set<Integer> indexSet = new HashSet<>();
        int size = forms.size();

        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                String nicknameOne = forms.get(i).get(1);
                String nicknameTwo = forms.get(j).get(1);

                if (!validateDuplication(nicknameOne, nicknameTwo)) {
                    indexSet.add(i);
                    indexSet.add(j);
                }
            }
        }

        return indexSet;
    }

    public static boolean validateDuplication(String nicknameOne, String nicknameTwo) {
        for (int i = 0; i < nicknameOne.length() - 1; i++) {
            String twoWords = nicknameOne.substring(i, i+2);

            if (nicknameTwo.contains(twoWords))
                return false;
        }

        return true;
    }

    private static List<String> getDuplicateStudentList(List<List<String>> forms, Set<Integer> indexSet) {
        List<String> duplicateStudentList = new ArrayList<>();

        for (int idx: indexSet) {
            String email = forms.get(idx).get(0);
            duplicateStudentList.add(email);
        }

        return duplicateStudentList;
    }

}
