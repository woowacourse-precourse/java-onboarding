package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/*
- 기능 구현사항 목록 -
1. 친구 목록 해쉬맵 만들기
2. user 와 이미 친구인 사람 목록 만들기 (나중에 해쉬맵에서 제거할 목록)
3. 점수 측정 -> value 값으로 정렬후 5명으로 자르기
 */
public class Problem7 {

    static List<String> standard = new ArrayList<>();
    static HashMap<String,Integer> friendList = new HashMap<>();

    private static void listOfPeople(List<List<String>> friends, List<String> visitors){
        for(List<String> relate : friends) {
            for(int i = 0; i < 2; i++) {
                friendList.put(relate.get(i), 0);
            }
        }
        for (String who : visitors) {
            friendList.put(who, 0);
        }
    }

    private static void makeStandard(String user, List<List<String>> friends) {
        for(List<String> relate : friends) {
            if (relate.contains(user)){
                List<String> list = new ArrayList<>(relate);
                list.remove(user);
                standard.add(list.get(0));
            }
        }
    }

    private static void knowTogather(String user, List<List<String>> friends) {
        for (List<String> relate : friends) {
            for (String j : standard) {
                if (relate.contains(j) && !relate.contains(user)) {
                    List<String> list2 = new ArrayList<>(relate);
                    list2.remove(j);
                    friendList.put(list2.get(0), friendList.get(list2.get(0))+10);
                }
            }
        }
    }
    
    private static void whoVisited(List<String> visitors) {
        for(String who : visitors){
            friendList.put(who, friendList.get(who)+1);
        }
    }

    private static void colanderZero(HashMap<String, Integer> new_dic) {
        for(String key : friendList.keySet()){
            if(friendList.get(key) > 0) {
                if(!standard.contains(key)) new_dic.put(key, friendList.get(key));
            }
        }
    }

    private static void sortByScore(HashMap<String, Integer> new_dic) {
        List<String> listKeySet = new ArrayList<>(new_dic.keySet());
        listKeySet.sort((value1, value2) -> (new_dic.get(value2).compareTo(new_dic.get(value1))));
    }
    
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        HashMap<String,Integer> new_dic = new HashMap<>();

        listOfPeople(friends, visitors);

        makeStandard(user, friends);

        knowTogather(user, friends);

        whoVisited(visitors);

        colanderZero(new_dic);

        sortByScore(new_dic);

        return new ArrayList<>(new_dic.keySet());
    }

}
