package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem7 {

    // 1. 나와의 친구 관계 파악하기
    static void getCheckFriend(List<String> myFriendsList, String user, List<List<String>> friends)
    {
        for(int idx=0; idx<friends.size(); idx++)
        {
            // 관계 내 내이름이 존재할 경우
            if(friends.get(idx).contains(user))
            {
                // 나의 친구 리스트에 친구 저장
                for(String name : friends.get(idx))
                    if(user != name) myFriendsList.add(name);
            }
        }
    }

    // 2-1. 함께 아는 친구 찾기
    static void getCheckFriToFri(List<String> friFriendList, String user, List<String> myFriendsList, List<List<String>> friends)
    {
        for(int idx=0; idx<myFriendsList.size(); idx++)
        {
            String friendName = myFriendsList.get(idx);

            for(int fIdx=0; fIdx<friends.size(); fIdx++)
            {
                List<String> shipList = friends.get(fIdx);

                // 관계 정보에서 모두가 내 친구 X, 관계 정보에서 내가 포함 X
                if((!shipList.contains(user)) && shipList.contains(friendName))
                {
                    // 추천 친구 확인 & 친구의 친구 리스트에 저장
                    if((shipList.indexOf(friendName) == 0) && (!myFriendsList.contains((shipList.get(1)))))
                        friFriendList.add(shipList.get(1));
                    else if((shipList.indexOf(friendName) == 1) && (!myFriendsList.contains((shipList.get(0)))))
                        friFriendList.add(shipList.get(0));
                }
            }
        }
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        // 나의 친구 리스트
        List<String> myFriendsList = new ArrayList<>();

        // 친구의 친구 리스트
        List<String> friFriendList = new ArrayList<>();

        // 나의 친구 확인
        getCheckFriend(myFriendsList,user,friends);

        // 친구의 친구 확인 & 저장
        getCheckFriToFri(friFriendList,user,myFriendsList,friends);

        // 친구의 친구 리스트 결과 확인
        System.out.println(friFriendList);

        return answer;
    }
}

// 기능 요구 사항
// 1. 나와의 친구 관계 파악하기
//  : 나의 친구 리스트 생성 후 친구 저장
// 2. 모든 친구 관계에서 함께 아는 친구 점수 매기기
//  : 친구의 친구 리스트를 생성 후 저장
//  : [명단,점수] 리스트 형식 생성 후 관계 점수 저장
// 3. 방문자 점수 매기기
//  : [명단,점수] 리스트에 방문 점수 매기기
// 4. 명단 정렬
//  : [명단,점수] 리스트를 이름 -> 점수으로 정렬하여 제한사항 해결
// 5. 친구 추천
//  : 인덱스에서 5명을 뽑되, 도중 0점이 나오면 정지
// 6. 제한사항
//  : user 길이
//  : friends 자체 길이
//  : friends 내 원소 길이
//  : friends 내 원소 아이디 길이
//  : 방문자 리스트 길이
//  : 사용자 아이디 형식
//  : 친구 관계 중복 확인

// 프로그래밍 요구 사항
// ✔ 1. JDK 11 버전
// 2. "build.gradle"을 변경 X, 외부 라이브러리 X
// 3. 프로그램 종료 시 "System.exit()"를 호출 X
// 4. 프로그램 구현이 완료되면 "ApplicationTest" 의 모든 테스트 성공하기
// 5. 프로그래밍 요구 사항에서 달리 명시하지 않은 한 파일, 패키지 이름을 수정하거나 이동 X

// 과제 진행 요구 사항
// ✔ 1. 미션은 "java-onboarding" 저장소를 "Fork & Clone" 해 시작하기
// ✔ 2. 과제 진행 및 제출하기
