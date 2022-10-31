package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Problem6 {

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");

        // 닉네임을 통해 해당 이메일을 바로 가져오기 위한 HashMap (key : 닉네임 / value : 이메일)
        HashMap<String, String> getEmailByNickname = new HashMap<>();

        // 닉네임 목록 List
        List<String> nicknameList = new ArrayList<>();

        // initialize getEmailByNickname & nicknameList
        for (List<String> form : forms) {
            String email = form.get(0);
            String nickname = form.get(1);
            getEmailByNickname.put(nickname, email);
            nicknameList.add(nickname);
        }

        // 중복 검사 진행 (중복 : 두 글자 이상의 문자가 연속적으로 순서에 맞추어 포함되어 있는 경우)
        // 1. 닉네임 목록에서 닉네임을 2개씩 뽑아서 확인
        // 2. 두 글자가 연속되었다면 중복으로 간주 -> 해당 닉네임 2개를 Set에 저장 (resultSet)

        // resultSet에 들어가있는 닉네임을 통해 이메일 목록을 가져오고, 이메일 목록을 오름차순으로 정렬

        return answer;
    }

}
