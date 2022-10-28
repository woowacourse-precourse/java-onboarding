package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> nicknameList = extractNicknames(forms);
        List<List<String>> nicknameSplitList = extractNicknameByTwoChar(nicknameList);

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
}