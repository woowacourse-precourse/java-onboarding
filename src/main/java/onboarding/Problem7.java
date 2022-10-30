package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    /**
     * 사용자의 아이디와 친구관계 정보, 사용자 타임라인 방문 기록으로 추천 친구 리스트를 반환
     * @param user : 사용자의 아이디
     * @param friends : 친구 관계 정보
     * @param visitors : 사용자 타임라인 방문 기록
     * @return 적합한 순서대로 정렬 된 추천 친구 리스트 (최대 5개)
     */
    private static List<String> getRecommendList(String user,List<List<String>> friends ,List<String> visitors){

    }

    /**
     * 친구 관계 정보를 받아 친구 관계 맵을 만들어 반환
     * @param friends : 친구 관계 정보
     * @return 친구 관계 정보로 만들어진 친구 관계 맵
     */
    private static Map<String , Set<String>> getFriendsMap(List<List<String>> friends){

    }

    /**
     * 유저 이름과 친구 관계 맵을 받아 추천 점수 맵에 등록
     * @param user : 추천을 받을 대상 유저
     * @param friendsMap : 친구 관계 맵
     * @param recommendScoreMap : 점수를 갱신할 추천 점수 맵
     */
    private static void setFriendsScore(String user, Map<String, Set<String>> friendsMap , Map<String , Integer> recommendScoreMap){

    }

    /**
     * 타임라인 방문자 기록을 받아 추천 점수 맵에 등록
     * @param visitors : 타임라인 방문자 기록
     * @param recommendScoreMap : 점수를 갱신할 추천 점수 맵
     */
    private static void setVisitorScore(List<String > visitors, Map<String, Integer> recommendScoreMap){

    }

    /**
     * 추천 점수 맵에 점수를 등록
     * @param recommendUser : 점수를 올릴 유저
     * @param score : 올릴 점수
     * @param recommendScoreMap : 점수를 갱신할 추천 점수 맵
     */
    private static void addScore(String recommendUser, int score, Map<String , Integer> recommendScoreMap){

    }

    /**
     * 추천 점수 맵에서 자신과 이미 등록된 친구를 삭제
     * @param user : 추천 대상 유저
     * @param friendsMap : 친구 관계 맵
     * @param recommendScoreMap : 유저별 추천 점수가 등록된 맵
     */
    private static void deleteUserAndFriends(String user, Map<String, Set<String>> friendsMap, Map<String, Integer> recommendScoreMap){

    }

    /**
     * 추천 점수 맵의 점수가 높은 유저 순으로 추천 유저 리스트를 반환
     * @param recommendScoreMap : 유저별 추천 점수가 등록된 맵
     * @return 추천 유저 리스트
     */
    private static List<String> getRecommendListByScoreMap(Map<String, Integer> recommendScoreMap){

    }
}
