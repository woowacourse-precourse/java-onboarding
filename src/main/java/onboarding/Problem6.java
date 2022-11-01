package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");

        List<String> emails = new ArrayList<>();
        List<String> nicknames = new ArrayList<>();

        for (List<String> form : forms) {
            emails.add(form.get(0));
            nicknames.add(form.get(1));
        }

        List<String> checkList = createCheckList(nicknames);

        return answer;
    }

    private static List<String> createCheckList(List<String> nicknames) {
        List<String> checkList = new ArrayList<>();

        for (String nickname : nicknames) {
            for (int i = 0; i < nickname.length() - 1; i++) {
                String checkStr = nickname.substring(i, i + 1);
                if (!checkList.contains(checkStr)) {
                    checkList.add(checkStr);
                }
            }
        }
        return checkList;
    }
}
