package onboarding;

import java.util.List;
import java.util.*;
import java.util.HashMap;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        Set<String> trueFriends = trueFriends(user, friends);

        HashMap<String, Integer> featuredMap = featuredFriends(user, friends, trueFriends);
        HashMap<String, Integer> visitorMap = visitorsPeople(visitors, trueFriends);

        featuredMap.putAll(visitorMap);

        List<String> sortList = new ArrayList<>(featuredMap.keySet());
        Collections.sort(sortList);
        sortList.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return featuredMap.get(o2).compareTo(featuredMap.get(o1));
            }
        });
        //5명까지만 추천하기
        if (sortList.size() <= 5) answer.addAll(sortList);
        else if (sortList.size() > 5) {
            for (int i = 0; i < 5; i++) {
                answer.add(sortList.get(i));
            }
        }
        return answer;
    }
    //user의 친구 구하기
    public static Set<String> trueFriends(String user, List<List<String>> friends) {
        Set<String> result = new HashSet<String>();
        for (int i = 0; i < friends.size(); i++) {

            if (user.equals(friends.get(i).get(0))) {
                result.add(friends.get(i).get(1));
            }
            if (user.equals(friends.get(i).get(1))) {
                result.add(friends.get(i).get(0));
            }
        }
        System.out.println(result);
        return result;
    }

    //friends 중 함께 아는 친구 구하고 +10 계산하기
    public static HashMap<String, Integer> featuredFriends(String user,List<List<String>>friends, Set<String>trueFriends){
        String[] trueList = trueFriends.toArray(new String[trueFriends.size()]);
        List<String> friendsAndNot = new ArrayList<String>();

        //user가 들어간 list 제외하고, 친구가 포함된 list만 저장
        for(List<String> friend : friends){
            if(user.equals(friend.get(0)) || user.equals(friend.get(1))) continue;
            else for(int i=0; i<trueList.length; i++){
                if(trueList[i].equals(friend.get(0))){
                    friendsAndNot.add(friend.get(1));
                } else if(trueList[i].equals(friend.get(1))){
                    friendsAndNot.add(friend.get(0));
                }
            }
        }

        List<String> trueFriendList = new ArrayList<>(trueFriends);
        // 방문자 리스트 중 친구 제외
        List<String> recommendList = new ArrayList<>();
        recommendList.addAll(friendsAndNot);
        recommendList.removeAll(trueFriendList);

        HashMap<String, Integer> result = new HashMap<String, Integer>();
        for (int i = 0; i < recommendList.size(); i++) {
            Integer count = result.get(recommendList.get(i));
            if (count == null) result.put(recommendList.get(i), 10);
            else result.put(recommendList.get(i), count + 10);
        }
        return result;
    }
    //방문자 목록 정리, +1계산
    public static HashMap<String, Integer> visitorsPeople(List<String> visitors, Set<String> trueFriends) {
        List<String> trueFriendList = new ArrayList<>(trueFriends);
        // 방문자 리스트 중 친구 제외
        List<String> visitorsList = new ArrayList<>();
        visitorsList.addAll(visitors);
        visitorsList.removeAll(trueFriendList);

        //계산하기 +1
        HashMap<String, Integer> result = new HashMap<String, Integer>();
        for (int i = 0; i < visitorsList.size(); i++) {
            Integer count = result.get(visitorsList.get(i));
            if (count == null) result.put(visitorsList.get(i), 1);
            else result.put(visitorsList.get(i), count + 1);
        }

        return result;
    }
}
