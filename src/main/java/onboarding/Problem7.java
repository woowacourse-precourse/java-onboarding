package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        //친구 리스트
        List<String> friendList = new ArrayList<>();
        friendList.add(user);
        //모든 사람 리스트
        Set<String> peopleList = new HashSet<>();
        //점수판
        HashMap<String, Integer> friendPoint = new HashMap<>();

        collectAllPeopleAndUserFriends(user, friends, visitors, friendList, peopleList);

        gradeScore(friends, visitors, friendList, peopleList, friendPoint);

        List<String> answer = Collections.emptyList();
        return answer;
    }

    private static void gradeScore(List<List<String>> friends, List<String> visitors, List<String> friendList, Set<String> peopleList, HashMap<String, Integer> friendPoint) {
        for (String people : peopleList) {
            friendPoint.put(people, 0);
        }

        //리스트로 10점 계산
        for (List<String> friend : friends) {
            if(friendList.indexOf(friend.get(0))!=-1 &&
                    friendList.indexOf(friend.get(1))== -1 ){
                friendPoint.put(friend.get(1), friendPoint.get(friend.get(1))+10);
            }else if(friendList.indexOf(friend.get(1))!=-1 &&
                    friendList.indexOf(friend.get(0))== -1){
                friendPoint.put(friend.get(0), friendPoint.get(friend.get(0))+10);
            }
        }
        //방문자로 1점 계산
        for (String visitor : visitors) {
            if(friendList.indexOf(visitor)==-1){
                friendPoint.put(visitor, friendPoint.get(visitor)+1);
            }
        }
    }

    private static void collectAllPeopleAndUserFriends(String user, List<List<String>> friends, List<String> visitors, List<String> friendList, Set<String> peopleList) {
        //친구 및 사람 확인
        for (List<String> friend : friends) {
            if(friend.get(0).equals(user) ){
                friendList.add(friend.get(1));
                peopleList.add(friend.get(1));
            }else if(friend.get(1).equals(user)){
                friendList.add(friend.get(0));
                peopleList.add(friend.get(0));
            }else{
                peopleList.add(friend.get(0));
                peopleList.add(friend.get(1));
            }
        }

        //방문자로 사람 확인
        for (String visitor : visitors) {
            peopleList.add(visitor);
        }
    }

}

