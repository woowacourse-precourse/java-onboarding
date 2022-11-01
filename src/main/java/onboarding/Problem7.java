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
        sns.setAllUserScore(friends);
        // 기능 4 : 최고 점수 가진 리스트 확보d
        return sns.getRecommendationList();
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

    // 기능 3 : 각 사용자마다 점수 부여
    void setAllUserScore(List<List<String>> friendlist)
    {
        int i, j;

        // 방문객 점수부터 먼저 추가
        int index;
        String name;
        int size = visitors.size();
        for(i = 0; i < size; ++i)
        {
            name = visitors.get(i);
            index = users.indexOf(name);
            ++scores[index]; // 방문객은 1점 추가
        }

        // 동일하게 아는 친구 추가
        int relations = friendlist.size();
        String friend1, friend2;
        int index1, index2;
        for(i = 0; i < relations; ++i)
        {
            friend1 = friendlist.get(i).get(0);
            friend2 = friendlist.get(i).get(1);
            // 둘 중 하나라도 지정된 사용자와 같다면 : 굳이 비교할 필요 없음
            if(friend1.equals(targetUser))
                continue;
            if(friend2.equals(targetUser))
                continue;

            if(this.friends.contains(friend1))
            {
                index1 = users.indexOf(friend2);
                scores[index1] += 10;
            }
            if(this.friends.contains(friend2))
            {
                index2 = users.indexOf(friend1);
                scores[index2] += 10;
            }
        }
    }
    // 기능 4 : 최고 점수 가진 리스트 확보
    List<String> getRecommendationList()
    {
        class Candidate implements Comparable<Candidate> {
            String name;
            int score;

            Candidate(String name, int score)
            {
                this.name = name;
                this.score = score;
            }
            int getScore() { return score; }
            String getString() { return name; }

            @Override
            public int compareTo(Candidate o) {
                if(this.score > o.score)
                    return -1;
                else if(this.score == o.getScore() && this.name.compareTo(o.getString()) < 0)
                    return -1;
                else
                    return 1;
            }
        }
        ArrayList<String> answer = new ArrayList<>(); // 정답 배열
        ArrayList<Candidate> candidates = new ArrayList<>(); // 후보들의 점수 배열

        // 최종 후보들의 이름과 점수 입력받기
        for(int i = 0; i < len; ++i)
        {
            if(scores[i] == 0) // 추천 점수 없으면 배제
                continue;
            if(friends.contains(users.get(i))) // 이미 친구이면 배제
                continue;
            candidates.add(new Candidate(users.get(i), scores[i]));
        }

        Collections.sort(candidates);
        for(int i = 0; i < candidates.size(); ++i)
        {
            // System.out.print(candidates.get(i).getString() + " : " + candidates.get(i).getScore());
            if(i < 5) // 최대 5명
                answer.add(candidates.get(i).getString());
        }

        return answer;
    }
}