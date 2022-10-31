package onboarding;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Comparator;

public class Problem7 {
    private static HashMap<String, Integer> recommendScore; //추천 점수 해시맵
    private static HashMap<String, Boolean> isFriend; //user와 친구인지 판단
    private static HashMap<String, List<String>> userList; //user 리스트
    private static PriorityQueue<User> pq; //우선순위 큐

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        init(); //초기화

        checkFriends(user, friends);

        checkVisitors(visitors);

        countRecommendScore(user, user, 0);

        initPriorityQueue();

        //recommendScore에 전체를 pq에 넣기
        for (String name : recommendScore.keySet()) {
            int score = recommendScore.get(name);
            if(isFriend.get(name) == null && score != 0){
                pq.add(new User(score, name));
            }
        }
        //5명이나 pq사이즈 보다 작은 만큼 answer에 추가
        for(int i=0;i<5 && !pq.isEmpty();i++){
            User tmp = pq.poll();
            answer.add((tmp.name));
        }

        return answer;
    }

    //초기화 메소드 추가
    private static void init(){
        recommendScore = new HashMap<>();
        isFriend = new HashMap<>();
        userList = new HashMap<>();
    }

    //우선순위 큐 초기화
    private static void initPriorityQueue(){
        pq = new PriorityQueue<>(new Comparator<User>() {
            @Override
            public int compare(User user1, User user2) {
                if(user1.score == user2.score){
                    return user1.name.compareTo(user2.name) > 0 ? 1 : -1;
                }
                return user1.score < user2.score ? 1 : -1;
            }
        });
    }

    //friends 확인하여 친구 관계 확인
    private static void checkFriends(String user, List<List<String>> friends){
        for(int i=0;i<friends.size();i++){
            List<String> friend = friends.get(i);
            String A = friend.get(0);
            String B = friend.get(1);

            //A가 user라면 B가 친구
            if(A.equals(user)){
                isFriend.put(B,true);
            }
            //B가 user라면 A가 친구
            else if(B.equals(user)){
                isFriend.put(A,true);
            }

            List<String> tmpA = userList.getOrDefault(A, new ArrayList<>());
            tmpA.add(B);
            userList.put(A, tmpA);

            List<String> tmpB = userList.getOrDefault(B, new ArrayList<>());
            tmpB.add(A);
            userList.put(B, tmpB);
        }
    }

    //visitors 확인하여 1점 추가
    private static void checkVisitors(List<String> visitors){
        for(String visitor : visitors){
            recommendScore.put(visitor, recommendScore.getOrDefault(visitor,0)+1);
        }
    }

    //user로 부터 2번 건넌 친구들 확인하는 dfs
    private static void countRecommendScore(String cur, String prev, int cnt){
        if(cnt == 2){
            recommendScore.put(cur, recommendScore.getOrDefault(cur,0)+10);
            return;
        }

        for(String next : userList.get(cur)){
            if(next.equals(prev)){
                continue;
            }
            countRecommendScore(next, cur, cnt+1);
        }
    }

    //우선순위 큐에 사용할 User 클래스
    private static class User{
        public int score;
        public String name;
        public User(int score, String name){
            this.score = score;
            this.name = name;
        }
    }
}