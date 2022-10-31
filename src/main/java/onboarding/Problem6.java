package onboarding;

import java.util.*;

public class Problem6 {

    /**
     * 연속된 두 글자의 닉네임이 같은 크루원들을 찾아 이메일을 알려줍니다.
     *
     * @param forms 닉네임 신청서들이 담긴 배열입니다.
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
        twoCharNicknames.put(nicknameCombination, new HashSet<>(List.of(email)));
    }

    /**
     * 특정 닉네임 조합을 사용하는 유저 수가 2명 이상인 유저들의 이메일을 찾습니다.
     *
     * @param nicknameUsers 특정 닉네임 조합을 사용하는 유저들의 이메일입니다.
     * @param duplicateNicknameUser 중복 닉네임을 사용하는 모든 유저들의 이메일 집합입니다.
     */
    private static void getEmailsByNickname(HashSet<String> nicknameUsers,
                                            HashSet<String> duplicateNicknameUser){
        if (nicknameUsers.size() >= 2) {
            duplicateNicknameUser.addAll(nicknameUsers);
        }
    }

    /**
     * 해시셋을 정렬된 리스트로 치환해줍니다.
     * @param thisSet 치환할 해시셋입니다.
     * @return 정렬된 리스트입니다.
     */
    private static List<String> setToSortedList(HashSet<String> thisSet){
        List<String> convertedList = new ArrayList<>(thisSet);
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
        List<String> answer = getDuplicateNicknameUsers(forms);
        return answer;
    }
}
