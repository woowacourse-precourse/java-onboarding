package onboarding;

import static onboarding.enums.problem6.Index.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem6 {
    public static final String REGEX = "";
    public static List<String> targetList;
    public static List<String> compareList;
    public static String[] targetNicknameArr;

    public static List<String> solution(List<List<String>> forms) {
        return new ArrayList<>(findAnswer(forms));
    }

    public static Set<String> findAnswer(List<List<String>> forms) {
        Set<String> answer = new HashSet<>();

        for (int targetIndex = START_INDEX.getIndex(); targetIndex < forms.size() - 1; targetIndex++) {
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
        targetNicknameArr = targetList.get(NAME_INDEX.getIndex()).split(REGEX);
    }

    public static void findTwoSameLetter(Set<String> answer) {
        for (int letterIndex = START_INDEX.getIndex(); letterIndex < targetNicknameArr.length - 1; letterIndex++) {
            String targetTwoLetter = chooseTargetTwoLetter(letterIndex);

            if (isSameTwoLetter(targetTwoLetter)) {
                addEmailAddress(answer);
                break;
            }
        }
    }

    public static void addEmailAddress(Set<String> answer) {
        answer.add(targetList.get(EMAIL_INDEX.getIndex()));
        answer.add(compareList.get(EMAIL_INDEX.getIndex()));
    }

    public static boolean isSameTwoLetter(String targetTwoLetter) {
        return compareList.get(NAME_INDEX.getIndex()).contains(targetTwoLetter);
    }

    public static String chooseTargetTwoLetter(int letterIndex) {
        return targetNicknameArr[letterIndex] + targetNicknameArr[letterIndex + 1];
    }

}