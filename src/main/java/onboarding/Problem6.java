package onboarding;

import java.util.*;

public class Problem6 {
    static Map<String, Set<String>> nicknameEmailMap;
    public static List<String> solution(List<List<String>> forms) {
        nicknameEmailMap = new HashMap<>();

        for (List<String> form : forms) {
            String email = form.get(0);
            String nickname = form.get(1);

            addPartOfNickname(email, nickname);
        }

        List<String> answer = makeEmailList();
        answer.sort(Comparator.naturalOrder());
        return answer;
    }

    /*
    * 주어진 닉네임을 2글자씩 잘라 중복 여부 Map에 추가
    *
    * @return void
    * */
    private static void addPartOfNickname(String email, String nickname) {
        for (int count = 0; count < nickname.length() - 1; count++) {
            String partOfNickname = nickname.substring(count, count + 2);
            Set<String> emailSet = nicknameEmailMap.getOrDefault(partOfNickname, new HashSet<>());
            emailSet.add(email);
            nicknameEmailMap.put(partOfNickname, emailSet);
        }
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
