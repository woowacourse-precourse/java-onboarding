package onboarding;

import java.util.*;

public class Problem6 {

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");

        List<String> realAnswer = new ArrayList<>();

        subStringMatching(forms, realAnswer);

        List<String> result = getNoDuplicateStrings(realAnswer);

        Collections.sort(result);
        return result;
    }

    private static List<String> getNoDuplicateStrings(List<String> realAnswer) {
        Set<String> set = new HashSet<>(realAnswer);
        List<String> result = new ArrayList<>(set);
        return result;
    }

    private static void subStringMatching(List<List<String>> forms,
        List<String> answer) { 
        int form_size = forms.size();
        for (int i = 0; i < form_size; i++) {
            String nickName = getNickName(forms, i);
            for (int start = 0; start < nickName.length(); start++) {
                for (int end = start + 1; end <= nickName.length(); end++) {
                    String subString = nickName.substring(start, end);
                    if (isSubChar(subString)) {
                        continue;
                    } else {
                        for (int other = 0; other < form_size; other++) {
                            String comp_nickName = getNickName(forms, other);
                            if (isSameNickName(nickName, comp_nickName)) {
                                continue;
                            }

                            if (isSameComparationNickName(subString,
                                comp_nickName)) {
                                continue;
                            }

                            if (isCompNickNameContainSubString(subString, comp_nickName)) {
                                putSameSubstringInAnswer(forms, answer, i, other);
                            }

                        }
                    }
                }
            }
        }


    }

    private static boolean isCompNickNameContainSubString(String subString, String comp_nickName) {
        return comp_nickName.contains(subString);
    }

    private static boolean isSubChar(String subString) {
        return subString.length() == 1;
    }

    private static void putSameSubstringInAnswer(List<List<String>> forms, List<String> answer,
        int i, int other) {
        String nickName_email = forms.get(i).get(0);
        String comp_nickName_email = forms.get(other).get(0);
        answer.add(nickName_email);
        answer.add(comp_nickName_email);
    }

    private static boolean isSameComparationNickName(String subString, String comp_nickName) {
        return comp_nickName.equals(subString);
    }

    private static boolean isSameNickName(String nickName, String comp_nickName) {
        return nickName.equals(comp_nickName);
    }

    private static String getNickName(List<List<String>> forms, int i) {
        return forms.get(i).get(1);
    }
}
