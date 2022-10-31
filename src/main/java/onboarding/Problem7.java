package onboarding;

import onboarding.problem7.FriendRecommender;

import java.util.*;

public class Problem7 {

    /*
    기능 목록
    1. 친구 관계 설정 기능
    2. 함께 아는 친구 분석 기능
    3. 타임라인 방문 기록 분석 기능
    4. 추천 점수와 이름순으로 정렬해서 최대 5명 추천하는 기능
     */
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        FriendRecommender friendRecommender = new FriendRecommender();

        return friendRecommender.recommend(user, friends, visitors);
    }
}
