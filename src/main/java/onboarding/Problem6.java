package onboarding;

import java.util.ArrayList;
import java.util.Collections;
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

            if (standardLen == 1) { // 만약 기준 닉네임이 외자라면 기준 미달이므로 다음 닉네임으로 넘어감
                continue;
            }

            for (int j=i+1; j<nicknamesLen; j++) { // 비교 대상인 닉네임 인덱스: j
                String target = nicknames.get(j);

                for (int k=0; k<standardLen-1; k++) { // 기준 닉네임의 글자 인덱스: k
                    if (target.contains(standard.substring(k, k+2))) {
                        similarNicknames.add(emails.get(i));
                        similarNicknames.add(emails.get(j));
                    }
                }
            }
        }

        List<String> answer = new ArrayList<>(similarNicknames);
        Collections.sort(answer);

        return answer;
    }
}
