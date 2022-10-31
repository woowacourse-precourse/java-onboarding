package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    /**
     * 사용자 아이디 user와 친구 관계 정보 friends, 사용자 타임 라인 방문 기록 visitors가 매개변수로 주어질 때,
     * 미스터코의 친구 추천 규칙에 따라 점수가 가장 높은 순으로 정렬하여 최대 5명을 return 하도록 solution 메서드를 완성하라.
     * 이때 추천 점수가 0점인 경우 추천하지 않으며, 추천 점수가 같은 경우는 이름순으로 정렬한다.
     *
     *
     * @param user SNS 사용자의 아이디
     * @param friends 친구관계가 들어있는 리스트
     * @param visitors 사용자의 타임라인을 방문했던 다른사용자들의 아이디
     * @return 최대 5명을 추천 규칙 순으로 정렬한 리스트
     */
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, Set<String>> friendships = new HashMap<>();
        Map<String, Integer> friendshipScore = new HashMap<>();

        for (List<String> friendship : friends) {
            String friend1 = friendship.get(0);
            String friend2 = friendship.get(1);

            if (friendships.containsKey(friend1)) {
                Set<String> friendSet = friendships.get(friend1);
                friendSet.add(friend2);
                friendships.put(friend1, friendSet);
            } else {
                Set<String> friendSet = new HashSet<>();
                friendSet.add(friend2);
                friendships.put(friend1, friendSet);
            }

            if (friendships.containsKey(friend2)) {
                Set<String> friendSet = friendships.get(friend2);
                friendSet.add(friend1);
                friendships.put(friend2, friendSet);
            } else {
                Set<String> friendSet = new HashSet<>();
                friendSet.add(friend1);
                friendships.put(friend2, friendSet);
            }
        }

        //Add friend scores
        Set<String> userDirectFriends = friendships.get(user);
        for (String directFriend:userDirectFriends) {
            Set<String> nonDirectFriends = friendships.get(directFriend);
            for (String nonDirectFriend:nonDirectFriends) {
                if (nonDirectFriend == user || userDirectFriends.contains(nonDirectFriend)) {
                    continue;
                }
                int score;
                if (friendshipScore.containsKey(nonDirectFriend)) {
                    score = friendshipScore.get(nonDirectFriend);
                    score += 10;
                } else {
                    score = 10;
                }
                friendshipScore.put(nonDirectFriend, score);
            }
        }
        
        //Add visitor scores
        for (String visitor:visitors) {
            if (userDirectFriends.contains(visitor)) {
                continue;
            }
            int score;
            if (friendshipScore.containsKey(visitor)) {
                score = friendshipScore.get(visitor);
                score += 1;
            } else {
                score = 1;
            }
            friendshipScore.put(visitor, score);
        }
        //get a list of Entries of the map that are sorted
        List<Map.Entry<String,Integer>> scores = friendshipScore.entrySet().stream()
                //sort in descending order by value
                .sorted(Map.Entry.<String,Integer>comparingByValue().reversed()
                        //sort alphabetically if the values are the same
                        .thenComparing(Map.Entry.comparingByKey()))
                //put entries into a list
                .collect(Collectors.toList());

        List<String> finalResultList = new ArrayList<>();
        //get the keys from the entries and add to a new list
        int count = 1;
        for (Map.Entry<String,Integer> entry: scores) {
            //maximum 5 entries
            if (count>5) {
                break;
            }
            finalResultList.add(entry.getKey());
            count += 1;
        }
        //return the sorted list
        return finalResultList;
    }

}
