package onboarding;

import onboarding.problem7.Member;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem7 {
    private static Map<String, Member> memberStore;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        memberStore = setMemberStore(friends);


        List<String> answer = Collections.emptyList();
        return answer;
    }



    /**
     * 7.1
     * 각 사용자를 나타내는 Member 클래스 생성 -> Map객체로 멤버 관리
     */
    public static Map<String, Member> setMemberStore(List<List<String>> friends) {
        memberStore = new HashMap<>();

        for (List<String> relation : friends) {
            String member1Name = relation.get(0);
            String member2Name = relation.get(1);

            Member member1 = getMember(member1Name);
            Member member2 = getMember(member2Name);

            // 서로의 친구 리스트에 각자를 추가
            member1.getFriends().add(member2);
            member2.getFriends().add(member1);
        }

        return memberStore;
    }

    /**
     * 7.1.1
     * 이름을 이용해 (memberStore에서 조회 후 반환) or (멤버 객체를 생성 후 반혼 + memberStore에 등록)
     */
    private static Member getMember(String name) {
        Member member = null;

        // member의 이름이 memberStore의 키 값에 존재 -> 멤버 존재
        if (memberStore.containsKey(name)) {
            member = memberStore.get(name);
        } else { // 멤버가 memberStore에 등록되지 않았다면 객체 생성후 등록
            member = new Member(name);
            memberStore.put(name, member);
        }

        return member;
    }
}
