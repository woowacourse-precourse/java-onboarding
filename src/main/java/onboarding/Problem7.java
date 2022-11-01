package onboarding;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Problem7 {
    private static HashMap<String, HashSet<String>> getGraphOf(List<List<String>> friends){
        HashMap<String, HashSet<String>> graph = new HashMap<>();
        for(List<String> friend:friends){
            String v1 = friend.get(0);
            String v2 = friend.get(1);

            if(graph.containsKey(v1))
                graph.get(v1).add(v2);
            else
                graph.put(v1, new HashSet<>(Collections.singletonList(v2)));

            if(graph.containsKey(v2))
                graph.get(v2).add(v1);
            else
                graph.put(v2, new HashSet<>(Collections.singletonList(v1)));
        }
        return graph;
    }
    private static HashMap<String, Integer> addPointByVisitor(HashMap<String, Integer> recommend, List<String> visitors){
        //방문자에 대한 1점 추가
        for(String visitor : visitors){
            if(recommend.containsKey(visitor))
                recommend.put(visitor, recommend.get(visitor)+1);
            else
                recommend.put(visitor, 1);
        }
        return recommend;

    }

    private static HashMap<String, Integer> deleteAlreadyFriend(HashMap<String, Integer> recommend, HashMap<String, HashSet<String>> graph, String user){
        HashSet<String> userFriends = graph.get(user);
        for(String friend:userFriends)
            recommend.remove(friend); //이미 친구이면 기존 추천에서 삭제
        return recommend;
    }


    private static HashMap<String, Integer> addPointByFriends(HashMap<String, Integer> recommend, HashMap<String, HashSet<String>> graph, String user){
        HashSet<String> userFriends = graph.get(user);
        for(String friend:userFriends){ //유저의 친구들
            HashSet<String> userFriendsOfFriend = graph.get(friend); //유저의 친구들의 친구들
            for(String friendOfFriend:userFriendsOfFriend){
                if(friendOfFriend.equals(user) || friendOfFriend.equals(friend)) continue;  //이미 친구거나 자기자신이면 넘어감
                if(recommend.containsKey(friendOfFriend))
                    recommend.put(friendOfFriend, recommend.get(friendOfFriend)+10);
                else
                    recommend.put(friendOfFriend, 10);
            }
        }
        return recommend;
    }

    private static List<String> sortRecommend(HashMap<String, Integer> recommend){
        //점수의 역정렬 및 키값에 의한 정렬 후 키값으로 매핑 후 list로 변환, 최대 5개만 반환
        Stream<Map.Entry<String,Integer>> sortedRecommend = recommend.entrySet().stream();
        sortedRecommend = sortedRecommend.sorted(Map.Entry.<String, Integer>comparingByValue().reversed().thenComparing(Map.Entry::getKey));
        Stream<String> keyRecommend = sortedRecommend.map(Map.Entry::getKey);
        List<String> answer = keyRecommend.collect(Collectors.toList());
        return answer.size() <= 5 ? answer : answer.subList(0, 5);
    }


    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        HashMap<String, HashSet<String>> graph = getGraphOf(friends);

        //사용자들 추천 점수 0으로 세팅
        HashMap<String, Integer> recommend = new HashMap<>();
        addPointByVisitor(recommend, visitors);
        deleteAlreadyFriend(recommend, graph, user);
        addPointByFriends(recommend, graph, user);

        return sortRecommend(recommend);
    }
}
