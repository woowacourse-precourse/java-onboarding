package onboarding;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Problem6 {
    public static final int EMAIL_INDEX = 0;
    public static final int NICKNAME_INDEX = 1;
    public static final int DUPLICATE_COUNT = 2;
    private static List<String> answer = new ArrayList<>();

    public static List<String> solution(List<List<String>> forms) {
        setEmailListOfDuplicatedNickNames(forms);
        return sortAnswer(answer);
    }

    private static void setEmailListOfDuplicatedNickNames(List<List<String>> forms) {
        for (List<String> userForm : forms) {
            String userEmail = userForm.get(EMAIL_INDEX);

            boolean isDuplicatedNickName = isDuplicatedNickName(forms, userForm);
            addEmailOfDuplicatedNickNames(userEmail, isDuplicatedNickName);
        }
    }

    private static boolean isDuplicatedNickName(List<List<String>> forms, List<String> userForm) {
        String userNickName = userForm.get(NICKNAME_INDEX);
        HashSet<String> truncatedNickNamesWithoutUser = getTruncatedNickNames(
                getNickNamesWithoutUser(forms, userForm));
        HashSet<String> truncatedNickNameOfUser = getTruncatedNickNames(List.of(userNickName));
        for (String nickName : truncatedNickNameOfUser) {
            if (truncatedNickNamesWithoutUser.contains(nickName)) {
               return true;
            }
        }
        return false;
    }

    private static void addEmailOfDuplicatedNickNames(String userEmail, boolean isDuplicatedNickName) {
        if (isDuplicatedNickName) {
            answer.add(userEmail);
        }
    }

    private static List<String> sortAnswer(List<String> answer) {
        return answer.stream().sorted().collect(Collectors.toList());
    }

    private static HashSet<String> getTruncatedNickNames(List<String> nickNames) {
        HashSet<String> truncatedNickNames = new HashSet<>();
        for (String nickName : nickNames) {
            for (int index = 0; index < nickName.length() - 1; index++) {
                truncatedNickNames.add(getTruncatedNickName(nickName, index));
            }
        }
        return truncatedNickNames;
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

}
