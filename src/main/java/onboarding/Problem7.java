package onboarding;

import java.util.*;

public class Problem7 {
    private static List<String> createUserFriends(String user, List<List<String>> friends){
        List<String> userFriends = new ArrayList<>();

        for(int i = 0; i < friends.size(); i++){
            if(friends.get(i).get(0) == user)
                userFriends.add(friends.get(i).get(1));
            else if(friends.get(i).get(1) == user)
                userFriends.add(friends.get(i).get(0));
        }

        return userFriends;
    }

    private static List<String> createUserFriendFriends(String user, List<String> userFriends, List<List<String>> friends){
        List<String> userFriendFriends = new ArrayList<>();

        for(int i = 0; i < userFriends.size(); i++){
            for(int j = 0; j < friends.size(); j++){
                if(userFriends.get(i) == friends.get(j).get(0))
                    userFriendFriends.add(friends.get(j).get(1));
                else if(userFriends.get(i) == friends.get(j).get(1))
                    userFriendFriends.add(friends.get(j).get(0));
            }
        }

        if(userFriendFriends.contains(user)){
            userFriendFriends.remove(user);
        }

        return userFriendFriends;
    }

    private static HashMap<String, Integer> createPoints(String user, List<String> userFriends, List<String> userFriendFriends, List<String> visitorList){
        HashMap<String, Integer> points = new HashMap<>();

        for(int i = 0; i < userFriendFriends.size(); i++){
            if(points.containsKey(userFriendFriends.get(i)))
                points.put(userFriendFriends.get(i), points.get(userFriendFriends.get(i)) + 10);
            else
                points.put(userFriendFriends.get(i), 10);
        }

        for(int i = 0; i < visitorList.size(); i++){
            if(points.containsKey(visitorList.get(i)))
                points.put(visitorList.get(i), points.get(visitorList.get(i)) + 1);
            else
                points.put(visitorList.get(i), 1);
        }

        for(int i = 0; i < userFriends.size(); i++){
            if(points.containsKey(userFriends.get(i)))
                points.remove(userFriends.get(i));
        }

        if(points.containsKey(user)){
            points.remove(user);
        }

        return points;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        List<String> userFriends = createUserFriends(user, friends);
        List<String> userFriendFriends = createUserFriendFriends(user, userFriends, friends);
        HashMap<String, Integer> points = createPoints(user, userFriends, userFriendFriends, visitors);

        List<Map.Entry<String, Integer>> sortedPoints = new ArrayList<>(points.entrySet());
        sortedPoints.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        sortedPoints.forEach(System.out::println);

        for(int i = 0; i < sortedPoints.size(); i++) {
            if (points.get(sortedPoints.get(i).getKey()) != 0 && answer.size() < 5)
                answer.add(Objects.toString(sortedPoints.get(i).getKey()));
            else
                break;
        }

        return answer;
    }
}
