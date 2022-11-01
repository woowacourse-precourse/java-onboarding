package onboarding;

import onboarding.problem7.Member;
import onboarding.problem7.MrKoRecommender;

import java.util.*;

public class Problem7 {
    private static Map<String, Member> memberMap;
    private static MrKoRecommender recommender;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        // friends와 visitors를 통해 모든 멤버들을 등록
        memberMap = setMemberMap(friends, visitors);
        setUserVisitors(user, visitors);

        // 추천객체 MrKoRecommender 초기화
        recommender = new MrKoRecommender(memberMap);

        // user에게 추천되는 친구리스트 반환
        List<Member> recommendedFriends = recommender.recommendFor(user);

        // 추천된 친구 리스트를 반환 형태로 변환
        for (Member member : recommendedFriends)
            answer.add(member.getName());

        return answer;
    }

    /**
     * 7.1
     * 각 사용자를 나타내는 Member 클래스 생성 -> Map객체로 멤버 관리
     */
    public static Map<String, Member> setMemberMap(List<List<String>> friends, List<String> visitors) {
        memberMap = new HashMap<>();

        for (List<String> relation : friends) {
            String member1Name = relation.get(0);
            String member2Name = relation.get(1);

            Member member1 = getMember(member1Name);
            Member member2 = getMember(member2Name);

            // 서로의 친구 리스트에 각자를 추가
            member1.getFriends().add(member2);
            member2.getFriends().add(member1);
        }

        for (String visitor : visitors)
            getMember(visitor);

        return memberMap;
    }

    /**
     * 7.1.1
     * 이름을 이용해 (memberStore에서 조회 후 반환) or (멤버 객체를 생성 후 반혼 + memberStore에 등록)
     */
    private static Member getMember(String name) {
        Member member = null;

        // member의 이름이 memberStore의 키 값에 존재 -> 멤버 존재
        if (memberMap.containsKey(name)) {
            member = memberMap.get(name);
        } else { // 멤버가 memberStore에 등록되지 않았다면 객체 생성후 등록
            member = new Member(name);
            memberMap.put(name, member);
        }

        return member;
    }

    /**
     * 7.2
     * 멤버, 멤버들의 친구 리스트, 방문자 리스트 초기화
     */
    public static void setUserVisitors(String user, List<String> visitors) {
        List<Member> userVisitors = memberMap.get(user).getVisitors();

        for (String visitor : visitors)
            userVisitors.add(memberMap.get(visitor));
    }

}
