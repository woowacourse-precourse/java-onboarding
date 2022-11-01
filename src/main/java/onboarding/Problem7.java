package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        HashMap<String, HashSet<String>> userInfo = createUserInfo(friends);

        HashSet<String> people0 = new HashSet<>(userInfo.keySet());
        HashSet<String> people1 = new HashSet<>(visitors);
        HashSet<String> mergedPeopleSet = new HashSet<String>();
        mergedPeopleSet.addAll(people0);
        mergedPeopleSet.addAll(people1);
        List<String> mergedPeopleList = new ArrayList<>(mergedPeopleSet);

        HashMap<String, Integer> pointInfo = createPointInfo(mergedPeopleList);

        pointInfo = givePointUsingFriendRelationship(user, userInfo, pointInfo);
        pointInfo = givePointUsingVisitorList(userInfo.get(user), visitors, pointInfo);


        return answer;
    }

    private static HashMap<String, HashSet<String>> createUserInfo(List<List<String>> friends) {
        HashMap<String, HashSet<String>> userInfo = new HashMap<String, HashSet<String>>();
        for (List<String> pair : friends) {
            String people0 = pair.get(0);
            String people1 = pair.get(1);
            if (userInfo.containsKey(people0)) {
                userInfo.get(people0).add(people1);
            } else {
                HashSet<String> temp = new HashSet<String>();
                temp.add(people1);
                userInfo.put(people0, temp);
            }
            if (userInfo.containsKey(people1)) {
                userInfo.get(people1).add(people0);
            } else {
                HashSet<String> temp = new HashSet<String>();
                temp.add(people0);
                userInfo.put(people1, temp);
            }
        }
        return userInfo;
    }

    private static HashMap<String, Integer> createPointInfo(List<String> people) {
        HashMap<String, Integer> pointInfo = new HashMap<String, Integer>();

        for (String p : people) {
            pointInfo.put(p, 0);
        }
        return pointInfo;
    }

    private static HashMap<String, Integer> givePointUsingFriendRelationship(String user, HashMap<String, HashSet<String>> userInfo, HashMap<String, Integer> pointInfo) {
        HashSet<String> friendOfUser = userInfo.get(user);
        for (String name : userInfo.keySet()) {
            // 본인이거나 서로 친구이지 않은 경우
            if (name != user && !(friendOfUser.contains(name))) {
                for (String n : userInfo.get(name)) {
                    if (friendOfUser.contains(n)) {
                        int point = pointInfo.get(name) + 10;
                        pointInfo.put(name, point);
                    }
                }
            }
        }
        return pointInfo;
    }

    private static HashMap<String, Integer> givePointUsingVisitorList(HashSet<String> friends, List<String> visitors, HashMap<String, Integer> pointInfo) {
        for (String visitor : visitors) {
            if (!friends.contains(visitor)) {
                int point = pointInfo.get(visitor) + 1;
                pointInfo.put(visitor, point);
            }
        }

        return pointInfo;
    }
//    private static List<String> findFriendsList(HashMap<String, Integer> pointInfo){
//
//    }
//    private static HashMap<String, Integer> deleteZero(HashMap<String, Integer> pointInfo){
//        return pointInfo;
//    }
}
