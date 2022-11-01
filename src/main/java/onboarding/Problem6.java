package onboarding;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> nicknameList = extractNicknames(forms);
        nicknameList = checkNicknameLength(nicknameList);
        List<String> emailList = extractEmails(forms);
        emailList = isCheckEmailFormat(emailList);

        List<List<String>> nicknameSplitList = extractNicknameByTwoChar(nicknameList);
        List<String> checkDuplicate = checkDuplicateNicknames(nicknameSplitList, nicknameList);

        return extractEmailCorrespondToName(forms, checkDuplicate);
    }

    public static List<String> extractNicknames(List<List<String>> forms) {
        List<String> nicknameList = new ArrayList<>();

        for (int i = 0; i < forms.size(); i++) {
            nicknameList.add(forms.get(i).get(1));
        }

        return nicknameList;
    }

    public static List<String> extractEmails(List<List<String>> forms) {
        List<String> emailList = new ArrayList<>();

        for (int i = 0; i < forms.size(); i++) {
            emailList.add(forms.get(i).get(0));
        }

        return emailList;
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

    public static List<String> extractEmailCorrespondToName(List<List<String>> forms,
                                                            List<String> duplicateNicknameList) {
        List<String> emailList = new ArrayList<>();

        for (int i = 0; i < forms.size(); i++) {
            if (duplicateNicknameList.contains(forms.get(i).get(1))) {
                emailList.add(forms.get(i).get(0));
            }
        }

        return sortEmailListAscending(emailList);
    }

    public static List<String> sortEmailListAscending(List<String> emailList) {
        Collections.sort(emailList);

        return emailList;
    }

    public static List<String> checkNicknameLength(List<String> nicknameList) {
        for (int i = 0; i < nicknameList.size(); i++) {
            if ((nicknameList.get(i).length() < 1) || (nicknameList.get(i).length() >= 20)) {
                nicknameList.remove(i);
            }
        }
        System.out.println(nicknameList);
        return nicknameList;
    }

    public static List<String> isCheckEmailFormat(List<String> emailList) {
        String emailRegex = "^[_a-z0-9-]+(.[_a-z0-9-]+)*@email.com";
        Pattern pattern = Pattern.compile(emailRegex);

        for (int i = 0; i < emailList.size(); i++) {
            Matcher matcher = pattern.matcher(emailList.get(i));

            if (!matcher.matches()) {
                emailList.remove(i);
            }
        }

        emailList = isCheckEmailLength(emailList);

        return emailList;
    }

    public static List<String> isCheckEmailLength(List<String> emailList) {
        for (int i = 0; i < emailList.size(); i++) {
            if ((emailList.get(i).length() < 11) || (emailList.get(i).length() >= 20)) {
                emailList.remove(i);
            }
        }
        System.out.println(emailList);
        return emailList;
    }
}