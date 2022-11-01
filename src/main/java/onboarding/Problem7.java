package onboarding;

import java.util.*;
import java.util.stream.Collectors;

/*
*   구현 기능
*   1. user의 친구 리스트 만드는 기능
*   2. 친구의 친구 찾는 기능
*   3. 관계를 기반으로 점수 부여하는 기능
*   4. 방문 여부를 기반으로 점수를 부여하는 기능
*   5. 추천 친구 리스트를 만들어 주는 기능
*   6. 추천 리스트 정렬 기능
*/
public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer;
        List<String> userfriends= findUserFrinds(user,friends);
        List<String> friendsofuserfriend = findFoF(user, userfriends, friends);

        Map<String,Integer> nameandscore = new HashMap<>();
        nameandscore = scoreByRelation(nameandscore,friendsofuserfriend);
        nameandscore = scoreByVisit(nameandscore, visitors, userfriends);

        answer = getRecommendList(nameandscore);

        return answer;
    }
    public static String findMyFriends( String myname, List<String> friends){
        String myfriend = "";
        if(friends.contains(myname)){
            if(friends.get(0).equals(myname)) {
                myfriend= friends.get(1);
            }
            else if(friends.get(1).equals(myname)){
                myfriend = friends.get(0);
            }
        }
        return myfriend;
    }

    public static List<String> findUserFrinds(String user, List<List<String>> friends){
        List<String> userfriends= new ArrayList<>();
        for (List<String> friend : friends) {
            String uesrfriend = findMyFriends(user, friend);
            if (!uesrfriend.isEmpty()) {
                userfriends.add(findMyFriends(user, friend));
            }
        }
        return userfriends;
    }

    public static List<String> findFoF(String user, List<String> userfriends, List<List<String>> friends){
        List<String> freindoffriend = new ArrayList<>();
        for (String userfriend : userfriends) {
            for (List<String> friend : friends) {
                if (!friend.contains(user)) {
                    String myfreind = findMyFriends(userfriend, friend);
                    if (!myfreind.isEmpty()) {
                        freindoffriend.add(myfreind);
                    }
                }
            }
        }
        return freindoffriend;
    }

    public static Map<String,Integer> scoreByRelation(Map<String,Integer> nameMap, List<String>fof){
        Map<String,Integer> result = nameMap;
        for (String s : fof) {
            if (!nameMap.containsKey(s)) {
                nameMap.put(s, 10);
            } else if (nameMap.containsKey(s)) {
                int score = nameMap.get(s);
                nameMap.put(s, score + 10);
            }
        }
        return result;
    }

    public static Map<String, Integer> scoreByVisit(Map<String,Integer> nameMap,List<String> visitors, List<String> friendsList){
        Map<String,Integer> result = nameMap;
        for (String visitorname : visitors) {
            if (!friendsList.contains(visitorname)) {
                if (!result.containsKey(visitorname)) {
                    result.put(visitorname, 1);
                } else if (result.containsKey(visitorname)) {
                    int score = result.get(visitorname);
                    result.put(visitorname, score + 1);
                }
            }
        }
        return result;
    }

    public static List<String> getRecommendList(Map<String, Integer> nameandscore ){
        List<Map.Entry<String,Integer>> sortedbyscore = nameandscore.entrySet()
                .stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toList());

        return orderByAlpha(sortedbyscore);
    }

    public static List<String> orderByAlpha(List<Map.Entry<String, Integer>> entry){
        List<String> result = new ArrayList<>();
        List<String> tmp;
        for (int i=0; i<entry.size()-1; i++) {
            int j=1;
            if(!result.contains(entry.get(i).getKey())) {
                tmp = new ArrayList<>();
                tmp.add(entry.get(i).getKey());
                if(entry.get(i).getValue() == entry.get(i+j).getValue() ) {
                    while (entry.get(i).getValue() == entry.get(i + j).getValue()) {
                        tmp.add(entry.get(i + j).getKey());
                        j++;
                        if( i+j == entry.size()){
                            break;
                        }
                    }
                    tmp.sort(Comparator.naturalOrder());
                }
                else if(entry.get(i).getValue() != entry.get(i+j).getValue()){
                    tmp.add(entry.get(i + j).getKey());
                }
                if(i+j == entry.size()-1){
                    tmp.add(entry.get(i + j).getKey());
                }
                for (String name : tmp) {
                    if(result.size()<5) {
                        result.add(name);
                    }
                }
            }
        }
        return result;
    }
}
