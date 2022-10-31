package onboarding;

import java.util.*;

public class Problem6 {

    /**
     * 입력이 유효한지 판별합니다.
     *
     * @param forms 입력으로 주어진 배열
     * @return 입력이 유효하다면 참, 아니면 거짓을 반환합니다.
     * */
    private static boolean isValidInput(List<List<String>> forms) {
        boolean valid = isValidForms(forms);

        for (List<String> form: forms) {
            valid &= isValidForm(form);
        }
        return valid;
    }

    /**
     * 숫자가 특정 범위 안의 숫자인지 알려줍니다.
     *
     * @param toCheck 확인할 숫자
     * @param leftBound 범위의 왼쪽 숫자
     * @param rightBound 범위의 오른쪽 숫자
     * @return 범위 안에 있으면 참, 아니면 거짓을 반환합니다.
     * */
    private static boolean isInRange(int toCheck, int leftBound, int rightBound) {
        return leftBound <= toCheck && toCheck <= rightBound;
    }

    /**
     * 신청서 배열이 올바른지 확인합니다.
     *
     * @param forms 신청서 배열입니다.
     * @return 신청서 배열이 주어진 조건에 부합하면 참, 아니면 거짓을 반환합니다.
     * */
    private static boolean isValidForms(List<List<String>> forms) {
        boolean valid = hasValidFormsLength(forms);
        return valid;
    }

    /**
     * 신청서 배열의 크기가 올바른지 확인합니다.
     *
     * @param forms 신청서 배열입니다.
     * @return 신청서 배열의 크기가 1~10000 사이라면 참, 아니면 거짓을 반환합니다.
     * */
    private static boolean hasValidFormsLength(List<List<String>> forms) {
        boolean valid = isInRange(forms.size(), 1, 10000);
        return valid;
    }

    /**
     * 각 신청서가 올바른지 확인합니다.
     *
     * @param form 이메일과 닉네임이 담긴 신청서입니다.
     * @return 신청서의 정보가 올바르다면 참, 아니면 거짓을 반환합니다.
     * */
    private static boolean isValidForm(List<String> form) {
        if (hasValidFormLength(form) == false) {
            return false;
        }
        String email = form.get(0);
        String nickname = form.get(1);

        boolean valid = hasValidEmail(email) &&
                hasValidNickname(nickname);
        return valid;
    }

    /**
     * 신청서가 포함한 정보가 2개인지 확인합니다.
     *
     * @param form 신청서 입니다.
     * @return 신청서가 2개의 정보를 가지고 있으면 참, 아니면 거짓을 반환합니다.
     * */
    private static boolean hasValidFormLength(List<String> form) {
        boolean valid = isInRange(form.size(), 2, 2);
        return valid;
    }

    /**
     * 신청서 첫 번째 정보가 이메일인지 확인합니다.
     *
     * @param email 신청서 첫 번째 정보입니다.
     * @return 해당 정보가 조건에 부합하는 이메일이면 참, 아니면 거짓을 반환합니다.
     * */
    private static boolean hasValidEmail(String email) {
        boolean valid = hasValidEmailLength(email) &&
                hasValidEmailForm(email) &&
                hasValidEmailDomain(email);
        return valid;
    }

    /**
     * 이메일의 길이가 조건에 부합하는지 확인합니다.
     *
     * @param email 신청서의 첫 번째 정보입니다.
     * @return 해당 정보의 길이가 11~19 사이의 값이라면 참, 아니면 거짓을 반환합니다.
     */
    private static boolean hasValidEmailLength(String email) {
        boolean valid = isInRange(email.length(), 11, 19);
        return valid;
    }

    /**
     * 이메일이 형식에 부합하는지 확인합니다.
     *
     * @param email 신청서의 첫 번째 정보입니다.
     * @return 해당 정보가 이메일의 형식에 부합하면 참, 아니면 거짓을 반환합니다.
     */
    private static boolean hasValidEmailForm(String email) {
        String emailPattern = "^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$";
        boolean valid = email.matches(emailPattern);
        return valid;
    }

    /**
     * 이메일의 도메인이 "@email.com"인지 확인합니다.
     *
     * @param email 신청서의 첫 번째 정보입니다.
     * @return 해당 정보가 "@email.com"으로 끝난다면 참, 아니면 거짓을 반환합니다.
     */
    private static boolean hasValidEmailDomain(String email) {
        boolean valid = email.endsWith("@email.com");
        return valid;
    }

    /**
     * 신청서 두 번째 정보가 닉네임인지 확인합니다.
     *
     * @param nickname 신청서의 두 번째 정보입니다.
     * @return 해당 정보가 조건에 부합하는 닉네임이면 참, 아니면 거짓을 반환합니다.
     */
    private static boolean hasValidNickname(String nickname) {
        boolean valid = hasValidNicknameLength(nickname) &&
                hasValidNicknameForm(nickname);
        return valid;
    }

    /**
     * 닉네임의 길이가 조건에 부합하는지 확인합니다.
     *
     * @param nickname 신청서의 두 번째 정보입니다.
     * @return 해당 정보의 길이가 1~19 사이의 값이면 참, 아니면 거짓을 반환합니다.
     */
    private static boolean hasValidNicknameLength(String nickname) {
        boolean valid = isInRange(nickname.length(), 1, 19);
        return valid;
    }

    /**
     * 닉네임이 한글로만 이루어져있는지 확인합니다.
     *
     * @param nickname 신청서의 두 번째 정보입니다.
     * @return 해당 정보가 한글만 포함한다면 참, 아니면 거짓을 반환합니다.
     */
    private static boolean hasValidNicknameForm(String nickname) {
        String koreanPattern = "^[ㄱ-ㅎㅏ-ㅣ가-힣]+$";
        boolean valid = nickname.matches(koreanPattern);
        return valid;
    }

    /**
     * 연속된 두 글자의 닉네임이 같은 크루원들을 찾아 이메일을 알려줍니다.
     *
     * @param forms 닉네임 신청서 배열입니다.
     * @return 닉네임이 중복되는 크루원들의 이메일 배열입니다.
     */
    private static List<String> getDuplicateNicknameUsers(List<List<String>> forms) {
        HashMap<String, HashSet<String>> twoCharNicknames = new HashMap<>();
        HashSet<String> duplicateNicknamesUsers = new HashSet<>();
        for (List<String> form: forms) {
            addEmailsByNickname(form, twoCharNicknames);
        }
        for (HashSet<String> nicknameUsers: twoCharNicknames.values()) {
            getEmailsByNickname(nicknameUsers, duplicateNicknamesUsers);
        }
        List<String> result = setToSortedList(duplicateNicknamesUsers);
        return result;
    }

    /**
     * 닉네임을 두 글자씩마다 해당 유저의 이메일을 추가합니다.
     *
     * @param form 닉네임 신청서입니다.
     * @param twoCharNicknames 닉네임 조합마다 유저 이메일을 추가할 해시맵입니다.
     */
    private static void addEmailsByNickname(List<String> form,
                                            HashMap<String, HashSet<String>> twoCharNicknames){
        String email = form.get(0);
        String nickname = form.get(1);

        for (int i = 1; i < nickname.length(); i++) {
            String nicknameCombination = nickname.substring(i-1, i+1);
            addEmails(nicknameCombination, email, twoCharNicknames);
        }
    }

    /**
     * 닉네임 조합이 존재한다면 기존 해시셋에 추가를, 아니면 새로운 해시셋을 추가합니다.
     *
     * @param nicknameCombination 닉네임 두 글자 조합입니다.
     * @param email 추가할 이메일입니다.
     * @param twoCharNicknames 닉네임 조합마다 유저 이메일을 추가할 해시맵입니다.
     */
    private static void addEmails(String nicknameCombination,
                                  String email,
                                  HashMap<String, HashSet<String>> twoCharNicknames) {
        if (twoCharNicknames.containsKey(nicknameCombination)) {
            twoCharNicknames.get(nicknameCombination)
                    .add(email);
            return;
        }
        twoCharNicknames.put(nicknameCombination, new HashSet<>(Arrays.asList(email)));
    }

    /**
     * 특정 닉네임 조합을 사용하는 유저 수가 2명 이상인 유저들의 이메일을 찾습니다.
     *
     * @param nicknameUsers 특정 닉네임 조합을 사용하는 유저들의 이메일입니다.
     * @param duplicateNicknameUser 중복 닉네임을 사용하는 모든 유저들의 이메일 집합입니다.
     */
    private static void getEmailsByNickname(HashSet<String> nicknameUsers, HashSet<String> duplicateNicknameUser){
        if (nicknameUsers.size() >= 2) {
            duplicateNicknameUser.addAll(nicknameUsers);
        }
    }

    /**
     * 해시셋을 정렬된 리스트로 치환해줍니다.
     * @param thisSet 치환할 해시셋입니다.
     * @return 정렬된 리스트입니다.
     */
    private static List<String> setToSortedList(HashSet thisSet){
        List<String> convertedList = new ArrayList<String>(thisSet);
        convertedList.sort(Comparator.naturalOrder());
        return convertedList;
    }

    /**
     * Problem5의 솔루션 코드입니다.
     *
     * @param forms 중복 닉네임 검사를 진행할 크루원 배열입니다.
     * @return 중복 닉네임을 가진 크루원들의 이메일 배열입니다.
     */
    public static List<String> solution(List<List<String>> forms) {
        if (isValidInput(forms) == false) {
            return Collections.emptyList();
        }
        List<String> answer = getDuplicateNicknameUsers(forms);
        return answer;
    }
}
