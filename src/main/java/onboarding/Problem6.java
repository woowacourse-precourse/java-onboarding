package onboarding;

import java.util.*;

public class Problem6 {
    static Map<String, Set<String>> nicknameEmailMap;
    public static List<String> solution(List<List<String>> forms) {
        nicknameEmailMap = new HashMap<>();

        for (List<String> form : forms) {
            String email = form.get(0);
            String nickname = form.get(1);

            for (int count = 0; count < nickname.length() - 1; count++) {
                String partOfNickname = nickname.substring(count, count + 2);
                Set<String> emailSet = nicknameEmailMap.getOrDefault(partOfNickname, new HashSet<>());
                emailSet.add(email);
                nicknameEmailMap.put(partOfNickname, emailSet);
            }
        }

        List<String> answer = makeEmailList();
        answer.sort(Comparator.naturalOrder());
        return answer;
    }

    /*
    * Map의 Value 중 size가 2 이상인 Set의 이메일들을 List에 추가해 반환
    *
    * @return List<String>
    * */
    private static List<String> makeEmailList() {
        List<String> emailList = new ArrayList<>();

        for (Set<String> emails : nicknameEmailMap.values()) {
            if (emails.size() >= 2) {
                emailList.addAll(emails);
            }
        }

        return emailList;
    }
}
