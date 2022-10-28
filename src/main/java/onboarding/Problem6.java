package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> nicknameList = extractNicknames(forms);
        List<List<String>> nicknameSplitList = extractNicknameByTwoChar(nicknameList);
        List<String> checkDuplicate = checkDuplicateNicknames(nicknameSplitList, nicknameList);

        return nicknameList;
    }

    public static List<String> extractNicknames(List<List<String>> forms) {
        List<String> nicknameList = new ArrayList<>();

        for (int i = 0; i < forms.size(); i++) {
            nicknameList.add(forms.get(i).get(1));
        }

        return nicknameList;
    }

    public static List<List<String>> extractNicknameByTwoChar(List<String> nicknameList) {
        List<List<String>> splitNicknameList = new ArrayList<>();

        for (int i = 0; i < nicknameList.size(); i++) {
            List<String> splitIndividualNickname = new ArrayList<>();

            for (int j = 0; j < nicknameList.get(i).length() - 1; j++) {
                splitIndividualNickname.add(nicknameList.get(i).substring(j, j + 2));
            }

            splitNicknameList.add(splitIndividualNickname);
        }

        return splitNicknameList;
    }

    public static List<String> checkDuplicateNicknames(List<List<String>> splitNicknameList,
                                                       List<String> nicknameList) {
        List<String> duplicateNicknameList = new ArrayList<>();

        for (int i = 0; i < splitNicknameList.size(); i++) {
            for (int j = i + 1; j < splitNicknameList.size(); j++) {
                for (int k = 0; k < splitNicknameList.get(i).size(); k++) {
                    if (nicknameList.get(j).contains(splitNicknameList.get(i).get(k))) {
                        duplicateNicknameList.add(nicknameList.get(j));
                        duplicateNicknameList.add(nicknameList.get(i));
                    }
                }
            }
        }
        return removeMultipleTimesName(duplicateNicknameList);
    }

    public static List<String> removeMultipleTimesName(List<String> duplicateNicknameList) {
        List<String> removeMultipleName =
                duplicateNicknameList.stream().distinct().collect(Collectors.toList());

        return removeMultipleName;
    }
}