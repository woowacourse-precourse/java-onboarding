package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, Integer> map = new HashMap<>();     // (이름, 추천점수)
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

        // 친구가 아닌 사이 +10점
        for (List<String> friend: friends){         // friends 리스트 중
            for (String notFriend: notFriends) {
                System.out.println(notFriend);
                if (friend.get(0).contains(notFriend)) {      // 친구가 아닌 경우 notFriends에 추가
                    notFriends.add(friend.get(1));
                    if (!map.containsKey(friend.get(1))) { //add
                        map.put(friend.get(1), 0);
                    }
                    int prev = map.get(friend.get(1));
                    System.out.println("친구가 아닌 사이: " + friend.get(1));
                    map.replace(friend.get(1), prev + 10);
                }
                if (friend.get(1).contains(notFriend)) {
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

        // 점수 계산
        for (String userFriend: usersFriend) map.remove(userFriend);        // 유저의 친구는 추천 친구에서 제외

        for(String key: map.keySet()){
            if(answer.size() == 5)          // 추천 친구는 최대 5명
                break;
            answer.add(key);
        }


        return answer;
    }
}
