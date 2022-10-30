package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        List<String> userFriends = new ArrayList<>();
        for (List<String> friend:friends) {
            if(friend.get(0).equals(user)){
                userFriends.add(friend.get(1));
            } else if (friend.get(1).equals(user)) {
                userFriends.add(friend.get(0));
            }
        }
        HashMap<String,Integer> record = new HashMap<>();

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

        for(String visitor : visitors){
            if(!(userFriends.contains(visitor))){
                if(record.get(visitor)!=null){
                    record.put(visitor,record.get(visitor)+1);
                }else{
                    record.put(visitor,1);
                }
            }
        }
        List<String> names = new ArrayList<>(record.keySet());
        Collections.sort(names,(k,v)->record.get(v).compareTo(record.get(k)));

        for(int i=0; i<names.size();i++){
            answer.add(names.get(i));
            if(i==4)break;
        }

        return answer;
    }
}
