package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        //TODO: network 만들기
        Map<String,List<String>> network = new HashMap<>();//{'이름':new ArrayList<>{}}
        for(List<String> friendship:friends){
            String oneName=friendship.get(0);
            String twoName=friendship.get(1);
            List<String>oneFriend=network.getOrDefault(oneName,new ArrayList<>());
            oneFriend.add(twoName);
            List<String>twoFriend=network.getOrDefault(twoName,new ArrayList<>());
            twoFriend.add(oneName);

            network.put(oneName,oneFriend);
            network.put(twoName,twoFriend);
        }
        //TODO: 'user 친구' 리스트
        //TODO: user와 친구가 아닌 'user 친구의 친구' 리스트 만들기
        List<String> userFriends=network.get(user);
        List<String> userFriendFriends=new ArrayList<>();
        for(String userFriend:userFriends){//user 친구들의
            for(String nominee:network.get(userFriend)){//친구들이
                //user와 친구가 아니라면,
                boolean isFriend=false;
                for(String uf:userFriends){
                    if(uf.equals(nominee)){
                        isFriend=true;
                        break;
                    }
                }
                if(isFriend==false&&!nominee.equals(user))
                    userFriendFriends.add(nominee);
            }
        }
        Map<String, Integer> score=new HashMap<>();//{'이름':점수}
        for(String uff :userFriendFriends){
            int prevScore=score.getOrDefault(uff,0);
            prevScore+=10;
            score.put(uff,prevScore);
        }

        for(String visitor:visitors){
            boolean isFriend=false;
            for(String userFriend:userFriends){
                if(userFriend.equals(visitor)){
                    isFriend=true;
                    break;
                }
            }
            if(isFriend==false){
                int prevScore=score.getOrDefault(visitor,0);
                prevScore+=1;
                score.put(visitor,prevScore);
            }
        }
        //TODO: score 높은 순서대로 정렬 + 최대 5명
        List<String> answer=score.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(5)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        return answer;
    }
}