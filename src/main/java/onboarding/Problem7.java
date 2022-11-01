package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        // 기능 1 : SNS 관리 클래스 생성 및 클래스 멤버변수 구성
        SNS sns = new SNS(user);

        // 기능 2 : 지정된 사용자에게 방문한 타 사용자 저장 및 친구 설정

        // 기능 3 : 각 사용자마다 점수 부여

        // 기능 4 : 최고 점수 가진 리스트 확보d

        return answer;
    }
}

class SNS
{
    private String targetUser; // 지정된 실행 결과
    private ArrayList<String> users; // 모든 사용자
    private int len; // 사용자 수
    private int[] scores; // 각 사용자 별 점수
    private ArrayList<String> visitors; // 지정된 사용자 SNS에 접근한 다른 사용자
    private ArrayList<String> friends; // 지정된 사용자의 친구 목록
    SNS(String name)
    {
        //implement
    }
}