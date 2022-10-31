package onboarding;

import java.util.*;

class Pair implements Comparable<Pair> {

    String name;
    int score;

    public Pair(String name, int score) {
        this.name = name;
        this.score = score;
    }

    // 추전점수가 큰 기준으로 정렬 추천점수가 같은 경우 이름을 기준으로 정렬
    @Override
    public int compareTo(Pair p) {
        if(this.score == p.score)
            return this.name.compareTo(p.name);
        else
            return Integer.compare(p.score,this.score);
    }
}

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        List<String> answer = new ArrayList<>();
        List<Pair> candidateMap = makeCandidateMap(user,friends,visitors);
        HashMap<String, List<String>> friendMap = makeFriendList(friends);
        List<String> userFriends = friendMap.get(user);

        // 사용자와 함께 아는 친구의 수로 점수 구하기
        for (Pair candidate : candidateMap) {
            List<String> candidateFriends = friendMap.get(candidate.name);
            if (candidateFriends == null) continue;
            int count = countOverlap(userFriends, candidateFriends);
            candidate.score = count * 50;
        }

        // 사용자의 타임라인에 방문한 횟수로 점수 구하기
        for (Pair candidate : candidateMap) {
            int count = Collections.frequency(visitors, candidate.name);
            candidate.score += count;
        }

        int count = 0;
        Collections.sort(candidateMap);

        // 추천 친구 후보군중에 상위 3명만 추출
        for (Pair candidate : candidateMap) {
            if (count > 3) break;
            if (userFriends.contains(candidate.name)) continue;
            answer.add(candidate.name);
            count++;
        }

        return answer;
    }

    // 친구 추천에 들어갈 수 있는 친구와 추천 점수 초기 설정하기
    public static List<Pair> makeCandidateMap(String user, List<List<String>> friends, List<String> visitors) {
        List<Pair> candidateMap = new ArrayList<>();
        HashSet<String> candidates = new HashSet<>();
        for (List<String> friend : friends) {
            candidates.add(friend.get(0));
            candidates.add(friend.get(1));
        }

        candidates.addAll(visitors);

        for (String candidate : candidates) {
            if (candidate.equals(user)) continue;
            candidateMap.add(new Pair(candidate, 0));
        }
        return candidateMap;
    }


    // 모든 친구 구하기
    public static HashMap<String, List<String>> makeFriendList(List<List<String>> friends) {
        HashMap<String, List<String>> friendMap = new HashMap<>();
        for (List<String> friend : friends) {
            if (friendMap.containsKey(friend.get(0))) {
                friendMap.get(friend.get(0)).add(friend.get(1));
            } else if (!friendMap.containsKey(friend.get(0))) {
                List<String> tmp = new ArrayList<>();
                tmp.add(friend.get(1));
                friendMap.put(friend.get(0), tmp);
            }

            if (friendMap.containsKey(friend.get(1))) {
                friendMap.get(friend.get(1)).add(friend.get(0));
            }
            else if(!friendMap.containsKey(friend.get(1))) {
                List<String> tmp = new ArrayList<>();
                tmp.add(friend.get(0));
                friendMap.put(friend.get(1), tmp);
            }
        }

        return friendMap;
    }

    // 유저의 친구와 추전될수있는 친구의 친구가 몇명이 겹치는지 확인하기
    public static int countOverlap(List<String> userFriends, List<String> candidateFriends) {
        int count = 0;
        for (String candidateFriend : candidateFriends) {
            if (userFriends.contains(candidateFriend)) count++;
        }
        return count;
    }
}
