package onboarding;

import onboarding.problem7.FriendRecommender;

import java.util.List;

/**
 * Problem 7 기능 목록
 * 1. 주어진 friends 에서 relationship 목록을 초기화한다.
 * 2. 친구 후보자 map 을 생성한다.
 * 2-1. relationships 에서 user 와 친구인 사람들의 친구들에게는 10점을 추가한다.
 * 2-2. user 의 SNS 을 방문한 사람들은 1점을 추가한다.
 * 3. 후보 리스트를 점수 내림차순으로 정렬하고 점수가 같으면 이름 오름차순으로 정렬한다.
 * 4. 정렬된 후보 리스트에서 최대 5명의 친구 후보를 반환한다.
 */
public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        FriendRecommender recommender = new FriendRecommender(user, friends, visitors);
        return recommender.recommend();
    }
}
