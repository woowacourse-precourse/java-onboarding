package onboarding;

import java.util.*;

/**
 *  구현할 기능 목록
 *      1. User 클래스 구현
 *          1.1. 닉네임과 이메일 프로퍼티를 가진다.
 *
 *      2. 크루들의 닉네임 중 같은 글자가 연속적으로 포함될 경우 해당 닉네임 사용 제한하는 기능
 *          2.1. 닉네임을 2글자씩 Set저장한다.
 *          2.2. Map을 통해 {key:value} -> {토큰, 닉네임에 해당 토큰이 있는 user 인덱스 번호 list}로 저장한다.
 *          2.3. Set를 통해 중복토큰 회원 저장한다.
 *
 *      3.  이메일 출력하는 기능
 *          3.1.이메일 오름차순으로 정렬한다.
 *
 */

public class Problem6 {

    // User 클래스
    static class User{
        private String email;
        private String nickname;


        public User(String email, String nickname) {
            this.email = email;
            this.nickname = nickname;
        }

        public String getEmail() {
            return email;
        }
        public String getNickname() {
            return nickname;
        }


    }

    public static List<String> solution(List<List<String>> forms) {
        Map<String, List<Integer>> tokenUserMap;
        Set<String> answerSet;
        List<String> answer = new ArrayList<>();
        List<User> userList = new ArrayList<>();

        //사용자 리스트에 저장
        for (List<String> form : forms) {
            User user = new User(form.get(0), form.get(1));
            userList.add(user);
        }

        // Map을 통해 토큰이 들어가는 User인덱스 저장 {key:value} -> {토큰, 닉네임에 토큰이 있는 user 인덱스 번호 list}
        tokenUserMap = getUserTokenMap(userList);

        // Set를 통해 중복토큰 회원 저장
        answerSet = getDuplicateSet(userList,tokenUserMap);

        for (String email : answerSet) {
            answer.add(email);
        }

        //이메일 오름차순으로 정렬
        Collections.sort(answer);

        return answer;
    }

    // Map을 통해 토큰이 들어가는 User인덱스 저장 {key:value} -> {토큰, 닉네임에 토큰이 있는 user 인덱스 번호 list}
    private static Map<String, List<Integer>> getUserTokenMap(List<User> userList) {
        Map<String, List<Integer>> tokenUserMap = new HashMap<>();

        for (int i = 0; i < userList.size(); i++) {
            Set<String> tokenSet = getTokenSet(userList.get(i).getNickname());
            for (String token : tokenSet) {
                if(tokenUserMap.containsKey(token)){
                    tokenUserMap.get(token).add(i);
                }
                else{
                    tokenUserMap.put(token,new ArrayList<Integer>());
                    tokenUserMap.get(token).add(i);
                }
            }
        }

        return tokenUserMap;
    }

    // Set를 통해 중복토큰 회원 저장
    private static Set<String> getDuplicateSet(List<User> userList,Map<String, List<Integer>>tokenUserMap) {
        Set<String> answerSet = new HashSet<>();

        // 중복토큰인지 확인
        for (List<Integer> value : tokenUserMap.values()) {
            // Map의 list의 사이즈가 1보다 크다면 중복토큰이 존재
            if (value.size() > 1) {
                for (Integer userIdx : value) {
                    answerSet.add(userList.get(userIdx).getEmail());
                }
            }
        }

        return answerSet;
    }

    //닉네임을 2글자씩 추출
    private static Set<String> getTokenSet(String nickname) {
        Set<String> tokenSet = new HashSet<>();
        for (int i = 0; i < nickname.length() - 1; i++) {
            String token = nickname.substring(i, i + 2);
            tokenSet.add(token);
        }
        return tokenSet;
    }
}
