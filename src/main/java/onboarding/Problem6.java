package onboarding;

import java.util.*;

/** 기능 목록
 * addCrew              : 크루 추가
 * checkAlarmTarget     : 알림 보내줄 대상인지 체크
 * checkOverlap         : 겹치는 부분 있는지 체크
 * getConfusedNickname  : 알림 보낼 이메일 get
 * checkValid           : 예외 처리
 * checkCrewNums        : 크루 크기 유효성 체크
 * checkEmail           : 이메일 유효성 체크
 * checkNickName        : 닉네임 유효성 체크
 * checkEmailForm       : 이메일 형식 유효성 체크
 * checkEmailLength     : 이메일 길이 유효성 체크
 * checkEmailDomain     : 이메일 도메인 체크
 * checkEmailId         : 이메일 아이디 체크
 * checkNickNameType    : 닉네임 한글 타입 체크
 * checkNickNameLength  : 닉네임 길이 확인
 */

public class Problem6 {

    private static Map<String, String> continuousMap = Collections.emptyMap();
    private static Set<String> alarm = Collections.emptySet();

    public static List<String> solution(List<List<String>> forms) {
        continuousMap = new HashMap<>();
        alarm = new HashSet<>();
        if(!checkCrewNums(forms))
            throw new IllegalArgumentException("제한사항 위반 [크루 인원 수]");
        for (List<String> form : forms) {
            addCrew(form);
        }
        return getConfusedNickname();
    }

    private static void addCrew(List<String> form) {
        String email = form.get(0);
        String nickname = form.get(1);
        if (!checkValid(email, nickname)) {
            throw new IllegalArgumentException("제한사항 위반");
        }
        checkAlarmTarget(nickname, email);

    }

    private static void checkAlarmTarget(String nickname, String email) {
        Set<String> userContinuousSet = new HashSet<>();
        for (int i = 0; i < nickname.length() - 1; i++) {
            StringBuilder sb = new StringBuilder();
            String continuousPart = (sb.append(nickname.charAt(i)).append(nickname.charAt(i + 1))).toString();
            userContinuousSet.add(continuousPart);
        }
        checkOverlap(userContinuousSet, email);
    }

    private static void checkOverlap(Set<String> userContinuousSet, String email) {
        for (String target : userContinuousSet) {
            if(continuousMap.containsKey(target)) {
                alarm.add(continuousMap.get(target));
                alarm.add(email);
            }
            else{
                continuousMap.put(target, email);
            }
        }
    }

    private static List<String> getConfusedNickname() {
        List<String> result = new ArrayList<>(alarm);
        Collections.sort(result);
        return result;
    }

    private static boolean checkValid(String email, String nickname) {
        return checkEmail(email) && checkNickName(nickname);
    }

    private static boolean checkCrewNums(List<List<String>> arr) {
        int crewSize = arr.size();
        return 1 <= crewSize && crewSize <= 10000;
    }

    private static boolean checkEmail(String email) {
        int emailLength = email.length();
        if (!checkEmailLength(emailLength)) {
            throw new IllegalArgumentException("제한사항 위반 [이메일 길이]");
        }
        return checkEmailForm(email);
    }

    private static boolean checkNickName(String nickname) {
        return checkNickNameLength(nickname) && checkNickNameType(nickname);
    }

    private static boolean checkEmailForm(String email) {
        String[] emailDetails;
        try {
            emailDetails = email.split("@");
        } catch (Exception e) {
            throw new IllegalArgumentException("제한사항 위반 [이메일]");
        }
        String emailId = emailDetails[0];
        String emailDomain = emailDetails[1];
        return checkEmailDomain(emailDomain) && checkEmailId(emailId);
    }

    private static boolean checkEmailLength(int n) {
        return 11 <= n && n < 20;
    }

    private static boolean checkEmailDomain(String emailDomain) {
        return emailDomain.equals("email.com");
    }

    private static boolean checkEmailId(String emailId) {
        return emailId.length() != 0;
    }

    private static boolean checkNickNameType(String nickname) {
        return nickname.matches("^[가-힣]*$");
    }

    private static boolean checkNickNameLength(String nickname) {
        int len = nickname.length();
        return 1<= len && len < 20;
    }
}
