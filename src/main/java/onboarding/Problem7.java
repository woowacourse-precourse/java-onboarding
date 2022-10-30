package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Hashtable<String, HashSet<String>> friendDict = new Hashtable<>();  //친구 관계를 저장
        Hashtable<String, Integer> scoreDict = new Hashtable<>();   //점수 정보를 저장

        for(List<String> friend: friends){
            if (friendDict.get(friend.get(0)) == null){ //처음 값의 경우 생성
                friendDict.put(friend.get(0), new HashSet<>(List.of(friend.get(1))));
            }
            else{   //처음이 아닌 경우 추가
                friendDict.get(friend.get(0)).add(friend.get(1));
            }
            if (friendDict.get(friend.get(1)) == null){ //위와 동일
                friendDict.put(friend.get(1), new HashSet<>(List.of(friend.get(0))));
            }
            else{
                friendDict.get(friend.get(1)).add(friend.get(0));
            }
        }

        for (String friend: friendDict.get(user)){
            for(String rFriend: friendDict.get(friend)){
                if (user.equals(rFriend)) continue; //자기 자신의 경우
                if (scoreDict.containsKey(rFriend)) //이미 점수가 있는 경우
                    scoreDict.put(rFriend, scoreDict.get(rFriend) + 10);
                else scoreDict.put(rFriend, 10);    //점수가 없어서 추가
            }
        }

        for (String visitor: visitors){
            if (friendDict.get(user).contains(visitor)) continue;   //이미 친구인 경우
            if (scoreDict.containsKey(visitor)) scoreDict.put(visitor, scoreDict.get(visitor) + 1); // 방문한 사람의 점수가 존재
            else scoreDict.put(visitor,1);  //방문한 사람의 점수가 존재하지 않음
        }

        List<String> keySet = new ArrayList<>(scoreDict.keySet());
        Collections.sort(keySet, (val1, val2) -> (scoreDict.get(val2).compareTo(scoreDict.get(val1)))); //내림차순 정렬

        return (keySet.size() >= 5)?keySet.subList(0, 6): keySet;
    }
}

