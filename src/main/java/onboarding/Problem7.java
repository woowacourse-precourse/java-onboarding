package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        HashMap<String,Integer> recommendScore = new HashMap<>();
        List<String> userFriend = new ArrayList<>();
        //finding friends
        for (List<String> friend : friends) {
            if (friend.contains(user)) {
                for (String s : friend) {
                    if (!user.equals(s))
                        userFriend.add(s);
                }
            }
        }
        //finding friend's friend
        for (List<String> friend : friends) {
            if(userFriend.contains(friend.get(0)) && !userFriend.contains(friend.get(1)) && !friend.get(1).equals(user)){
                if(recommendScore.containsKey(friend.get(1)))
                    recommendScore.put(friend.get(1), recommendScore.get(friend.get(1))+10);
                else
                    recommendScore.put(friend.get(1), 10);
            }
            else if(userFriend.contains(friend.get(1)) && !userFriend.contains(friend.get(0)) && !friend.get(0).equals(user)){
                if(recommendScore.containsKey(friend.get(0)))
                    recommendScore.put(friend.get(0), recommendScore.get(friend.get(0))+10);
                else
                    recommendScore.put(friend.get(0), 10);
            }
        }
        //finding visitors
        for (String visitor : visitors) {
            if (!userFriend.contains(visitor) && !recommendScore.containsKey(visitor)) {
                recommendScore.put(visitor, 1);
            }
            if (!userFriend.contains(visitor) && recommendScore.containsKey(visitor)) {
                recommendScore.put(visitor, recommendScore.get(visitor) + 1);
            }
        }

        //score 헤쉬맵 정렬후 0이 아닌거만 5개 출력
        List<String> answer = new ArrayList<>();
        List<String> keySetList = new ArrayList<>(recommendScore.keySet());
        keySetList.sort((o1, o2) -> (recommendScore.get(o2).compareTo(recommendScore.get(o1))));
        int counter = Math.min(5, keySetList.size());
        for(int i = 0; i < counter; i ++) {
            answer.add(keySetList.get(i));
        }
        return answer;
    }
}
