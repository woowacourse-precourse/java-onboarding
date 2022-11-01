package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        Map<String,List<String>> friendList = new HashMap<>();
        Map<String,Integer> result = new HashMap<>();
        for (List<String> friend : friends) {
            if(friendList.containsKey(friend.get(0))){
                List<String> lists = new ArrayList<>(friendList.get(friend.get(0)));
                if (!lists.contains(friend.get(1))){
                    lists.add(friend.get(1));
                    friendList.put(friend.get(0), lists);
                }
            }
            else{
                String[] strings = {friend.get(1)};
                friendList.put(friend.get(0),Arrays.asList(strings));
            }

            if (friendList.containsKey(friend.get(1))) {
                List<String> lists = new ArrayList<>(friendList.get(friend.get(1)));
                if (!lists.contains(friend.get(0))){
                    lists.add(friend.get(0));
                    friendList.put(friend.get(1), lists);
                }
            }
            else{
                String[] strings = {friend.get(0)};
                friendList.put(friend.get(1),Arrays.asList(strings));
            }

        }
        //점수 정렬
        for (String key : friendList.keySet()) {
            int cnt = 0;
            List<String> lists = friendList.get(user);
            if(!lists.contains(key)){
                for (String name : friendList.get(key)) {
                    if (friendList.get(user).contains(name)){
                        cnt+=10;
                    }
                }
                result.put(key, cnt);
            }

        }
        for (String visitor : visitors) {
            if(result.containsKey(visitor)){
                result.put(visitor,result.get(visitor)+1);
            }
            else{
                result.put(visitor,1);
            }
        }
        for (int i = 0; i < result.size(); i++) {
            int max=0;
            String item = "";
            for (Map.Entry<String, Integer> entry : result.entrySet()) {
                if(answer.contains(entry.getKey()))
                    continue;
                if (entry.getKey()==user || friendList.get(user).contains(entry.getKey())){
                    continue;
                }
                if (entry.getValue() > max){
                    max = entry.getValue();
                    item=entry.getKey();
                }
                else if (entry.getValue() == max){
                    if (item.compareTo(entry.getKey()) > 0){
                        item=entry.getKey();
                    }
                }
            }
            if (!item.equals("")){
                if(answer.size()<5)
                    answer.add(item);
                else
                    break;
            }

        }


        return answer;
    }

}
