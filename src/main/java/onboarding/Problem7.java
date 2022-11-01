package onboarding;

import java.util.*;

public class Problem7 {
    /**
     * 친구 목록은 제외한다.
     */
    private static Set<String> alreadyFriends = new HashSet<>();

    /**
     * User Class 생성
     */
    static class User implements Comparable<User> {
        private final String name;
        private int score;
        public User(String name, int score) {
            this.name = name;
            this.score = score;
        }
        public String getName() {
            return name;
        }

        public int getScore() {
            return score;
        }

        public void updateScore(int i) { this.score += i; }
        @Override
        public int compareTo(User user) {
            if(this.score != user.getScore()) return Integer.compare(this.score, user.getScore()) * -1;
            else return this.name.compareTo(user.getName());
        }
    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer;
        HashMap<String, User> candidates = buildObjectPool(user, friends, visitors);
        HashMap<String, ArrayList<User>> al = buildFriendsNetworkGraph(friends, candidates);
        countFriendNetworkScore(user, al);
        countVisitHistScore(candidates, visitors);
        answer = getRecommendList(candidates);
        return answer;
    }

    /**
     * 후보자 목록을 생성한다.
     * @param user
     * @param friends
     * @param visitors
     * @return
     */
    private static HashMap<String, User> buildObjectPool(String user, List<List<String>> friends, List<String> visitors) {
        HashMap<String, User> candidates = new HashMap<>();
        for(List<String> friend : friends) {
            for(int i=0 ; i<2 ; i++) {
                if(friend.contains(user)) {
                    alreadyFriends.add(friend.get(0));
                    alreadyFriends.add(friend.get(1));
                }
                if(!candidates.containsKey(friend.get(i)))
                    candidates.put(friend.get(i), new User(friend.get(i), 0));
            }
        }
        for(String visitor : visitors)
            if(!candidates.containsKey(visitor))
                candidates.put(visitor, new User(visitor, 0));

        return candidates;
    }

    /**
     * 입력받은 친구 관계를 탐색에 용이하도록 연결리스트 형식으로 저장한다.
     * @param friends
     * @param candidates
     * @return
     */
    private static HashMap<String, ArrayList<User>> buildFriendsNetworkGraph(List<List<String>> friends, HashMap<String, User> candidates) {
        HashMap<String, ArrayList<User>> adjList = new HashMap<>();
        for(List<String> friend : friends) {
            if(!adjList.containsKey(friend.get(0)))
                adjList.put(friend.get(0), new ArrayList<>());
            adjList.get(friend.get(0)).add(candidates.get(friend.get(1)));

            if(!adjList.containsKey(friend.get(1)))
                adjList.put(friend.get(1), new ArrayList<>());
            adjList.get(friend.get(1)).add(candidates.get(friend.get(0)));
        }
        return adjList;
    }

    /**
     * 친구  관계에 대한 점수
     * @param user
     * @param adjList
     */
    private static void countFriendNetworkScore(String user, HashMap<String, ArrayList<User>> adjList) {
        Queue<User> queue = new LinkedList<>(adjList.get(user));
        while(!queue.isEmpty()) {
            for(User u : adjList.get(queue.peek().getName())) {
                u.updateScore(10);
            }
            queue.poll();
        }
    }

    /**
     * 방문자 관계에 대한 점수
     * @param candidates
     * @param visitors
     */
    private static void countVisitHistScore(HashMap<String, User> candidates, List<String> visitors) {
        for(String visit : visitors)
            candidates.get(visit).updateScore(1);
    }

    /**
     * 이름순 정렬 상위 5명을 반환한다.
     * @param candidates
     * @return
     */
    private static List<String> getRecommendList(HashMap<String, User> candidates) {
        List<String> getRecommendList = new ArrayList<>();
        for(String name : alreadyFriends)
            candidates.remove(name);
        List<User> finalCandidates = new ArrayList<>(candidates.values());
        for(int i=0 ; i<finalCandidates.size() ; i++)
            if(finalCandidates.get(i).getScore() == 0)
                finalCandidates.remove(i);

        for(User c : finalCandidates) {
            if(getRecommendList.size() > 5) break;
            getRecommendList.add(c.getName());
        }
        return getRecommendList;
    }
}
