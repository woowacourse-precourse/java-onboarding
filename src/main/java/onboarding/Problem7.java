package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        List<String> currentFriends = new ArrayList<>();
        HashMap<String,Integer> map = new HashMap<>();

        String user1;
        String user2;

        for(List<String> relation:friends){
            user1 = relation.get(0);
            user2 = relation.get(1);
            if(user1 == user)
            {
                currentFriends.add(user2);
            }
            if(user2 == user)
            {
                currentFriends.add(user1);
            }
        }

        // 친구의 친구들 찾기
        for(List<String> relation:friends){
            user1 = relation.get(0);
            if (user1 == user) continue;
            user2 = relation.get(1);
            if (user2 == user) continue;

            for (String myFriend:currentFriends)
            {
                if(myFriend == user1)
                {
                    map.put(user2, 10);
                }
                if(myFriend == user2)
                {
                    map.put(user1, 10);
                }
            }
        }

//        방문 목록 점수 추가
        for (String vistor:visitors)
        {
            if (!currentFriends.contains(vistor)) map.put(vistor, map.containsKey(vistor)? map.get(vistor) + 1 : 1);
        }

//        정렬
        List<String> keySet = new ArrayList<>(map.keySet());
        keySet.sort(new Comparator<String>() {
            @Override
//            점수가 같을 때 이름순 정렬 필요.
            public int compare(String o1, String o2) {
                return map.get(o2).compareTo(map.get(o1));
            }
        });

        for(String key : keySet)
        {
            answer.add(key);
        }

        return answer;
    }
}
