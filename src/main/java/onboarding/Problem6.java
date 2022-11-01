package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = Collections.emptyList();

        // 크루가 1명 이하거나 10000명 이상일 때 예외 처리
        if (forms.size() < 1 || forms.size() > 10000)
            return answer;

        answer = new ArrayList<>();
        List<String> nicknames = new ArrayList<>();
        List<String> emails = new ArrayList<>();
        String sub = "";

        // email과 nickname을 각각의 리스트의 똑같은 인덱스에 저장
        for (int i = 0; i < forms.size(); i++) {
            nicknames.add(forms.get(i).get(1));
            emails.add(forms.get(i).get(0));
        }

        // 이메일 도메인이 email.com이 아니거나 이메일 길이가 11자 미만 20자 이상일 경우 예외 처리
        for (int i = 0; i < emails.size(); i++) {
            if (!emails.get(i).contains("email.com") || emails.get(i).length() >= 20 || emails.get(i).length() < 11)
                return answer;
        }

        // 모든 닉네임을 두자리 이상으로 잘라서 다른 닉네임과 비교해서 겹치면 answer 배열에
        // 겹친 두 닉네임 유저의 이메일 저장
        for (int i = 0; i < nicknames.size(); i++) {
            for (int j = 0 ; j < nicknames.get(i).length() - 1; j++) {
                sub = nicknames.get(i).substring(j, j + 2);
                for (int k = i + 1; k < nicknames.size(); k++) {
                    if (nicknames.get(k).contains(sub)) {
                        answer.add(emails.get(i));
                        answer.add(emails.get(k));
                    }
                }
            }
        }

        // answer 배열에 중복 이메일 삭제
        answer = answer.stream().distinct().collect(Collectors.toList());
        Collections.sort(answer);
        return answer;
    }
}
