package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** 기능 목록
 * solutionLogic        : 메인 솔루션
 * checkValid           : 예외 처리
 * checkCrewNums        : 크루 크기 유효성 체크
 * checkEmailForm       : 이메일 형식 유효성 체크
 * checkEmailLength     : 이메일 길이 유효성 체크
 * checkEmailDomain     : 이메일 도메인 체크
 * checkNickNameType    : 닉네임 한글 타입 체크
 * checkNickNameLength  : 닉네임 길이 확인
 */

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    private static class CrewList{
        private final Map<String, String> crewList = new HashMap<>();
        private final List<String> alarm = new ArrayList<>();

        private void addCrew() {

        }

        private boolean checkValid() {
            return
        }

        private boolean checkCrewNums() {

        }

        private boolean checkEmail(String email) {
            int emailLength = email.length();
            if (!checkEmailLength(emailLength)) {
                return false;
            }
            return checkEmailForm(email);
        }

        private boolean checkNickName(String nickname) {
            return checkNickNameLength(nickname) && checkNickNameType(nickname);
        }

        private void checkAlarmTarget(String nickname) {

        }

        private boolean checkEmailForm(String email) {
            String[] emailDetails = email.split("@");
            String emailId = emailDetails[0];
            String emailDomain = emailDetails[1];
            return checkEmailDomain(emailDomain) && checkEmailId(emailId);
        }

        private boolean checkEmailLength(int n) {
            return 11 <= n && n <= 20;
        }

        private boolean checkEmailDomain(String emailDomain) {
            if (emailDomain.length() == 0 || !emailDomain.equals("email.com")) {
                return false;
            }
            return true;
        }

        private boolean checkEmailId(String emailId) {
            if (emailId.length() == 0) {
                return false;
            }
            return true;
        }


        private boolean checkNickNameType(String nickname) {

        }
        private boolean checkNickNameLength(String nickname) {

        }
    }
}

