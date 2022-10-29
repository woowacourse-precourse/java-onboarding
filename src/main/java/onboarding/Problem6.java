package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {

        Map<String, String> memberMap = memberListToMap(forms);
        List<String[]> nicknameArrays = changeNicknameStringToArray(memberMap);
        Set<String> duplicatedNickname = findDuplicatedNickname(nicknameArrays);
        List<String> answer = null;
        return answer;
    }

    private static Set<String> findDuplicatedNickname(List<String[]> nicknameArrays) {

        Set<String> duplicatedNames = new HashSet<>();
        for (int i = 0; i < nicknameArrays.size()-1; i++) {
            String[] standardMember = nicknameArrays.get(i);

            for (int j = 0; j < standardMember.length - 1; j++) {
                String standardMemberString = standardMember[j] + standardMember[j+1];

                for (int k = i+1; k < nicknameArrays.size(); k++) {
                    String[] comparedMember = nicknameArrays.get(k);

                    for (int l = 0; l < comparedMember.length - 1; l++) {
                        String comparedMemberString = comparedMember[l] + comparedMember[l+1];

                        if (standardMemberString.equals(comparedMemberString)) {
                            duplicatedNames.add(String.join("", standardMember));
                            duplicatedNames.add(String.join("", comparedMember));
                            break;
                        }
                    }

                }
            }
        }
        return duplicatedNames;
    }

    private static List<String[]> changeNicknameStringToArray(Map<String, String> memberMap) {
        return memberMap.keySet().
                stream().map(i -> i.split("")).
                collect(Collectors.toList());
    }


    private static Map<String, String> memberListToMap(List<List<String>> forms) {

        Map<String, String> member = new HashMap<>();
        for (List i : forms) {
            member.put((String) i.get(1), (String) i.get(0));
        }
        return member;
    }
}
