package onboarding.problem6;

import java.util.*;
import java.util.stream.Collectors;

public class FindEmailList {
    public static List<String> findEmailList(List<String> nicknameList, List<String> emailList) {
        List<String> duplicateNicknameList = new ArrayList<>();
        List<String> duplicateEmailList = new ArrayList<>();

        for (int i = 0; i < nicknameList.size(); i++) {
            String searchingNickname = nicknameList.get(i);

            duplicateNicknameList.addAll(findDuplication(nicknameList, searchingNickname, i));
        }

        for (int i = 0; i < nicknameList.size(); i++) {
            if(duplicateNicknameList.contains(nicknameList.get(i))) {
                duplicateEmailList.add(emailList.get(i));
            }
        }

        return duplicateEmailList.stream()
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }

    private static List<String> findDuplication(List<String> nicknameList, String searchingNickname, int index) {
        List<String> duplicateList = new ArrayList<>();

        for (int i = index + 1; i < nicknameList.size(); i++) {
            duplicateList.addAll(searchNicknameList(searchingNickname, nicknameList.get(i)));
        }

        return duplicateList;
    }

    private static List<String> searchNicknameList(String searchingNickname, String comparisonNickname) {
        List<String> duplicateList = new ArrayList<>();

        for (int i = 0; i < searchingNickname.length() - 1; i++) {
            String subStringNickname = searchingNickname.substring(i, i + 2);

            duplicateList.addAll(addDuplicationList(searchingNickname, subStringNickname, comparisonNickname));
        }

        return duplicateList;
    }

    private static List<String> addDuplicationList(String searchingNickname, String subStringNickname, String comparisonNickname) {
        List<String> duplicateList = new ArrayList<>();

        if (comparisonNickname.contains(subStringNickname)) {
            duplicateList.add(searchingNickname);
            duplicateList.add(comparisonNickname);
        }

        return duplicateList;
    }
}
