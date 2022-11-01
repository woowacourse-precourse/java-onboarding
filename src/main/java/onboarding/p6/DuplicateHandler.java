package onboarding.p6;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class DuplicateHandler {
    List<List<String>> member;

    public DuplicateHandler(List<List<String>> member) {
        this.member = member;
    }

    // 닉네임이 중복되는 이메일 리스트를 반환한다
    public List<String> getDuplicateNicknameToEmail() {
        List<String> dupEmailList = new ArrayList<>();
        for (int i = 0; i < member.size(); i++) {
            List<String> mem = member.get(i);
            String email = mem.get(0);
            String nickname = mem.get(1);

            if (wholeValidation(nickname, email)) {
                if (nicknameDuplicateCheck(nickname, i)) {
                    dupEmailList.add(email);
                }
            }
        }

        return sortAscDistinctEmail(dupEmailList);
    }

    // nickname 중복 확인
    private boolean nicknameDuplicateCheck(String nickname, int me) {
        for (int j = 0; j < member.size(); j++) {
            if (j == me) {
                continue;
            }

            // 주어진 nickname 을 두글자씩 비교
            for (int i = 0; i < nickname.length() - 1; i++) {
                if (member.get(i).get(1).contains(nickname.substring(i, i + 2))) {
                    return true;
                }
            }

        }
        return false;
    }

    // email List 정렬, 중복제거
    private List<String> sortAscDistinctEmail(List<String> email) {
        return email.stream().sorted().distinct().collect(Collectors.toList());
    }

    /*
    * 이메일 예외 목록
    * 1. email.com 도메인이 아닐 때
    * 2. 이메일 길이가 11자 이상 20자 미만이 아닐 때
    * */
    private boolean emailValidation(String email) {
        if (!email.contains("email.com")) {
            return false;
        }
        return email.length() >= 11 && email.length() < 20;
    }

    /*
     * 닉네임 예외 목록
     * 1. 한글만 포함된 문자가 아닐 때
     * 2. 닉네임 길이가 1자 이상 20자 미만이 아닐 때
     * */
    private boolean nicknameValidation(String nickname) {
        if (!Pattern.matches("^[가-힣]*$", nickname)) {
            return false;
        }
        return nickname.length() >= 1 && nickname.length() < 20;
    }

    // 모든 유효성 검사 실행 (닉네임, 이메일)
    private boolean wholeValidation(String nickname, String email) {
        return nicknameValidation(nickname) && emailValidation(email);
    }
}
