package onboarding;

import java.util.*;

// 닉네임을 뽑아와서 그걸로 나올 수 있는 중복 검사 형식을 리스트로 만든다.
//
public class Problem6 {

    static Map<String, String> emailNicknameMap = new HashMap<>();
    static Map<String, Boolean> nicknameOverlapStatusMap = new HashMap<>();

    // nicknameOverlapStatusMap 초기 값 셋팅
    public static void initNicknameOverlapStatus(Map<String, String> emailNicknameMap) {
        for (String value : emailNicknameMap.values()) {
            nicknameOverlapStatusMap.put(value, false);
        }
    }

    // forms 를 Map 으로 변환하는 메서드
    // 반환은 HashMap<String,String> ex) {json@email.com, 제이슨} 으로 수행한다.
    public static Map<String, String> convertToEmailNicknameMap(List<List<String>> forms) {
        for (List<String> form : forms) {
            for (int formListIndex = 0; formListIndex < form.size() - 1; formListIndex++) {
                emailNicknameMap.put(form.get(formListIndex), form.get(formListIndex + 1));
            }
        }
        return emailNicknameMap;
    }

    // forms 에서 모든 닉네임을 리스트로 추출하는 메서드
    public static List<String> extractNicknameList(List<List<String>> forms) {
        List<String> nicknameList = new ArrayList<>();
        for (List<String> form : forms) {
            nicknameList.add(form.get(1));
        }
        return nicknameList;
    }

    // Nickname 으로 Email 추출하기 (Nickname -> Email)
    // solution 메서드 결과 반환 시
    // 닉네임 중복 여부를 담고 있는 nicknameOverlapStatusMap 에 담겨있는 Email을 닉네임을 기반으로 추출하기 위함
    public static String extractEmailInMapByNickname(String nickname) {
        for (String key : emailNicknameMap.keySet()) {
            if (emailNicknameMap.get(key).equals(nickname)) {
                return key;
            }
        }
        return null;
    }

    // nickname 으로 중복 확인 검사 양식 리스트 만들기
    public static List<String> extractCheckFormListByNickname(String nickname) {
        int nicknameLength = nickname.length();
        List<String> checkFormList = new ArrayList<>();

        // 순회중인 닉네임의 길이만큼 순회
        for (int nicknameIndex = 0; nicknameIndex < nicknameLength - 1; nicknameIndex++) {
            // 중복검사 양식 셋팅 (현재 입력받은 닉네임의 두 글자씩 순회하여 조합)
            checkFormList.add(nickname.substring(nicknameIndex, nicknameIndex + 2));
        }
        return checkFormList;
    }

    // 닉네임 중복검사 결과 반영하기
    // @Param : 닉네임 중복조건 리스트, 검사 대상 닉네임, 닉네임 중복조건이 생성된 닉네임
    public static void updateOverlapStatusMap(
            List<String> checkFormList, String checkingTargetNickname, String originalNickname) {

        int checkingTargetNicknameLength = checkingTargetNickname.length();

        // 중복 검사 대상 닉네임 길이 -1 만큼 반복
        for (int i = 0; i < checkingTargetNicknameLength - 1; i++) {
            // 중복 검사 양식 리스트 길이만큼 반복
            for (String checkForm : checkFormList) {
                // 중복 검사 대상 닉네임 2글자와 중복 검사 양식과 같으면 nicknameOverlapStatus true 로 변경
                if (checkingTargetNickname.substring(i, i + 2).equals(checkForm)) {
                    nicknameOverlapStatusMap.put(checkingTargetNickname, true);
                    nicknameOverlapStatusMap.put(originalNickname, true);
                    break;
                }
            }
        }
    }

    // 중복된 닉네임 검사 메서드를 호출하는 메서드
    // extractNicknameList 메서드에서 추출한 nicknameList 를 매개변수로 받는다.
    // 이 매개변수를 토대로 중복검사를 수행하여
    // 중복 여부를 담고 있는 updateOverlapStatusMap 에 중복 여부를 반영한다.
    public static void checkNicknameOverlap(List<String> nicknameList) {

        int nicknameListSize = nicknameList.size();

        // 닉네임 리스트 순회
        for (int nicknameListIndex = 0; nicknameListIndex < nicknameListSize; nicknameListIndex++) {
            String nickname = nicknameList.get(nicknameListIndex);

            // 다음 닉네임 리스트 원소부터 중복검사 양식을 검사한다.
            // nicknameList 리스트의 k 인덱스를 참조한다 (현재 i 보다 한칸 더 크도록)
            for (int nicknameIndex = nicknameListIndex + 1; nicknameIndex < nicknameListSize; nicknameIndex++) {
                updateOverlapStatusMap(extractCheckFormListByNickname(nickname), nicknameList.get(nicknameIndex), nickname);
            }
        }
    }

    // 닉네임 중복 여부를 담고있는 nicknameOverlapStatusMap -> List 로 변환하기
    public static List<String> nicknameOverlapStatusMapConvertToList() {
        List<String> result = new ArrayList<>();
        for (String nickname : nicknameOverlapStatusMap.keySet()) {
            if (nicknameOverlapStatusMap.get(nickname) && extractEmailInMapByNickname(nickname) != null) {
                result.add(extractEmailInMapByNickname(nickname));
            }
        }
        return result;
    }

    public static List<String> solution(List<List<String>> forms) {

        // 입력값 Map 자료형으로 변환
        Map<String, String> emailNicknameMap = convertToEmailNicknameMap(forms);

        // 입력값에 포함된 Nickname 항목 List 로 추출
        List<String> nicknameList = extractNicknameList(forms);

        // 중복 여부를 담을 Map 셋팅하기
        initNicknameOverlapStatus(emailNicknameMap);

        // 중복 확인을 위한 메서드 호출
        checkNicknameOverlap(nicknameList);

        List<String> result = nicknameOverlapStatusMapConvertToList();
        Collections.sort(result);
        
        return result;
    }
}
