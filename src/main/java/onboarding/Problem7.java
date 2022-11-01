package onboarding;

import java.util.*;

/**
 * 기능 목록
 * 1. 크루들의 정보를 저장할 Crew 클래스
 *      1. 점수를 10점 올리는 기능
 *      2. 점수를 1점 올리는 기능
 * 2. friends의 친구관계를 Crew에 넣고, 크루들을 team에 넣는 기능
 *      1. 친구 관계를 맺는 기능
 *      2. 크루 객체를 생성해서 team에 넣는 기능
 * 3. 함께 아는 친구일 경우, 10점을 부여하는 기능
 * 4. 타임라인에 방문한 경우, 1점을 부여하는 기능
 * 5. 점수가 가장 높은 기준으로 정렬하되 점수가 같은 경우는 이름순으로 정렬하는 기능
 * 6. user이거나, 이미 친구이거나, 점수가 0점인 경우를 제외한 친구를 5명까지 answer에 추가하는 기능
 */

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        Map<String, Crew> team = new HashMap<>();//crew들을 모아놓는 list
        team.put(user, new Crew(user)); //team의 0번은 user이다.

        makeFriends(friends, team);

        friendTogetherKnow(user, team);

        visitTimeline(visitors, team);

        // 점수 기준으로 오름 차순 정렬
        List<Crew> crews = new ArrayList<>(team.values());

        crews.sort(Comparator.comparing(Crew::getName));
        crews.sort(Comparator.comparing(Crew::getScore).reversed());

        // user이거나, 이미 친구이거나, 점수가 0점인 경우를 제외한 친구를 5명까지 answer에 추가하는 기능
        for (Crew crew : crews) {
            if (!crew.getName().equals(user) && !team.get(user).getFriends().contains(crew.getName()) && crew.getScore() != 0 ) {
                if (answer.size() >= 5) {
                    return answer;
                }
                answer.add(crew.getName());
            }
        }
        return answer;
    }

    // 타임라인에 방문한 경우, 1점을 부여하는 기능
    private static void visitTimeline(List<String> visitors, Map<String, Crew> team) {
        for (String visitor : visitors) {
            addCrew(team, visitor);
            team.get(visitor).plusScoreOne();
        }
    }

    // 함께 아는 친구일 경우, 10점을 부여하는 기능
    private static void friendTogetherKnow(String user, Map<String, Crew> team) {
        
        for (String member : team.keySet()) {
            Crew crew = team.get(member);
            for (String friend : crew.getFriends()) {
                if (team.get(user).getFriends().contains(friend)) {
                    crew.plusScoreTen();
                }
            }
        }
    }

    // 친구 관계 맺기
    private static void makeFriends(List<List<String>> friends, Map<String, Crew> team) {
        for (List<String> friend : friends) {
            for (String member : friend) {
                addCrew(team, member);
            }
            team.get(friend.get(0)).getFriends().add(friend.get(1));
            team.get(friend.get(1)).getFriends().add(friend.get(0));
        }
    }

    //크루가 team에 없을 시 객체 생성해서 team에 추가
    private static void addCrew(Map<String, Crew> team, String member) {
        if (!team.containsKey(member)) {
            team.put(member, new Crew(member));
        }
    }

    static class Crew {
        String name;
        int score;
        List<String> friends = new ArrayList<>();

        public Crew(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public int getScore() {
            return score;
        }

        public List<String> getFriends() {
            return friends;
        }

        public void plusScoreTen(){
            this.score += 10;
        }

        public void plusScoreOne() {
            this.score += 1;
        }
    }
    
}
