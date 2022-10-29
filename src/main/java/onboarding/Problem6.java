package onboarding;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");

        int size = forms.size();
        Set<Integer> indexSet = new HashSet<>();

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

        return answer;
    }

    public static boolean validateDuplication(String nicknameOne, String nicknameTwo) {
        for (int i = 0; i < nicknameOne.length() - 1; i++) {
            String twoWords = nicknameOne.substring(i, i+2);

            if (nicknameTwo.contains(twoWords))
                return false;
        }

        return true;
    }
}
