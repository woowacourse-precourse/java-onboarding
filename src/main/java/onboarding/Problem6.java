package onboarding;

import java.util.*;

/** 기능 목록
 * [CreList Collection]
 * addCrew              : 크루 추가
 * getConfusedNickname  : 알림 보낼 이메일 get
 * checkValid           : 예외 처리
 * checkCrewNums        : 크루 크기 유효성 체크
 * checkEmail           : 이메일 유효성 체크
 * checkNickName        : 닉네임 유효성 체크
 * checkAlarmTarget     : 알림 보내줄 대상인지 체크
 * checkOverlap         : 겹치는 부분 있는지 체크
 * checkEmailForm       : 이메일 형식 유효성 체크
 * checkEmailLength     : 이메일 길이 유효성 체크
 * checkEmailDomain     : 이메일 도메인 체크
 * checkEmailId         : 이메일 아이디 체크
 * checkNickNameType    : 닉네임 한글 타입 체크
 * checkNickNameLength  : 닉네임 길이 확인
 */

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        CrewList crewList = new CrewList();
        for (List<String> form : forms) {
            if(!crewList.addCrew(form)) return Collections.emptyList();
        }
        return crewList.getConfusedNickname();
    }

    private static class CrewList{
        private final Map<String, String> crewList = new HashMap<>();
        private final Map<String,String> continuousSet = new HashMap<>();
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
            checkAlarmTarget(nickname, email);
            return checkCrewNums();
        }

        private List<String> getConfusedNickname() {
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

        private void checkAlarmTarget(String nickname, String email) {
            Set<String> userContinuousSet = new HashSet<>();

            for (int i = 0; i < nickname.length() - 1; i++) {
                StringBuilder sb = new StringBuilder();
                String continuousPart = (sb.append(nickname.charAt(i)).append(nickname.charAt(i + 1))).toString();
                userContinuousSet.add(continuousPart);
            }
            checkOverlap(userContinuousSet, email);
        }

        private void checkOverlap(Set<String> userContinuousSet, String email) {
            for (String target : userContinuousSet) {
                if(continuousSet.containsKey(target)) {
                    alarm.add(continuousSet.get(target));
                    alarm.add(email);
                }
                else{
                    continuousSet.put(target, email);
                }
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
            return emailDomain.length() != 0 && emailDomain.equals("email.com");
        }

        private boolean checkEmailId(String emailId) {
            return emailId.length() != 0;
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

