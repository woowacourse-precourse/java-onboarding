package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, Integer> map = new HashMap<>();
        List<String> answer = new ArrayList<>();
        List<String> usersFriend = new ArrayList<>();
        List<String> notFriends = new ArrayList<>();

        // usersFriend: 유저의 친구 리스트 -> answer에서 제외
        for(int i=0; i<friends.size(); i++){
            int friend = -1;
            for(int j=0; j<friends.get(i).size(); j++){
                if(friends.get(i).get(j).contains(user)){
                    if(friends.get(i).indexOf(user) == 0){
                        friend = 1;
                    }
                    else{
                        friend = 0;
                    }
                    usersFriend.add(friends.get(i).get(friend));
                }
            }

        }

        // 친구 여부 확인 -> 친구는 제외, 친구의 친구만
        for (List<String> friend: friends){         // friends 리스트 중
            for (String notFriend: notFriends) {
                if (friend.get(0).equals(notFriend)) {      // 친구가 아닌 경우 notFriends에 추가
                    notFriends.add(friend.get(1));
                    if (!map.containsKey(friend.get(1))) { //add
                        map.put(friend.get(1), 0);
                    }
                    int prev = map.get(friend.get(1));
                    System.out.println("친구가 아닌 사이: " + friend.get(1));
                    map.replace(friend.get(1), prev + 10);
                }
                if (friend.get(1).equals(notFriend)) {
                    notFriends.add(friend.get(0));
                    if(!map.containsKey(friend.get(0))){
                        map.put(friend.get(0), 0);
                    }
                    int prev2 = map.get(friend.get(0));
                    System.out.println("친구가 아닌 사이: "+friend.get(0));
                    map.replace(friend.get(0), prev2+10);
                }

            }
        }

        // 친구가 아닌 사이는 +10점
        for(String notFriend: notFriends){
            int prev = map.get(notFriend);
            System.out.println("친구가 아닌 사이: "+notFriend);
            map.put(notFriend, prev+10);
        }

        // 방문자는 +1점
        for(int i=0; i<visitors.size(); i++){
            for(int j=0; j<usersFriend.size(); j++){
                if(!visitors.get(i).contains(usersFriend.get(j))){                // 유저의 친구가 아니라면
                    if(!map.containsKey(visitors.get(i))){ //add
                        map.put(visitors.get(i),0);
                    }
                    map.replace(visitors.get(i), map.get(visitors.get(i))+1);
                    break;
                }
            }
        }


        // 방문자는 +1점
        /*for(String visit: visitors){
            int prev = map.get(visit);
            map.put(visit, prev+1);
        }*/

        // 점수 계산
        map.remove(user);
        for (String userFriend: usersFriend) map.remove(userFriend);
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(map.entrySet());
        int i = 0;
        for (Map.Entry<String, Integer> entry : entryList) {
            if (i == 5) break;
            answer.add(entry.getKey());
            i++;
        }

        for (String key : map.keySet()) {
            System.out.println("[key]:" + key + ", [value]:" + map.get(key));
        }
        //answer.addAll(map.keySet());

        return answer;
    }
}
