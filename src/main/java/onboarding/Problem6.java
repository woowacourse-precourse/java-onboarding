package onboarding;

import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");

        // 입력 형태
//        List<List<String>> forms = List.of(
//                List.of("jm@email.com", "제이엠"),
//                List.of("jason@email.com", "제이슨"),
//                List.of("woniee@email.com", "워니"),
//                List.of("mj@email.com", "엠제이"),
//                List.of("nowm@email.com", "이제엠")
//        );
        // 1. 후에 닉네임을 통해 해당 이메일을 바로 가져오기 위해서 HashMap을 생성 (key : 닉네임 / value : 이메일)
        // 2. 닉네임만을 전부 저장한 List 생성 (nicknameList)

        // 중복 검사 진행 (중복 : 두 글자 이상의 문자가 연속적으로 순서에 맞추어 포함되어 있는 경우)
        // 1. 닉네임 목록에서 닉네임을 2개씩 뽑아서 확인
        // 2. 두 글자가 연속되었다면 중복으로 간주 -> 해당 닉네임 2개를 Set에 저장 (resultSet)

        // resultSet에 들어가있는 닉네임을 통해 이메일 목록을 가져오고, 이메일 목록을 오름차순으로 정렬

        return answer;
    }
}
