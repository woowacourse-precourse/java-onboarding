package onboarding;

import javax.swing.text.html.parser.Entity;
import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        List<String> user_friend = new ArrayList<>();
        //user의 친구가 누구인지 찾기! 친구가 없으면 so sad..
        for(int i=0 ; i<friends.size() ; i++){
            if (friends.get(i).get(0).equals(user))
                user_friend.add(friends.get(i).get(1));
            else if (friends.get(i).get(1).equals(user))
                user_friend.add(friends.get(i).get(0));
        }

        //Map은 파이썬의 딕셔너리와 똑같다 잘 기억하자!
        HashMap<String, Integer> score = new HashMap<>();
        //friend 리스트와 유저의 친구를 비교한다.
        for(int i=0 ; i<friends.size() ; i++){
            for(int j=0 ; j<user_friend.size() ; j++){
                //친구의 친구가 본인이면 건너뛰기
                if (friends.get(i).get(0).equals(user) || friends.get(i).get(1).equals(user))
                    continue;
                if (friends.get(i).get(0).equals(user_friend.get(j)))
                    //이때 딕셔너리에 key값이 저장되어있는지 안되어있는지에 따라 value에 0을 저장하거나 10을 더한다.
                    if (score.containsKey(friends.get(i).get(1)))
                        score.put(friends.get(i).get(1), score.get(friends.get(i).get(1))+10);
                    else
                        score.put(friends.get(i).get(1), 0);

                else if (friends.get(i).get(1).equals(user_friend.get(j)))
                    if (score.containsKey(friends.get(i).get(0)))
                        score.put(friends.get(i).get(0), score.get(friends.get(i).get(0))+10);
                    else
                        score.put(friends.get(i).get(0), 0);
            }
        }
        //방문자도 key에 있는지 없는지에 따라 0을 저장하거나 1점을 더한다!
        for(int i=0 ; i<visitors.size() ; i++){
            if (score.containsKey(visitors.get(i)))
                score.put(visitors.get(i), score.get(visitors.get(i))+1);
            else
                score.put(visitors.get(i), 0);
        }
        // 친구의 친구가 내친구면 제거!
        for (int i=0 ; i<user_friend.size() ; i++)
            score.remove(user_friend.get(i));


        //comparator를 이용한 Value 내림차순 구조 이해해보기!
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(score.entrySet());
        entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        List<String> a = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : entryList){
            a.add(entry.getKey());
        }

        List<String> answer = Collections.emptyList();

        answer = a;
        return answer;
    }
}
