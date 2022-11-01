package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        for (List<String> form : forms) {
            if (!isValidEmail(form.get(0))) {
                answer.add("[Error] 이메일 형식 오류");
                return answer;
            }
            if (!isValidNickname(form.get(1))) {
                answer.add("[Error] 닉네임 형식 오류");
                return answer;
            }
        }

        List<String> emails = new ArrayList<>();
        List<String> nicknames = new ArrayList<>();

        for (List<String> form : forms) {
            emails.add(form.get(0));
            nicknames.add(form.get(1));
        }

        answer.addAll(stringContinuity(emails, nicknames));

        return answer;
    }
    //이메일의 유효성 검사
    public static boolean isValidEmail(String emails) {
        String regex = "^[_a-z0-9-]+(.[_a-z0-9-]+)*@email.com";

        // 이메일의 형식 지정
        if (!emails.matches(regex)) {
            return false;
        }
        //이메일의 길이 범위 초과된 경우
        return emails.length() >= 10 && emails.length() < 20;
    }
    // 닉네임의 유효성 검사
    public static boolean isValidNickname(String nickname) {
        String hangeulCherker = "^[가-힣]*$";

        //닉네임이 한글로 구성되어 있는지
        if (!nickname.matches(hangeulCherker)) {
            return false;
        }
        // 닉네임의 길이가 제한사항에 적합한지
        return nickname.length() >= 1 && nickname.length() < 20;
    }

    // 같은 글자가 포함된 닉네임 찾는 메소드
    public static List<String> stringContinuity(List<String> emails, List<String> nicknames) {
        List<String> continuityList = new ArrayList<>();

        for (int i = 0; i < nicknames.size(); i++) {
            String consecutiveSubString;

            for (int j = 0; j < nicknames.get(i).length() - 1; j++) {
                // 닉네임이 가질 수 있는 연속적인 substring 2개의 문자 선택
                if (j == nicknames.get(i).length() - 2) {
                    consecutiveSubString = nicknames.get(i).substring(j);
                } else consecutiveSubString =nicknames.get(i).substring(j, j + 2);
                // substring을 가진 닉네임을 선택하기
                if (nicknames.get(j).contains(consecutiveSubString)) {
                    continuityList.add(emails.get(i));
                    j = nicknames.get(i).length()-1;
                }
            }
        }

        //오름차순 정렬
        Collections.sort(continuityList);
        //리스트 중복 제거
        continuityList = continuityList.stream().distinct().collect(Collectors.toList());

        return continuityList;
    }
}
