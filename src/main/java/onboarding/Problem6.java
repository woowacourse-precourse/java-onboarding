package onboarding;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem6 {

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    // 1. 이메일 형식에 부합하는가?
    // 2. 이메일 길이가 11자 이상 20자 미만인가?
    // 3. 신청한 이메일이 email 도메인인가?
    // TODO 앞부분 문자 제한이 없다면 논리 오류 발생, 수정 필요
    private static boolean isValidEmail(String email) {
        if (11 <= email.length() && email.length() < 20) {
            Pattern pattern = Pattern.compile("^[a-zA-Z0-9]+@email\\.com+$");
            Matcher matcher = pattern.matcher(email);
            return matcher.matches();
        }
        return false;
    }

    // 4. 닉네임이 한글인가?
    // 5. 닉네임 길이가 1자 이상 20자 미만인가?
    // Q. 한글은 공백이 포함되는가?
    private static boolean isValidNickname(String nickname) {
        if (1 <= nickname.length() && nickname.length() < 20) {
            Pattern pattern = Pattern.compile("^[ㄱ-ㅣ가-힣]+$");
            Matcher matcher = pattern.matcher(nickname);
            return matcher.matches();
        }
        return false;
    }

    // 6. 두 글자 이상의 문자가 연속적으로 순서에 맞추어 포함되어 있는 경우 중복으로 간주

    // 7. result는 이메일에 해당하는 부분의 문자열을 오름차순으로 정렬하고 중복은 제거

    // MEMO
    // 닉네임 : ABCD -> AB BC CD ABC BCD ABCD, 4글자 -> 6개
    // 닉네임 : ABCDE -> AB BC CD DE ABC BCD CDE ABCD BCDE ABCDE, 5글자 -> 10개
    // 닉네임 : ABCDEF -> AB BC CD DE EF ABC BCD CDE DEF ABCD BCDE CDEF ABCDE BCDEF ABCDEF, 6글자 -> 15개
}
