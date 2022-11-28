package onboarding;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Problem6 {
    public static final int EMAIL_INDEX = 0;
    public static final int NICKNAME_INDEX = 1;
    public static final int DUPLICATE_COUNT = 2;

    public static List<String> solution(List<List<String>> forms) {

        List<String> answer = new ArrayList<>();

        for (List<String> userForm : forms) {

            String userNickName = userForm.get(NICKNAME_INDEX);
            String userEmail = userForm.get(EMAIL_INDEX);

            HashSet<String> truncatedNickNamesExceptUser = getTruncatedNickNamesWithoutUser(
                    getNickNamesWithoutUser(forms, userForm));
            HashSet<String> truncatedNickNamesContainingUser = getTruncatedNickNamesContainingUser(
                    getNickNamesContainingUser(forms));

            int sizeBefore = truncatedNickNamesExceptUser.size();
            int sizeAfter = truncatedNickNamesContainingUser.size();
            int gapInCaseOfNoDuplication = userNickName.length() - 1;
            boolean isDuplicatedNickName = sizeBefore + gapInCaseOfNoDuplication > sizeAfter;

            if (isDuplicatedNickName) {
                answer.add(userEmail);
            }
        }

        return sortAnswer(answer);
    }

    private static List<String> sortAnswer(List<String> answer) {
        return answer.stream().sorted().collect(Collectors.toList());
    }

    private static HashSet<String> getTruncatedNickNamesContainingUser(List<String> nickNamesContianingUser) {
        HashSet<String> truncatedNickNamesContainingUser = new HashSet<>();
        for (String nickName : nickNamesContianingUser) {
            for (int index = 0; index < nickName.length() - 1; index++) {
                truncatedNickNamesContainingUser.add(getTruncatedNickName(nickName, index));
            }
        }
        return truncatedNickNamesContainingUser;
    }

    private static HashSet<String> getTruncatedNickNamesWithoutUser(List<String> nickNamesWithoutUser) {
        HashSet<String> truncatedNickNamesWithoutUser = new HashSet<>();
        for (String nickName : nickNamesWithoutUser) {
            for (int index = 0; index < nickName.length() - 1; index++) {
                truncatedNickNamesWithoutUser.add(getTruncatedNickName(nickName, index));
            }
        }
        return truncatedNickNamesWithoutUser;
    }

    private static String getTruncatedNickName(String nickName, int index) {
        return nickName.substring(index, index + DUPLICATE_COUNT);
    }

    private static List<String> getNickNamesWithoutUser(List<List<String>> forms, List<String> userForm) {
        List<String> nickNamesExceptUser = forms.stream()
                .filter(element -> element != userForm)
                .map(element -> element.get(NICKNAME_INDEX))
                .collect(Collectors.toList());
        return nickNamesExceptUser;
    }

    private static List<String> getNickNamesContainingUser(List<List<String>> forms) {
        return forms.stream()
                .map(element -> element.get(NICKNAME_INDEX))
                .collect(Collectors.toList());
    }

}
