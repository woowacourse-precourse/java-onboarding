package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        //친구 이름을 인덱스로 저장
        Map<String, Integer> friendNum = new HashMap<>();

        //인덱스를 친구 이름으로 다시 변환
        Map<Integer, String> friendName = new HashMap<>();

        //친구 추천 점수
        Map<String,Integer> score = new HashMap<>();

        //친구 이름을 인덱스로 변환해주는 기능
        int idx = 1;
        friendNum.put(user, 0);
        for(int i=0; i<friends.size(); i++){
            for(int j=0; j<friends.get(i).size(); j++){
                if(!friendNum.containsKey(friends.get(i).get(j))){
                    friendNum.put(friends.get(i).get(j), idx);
                    friendName.put(idx, friends.get(i).get(j));
                    idx++;
                }
            }
        }
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0; i<idx; i++){
            graph.add(new ArrayList<>());
        }

        //친구 관계를 그래프로 구현함
        for(int i=0; i<friends.size(); i++){
            int v = friendNum.get(friends.get(i).get(0));
            int u = friendNum.get(friends.get(i).get(1));
            graph.get(v).add(u);
            graph.get(u).add(v);

        }
        //이미 친구가 아니면서 함께 아는 친구 인지 확인
        for(int i=1; i<idx; i++){
            for(int j=0; j<graph.get(i).size(); j++){
                if(!graph.get(0).contains(i)
                        && graph.get(0).contains(graph.get(i).get(j))){
                    if(score.containsKey(friendName.get(i))){
                        int tmp = score.get(friendName.get(i));
                        score.put(friendName.get(i), tmp + 10);
                    }else{
                        score.put(friendName.get(i), 10);
                    }
                }
            }
        }
        //이미 친구인 사람이 아니면서 방문한 사람들의 점수를 올려줍니다.
        for(int i=0; i < visitors.size(); i++){
            if(!friendNum.containsKey(visitors.get(i))){
                friendNum.put(visitors.get(i), idx);
                friendName.put(idx, visitors.get(i));
                idx++;
            }
            if(score.containsKey(friendName.get(friendNum.get(visitors.get(i))))){
                int tmp = score.get(friendName.get(friendNum.get(visitors.get(i))));
                score.put(friendName.get(friendNum.get(visitors.get(i))), tmp + 1);
            }else{
                score.put(friendName.get(friendNum.get(visitors.get(i))), 1);
            }
        }
        //answer 의 크기가 최대 5가 되기 전까지 이미 친구가 아니고 점수가 0이 아닌 사람을 answer 에 넣어줍니다.
        for(String key: score.keySet()){
            if(answer.size() < 5 && score.get(key) != 0 && !graph.get(0).contains(friendNum.get(key))){
                answer.add(key);
            }
        }

        //점수가 높은 순으로 정렬하고 점수가 같을 때는 이름 순으로 정렬
        answer.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (score.get(o1) == score.get(o2)) {
                    return o1.compareTo(o2);
                } else {
                    return score.get(o2) - score.get(o1);
                }
            }
        });

        return answer;
    }
}
