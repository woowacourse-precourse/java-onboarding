package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        relation = new HashMap<>();

        List<String> myFriendList = new ArrayList<>();
        List<List<String>> friendsGraph = new ArrayList<>();
        for (List<String> friendPair : friends){
            if (friendPair.contains(user)){ // user가 있는 경우
                myFriendList.add(getAnotherOne(friendPair,user)); // 친구 리스트에 친구명 추가
            } else { // user 없는 경우
                friendsGraph.add(friendPair); // 그래프에 쌍 추가
            }
        }

        for(String myFriend : myFriendList){
            for(List<String> friendPair : friendsGraph){
                if (friendPair.contains(myFriend)){
                    String addPointName = getAnotherOne(friendPair, myFriend);
                    addRelationPoint(addPointName, 10);
                }
            }
        }

        for (String visitor : visitors){
            if(!myFriendList.contains(visitor))
                addRelationPoint(visitor, 1);
        }

        // key만 모아오기
        answer = new ArrayList<>(relation.keySet());
        // 정렬
        answer.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return relation.get(o1).compareTo(relation.get(o2));
            }
        });
        return answer;
    }

    private static Map<String,Integer> relation;
    private static void addRelationPoint(String name, int point){
        if (relation.containsKey(name)) // 있는지 찾고
            relation.put(name, relation.get(name)+10); // 있으면 점수 더하기
        else
            relation.put(name, 10); // 없으면 새로 추가하기
    }
    private static String getAnotherOne(List<String> twoList, String name){
        if (twoList.get(0).equals(name))
            return twoList.get(1);
        else
            return twoList.get(0);
    }

}
