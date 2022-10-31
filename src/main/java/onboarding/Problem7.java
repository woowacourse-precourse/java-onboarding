package onboarding;

import java.util.*;
import java.util.function.Predicate;

public class Problem7 {
    public static int ACQUAINTANCE_POINT = 10;
    public static int VISITOR_POINT = 1;
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {


        Set<String> userFriend = findUserFriends(user, friends);
        Map<String,List<String>> friendMap = makeFriendMap(userFriend, friends);

        HashMap<String,Integer> recommendMap = new HashMap<>();
        recommendAcquaintance(friendMap, recommendMap);
        recommendVisitors(visitors, userFriend, recommendMap);


        return makeRecommendList(recommendMap);
    }


    //유저의 친구관계 알아내기
    public static Set<String> findUserFriends(String user, List<List<String>> friends) {
        Set<String> userFriend = new HashSet<>();
        for (List<String> f : friends) {         //user이름 포함되면 set에 넣기
            if (f.contains(user)) {
                userFriend.add(f.get(0));
                userFriend.add(f.get(1));
            }
        }
        return userFriend;
    }

    //친구의 친구관계 리스트 만들기
    public static List<String> makeFriendList(Set<String> userFriend, String friend, List<List<String>> friends) {
        ArrayList<String> friendList = new ArrayList<>();

        for(List<String> list : friends){
            if (list.get(0).equals(friend) && !userFriend.contains(list.get(1))) friendList.add(list.get(1));
            if (list.get(1).equals(friend) && !userFriend.contains(list.get(0))) friendList.add(list.get(0));
        }
        return friendList;
    }

    //친구 맵 만들기
    public static Map<String,List<String>> makeFriendMap(Set<String> userFriends, List<List<String>> friends){
        Map<String,List<String>> friendMap = new HashMap<>();
        for (String friend : userFriends){
            List<String> friendList =  makeFriendList(userFriends, friend, friends);
            friendMap.put(friend,friendList);  //수정필요. 친구와, 친구관계로 ->친구 리스트 만들기
        }
        return friendMap;
    }


    //추천리스트에 아는 사이 넣기 : (유저) 프랜드 맵 순회하면서 VALUE꺼내서, 추천리스트에 넣고 점수주기
    public static void recommendAcquaintance(Map<String,List<String>> friendMap, HashMap<String,Integer> recommendMap){
        for(Map.Entry<String,List<String>> e : friendMap.entrySet()){
            for(String person : e.getValue()){
                if (recommendMap.containsKey(person)){
                    recommendMap.replace(person, recommendMap.get(person)+10);
                }else recommendMap.put(person, 10);
            }
        }
    }


    //추천리스트에 방문 횟수 넣기.
    public static void recommendVisitors(List<String> visitors, Set<String> userFriends, HashMap<String,Integer> recommendMap){

        for(String visitor : visitors){
            if (userFriends.contains(visitor)) continue;
            if (recommendMap.containsKey(visitor)){
                recommendMap.replace(visitor, recommendMap.get(visitor)+1);
            }else recommendMap.put(visitor,1);
        }

    }

    //추천 리스트 정렬하기
    public static List<String> makeRecommendList(HashMap<String,Integer> recommendMap) {
        List<String> recommendList = new ArrayList<>();
        System.out.println(recommendMap);
        recommendMap.entrySet().stream()
                .sorted(new Comparator<Map.Entry<String, Integer>>() {
                    @Override
                    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                        if(o1.getValue().equals(o2.getValue())){
                            return o1.getKey().compareTo(o2.getKey());
                        }
                        return o2.getValue() - o1.getValue();
                    }
                })
                .filter(new Predicate<Map.Entry<String, Integer>>() {
                    @Override
                    public boolean test(Map.Entry<String, Integer> stringIntegerEntry) {
                        if (stringIntegerEntry.getValue() >0) return true;
                        return false;
                    }
                })
                .forEach(e->recommendList.add(e.getKey())); //collect(Collectors.toList ->

        if(recommendList.size()>5) return recommendList.subList(0,5);
        return recommendList;

    }

}