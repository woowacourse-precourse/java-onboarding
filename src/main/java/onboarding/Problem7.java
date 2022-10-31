package onboarding;

import java.util.*;
import java.util.Collection;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        // 1. 친구 목록 만들기
        // 2. 친구의 친구 목록만들기 -> 추천친구에 무조건추가
        // 3. 방문자 확인하기 -> 친구만아니면 추천친구에 추가하기

        // 친구 목록만들기 -> 친구의 친구 목록만들기 -> 추천친구에 무조건추가 +10
        // 친구 목록만들기 -> 방문자 친구만들기 -> 친구만 아니면 추천친구에 추가 +1

        // 추천 친구목록에는 친구의친구만 추가되어있음
        

        Map<String, Integer> list = visitorCalculate(user, friends, visitors);
        // 값 정렬하기
        List<String> answer = new ArrayList<>(list.keySet());
        answer.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return list.get(o1).compareTo(list.get(o2));
            }
        });
        Collections.sort(answer);

        // answer이 5이상의 데이터를 가지고있으면 나머지는 삭제하기
        if(answer.size()>5) {
            for (int i = answer.size() - 1; i > 4; i--) {
                answer.remove(i);
            }
        }

        return answer;
    }

    public static Set friendsList(String user, List<List<String>> friends){ // mrko 친구
        // 친구목록만들기
        //  1번 값이 mrko면 0번값을 친구목록에 저장
        Set friendsSet = new HashSet();
        for (int i =0; i<friends.size();i++){
            String left = friends.get(i).get(0);
            String right = friends.get(i).get(1);
            if(right.equals(user))friendsSet.add(left);
        }

        return friendsSet;

    }
    public static Map friendsfriendsList(Set friendsSet, String user, List<List<String>> friends){ // mrko 친구의 친구
        // 받아온 친구목록이랑 0번값이 친구면 친구의친구 -> 추천친구에 무조건 추가 +10
        Map<String, Integer> recommendedFriend = new HashMap<>();
        for (int i =0; i<friends.size();i++){
            String left = friends.get(i).get(0);
            String right = friends.get(i).get(1);
            if(!friendsSet.add(left) && !right.equals(user))recommendedFriend.put(right, recommendedFriend.getOrDefault(right,0)+10);
        }
        return recommendedFriend;
    }
    public static Map visitorCalculate(String user, List<List<String>> friends, List<String> visitors){
        // 친구목록이랑 방문자 친구 비교해서 친구 아니면 추천친구에 +1
        Set friendsSet = friendsList(user,friends);
        Map<String, Integer> recommendedFriend = friendsfriendsList(friendsSet,user,friends);

        for(String s :visitors){// 방문자의 수 체크하기
            if(friendsSet.add(s)){
                // 이미 친구 추천에 있는경우 방문했으니 +1
                if(recommendedFriend.containsKey(s))recommendedFriend.put(s,recommendedFriend.getOrDefault(s,0)+1);
            }
            else { // visitors와 친구리스트를 비교해서 친구 아니면 +1
                recommendedFriend.put(s,recommendedFriend.getOrDefault(s,0)+1);}
        }

        return recommendedFriend;
    }


    }




