package onboarding;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 기능 목록
 * 1. 사용자 정보{email, nickname}이 주어진 제한 조건에 맞는지 검증
 * 2. 현재 사용자 정보의 nickname과 사용자 정보를 기록하는 map에 대해 비슷한 닉네임이 있는지 검증
 * 3. 비슷한 닉네임이 있다면 해당 사용자 정보 answer 리스트에 추가
 * 4. 닉네임을 2글자씩 분리하여 사용자 정보 기록하는 map에 중복되지 않게 저장
 * 5. map과 answer 객체를 바탕으로 최초 중복 부분 닉네임 등록자 정보 추가 후 answerEmail로 반환
 * 6. 이메일을 기준으로 오름차순 정렬
 * 7. 중복 제거 후 반환
 */
public class Problem6 {
    static final int MIN_EMAIL_LENGTH = 11;
    static final int MAX_EMAIL_LENGTH = 20;
    static final int MIN_NICKNAME_LENGTH = 1;
    static final int MAX_NICKNAME_LENGTH = 20;
    static final String EMAIL_DOMAIN = "email.com";
    static final String KOREAN_REGEX = "[ㄱ-ㅎㅏ-ㅣ가-힣]+";

    static class UserInfo {
        String email;
        String nickname;

        UserInfo(String email, String nickname) {
            this.email = email;
            this.nickname = nickname;
        }
    }

    /* 최종 시간 복잡도 O(N*L), N: forms 길이, L : 문자열 길이 */
    public static List<String> solution(List<List<String>> forms) {
        List<UserInfo> answer = new ArrayList<>();
        HashMap<String, String> map = new HashMap<>();

        for (List<String> form : forms) {
            String email = form.get(0), nickname = form.get(1);
            UserInfo userInfo = new UserInfo(email, nickname);
            if (!validateUserInfo(userInfo)) continue;
            if (hasSimilarNickname(map, userInfo)) answer.add(userInfo);
            insertSplitNickname(map, userInfo);
        }

        List<String> answerEmail = getAllEmails(map, answer);
        Collections.sort(answerEmail);
        return deleteDuplicatedEmail(answerEmail);
    }

    /**
     * 시간 복잡도 : O(1 * L) L: 문자열 길이 in [1, 20)
     * 각 닉네임을 2글자씩 쪼개며 비슷한 닉네임이 있는지 검증
     *
     * @param map
     * @param user
     * @return
     */
    static boolean hasSimilarNickname(HashMap<String, String> map, UserInfo user) {
        if (user.nickname.length() == 1) return false;
        for (int i = 0; i < user.nickname.length() - 1; i++) {
            String target = user.nickname.substring(i, i + 2);
            if (map.containsKey(target)) return true;
        }
        return false;
    }

    /**
     * 시간 복잡도 : O(1 * L) L: 문자열 길이 in [1, 20)
     * 각 닉네임의 2글자부터 문자열 끝까지 늘려가며 새로운 닉네임과 해당 사용자의 최초 이메일을 저장
     *
     * @param map
     * @param user
     */
    static void insertSplitNickname(HashMap<String, String> map, UserInfo user) {
        if (user.nickname.length() == 1) {
            map.put(user.nickname, user.email);
        } else {
            for (int i = 0; i < user.nickname.length() - 1; i++) {
                String splitNickname = user.nickname.substring(i, i + 2);
                if (!map.containsKey(splitNickname)) map.put(splitNickname, user.email);
            }
        }
    }

    /**
     * 시간 복잡도 O( N * L * 1) N: forms 길이, L : 문자열 길이
     * answer 리스트에 있는 이메일 중 닉네임들에 대해 최초 등록자 이메일을 갖는 유저를 answer 리스트에 추가한다.
     *
     * @param map
     * @param answer
     */
    static List<String> getAllEmails(HashMap<String, String> map, List<UserInfo> answer) {
        List<String> emails = new ArrayList<>();

        for (UserInfo userInfo : answer) {
            if (userInfo.nickname.length() > 1) {
                for (int i = 0; i < userInfo.nickname.length() - 1; i++) {
                    String splitNickname = userInfo.nickname.substring(i, i + 2);
                    if (map.containsKey(splitNickname)) {
                        String firstEmail = map.get(splitNickname);
                        emails.add(firstEmail);
                    }
                    emails.add(userInfo.email);
                }
            }
        }
        return emails;
    }

    static List<String> deleteDuplicatedEmail(List<String> answer) {
        return answer.stream().distinct().collect(Collectors.toList());
    }

    static boolean validateUserInfo(UserInfo userInfo) {
        return hasValidEmailLength(userInfo.email) && hasValidDomain(userInfo.email) && hasValidNickname(userInfo.nickname);
    }

    static boolean hasValidEmailLength(String email) {
        int length = email.length();
        return length >= MIN_EMAIL_LENGTH && length < MAX_EMAIL_LENGTH;
    }

    static boolean hasValidDomain(String email) {
        return email.contains("@" + EMAIL_DOMAIN);
    }

    static boolean hasValidNickname(String nickname) {
        int length = nickname.length();
        boolean validLength = length >= MIN_NICKNAME_LENGTH && length < MAX_NICKNAME_LENGTH;
        boolean onlyKorean = nickname.matches(KOREAN_REGEX);
        return validLength && onlyKorean;
    }
}
