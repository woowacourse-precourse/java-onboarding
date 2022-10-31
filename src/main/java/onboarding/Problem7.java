package onboarding;

import java.util.*;

public class Problem7 {

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


        return answer;
    }

    // 새로운 친구후보에 대한 Object Pool을 생성 및 구성
    private static HashMap<String, Candidate> buildObjectPool(String user, List<List<String>> friends, List<String> visitors) {
        // 모든 후보(fiends, visitors)에 대해서 Object Pool을 생성함
        HashMap<String, Candidate> candidates = new HashMap<>(); // 후보자들의 객체를 저장하는 객체 Pool
        // friends를 탐색하며 객체 Pool 갱신
        Set<String> excluder = new HashSet<>(); // user, user의 친구들 제외시킬 사람
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
}
