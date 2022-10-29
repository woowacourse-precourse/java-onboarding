package onboarding;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem6 {
    public static final int START_INDEX = 0;
    public static final int EMAIL_INDEX = 0;
    public static final int NAME_INDEX = 1;
    public static final String REGEX = "";
    public static List<String> targetList;
    public static List<String> compareList;
    public static String[] targetNicknameArr;

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>(findAnswer(forms));

        return answer;
    }

    public static Set<String> findAnswer(List<List<String>> forms) {
        Set<String> answer = new HashSet<>();

        for (int targetIndex = START_INDEX; targetIndex < forms.size() - 1; targetIndex++) {
            chooseTargetNickName(forms, targetIndex);
            compareWithTarget(forms, answer, targetIndex);
        }
        return answer;
    }

    public static void compareWithTarget(List<List<String>> forms, Set<String> answer, int targetIndex) {
        for (int compareIndex = targetIndex + 1; compareIndex < forms.size(); compareIndex++) {
            chooseCompareNickName(forms, compareIndex);
            findTwoSameLetter(answer);
        }
    }

    public static void chooseCompareNickName(List<List<String>> forms, int compareIndex) {
        compareList = forms.get(compareIndex);
    }

    public static void chooseTargetNickName(List<List<String>> forms, int targetIndex) {
        targetList = forms.get(targetIndex);
        targetNicknameArr = targetList.get(NAME_INDEX).split(REGEX);
    }

    public static void findTwoSameLetter(Set<String> answer) {
        for (int letterIndex = START_INDEX; letterIndex < targetNicknameArr.length - 1; letterIndex++) {
            String targetTwoLetter = chooseTargetTwoLetter(letterIndex);

            if (isSameTwoLetter(targetTwoLetter)) {
                addEmailAddress(answer);
                break;
            }
        }
    }

    public static void addEmailAddress(Set<String> answer) {
        answer.add(targetList.get(EMAIL_INDEX));
        answer.add(compareList.get(EMAIL_INDEX));
    }

    public static boolean isSameTwoLetter(String targetTwoLetter) {
        return compareList.get(NAME_INDEX).contains(targetTwoLetter);
    }

    public static String chooseTargetTwoLetter(int letterIndex) {
        return targetNicknameArr[letterIndex] + targetNicknameArr[letterIndex + 1];
    }

}