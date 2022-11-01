package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class Problem7 {

    public static List<String> solution(String user, List<List<String>> friends,
        List<String> visitors) {
        List<String> answer = Collections.emptyList();

        return answer;
    }

    //친구 관계 정보를 이용하여 각 유저별 친구목록을 만드는 기능
    public static HashMap<String, Set<String>> getFriendList(List<List<String>> friends) {
        //이름,친구목록 을 가지는 HashMap 생성
        HashMap<String, Set<String>> friendList = new HashMap<>();
        //친구목록을 생성해주는 부분
        for (List<String> currentFriendshipInfo : friends) {
            String friendA = currentFriendshipInfo.get(0);
            String friendB = currentFriendshipInfo.get(1);
            if (!friendList.containsKey(friendA)) {
                Set<String> tempSet = new HashSet<>();
                tempSet.add(friendB);
                friendList.put(friendA, tempSet);
            }
            if (!friendList.containsKey(friendB)) {
                Set<String> tempSet = new HashSet<>();
                tempSet.add(friendA);
                friendList.put(friendB, tempSet);
            }
            //A와 B가 친구라면 , B와 A도 친구이므로 각각 서로를 친구목록에 추가해준다.
            friendList.get(friendA).add(friendB);
            friendList.get(friendB).add(friendA);
        }

        return friendList;
    }


    //방문목록을 이용하여 방문한 유저의 추천 포인트를 증가시키는 기능 추가
    public static void addVisitPoint(HashMap<String, Integer> pointList,
        List<String> visitors) {
        //방문자에 대해 추천점수 1을 증가시켜준다.
        for (String visitor : visitors) {
            //추천점수 Map에 없는 유저라면 추가해준다.
            if (!pointList.containsKey(visitor)) {
                pointList.put(visitor, 0);
            }
            pointList.put(visitor, pointList.get(visitor) + 1);
        }
    }

    //user와 같은 친구를 가지고 있는 사용자에게 추천점수를 부여하는 기능 추가
    public static void addSameFriendPoint(String user,
        List<List<String>> friends, HashMap<String, Set<String>> friendList,
        HashMap<String, Integer> pointList) {
        List<String> userFriendsList = new ArrayList<>(friendList.get(user)); //user의 친구목록 리스트

        //모든 사용자의 친구목록에 대해 검사하고 user와 같은 친구를 가진다면 10점을 부여한다.
        for (String friend : friendList.keySet()) {
            if (friend.equals(user)) { //user의 친구목록은 살펴보지않는다.
                continue;
            }
            //user와 같은 친구를 가진다면 10점을 부여한다.
            for (String userFriend : userFriendsList) {
                if (friendList.get(friend).contains(userFriend)) {
                    pointList.put(friend, pointList.get(friend) + 10);
                }
            }
        }

        //이미 user와 친구인 사용자들은 제거해준다.
        for (String userFriend : userFriendsList) {
            pointList.remove(userFriend);
        }

    }


}
