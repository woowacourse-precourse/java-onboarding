package onboarding;

import java.util.*;

public class Problem7 {
    private static Set<String> excluder = new HashSet<>(); // 후보에서 제외되어야 하는 사람의 Set (user, 이미 친구인 사람들)
    static class Candidate implements Comparable<Candidate> {
        private final String name; // 이름
        private int weight;  // 친구추천 기준에 대한 가중치

        public Candidate(String name, int weight) {
            this.name = name;
            this.weight = weight;
        }

        public String getName() { return this.name; }
        public int getWeight() { return this.weight; }
        public void updateWeight(int increment) { this.weight += increment; }
        @Override
        public int compareTo(Candidate c) {
            if(this.weight != c.getWeight()) return Integer.compare(this.weight, c.getWeight()) * -1;
            else return this.name.compareTo(c.getName());
        }
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        // 1. 모든 친구 후보에 대한 Object Pool을 생성 및 구성
        HashMap<String, Candidate> candidates = buildObjectPool(user, friends, visitors);

        // 2. 제공된 친구 관계 정보를 Graph로 구성
        HashMap<String, ArrayList<Candidate>> al = buildFriendsNetworkGraph(friends, candidates);

        // 3. 구성한 친구관계 Graph를 탐색하며 함께 아는 친구에 대한 점수를 갱신
        countFriendNetworkScore(user, al);

        // 4. 방문자 정보를 탐색하며 방문 이력에 대한 점수를 갱신함
        countVisitHistScore(candidates, visitors);

        // 5. 종합한 정보를 바탕으로 최종 친구목록을 구성하여 반환
        answer = getRecomendList(candidates);
        return answer;
    }

    // 새로운 친구후보에 대한 Object Pool을 생성 및 구성
    private static HashMap<String, Candidate> buildObjectPool(String user, List<List<String>> friends, List<String> visitors) {
        // 모든 후보(fiends, visitors)에 대해서 Object Pool을 생성함
        HashMap<String, Candidate> candidates = new HashMap<>(); // 후보자들의 객체를 저장하는 객체 Pool
        // friends를 탐색하며 객체 Pool 갱신
        for(List<String> friend : friends) {
            for(int i=0 ; i<2 ; i++) {
                if(friend.contains(user)) {
                    excluder.add(friend.get(0));
                    excluder.add(friend.get(1));
                }
                if(!candidates.containsKey(friend.get(i)))
                    candidates.put(friend.get(i), new Candidate(friend.get(i), 0));
            }
        }
        // visitors를 탐색하며 객체 Pool 갱신
        for(String visitor : visitors)
            if(!candidates.containsKey(visitor))
                candidates.put(visitor, new Candidate(visitor, 0));

        return candidates;
    }

    // 제공된 친구관계 정보를 Graph로 구성
    private static HashMap<String, ArrayList<Candidate>> buildFriendsNetworkGraph(List<List<String>> friends, HashMap<String, Candidate> candidates) {
        HashMap<String, ArrayList<Candidate>> al = new HashMap<>(); // adjacency list
        for(List<String> friend : friends) {
            if(!al.containsKey(friend.get(0)))
                al.put(friend.get(0), new ArrayList<>());
            al.get(friend.get(0)).add(candidates.get(friend.get(1)));

            if(!al.containsKey(friend.get(1)))
                al.put(friend.get(1), new ArrayList<>());
            al.get(friend.get(1)).add(candidates.get(friend.get(0)));
        }
        return al;
    }

    // 구성한 친구관계 Graph를 탐색하며 함께 아는 친구에 대한 점수를 갱신
    private static void countFriendNetworkScore(String user, HashMap<String, ArrayList<Candidate>> al) {
        Queue<Candidate> queue = new LinkedList<>(al.get(user)); // 탐색에 사용하는 queue
        while(!queue.isEmpty()) {
            for(Candidate c : al.get(queue.peek().getName()))
                c.updateWeight(10);
            queue.poll();
        }
    }

    // 방문자 정보를 탐색하며 방문 이력에 대한 점수를 갱신
    private static void countVisitHistScore(HashMap<String, Candidate> candidates, List<String> visitors) {
        for(String visit : visitors)
            candidates.get(visit).updateWeight(1);
    }

    // 종합한 정보를 바탕으로 최종 친구목록을 구성하여 반환
    private static List<String> getRecomendList(HashMap<String, Candidate> candidates) {
        List<String> recommedList = new ArrayList<>();
        for(String name : excluder)
            candidates.remove(name);
        List<Candidate> finalCandidates = new ArrayList<>(candidates.values());
        // 4-2. 제외시켜야하는 사람들을 제외시킴 (weight가 0인 사람들)
        for(int i=0 ; i<finalCandidates.size() ; i++)
            if(finalCandidates.get(i).getWeight() == 0)
                finalCandidates.remove(i);

        for(Candidate c : finalCandidates) {
            if(recommedList.size() > 5) break; // 최대 5개 까지만 종합함
            recommedList.add(c.getName());
        }
        return recommedList;
    }
}
