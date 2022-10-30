package onboarding;

import java.util.*;

public class Problem7 {
    /**
     * 추천할 친구를 리턴해주는 메서드입니다.
     *
     * @param :
     *   - String, 유저
     *   - List<List<String>>, 친구 관계들
     *   - List<String>, 방문자
     * @return : List<Integer>, 점수에 따라 추천하는 친구들의 아이디
     */
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    /**
     * 친구 관계를 Map으로 정리하여 리턴하는 메서드 입니다.
     *
     * @param : List<List<String>>, 친구 관계들
     * @return : Map<String, Set<String>>, Map으로 정리된 친구 관계. Key가 아이디, Value가 Set<String>. Value에는 그 사람과 친구인 사람의 아이디
     */
    public static Map<String, Set<String>> setConnection(List<List<String>> friends) {
        Map<String, Set<String>> answer = new HashMap<>();
        return answer;
    }

    /**
     * 친구 관계와, 방문자를 보고 점수를 구해주는 메서드
     *
     * @param :
     *   - Map<String, Set<String>>, Map으로 정리된 친구 관계. Key가 아이디, Value가 Set<String>. Value에는 그 사람과 친구인 사람의 아이디
     *   - List<String>, 방문자
     * @return : Map<String, Integer>, Map으로 정리된 아이디와 점수. Key가 아이디, Value가 점수
     */
    public static Map<String, Integer> calculateScore(Map<String, Set<String>> friendConnection, List<String> visitors) {
        Map<String, Integer> answer = new HashMap<>();
        return answer;
    }

    /**
     * 추천해줄 친구를 뽑아주는 메서드
     *
     * @param : Map<String, Integer>, Map으로 정리된 아이디와 점수. Key가 아이디, Value가 점수
     * @return : List<String>, 추천할 친구들의 아이디
     */
    public static List<String> selectTop5(Map<String, Integer> friendScore) {
        List<String> answer = new LinkedList<>();
        return answer;
    }
}
