package onboarding;

import java.util.*;

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
    * 추천 친구를 구할 메서드(getRecommnededFriends)
    * 해당 이름을 가지는 객체를 반환하는 메서드 (getMember : Member)
        -> 만약 목록에 그런 이름을 가지는 멤버 객체가 존재하지 않는 경우 새로 생성해서 반환

    * 전체 멤버 목록을 반환하는 메서드 (getAllMembers)
 */
public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        for(List<String> friendShip : friends){

        }

        return answer;
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
}

class Member{
    private final String name;
    private Integer score;
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
