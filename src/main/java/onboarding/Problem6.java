package onboarding;

import java.util.*;

public class Problem6 {
    // 부분 닉네임 문자열과 이메일 정보를 담은 맵이다.
    static Map<String, String> partNameWithEmail;

    // 결과 이메일을 담는 TreeSet이다.
    static Set<String> answer;

    public static List<String> solution(List<List<String>> forms) {
        partNameWithEmail = new HashMap<>();
        answer = new TreeSet<>();

        for(List<String> form : forms) {
            // 크루들의 이메일과 닉네임 정보를 각각 추출한다.
            String email = form.get(0);
            String nickname = form.get(1);

            // 이메일을 한 글자씩 끊어서 배열로 만든다.
            String[] nameArr = nickname.split("");

            // 2글자씩 끊어서 부분 닉네임을 생성한 뒤 중복을 체크한다.
            createPartNicknameAndCheck(email, nameArr);
        }

        // 결과를 오름차순으로 정렬한다.
        List<String> answerList = new ArrayList<>(answer);
        answerList.sort(String::compareTo);

        return answerList;
    }

    /**
     * 닉네임 배열로부터 2글자씩 자르고 중복을 체크한다.
     *
     * @param email 사용자의 이메일
     * @param nameArr 사용자의 닉네임 배열
     */
    private static void createPartNicknameAndCheck(String email, String[] nameArr) {
        for (int i = 0; i < nameArr.length-1; i++) {
            String partNickname = nameArr[i] + nameArr[i+1];
            // 부분 닉네임 문자열에 대한 중복 체크를 진행한다.
            checkDuplicatedAndAddResult(email, partNickname);
            partNameWithEmail.put(partNickname, email);
        }
    }

    /**
     * 부분 닉네임 문자열에 대한 중복 체크를 진행한 뒤 결과 Set에 담는다.
     *
     * @param email 사용자의 이메일
     * @param partNickname 사용자의 부분 닉네임 문자열
     */
    private static void checkDuplicatedAndAddResult(String email, String partNickname) {
        if(partNameWithEmail.containsKey(partNickname)) {
            // 해당 사용자의 이메일을 결과 Set에 추가한다.
            answer.add(email);
            // 중복된 부분 문자열을 가진 사용자의 이메일을 결과 Set에 추가한다.
            answer.add(partNameWithEmail.get(partNickname));
        }
    }
}
