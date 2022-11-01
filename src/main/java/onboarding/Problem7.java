package onboarding;

import java.util.*;

public class Problem7 {
    static TreeMap<String, Integer> treemap = new TreeMap<>();
    static ArrayList<String> friend_lis = new ArrayList<>();

    static ArrayList<String> common_friend_lis = new ArrayList<>();
    public static void Friend_find(String user, String friend, List<List<String>> friends){
        for (List i : friends) {
            if (i.get(0) == friend && i.get(1) != user) {
                String common_friend = i.get(1).toString();
                common_friend_lis.add(common_friend);
            } else if (i.get(1) == friend && i.get(0) != user) {
                String common_friend = i.get(0).toString();
                common_friend_lis.add(common_friend);
            }
        }


    }

    public static ArrayList<String> solution(String user, List<List<String>> friends, List<String> visitors) {
//        List<String> answer = Collections.emptyList();
//        return answer;
        for (List i : friends){
            if (i.get(0)==user){
//                friends 이중리스트에서 나랑 친구 찾기
                String friend = i.get(1).toString(); // .toString()이 될지 모르겠다.
                friend_lis.add(friend);
                Friend_find(user,friend, friends);

            }else if(i.get(1)==user){
                String friend = i.get(0).toString();
                friend_lis.add(friend);
                Friend_find(user, friend, friends);

            }
        }
        for (String k : common_friend_lis) {
            if (treemap.get(k) == null) { // 공통 친구가 해시맵에 없다면 새롭게 추가
                treemap.put(k, 10);
            } else {  // 있으면 기존 값에  10더하기
                treemap.put(k, treemap.get(k) + 10);
            }
        }



        for (String j : visitors){
            if(!friend_lis.contains(j)) { // 친구리스트에 해당 방문자가 없을때
                if (treemap.get(j) == null) { // 공통 친구가 해시맵에 없다면 새롭게 추가
                    treemap.put(j, 1);
                } else {  // 있으면 기존 값에  10더하기
                    treemap.put(j, treemap.get(j) + 1);
                }
            }
        }
//        여기까지 친구 추천 트리맵을 만들었음!!!!!!


        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(treemap.entrySet());
        Collections.sort(entryList, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> obj1, Map.Entry<String, Integer> obj2){
                return obj2.getValue().compareTo(obj1.getValue());
            }
        });

        ArrayList<String> recommend_friend_lis = new ArrayList<>();

        for(Map.Entry<String, Integer> entry:entryList){
            String recommend_friend = entry.getKey();
            recommend_friend_lis.add(recommend_friend);

        }
        return recommend_friend_lis;
    }
}
