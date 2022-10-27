package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
//A와 B는 친구
//입력된 유저와 친구는 아니지만,

//같이 알고있는 사람이 있다면 +10점
//방문횟수 + 1점

//필요한 기능 목록 -> 유저의 친구 찾기
//유저의 친구 목록에 있는 사람 result에서 제외
//유저의 친구의 친구를 찾고, 그 유저에게 + 10점
//방문자들은 +1점
public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        List<String> myFriends = findMyFriends(user,friends);
        List<String> visitorNotMyFriend = getVisitorsNotMyFriend(visitors,myFriends);
        HashMap<String,Integer> visitorsNotMyFriendPoints =  getVisitorsNotMyFriendPoints(visitorNotMyFriend,myFriends);

        return answer;
    }
//입력된 유저의 친구 목록을 구해야함 - findMyFriends
    public static List<String> findMyFriends(String user, List<List<String>> friends){
        List<String> result = new ArrayList<String>();

        for(int i = 0; i<friends.size(); i++){
            if(friends.get(i).indexOf(user)==0){
                result.add(friends.get(i).get(1));
                continue;
            }
            if(friends.get(i).indexOf(user)==1) {
                result.add(friends.get(i).get(0));
            }

        }
        System.out.println(result);
        return result;

    }

    public static HashMap<String,Integer> getFriendsFriendAndPoints(List<String> myFriend, String user){

    }

//입력된 방문자 목록과 횟수
    public static HashMap<String,Integer> getVisitorsNotMyFriendPoints(List<String> visitors,List<String> myFriends){
        List<String> visitorsNotMyFriend = getVisitorsNotMyFriend(visitors,myFriends);


        HashMap<String,Integer> result = new HashMap<String,Integer>();

        for(int i =0 ;i<visitorsNotMyFriend.size(); i++){
            Integer prevVisitNum = result.get(visitorsNotMyFriend.get(i));
            if (prevVisitNum!=null){
                result.put(visitors.get(i),prevVisitNum+1);
                continue;
            }
            result.put(visitors.get(i),1);
        }
        return result;
    }
    //방문자중 내 친구가 아닌 사람을 찾는 함수
    public static List<String> getVisitorsNotMyFriend(List<String> visitors,List<String> myFriends){
        List<String> result = new ArrayList<String>();
        result.addAll(visitors);
        System.out.println(myFriends.get(0));

        result.removeAll(myFriends);

        System.out.println(result);
        return visitors;
    }
}
