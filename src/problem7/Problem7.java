package problem7;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem7 {
	public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> result = new ArrayList<>();
        List<String> userFriend = new ArrayList<>();
        Map<String, Integer> recommendScore = new HashMap<>(); 

        for (List<String> friend : friends) {
            if(friend.contains(user)) {
            	userFriend.addAll(friend);
            }
        }
        userFriend.remove(user);

        for (List<String> friend : friends) {
            String friend1 = friend.get(0);
            String friend2 = friend.get(1);

            if(friend1.equals(user) || friend2.equals(user)) continue;

            if(userFriend.contains(friend1)) {
                if(recommendScore.containsKey(friend2)) {
                    recommendScore.put(friend2, recommendScore.get(friend2)+10);
                }
                else recommendScore.put(friend2, 10);
            }

            if(userFriend.contains(friend2)) {
                if(recommendScore.containsKey(friend1)) {
                    recommendScore.put(friend1, recommendScore.get(friend1)+10);
                }
                else recommendScore.put(friend1, 10);
            }
        }

        for(String visitor: visitors){
            if(recommendScore.containsKey(visitor)) {
                recommendScore.put(visitor, recommendScore.get(visitor)+1);
            }
            else recommendScore.put(visitor, 1);
        }

        
        // HashMap Value 기준으로 정렬 (추천점수 큰 순으로)
        List<Map.Entry<String, Integer>> entryList = new ArrayList<Map.Entry<String, Integer>>(recommendScore.entrySet());
        entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
            	return o2.getValue() - o1.getValue();
            }
        });

        for(Map.Entry<String, Integer> entry: entryList){	
            result.add(entry.getKey());
        }
        result.removeAll(userFriend);

        return result;
    }
}
