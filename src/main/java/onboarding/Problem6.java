package onboarding;

import java.util.*;
import java.util.regex.Pattern;

/** 기능 목록
 *
 *
 * [CreList Collection]
 * addCrew              : 크루 추가
 * checkValid           : 예외 처리
 * checkCrewNums        : 크루 크기 유효성 체크
 * checkEmail           : 이메일 유효성 체크
 * checkNickName        : 닉네임 유효성 체크
 * checkAlarmTarget     : 알림 보내줄 대상인지 체크
 * checkEmailForm       : 이메일 형식 유효성 체크
 * checkEmailLength     : 이메일 길이 유효성 체크
 * checkEmailDomain     : 이메일 도메인 체크
 * checkEmailId         : 이메일 아이디 체크
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
        private final Set<String> continuousSet = new HashSet<>();
        private final Set<String> alarm = new HashSet<>();

        private boolean addCrew(List<String> form) {
            String email = form.get(0);
            String nickname = form.get(1);
            if (checkValid(email, nickname)) {
                crewList.put(email, nickname);
            } else {
                System.out.println("올바르지 않은 형식");
                return false;
            }
            if (checkAlarmTarget(nickname)) {
                alarm.add(nickname);
            }
            return checkCrewNums();
        }

        private List<String> getConfusedNickname(Set<String> alarm) {
            List<String> result = new ArrayList<>(alarm);
            Collections.sort(result);
            return result;
        }

        private boolean checkValid(String email, String nickname) {
            return checkEmail(email) && checkNickName(nickname);
        }

        private boolean checkCrewNums() {
            int crewSize = crewList.size();
            return 1 <= crewSize && crewSize <= 10000;
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

        private boolean checkAlarmTarget(String nickname) {
            Set<String> userContinuousSet = new HashSet<>();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < nickname.length() - 1; i++) {
                String continuousPart = sb.append(nickname.charAt(i)).append(nickname.charAt(i + 1)).toString();
                userContinuousSet.add(continuousPart);
            }
            return checkOverlap(userContinuousSet);
        }

        private boolean checkOverlap(Set<String> userContinuousSet) {
            int lastSize = continuousSet.size();
            int userSize = userContinuousSet.size();
            continuousSet.addAll(userContinuousSet);
            int nowSize = continuousSet.size();
            if (nowSize == lastSize + userSize) {
                return false;
            } else {
                return true;
            }
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
            return nickname.matches("^[가-힣]*$");
        }

        private boolean checkNickNameLength(String nickname) {
            int len = nickname.length();
            return 1<= len && len < 20;
        }
    }
}

