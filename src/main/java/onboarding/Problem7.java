package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Problem7 {

    // 중복 제거
    static List<List<String>> rmOverlap(List<List<String>> values) {
        return values.stream().distinct().collect(Collectors.toList());
    }

    // 1. 나와의 친구 관계 파악하기
    static void getCheckFriend(List<String> myFriendsList, String user, List<List<String>> friends) {
        for (int idx = 0; idx < friends.size(); idx++) {
            // 관계 내 내이름이 존재할 경우
            if (friends.get(idx).contains(user)) {
                // 나의 친구 리스트에 친구 저장
                for (String name : friends.get(idx))
                    if (user != name) myFriendsList.add(name);
            }
        }
    }

    // 2-1. 함께 아는 친구 찾기
    static void getCheckFriToFri(List<String> friFriendList, String user, List<String> myFriendsList, List<List<String>> friends) {
        for (int idx = 0; idx < myFriendsList.size(); idx++) {
            String friendName = myFriendsList.get(idx);

            for (int fIdx = 0; fIdx < friends.size(); fIdx++) {
                List<String> shipList = friends.get(fIdx);

                // 관계 정보에서 모두가 내 친구 X, 관계 정보에서 내가 포함 X
                if ((!shipList.contains(user)) && shipList.contains(friendName)) {
                    // 추천 친구 확인 & 친구의 친구 리스트에 저장
                    if ((shipList.indexOf(friendName) == 0) && (!myFriendsList.contains((shipList.get(1)))))
                        friFriendList.add(shipList.get(1));
                    else if ((shipList.indexOf(friendName) == 1) && (!myFriendsList.contains((shipList.get(0)))))
                        friFriendList.add(shipList.get(0));
                }
            }
        }
    }

    // 2-2. 관계 점수 저장
    static List<List<String>> addScoreShip(List<String> friFriendList, List<List<String>> friendRecoList) {
        for (String name : friFriendList) {
            int count = 0;
            count = Collections.frequency(friFriendList, name) * 10;

            // 이름, 점수 정보 리스트
            List<String> infoScore = new ArrayList<>();
            infoScore.add(name);
            infoScore.add(Integer.toString(count));

            // 추천 점수 저장
            friendRecoList.add(infoScore);
        }

        // 리스트 내 중복 제거
        List<List<String>> tempResult = rmOverlap(friendRecoList);

        return tempResult;
    }

    // 3-1. 방문 수만큼 점수 확인
    static void addVisitorScore(List<List<String>> infoScoreList, List<String> visitors, List<String> myFriendsList) {
        // 방문객 중복 제거
        List<String> filterVisitors = visitors.stream().distinct().collect(Collectors.toList());

        for (String name : filterVisitors) {
            // 방문객이 나의 친구가 아닌 경우
            if (!myFriendsList.contains(name)) {
                // 방문객 점수
                int nameCount = Collections.frequency(visitors, name);

                // 친구 추천 점수 갱신
                renewAddScore(infoScoreList, name, nameCount);
            }
        }
    }

    // 3-2 친구 추천 점수 리스트에 방문 점수 매기기
    static void renewAddScore(List<List<String>> infoScoreList, String name, int visitScore) {
        for (List<String> infoScore : infoScoreList) {
            // 방문자가 친구의 친구인 경우
            if (infoScore.contains(name)) {
                String score1 = infoScore.get(1);
                String score2 = Integer.toString(visitScore);

                // 점수 타입 변환 후 연산
                String scoreResult = getScoreCalc(score1, score2);

                // 점수 갱신
                infoScore.set(1, scoreResult);
                return;
            }
        }

        // 방문자가 친구의 친구가 아닌 경우
        List<String> infoVisitScore = new ArrayList<>();
        infoVisitScore.add(name);
        infoVisitScore.add(Integer.toString(visitScore));

        // 점수 추가
        infoScoreList.add(infoVisitScore);
        return;
    }

    // 4. 명단 정렬하기
    static void getRecoSort(List<List<String>> infoScoreList) {
        int sortNumber = 0;

        while (sortNumber < 2) {
            if (sortNumber >= 2)
                break;

            for (int a = 1; a < infoScoreList.size(); a++) {
                for (int b = a; b > 0; b--) {
                    String listOne = infoScoreList.get(b).get(sortNumber);
                    String listTwo = infoScoreList.get(b - 1).get(sortNumber);

                    // 이름 순으로 정렬
                    if (sortNumber == 0) {
                        if (listOne.compareTo(listTwo) < 0) {
                            List<String> temp = infoScoreList.get(b);
                            infoScoreList.set(b, infoScoreList.get(b - 1));
                            infoScoreList.set(b - 1, temp);
                        } else
                            break;
                    }

                    // 추천 점수 순으로 정렬
                    else if (sortNumber == 1) {
                        if (getNumSort(listOne, listTwo) == 1) {
                            List<String> temp = infoScoreList.get(b);
                            infoScoreList.set(b, infoScoreList.get(b - 1));
                            infoScoreList.set(b - 1, temp);
                        } else
                            break;
                    }
                }
            }

            sortNumber += 1;
        }
    }

    // 5. 친구 추천하기
    static List<String> getResultList(List<List<String>> infoScoreList) {
        // 최종 명단 정보 리스트
        List<String> resultList = new ArrayList<>();

        for (List<String> personInfo : infoScoreList) {
            int score = Integer.parseInt(personInfo.get(1));

            // 최종 명단 리스트가 꽉찬 경우
            if (personInfo.size() == 5)
                break;

            // 점수가 0보다 크면서 최종 명단 리스트가 5보다 작다면 추가
            if ((score > 0) && (resultList.size() < 5)) {
                resultList.add(personInfo.get(0));
            }
        }

        return resultList;
    }

    // 점수 타입 변환 & 점수 순 정렬 수행
    static int getNumSort(String listOne, String listTwo)
    {
        int num1 = Integer.parseInt(listOne);
        int num2 = Integer.parseInt(listTwo);

        if(num1 > num2)
            return 1;
        else
            return -1;
    }

    // 점수 타입 변환 & 연산 수행
    static String getScoreCalc(String score1, String score2)
    {
        int num1 = Integer.parseInt(score1);
        int num2 = Integer.parseInt(score2);

        int sumResult = num1 + num2;

        return Integer.toString(sumResult);
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        // 나의 친구 리스트
        List<String> myFriendsList = new ArrayList<>();

        // 친구의 친구 리스트
        List<String> friFriendList = new ArrayList<>();

        // 친구 추천 리스트
        List<List<String>> friendRecoList = new ArrayList<>();

        // 나의 친구 확인
        getCheckFriend(myFriendsList,user,friends);

        // 친구의 친구 확인 & 저장
        getCheckFriToFri(friFriendList,user,myFriendsList,friends);

        // 친구의 친구 관계 점수 저장
        List<List<String>> infoScoreList = addScoreShip(friFriendList,friendRecoList);

        // 방문자 점수 추가
        addVisitorScore(infoScoreList, visitors, myFriendsList);

        // 친구 추천 명단 정렬
        getRecoSort(infoScoreList);

        // 친구 추천 상위 5명
        answer = getResultList(infoScoreList);

        return answer;
    }
}

// 기능 요구 사항
// ✔ 1. 나와의 친구 관계 파악하기
//  : 나의 친구 리스트 생성 후 친구 저장
// ✔ 2. 모든 친구 관계에서 함께 아는 친구 점수 매기기
//  : 함께 아는 친구 찾기
//  : [명단,점수] 리스트 형식 생성 후 관계 점수 저장
// ✔ 3. 방문자 점수 매기기
//  : 방문 수만큼 점수 확인
//  : [명단,점수] 리스트에 방문 점수 매기기
// ✔ 4. 명단 정렬
//  : [명단,점수] 리스트를 이름 -> 점수으로 정렬하여 제한사항 해결
// ✔ 5. 친구 추천
//  : 인덱스에서 5명을 뽑되, 도중 0점이 나오면 정지

// 프로그래밍 요구 사항
// ✔ 1. JDK 11 버전
// ✔ 2. "build.gradle"을 변경 X, 외부 라이브러리 X
// ✔ 3. 프로그램 종료 시 "System.exit()"를 호출 X
// ✔ 4. 프로그램 구현이 완료되면 "ApplicationTest" 의 모든 테스트 성공하기
// ✔ 5. 프로그래밍 요구 사항에서 달리 명시하지 않은 한 파일, 패키지 이름을 수정하거나 이동 X

// 과제 진행 요구 사항
// ✔ 1. 미션은 "java-onboarding" 저장소를 "Fork & Clone" 해 시작하기
// ✔ 2. 과제 진행 및 제출하기
