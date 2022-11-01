package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        answer = new ArrayList<String>();

        //user의 친구 목록
        ArrayList<String> friends_list = new ArrayList<String>();
        //친구 이름과 점수를 같이 저장할 map 선언
        Map<String, Integer> map = new TreeMap<>();

        //user와 아는 친구 골라내서 friends_list에 넣기
        for(int i=0; i<friends.size(); i++) {
            if(friends.get(i).get(0) == user) {
                friends_list.add(friends.get(i).get(1));
            }
            if(friends.get(i).get(1) == user) {
                friends_list.add(friends.get(i).get(0));
            }
        }

        //friends 리스트 다시 돌면서 friends_list의 친구들이 아는 친구 찾기
        //이때 user는 제외
        //아는 친구 찾았으면 map에 이름을 key로 해서 value에 점수(10점) 넣기
        for (int i=0; i<friends.size(); i++) {
            if (friends_list.contains(friends.get(i).get(0)) && friends.get(i).get(1) != user) {
                if (map.containsKey(friends.get(i).get(1))) {
                    int value = map.get(friends.get(i).get(1));
                    map.replace(friends.get(i).get(1), value + 10);
                }
                else {
                    map.put(friends.get(i).get(1), 10);
                }
            }
            else if (friends_list.contains(friends.get(i).get(1)) && friends.get(i).get(1) != user) {
                if (map.containsKey(friends.get(i).get(0))) {
                    int value = map.get(friends.get(i).get(0));
                    map.replace(friends.get(i).get(0), value + 10);
                }
                else {
                    map.put(friends.get(i).get(0), 10);
                }
            }
        }

        //방문자들 목록 돌면서 점수 넣기
        for (int i=0; i<visitors.size(); i++) {
            if (map.containsKey(visitors.get(i))) {
                int value = map.get(visitors.get(i));
                map.replace(visitors.get(i), value + 1);
            }
            else {
                if (!friends_list.contains(visitors.get(i))) {
                    map.put(visitors.get(i), 1);
                }
            }
        }

        List<String> key = new ArrayList<>(map.keySet());
        key.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return map.get(o2).compareTo(map.get(o1));
            }
        });

        int n = 0;
        for (int i=0; i<key.size(); i++) {
            if (friends_list.contains(key.get(i)) || key.get(i) == user) {
                continue;
            }
            else {
                answer.add(key.get(i));
                n += 1;
            }
            if (n == 5) {
                break;
            }
        }

        return answer;
    }
}
