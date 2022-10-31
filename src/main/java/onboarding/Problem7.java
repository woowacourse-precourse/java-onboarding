package onboarding;

import java.util.*;
import java.util.Collections;


class RecommendScore{
    private String name;
    private int score;

    public RecommendScore(String name, int score){
        this.name = name;
        this.score = score;
    }

    public String getName(){
        return name;
    }

    public int getScore(){
        return score;
    }

}
public class Problem7{
    public static List<RecommendScore> AllFriendsList(String user, List<List<String>> friends, List<String> visitors){
        List<RecommendScore> allfriends = new ArrayList<>();
        Set<String> set = new HashSet<>();

        //friends 목록에 있는 유저 아이디 집합에 add
        for(int i = 0; i<friends.size(); i++){
            for(int j = 0; j<2; j++)
                set.add(friends.get(i).get(j));
        }

        //visitors 목록에 있는 유저 아이디 집합에 add
        for(int i = 0; i<visitors.size(); i++){
            set.add(visitors.get(i));
        }

        //user 아이디는 집합에서 제거
        set.remove(user);

        //집합의 원소들(친구들)을 점수를 초기화해서 친구 목록에 저장
        Iterator<String> iter = set.iterator();

        while(iter.hasNext()){
           allfriends.add(new RecommendScore(iter.next(), 0));
        }
        return allfriends;
    }


    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        List<RecommendScore> allList = AllFriendsList(user, friends, visitors);

        return answer;
    }
}
