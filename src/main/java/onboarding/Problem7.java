package onboarding;

import java.util.*;
import java.util.stream.Collectors;

/*
 *  🚀 기능 명세
    사용자의 정보를 저장할 객체 (이름 / 친구 관계 / 점수) (Member)
    * 이름을 반환하는 메서드 (getName : String)
    * 친구 목록을 반환하는 메서드 (getFriendSet : Set)
    * 친구를 추가할 메서드 (addFriend)

    * 점수를 반환하는 메서드 (getScore : int)
    * 점수를 변경하는 메서드 (setScore : int)

    멤버 목록을 저장할 객체 (멤버 목록) (MemberRepository)
    *
    * 추천 친구를 구할 메서드(getRecommnededFriendList)
    * 해당 이름을 가지는 객체를 반환하는 메서드 (getMember : Member)
        -> 만약 목록에 그런 이름을 가지는 멤버 객체가 존재하지 않는 경우 새로 생성해서 반환

    * 전체 멤버 목록을 반환하는 메서드 (getMemberLust)
 */
public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        MemberRepository memberRepository = new MemberRepository();

        Member userMember = memberRepository.getMember(user);

        for(List<String> friendShip : friends){
            Member member1 = memberRepository.getMember(friendShip.get(0));
            Member member2 = memberRepository.getMember(friendShip.get(1));

            member1.addFriend(member2.getName());
            member2.addFriend(member1.getName());
        }

        for(Member member : memberRepository.getMemberList()){
            if(member == userMember)
                continue;

            Set<String> retainFriendSet = new HashSet<String>();
            retainFriendSet.addAll(userMember.getFriendSet());
            retainFriendSet.retainAll(member.getFriendSet());

            member.setScore(retainFriendSet.size() * 10);
        }

        for(String visitor : visitors){
            Member visitedMember = memberRepository.getMember(visitor);
            visitedMember.setScore(visitedMember.getScore() + 1);
        }

        return memberRepository.getRecommendedFriendList(userMember);
    }
}

class MemberRepository{
    Map<String,Member> memberMap = new HashMap<String,Member>();

    public Member getMember(String name){
        if(memberMap.get(name) == null){
            memberMap.put(name, new Member(name));
        }
        return memberMap.get(name);
    }

    public List<Member> getMemberList(){
        return new ArrayList<Member>(memberMap.values());
    }

    public List<String> getRecommendedFriendList(Member user){
        List<Member> memberList = getMemberList();


        memberList.sort((o1, o2) ->  {
            if(o1.getScore() != o2.getScore())
                return o2.getScore() - o1.getScore();
            return o1.getName().compareTo(o2.getName());
        });
        List<Member> filteredRecommendedMemberList = memberList.stream()
                .filter(member -> member.getScore() != 0 && user.getFriendSet().contains(member.getName()) == false)
                .collect(Collectors.toList());

        List<String> filteredRecommendedMemberNameList = new ArrayList<String>();

        for(Member member : filteredRecommendedMemberList){
            filteredRecommendedMemberNameList.add(member.getName());
        }
        return filteredRecommendedMemberNameList;
    }
}

class Member{
    private final String name;
    private Integer score = 0;
    private Set<String> friendSet = new HashSet<>();

    public Member(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public int getScore(){
        return this.score;
    }

    public void setScore(int score){
        this.score = score;
    }

    public Set<String> getFriendSet(){
        return this.friendSet;
    }

    public void addFriend(String name){
        friendSet.add(name);
    }
}
