package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    /**
     * 닉네임을 두글자씩 잘라 해당 닉네임을 포함하는 멤버의 이메일을 저장
     * @param members
     * @return
     */
    private static Map<String, List<Member>> getMemberMapByNickname(List<Member> members) {
        Map<String, List<Member>> memberMap = new HashMap<>();
        members.forEach(member -> {
            String nickname = member.getName();
            for (int i=0; i<nickname.length()-1; i++) {
                String key = nickname.substring(i, i+2);
                memberMap.putIfAbsent(key, new ArrayList<>());  // key 값이 이미 존재하는 경우 Map의 value 반환, 존재하지 않는 경우 Map에 저장하고 null 반환
                memberMap.get(key).add(member); // key에 맴버를 추가
            }
        });
        return memberMap;
    }

    /**
     * 두글자 이상 중복된 닉네임을 가진 멤버의 email 반환
     * @param memberMap
     * @return
     */
    private static List<String> getHasDuplicationNicknameMembers(Map<String, List<Member>> memberMap) {
        List<String> answer;
        answer = memberMap.values().stream()
                .filter(value -> value.size() > 1)  // 중복된 닉네임을 가진 멤버가 2명 이상인 member만 사용하도록 filter
                .flatMap(Collection::stream)    // filter 를 거친 후의 값을 반환
                .map(Member::getEmail)  // email 만 가져와서 stream 에 저장
                .sorted()   // 오름차순 정렬
                .collect(Collectors.toList());  // stream 의 요소를 list 객체로 변환
        return answer;
    }

    public static class Member {
        private String email;
        private String name;

        private Member(String email, String name) {
            this.email = email;
            this.name = name;
        }

        public static Member of(List<String> form) {
            return new Member(form.get(0), form.get(1));
        }

        public String getEmail() {
            return email;
        }

        public String getName() {
            return name;
        }
    }
}
