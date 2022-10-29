package onboarding;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class Problem7 {
    // 추천 후보 클래스
    private static class recommender implements Comparable<recommender>{
        String name;
        int score;
        // 생성자
        public recommender(String name, int score){
            this.name = name;
            this.score = score;
        }
        // 점수로 비교후 같으면 문자순 비교
        @Override
        public int compareTo(recommender r) {
            if(this.score - r.score == 0)
                return this.name.compareTo(r.name);
            return r.score - this.score;
        }
    }
    // 추천 대상에 대한 점수 갱신
    private static void setScore(HashMap<String, Integer> map, String name, int score){
        if(map.get(name) == null)
            map.put(name, score);
        else
            map.put(name, map.get(name) + score);
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        HashSet<String> userFriends = new HashSet<>(10);
        HashMap<String, Integer> map = new HashMap<>(friends.size());
        List<recommender> recommenders = new LinkedList<>();
        List<String> answer = new ArrayList<>(5);
        // 유저와 친구인 아이디 찾기
        for(List<String> pair : friends)
            if(pair.get(0) == user || pair.get(1) == user)
                userFriends.add(pair.get(0) == user ? pair.get(1) : pair.get(0));
        // 유저와 동일한 친구를 같는 아이디 찾고 1명 당 10점 씩 부여
        for(List<String> pair : friends)
            if(userFriends.contains(pair.get(0)) || userFriends.contains(pair.get(1))){
                int i = userFriends.contains(pair.get(0)) ? 1 : 0;
                if(pair.get(i) != user)
                    setScore(map, pair.get(i), 10);
            }
        // 방문자를 찾고 방문 횟수당 1점 씩 부여
        for(String name : visitors)
            if(!userFriends.contains(name))
                setScore(map, name, 1);
        // 추천 대상자를 추천 대상자 자료형의 리스트로 변경
        for(Map.Entry<String,Integer> entry : map.entrySet())
            recommenders.add(new recommender(entry.getKey(), entry.getValue()));
        // 자료형 기준으로 정렬
        Collections.sort(recommenders);

        for(int i = 0; i < 5 && i < recommenders.size(); ++i)
            answer.add(recommenders.get(i).name);
        return answer;
    }
}