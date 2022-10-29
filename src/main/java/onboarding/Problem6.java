package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        return getEmailList(forms);
    }

    private static List<List<String>> makeSubstringWithTwoWords(List<List<String>> forms) {
        List<List<String>> substringList = new ArrayList<>();

        for (int i = 0; i < forms.size(); i++) {
            List<String> substrings = new ArrayList<>();
            String nickname = forms.get(i).get(1);
            for (int j = 0; j < nickname.length() - 1; j++) {
                String substring = nickname.substring(j, j + 2);
                substrings.add(substring);
            }
            substringList.add(substrings);
        }

        return substringList;
    }

    private static Set<String> makeSubstringSet(List<List<String>> substringList) {
        Set<String> tmpSet = new HashSet<>();
        Set<String> substringSet = new HashSet<>(); // 최소 2개 이상 존재하는 부분 닉네임들만 저장하는 set

        for (int i = 0; i < substringList.size(); i++) {
            for (int j = 0; j < substringList.get(i).size(); j++) {
                String substring = substringList.get(i).get(j);

                if (tmpSet.contains(substring)) {
                    // tmpSet에 이미 substring이 존재했다면, 최소 2개 이상이라는 의미이므로 substringSet에 추가한다.
                    substringSet.add(substring);
                    continue;
                }

                tmpSet.add(substring);
            }
        }

        return substringSet;
    }

    private static boolean[] makeConsecutiveNicknameCheckArray(List<List<String>> forms) {
        boolean[] isConsecutive = new boolean[forms.size()];
        List<List<String>> substringList = makeSubstringWithTwoWords(forms);
        Set<String> substringSet = makeSubstringSet(substringList);

        for (int i = 0; i < substringList.size(); i++) {
            List<String> substrings = substringList.get(i);
            for (int j = 0; j < substrings.size(); j++) {
                String substring = substrings.get(j);

                if (substringSet.contains(substring)) {
                    isConsecutive[i] = true;
                    break;
                }
            }
        }

        return isConsecutive;
    }

    private static List<String> getEmailList(List<List<String>> forms) {
        List<String> emailList = new ArrayList<>();
        boolean[] isConsecutive = makeConsecutiveNicknameCheckArray(forms);

        for (int i = 0; i < forms.size(); i++) {
            if (isConsecutive[i]) {
                String email = forms.get(i).get(0);
                emailList.add(email);
            }
        }

        Set<String> emailSet = new TreeSet<>(emailList);
        List<String> sortedEmailList = new ArrayList<>(emailSet);

        return sortedEmailList;
    }
}
