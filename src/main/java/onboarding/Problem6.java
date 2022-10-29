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

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>(findAnswer(forms));

        return answer;
    }

    public static Set<String> findAnswer(List<List<String>> forms) {
        Set<String> answer = new HashSet<>();

        for (int targetIndex = START_INDEX; targetIndex < forms.size() - 1; targetIndex++) {
            String[] targetNicknameArr = forms.get(targetIndex).get(NAME_INDEX).split(REGEX);

            for (int nicknameIndex = targetIndex + 1; nicknameIndex < forms.size(); nicknameIndex++) {
                String nickname = forms.get(nicknameIndex).get(NAME_INDEX);

                findTwoSameLetter(forms, targetIndex, nicknameIndex, targetNicknameArr, nickname, answer);
            }
        }
        return answer;
    }

    public static void findTwoSameLetter(List<List<String>> forms, int targetIndex, int nicknameIndex, String[] targetNicknameArr, String nickname, Set<String> answer) {
        for (int letterIndex = START_INDEX; letterIndex < targetNicknameArr.length - 1; letterIndex++) {
            String targetTwoLetter = targetNicknameArr[letterIndex] + targetNicknameArr[letterIndex + 1];

            if (nickname.contains(targetTwoLetter)) {
                answer.add(forms.get(targetIndex).get(EMAIL_INDEX));
                answer.add(forms.get(nicknameIndex).get(EMAIL_INDEX));
                break;
            }
        }
    }
}