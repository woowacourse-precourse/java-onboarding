package onboarding;

import java.util.*;

// 닉네임을 뽑아와서 그걸로 나올 수 있는 중복 검사 형식을 리스트로 만든다.
//
public class Problem6 {

    static Map<String, String> emailNicknameMap = new HashMap<>();
    static Map<String, Boolean> nicknameFlag = new HashMap<>();

    // 주어진 2차원 리스트에서 닉네임을 추출하는 메서드
    // 반환은 HashMap<String,String> ex) {json@email.com, 제이슨} 으로 수행한다.
    public static Map<String, String> extractEmailNicknameMap(List<List<String>> forms) {
        for (List<String> form : forms) {
            for (int i = 0; i < form.size() - 1; i++) {
                emailNicknameMap.put(form.get(i), form.get(i + 1));
            }
        }
        return emailNicknameMap;
    }

    // emailNicknameMap 에서 모든 닉네임 리스트로 추출하는 메서드
    public static List<String> extractNicknameListFromMap(Map<String, String> emailNicknameMap) {
        return new ArrayList<>(emailNicknameMap.values());
    }

    // 중복된 닉네임 검사를 위한 메서드 (닉네임 검사 전 값 셋팅 및 중복 검사 메서드 호출하기)
    public static void overlapChecker(List<String> nicknameList) {

        int nicknameListSize = nicknameList.size();

        // 닉네임 리스트 순회
        for (int i = 0; i < nicknameListSize; i++) {
            String nickname = nicknameList.get(i);
            int nicknameLength = nickname.length();

            // 순회중인 닉네임의 길이만큼 순회
            for (int j = 0; j < nicknameLength - 1; j++) {
                // 중복검사 양식 셋팅
                String checkForm = String.valueOf(nickname.charAt(j)) + String.valueOf(nickname.charAt(j + 1));

                // 다음 닉네임 리스트 원소부터 중복검사 양식을 검사한다.
                // nicknameList 리스트의 k 인덱스를 참조한다 (현재 i 보다 한칸 더 크도록)
                for (int k = i + 1; k < nicknameListSize; k++) {
                    checkFormContainsChecker(checkForm, nicknameList.get(k), nickname);
                }
            }
        }
    }

    // 실제로 닉네임 중복검사를 수행하는 메서드
    // 매개변수(파라미터)로 닉네임 중복조건, 검사 대상 닉네임, 닉네임 중복조건이 생성된 기존 닉네임
    // 을 받아 문자열로 비교하여 검사대상 닉네임 2글자씩 순회하며, 닉네임 중복조건과 일치하면 nicknameFlag 의 value true 로 변환 
    public static void checkFormContainsChecker(String checkForm, String targetNickname, String originalNickname) {
        int nicknameLength = targetNickname.length();

        for (int i = 0; i < nicknameLength - 1; i++) {
            if ((String.valueOf(targetNickname.charAt(i)) + String.valueOf(targetNickname.charAt(i + 1))).equals(checkForm)) {
                nicknameFlag.put(targetNickname, true);
                nicknameFlag.put(originalNickname, true);
            }
        }
    }

    public static String getEmailByNickname(String nickname) {
        for (String key : emailNicknameMap.keySet()) {
            if (emailNicknameMap.get(key).equals(nickname)) {
                return key;
            }
        }
        return null;
    }

    // 닉네임 중복 여부에 대한 Flag Map 수정자
    public static void setNicknameFlagMap(Map<String, String> emailNicknameMap) {
        for (String value : emailNicknameMap.values()) {
            nicknameFlag.put(value, false);
        }
    }

    public static List<String> flagMapConvertToList() {
        List<String> result = new ArrayList<>();
        for (String nickname : nicknameFlag.keySet()) {
            if (nicknameFlag.get(nickname)) {
                result.add(getEmailByNickname(nickname));
            }
        }

        return result;
    }

    public static List<String> solution(List<List<String>> forms) {

        Map<String, String> emailNicknameMap = extractEmailNicknameMap(forms);
        List<String> nicknameList = extractNicknameListFromMap(emailNicknameMap);
        setNicknameFlagMap(emailNicknameMap);
        overlapChecker(nicknameList);

        List<String> result = flagMapConvertToList();
        Collections.sort(result);
        return result;
    }
}
