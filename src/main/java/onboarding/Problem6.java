package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>(forms.size());
        List<String> emailList = new ArrayList<>();

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
            }

            //위 패턴을 통해 겹치는 닉네임을 추출한다
            List<String> nicknames;
            nicknames = overlapNicknameExtraction(answer, pattern);
            if (nicknames.size() >= 2) {
                for (String str : nicknames) {
                    overlapNickname.add(str.toString());
                }
            }
        }

        //추출한 겹치는 닉네임과 입력받은 매개변수의 닉네임을 비교하여, 해당 닉네임의 이메일을 추출
        for (String str : overlapNickname) {
            emailList.add(emailExtraction(forms, str));
        }

        //이메일의 형태가 email.com인지 확인
        List<String> result = new ArrayList<>();
        checkDomain(emailList,result);

        //문자열 오름차순 순서로 정렬
        Collections.sort(result);


        return result;
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

    private static String emailExtraction(List<List<String>> forms, String str) {
        String email = "";
        for (int q = 0; q < forms.size(); q++) {
            if (str.equals(forms.get(q).get(1))) {
                email = forms.get(q).get(0);
            }
        }
        return email;
    }

    private static void checkDomain(List<String> emailList, List<String> result) {
        for (int i = 0; i < emailList.size(); i++) {
            if (emailList.get(i).matches("\\w+@email\\.com$")) {
                result.add(emailList.get(i));
            }
        }
    }
}
