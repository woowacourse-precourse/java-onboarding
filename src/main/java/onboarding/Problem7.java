package onboarding;

import java.util.*;

import static org.junit.jupiter.params.shadow.com.univocity.parsers.conversions.Conversions.toLowerCase;

public class Problem7 {
    // 기능 구현 목록
    // 1. 예외처리
    //  (1) user의 길이가 1이상 30이하인 문자열이 아닌경우
    //  (2) friends의 길이가 1이상 10000이하가 아닌경우
    //  (3) 아이디의 길이가 1 이상 30이하가 아닌 경우
    //  (4) 사용자 아이디는 알파벳 소문자로만 이루어져있지 않은 경우가 있다면 모두 소문자로 변환
    //  (5) visitors는 길이가 0이상 10000이하인 리스트 배열이 아닌경우.
    // 2. user의 친구찾기
    // 3. 추천 친구들을 저장
    // 4. 방문자들 정보로부터 추천친구 정보 추가
    // 5. 사용자와 함께 아는 친구 점수 구하기
    // 6. 사용자의 타임라인에 방문한 횟수 점수 구하고 점수가 0인 것은 제거하기
    // 7. 결과를 내림차순으로 정렬
    public static List<String> solution(String user, List<List<String>
            > friends, List<String> visitors) {
        // 제한사항에 대한 예외처리
        // 1. user의 길이가 1이상 30이하인 문자열이 아닌경우
        
        if (!(1 <= user.length() && 30 >= user.length())){
            List<String> answer = List.of("user의 길이가 1이상 30이하인 문자열이 아닌경우");
            return answer;
        }
        // 2. friends의 길이가 1이상 10000이하가 아닌경우
        if (!(1 <= friends.size() && 10000 >= friends.size())){
            List<String> answer = List.of("friends의 길이가 1이상 10000이하가 아닌경우");
            return answer;
        }
        for (int i = 0; i < friends.size(); i++) {
            for (int j = 0; j < friends.get(i).size(); j++) {
                // 3. 아이디의 길이가 1 이상 30이하가 아닌 경우
                if (!(1 <= friends.get(i).get(j).length() && 30 >= friends.get(i).get(j).length())) {
                    List<String> answer = List.of("아이디의 길이가 1 이상 30이하가 아닌 경우");
                    return answer;
                }
                // 4. 사용자 아이디는 알파벳 소문자로만 이루어져있지 않은 경우가 있다면 모두 소문자로 변환
                else {
                    friends.get(i).get(j).toLowerCase();
                }
            }
        }
        // 5. visitors는 길이가 0이상 10000이하인 리스트 배열이 아닌경우.
        if ((!(0 <= visitors.size() && 10000 >= visitors.size()))) {
            List<String> answer = List.of("visitors는 길이가 0이상 10000이하인 리스트 배열이 아닌경우");
            return answer;
        }



        return result;
    }
}