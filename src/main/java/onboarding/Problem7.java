package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        //user의 친구 구하기
        List<String> userFriends = new ArrayList<>();
        for (List<String> friend:friends) {
            if(friend.get(0).equals(user)){
                userFriends.add(friend.get(1));
            } else if (friend.get(1).equals(user)) {
                userFriends.add(friend.get(0));
            }
        }

        //점수를 저장할 해시맵
        HashMap<String,Integer> record = new HashMap<>();

        //user의 친구와 친구이면 10점 추가. 단, 유저가 아니여야 함.
        for(List<String> friend : friends){
            for(String userFriend : userFriends){
                String friendsFriend = "";
                if(friend.get(0).equals(userFriend)&&!(friend.get(1).equals(user))){
                    friendsFriend = friend.get(1);

                    if(record.get(friendsFriend)!=null){
                        record.put(friendsFriend,record.get(friendsFriend)+10);
                    }else{
                        record.put(friendsFriend,10);
                    }
                }else if(friend.get(1).equals(userFriend)&&!(friend.get(0).equals(user))){
                    friendsFriend = friend.get(0);
                    if(record.get(friendsFriend)!=null){
                        record.put(friendsFriend,record.get(friendsFriend)+10);
                    }else{
                        record.put(friendsFriend,10);
                    }
                }
            }
        }

        //방문 횟수 만큼 점수 추가. 단, 유저가 아니여야 함
        for(String visitor : visitors){
            if(!(visitor.equals(user))){
                if(record.get(visitor)!=null){
                    record.put(visitor,record.get(visitor)+1);
                }else{
                    record.put(visitor,1);
                }
            }
        }
        List<String> names = new ArrayList<>(record.keySet());
        Collections.sort(names,(k,v)->record.get(v).compareTo(record.get(k)));

        //이미 친구인 경우를 제외하고 answer에 추가
        for(int i=0; i<names.size();i++){
            if(userFriends.contains(names.get(i))){
                names.remove(i);
                i--;
            }else{
                answer.add(names.get(i));
            }

            if(i==4)break;
        }

        return answer;
    }
}
