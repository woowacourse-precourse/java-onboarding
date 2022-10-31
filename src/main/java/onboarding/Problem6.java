package onboarding;

import java.util.*;

public class Problem6 {

    public static List<String> solution(List<List<String>> forms) {
        return getRestrictedNicknames(forms);
    }

    private static List<String> getRestrictedNicknames(List<List<String>> forms) {
        Set<String> restrictedNicknames = new HashSet<>();

        for (int i = 0; i < forms.size() - 1; i++) {
            for (int j = i + 1; j < forms.size(); j++) {
                if (validateNicknameDuplication(forms.get(i).get(1), forms.get(j).get(1))) {
                    restrictedNicknames.add(forms.get(i).get(0));
                    restrictedNicknames.add(forms.get(j).get(0));
                }
            }
        }
        return new ArrayList<>(restrictedNicknames);
    }

    static boolean validateNicknameDuplication(String input, String target) {
        for (int left = 0; left < input.length() - 2; left++) {
            int right = left + 2;
            if (right > input.length()) return false;

            String inputSub = input.substring(left, right);

            if (target.contains(inputSub)) return true;
        }

        return false;
    }

}
