package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        boolean isDataValid = validData(forms);

        if (isDataValid) {
            answer.add("데이터가 적합하지 않습니다.");
        } else {
            answer = findHasDuplicatedNickCrew(forms);
        }

        return answer;
    }

    private static boolean validData(List<List<String>> forms) {
        boolean isDataValid = true;

        String emailPattern = "^[_a-zA-Z0-9-\\\\.]+@email.com$";
        String nicknamePattern = "^[가-힣]+$";

        for (List<String> crew: forms) {
            String email = crew.get(0);
            String nickname = crew.get(1);
            boolean isDataLengthInRange = true;
            boolean isEmailSuitable = Pattern.matches(emailPattern, email);
            boolean isNickSuitable = Pattern.matches(nicknamePattern, nickname);

            if (forms.size() > 10000) {
                isDataLengthInRange = false;
            }

            if (!isDataLengthInRange || !isEmailSuitable || !isNickSuitable || (email.length() < 11 || email.length() > 20) || nickname.length() > 19) {
                isDataValid = false;
                break;
            }
        }

        return isDataValid;
    }

    private static List<String> findHasDuplicatedNickCrew(List<List<String>> forms) {
        List<String> crewList = new ArrayList<>();

        return crewList;
    }
}
