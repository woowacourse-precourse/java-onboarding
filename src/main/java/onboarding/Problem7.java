package onboarding;

/**
 *
 * [ SNS ]
 *  - users = 유저들이 저장되어 있는 리스트
 *
 * ( 유저 저장에 필요한 메서드 )
 *  - is_user_exist(String username) = username 이름의 유저가 있는지 반환
 *  - make_user(String username) = username 으로 User 를 생성한다.
 *  - add_user(User user) = 유저를 users 에 추가한다.
 *
 * ( 유저 조회 )
 *  - find_by_name(String name) = 이름으로 유저를 찾아 반환한다.
 *  - all_users() = 모든 유저를 반환한다.
 *
 * ( 유저끼리의 친구 등록을 위한 메서드 )
 *  - is_friend(User user1, User user2) = user1 과 user2 가 서로 친구로 등록되어있는지 반환
 *  - make_friend(User user1, User user2) = user1 과 user2 서로를 친구로 등록
 *
 * ( 친구 추천을 위한 메서드 )
 *  - find_five_recommended_friend(User user) = user 에게 추천할 친구를 최대 5명을 찾아 이름을 리스트로 반환한다.
 *  - is_score_exist_for_target(String target) = target 에게 추천할 점수가 있는지 반환
 *  - recommend_user(User user, List<User> recommend_list) = user 를 추천리스트에 추가
 *  - sort_descending_with_score(List<User> recommend_list) = 추천리스트를 점수의 내림 차순으로 정렬
 *  - show_recommend_user(List<User> recommend_list) = 추천 리스트를 반환
 *
 * [ User ]
 *  - name = 이름
 *  - friends = 친구들이 저장되어 있는 리스트
 *  - visitors = 타임라인에 방문한 횟수
 *  - score = 친구 추천 점수들이 있는 map
 *
 *  - show_name() = 이름을 반환
 *  - is_friend(User user) = user 가 friends 에 있는지 반환
 *  - add_friend(User user) = user 를 friends 에 추가
 *  - show_friends() = 모든 친구를 반환
 *  - is_visitor(User user) = user 가 visitors 에 있는지 반환
 *  - add_visitor(User user) = user 를 visitors 에 추가
 *  - show_visitors() = 모든 방문자를 반환
 *  - is_score_exist(User user) = user 를 대상으로한 score 가 있는지 반환
 *  - add_score(int amount) = score 를 amount 만큼 증가
 *  - show_score() = score 를 반환
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
}
