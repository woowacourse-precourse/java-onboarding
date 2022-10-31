package onboarding;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> emails = new ArrayList<>();
        List<String> nicknames = new ArrayList<>();
        HashSet<String> similarNicknames = new HashSet<>();

        for (List<String> form: forms) {
            emails.add(form.get(0));
            nicknames.add(form.get(1));
        }

        int nicknamesLen = nicknames.size();

        for (int i=0; i<nicknamesLen-1; i++) { // 기준이 되는 닉네임 인덱스: i
            String standard = nicknames.get(i);
            int standardLen = standard.length();
        }

        List<String> answer = List.of("answer");
        return answer;
    }
}
