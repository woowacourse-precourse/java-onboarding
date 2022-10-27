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

        }

        private boolean checkCrewNums() {

        }

        private boolean checkEmailForm() {

        }
        private boolean checkEmailLength() {

        }
        private boolean checkEmailDomain() {

        }
        private boolean checkNickNameType() {

        }
        private boolean checkNickNameLength() {

        }
    }
}

