package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        HashMap<String,Integer> friend_score = new HashMap<>();

        //System.out.print(friendList(user,friends));

        //같이 아는 친구 점수
        for(String user_friend: friendList(user,friends)){
            for(String s : friendList(user_friend,friends)){
                if(!friendList(user,friends).contains(s)){
                    if(!user.equals(s)){
                        if(!friend_score.containsKey(s)){
                            friend_score.put(s,10);
                        }else{
                            friend_score.put(s, friend_score.get(s)+10);
                        }
                    }
                }
            }
        }
        //방문자 점수
        for(String s : visitors){
            if(!friendList(user,friends).contains(s)){
                if(!friend_score.containsKey(s)){
                    friend_score.put(s, 1);
                }else{
                    friend_score.put(s, friend_score.get(s)+1);
                }
            }

        }

        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(friend_score.entrySet());
        entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        //System.out.println(entryList);
        for(Map.Entry<String, Integer> entry : entryList){
            if(answer.size() < 5){
                answer.add(entry.getKey());
            }
        }

        return answer;
    }

    public static List<String> friendList(String user,List<List<String>> friends){
        HashSet<String> friendList = new HashSet<>();

        for(List<String>s : friends){
            if(s.contains(user)) {
                if(!s.get(0).equals(user)){
                    friendList.add(s.get(0));
                }
                if(!s.get(1).equals(user)){
                    friendList.add(s.get(1));
                }
            }
        }

        return new ArrayList<>(friendList);
    }
}