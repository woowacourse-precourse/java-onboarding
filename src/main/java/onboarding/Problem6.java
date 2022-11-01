package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {

        Map<String, String> memberMap = memberListToMap(forms);
        List<String[]> nicknameArrays = changeNicknameStringToArray(memberMap);
        Set<String> duplicatedNicknames = findDuplicatedNickname(nicknameArrays);
        List<String> emailList = findEmailByNickname(memberMap, duplicatedNicknames);
        return emailList;
    }

    private static List<String> findEmailByNickname(Map<String, String> memberMap, Set<String> duplicatedNicknames) {

        List<String> emailList = new ArrayList<>();
        for (String i : duplicatedNicknames) {
            emailList.add(memberMap.get(i));
        }
        Collections.sort(emailList);
        return emailList;
    }

    private static Set<String> findDuplicatedNickname(List<String[]> nicknameArrays) {

        Set<String> duplicatedNames = new HashSet<>();
        for (int i = 0; i < nicknameArrays.size()-1; i++) {
            String[] standardMember = nicknameArrays.get(i);

            chooseTwoCharFromStandardMember(nicknameArrays, duplicatedNames, i, standardMember);
        }
        return duplicatedNames;
    }

    private static void chooseTwoCharFromStandardMember(List<String[]> nicknameArrays, Set<String> duplicatedNames, int i, String[] standardMember) {
        for (int j = 0; j < standardMember.length - 1; j++) {
            String standardMemberString = standardMember[j] + standardMember[j+1];

            pickMemberExceptStandardMember(nicknameArrays, duplicatedNames, i, standardMember, standardMemberString);
        }
    }

    private static void pickMemberExceptStandardMember(List<String[]> nicknameArrays, Set<String> duplicatedNames, int i, String[] standardMember, String standardMemberString) {
        for (int k = i +1; k < nicknameArrays.size(); k++) {
            String[] comparedMember = nicknameArrays.get(k);

            chooseTwoCharFromMemberExceptStandardMember(duplicatedNames, standardMember, standardMemberString, comparedMember);

        }
    }

    private static void chooseTwoCharFromMemberExceptStandardMember(Set<String> duplicatedNames, String[] standardMember, String standardMemberString, String[] comparedMember) {
        for (int l = 0; l < comparedMember.length - 1; l++) {
            String comparedMemberString = comparedMember[l] + comparedMember[l+1];

            if (compareStandardMemberToComparedMember(duplicatedNames, standardMember, standardMemberString, comparedMember, comparedMemberString))
                break;
        }
    }

    private static boolean compareStandardMemberToComparedMember(Set<String> duplicatedNames, String[] standardMember, String standardMemberString, String[] comparedMember, String comparedMemberString) {
        if (standardMemberString.equals(comparedMemberString)) {
            duplicatedNames.add(String.join("", standardMember));
            duplicatedNames.add(String.join("", comparedMember));
            return true;
        }
        return false;
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
