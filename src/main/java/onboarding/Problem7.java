package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        Map<String,Integer> map = new HashMap<String,Integer>();
        List<String> istring;

        // user의 친구 리스트 구하기
        List<String> friendsOfUser = new ArrayList<String>();
        for (int i = 0; i < friends.size(); i++) {
            istring = friends.get(i);
            for (int j = 0; j < 2; j++) {
                if (istring.get(j).equals(user)) {
                    friendsOfUser.add(istring.get(1 - j));
                    //System.out.println("user의 친구 리스트 구하기: "+friendsOfUser);
                }
            }
        }
        // user의 추천 친구 구하기-friends
        String jstring;
        String userFriend;
        int score=0;
        for (int i=0;i< friendsOfUser.size();i++){ //user의 친구들 중에서
            userFriend = friendsOfUser.get(i); //donut, shakevan

            for (int a=0;a< friends.size();a++){
                for(int b=0; b<2; b++){
                    score=0;
                    if (friends.get(a).get(1-b)!="mrko" &&(friends.get(a).get(b)).equals(userFriend)){
                        //System.out.println(friends.get(a).get(b)+" "+friends.get(a).get(1-b));
                        if ( map.containsKey(friends.get(a).get(1-b))) { //이미 키가 존재한다면
                            score=map.get(friends.get(a).get(1 - b));
                            //System.out.println(1);
                        }
                        score += 10;
                        map.put(friends.get(a).get(1 - b), score);
                        //System.out.println("user의 추천 친구 구하기-friends: "+map);
                    }
                }
            }
        }

        // user의 추천 친구 구하기-visitors
        int alreadyFriends=0;
        for (int i=0; i< visitors.size(); i++){
            score=0;
            alreadyFriends=0;
            // 이미 user와 친구라면? -> 제외
            for (int j=0; j< friendsOfUser.size(); j++) { //user의 친구들 중에서
                if (visitors.get(i).equals(friendsOfUser.get(j))){
                    alreadyFriends=1;
                }
            }

            if (alreadyFriends==1)  continue;
            else if (map.containsKey(visitors.get(i))) { //이미 키가 존재한다면
                score=map.get(visitors.get(i));
            }
            score+=1;
            map.put(visitors.get(i), score);
            //System.out.println("user의 추천 친구 구하기-visitors: "+map);
        }
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(map.entrySet());
        entryList.sort(((o2, o1) -> map.get(o1.getKey()) - map.get(o2.getKey())));

        for(String key : map.keySet()){
            answer.add(key);
        }
        return answer;
    }
}
