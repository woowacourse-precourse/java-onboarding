package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    public static void main(String[] args) {
        List<List<String>> forms = List.of(
                List.of("jm@email.com", "제이엠"),
                List.of("jason@email.com", "제이슨"),
                List.of("woniee@email.com", "워니"),
                List.of("mj@email.com", "엠제이"),
                List.of("nowm@email.com", "이제엠")
        );
        System.out.println("닉네임 목록 : " + solution(forms));
    }
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>(forms.size());

        //입력받은 이메일과 닉네임 중, 닉네임만 추출
        for (int i = 0; i < forms.size(); i++) {
            answer.add(forms.get(i).get(1));
        }

        String[] nickname;
        String pattern = "";
        List<String> overlapNickname = new ArrayList<>();
        for (int i = 0; i < answer.size(); i++) {
            nickname = answer.get(i).split("");

            //중복되는 닉네임을 찾을 수 있도록 패턴을 만들고
            for (int j = 1; j < nickname.length; j++) {
                pattern = nickname[j-1] + nickname[j];
                System.out.println("패턴은 다음과 같습니다. : " + pattern);
            }

            //위 패턴을 통해 겹치는 닉네임을 추출한다
            List<String> nicknames = new ArrayList<>();
            nicknames = overlapNicknameExtraction(answer, pattern);
            if (nicknames.size() >= 2) {
                overlapNickname.add(nicknames.toString());
            }
            System.out.println("겹치는 닉네임들은 다음과 같습니다. : " + overlapNickname);
        }
        return answer;
    }


    private static List<String> overlapNicknameExtraction(List<String> nicknames, String pattern) {
        List<String> overlapNickname = new ArrayList<>(nicknames.size());
        for (int i = 0; i < nicknames.size(); i++) {
            if (nicknames.get(i).contains(pattern)) {
                overlapNickname.add(nicknames.get(i));
            }
        }
        return overlapNickname;
    }
}
