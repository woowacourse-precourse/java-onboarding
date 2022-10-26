package onboarding;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 *  🚀 기능 명세
    사용자의 정보를 저장할 객체 (이름 / 친구 관계 / 점수)
    * 이름을 반환하는 메서드 (getName : String)
    * 친구 목록을 반환하는 메서드 (getFriendSet : Set)
    * 친구를 추가할 메서드 (addFriend)

    * 점수를 반환하는 메서드 (getScore : int)
    * 점수를 변경하는 메서드 (setScore : int)

    추천 친구를 구할 메서드(getRecommnededFriends)

 */
public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
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
