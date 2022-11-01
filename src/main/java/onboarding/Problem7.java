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
        sns.setAllUsers(friends, visitors);
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
        this.len = 0;
        this.targetUser = name;
        users = new ArrayList<>();
        visitors = new ArrayList<>();
        friends = new ArrayList<>();
        // score 사용자별 점수 배열 : 생성자에서 생성 불가능 , 얼마나 많은 사용자가 있는지 아직 모름
    }

    // 기능 2 : 지정된 사용자에게 방문한 타 사용자 저장 및 친구 설정
    void setAllUsers(List<List<String>> friendlist, List<String> visitors)
    {
        // 방문자 먼저 사용자 명단에 등록
        int size = visitors.size();
        for(int i = 0; i < size; ++i)
        {
            this.visitors.add(visitors.get(i));
            addUser(visitors.get(i));
        }
        // 방문자 : 여러 번 방문 가능하므로 중복 체크해야 함

        // 친구 등록 : 지정된 사용자와 친구가 아니더라도 등록 , 다른 친구를 같이 알고 있을 수 있음
        size = friendlist.size();
        String friend1, friend2;
        for(int i = 0; i < size; ++i)
        {
            friend1 = friendlist.get(i).get(0);
            friend2 = friendlist.get(i).get(1);
            // System.out.print("friend1 :" + friend1 + ", friend2 :"+friend2 + "\n");

            // 두 관계 중 한 사람이 지정된 사용자라면
            // 중복된 친구 관계는 나오지 않으므로
            // 한번 나올 때마다 바로 지정된 사용자의 친구 목록에 바로 추가하기
            if(friend1.equals(targetUser))
                this.friends.add(friend2);
            else if(friend2.equals(targetUser))
                this.friends.add(friend1);

            addUser(friend1);
            addUser(friend2);
        }

        // 전체 인원 모두 구했으므로
        scores = new int[len];
    }

    // 전체 사용자 목록에 이름이 있는지 확인하고
    // 없으면 새로 추가하는 함수
    void addUser(String name)
    {
        // 지정된 사용자라면 굳이 친구 목록에 추가할 필요가 없음
        if(name.equals(this.targetUser))
            return;
        // 전체 사용자에 사용자 아이디 등록되어 있지 않다면 추가
        if(!users.contains(name))
        {
            users.add(name);
            ++len;
        }
    }


}