package onboarding;


import java.util.*;

public class Problem7 {

    final static int friendsScore = 10; // 사용자와 함께 아는 친구 점수
    final static int visitTimeLineScore = 1; //사용자의 타임라인에 방문한 점수
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        List<String> visitorsArr = new LinkedList<>(visitors); // visitors에서 이미 친구인 이름을 용이하게 제외하기 위해 LinkedList로 재생성

        List<String> friendsList = idSearch(user, friends); // 사용자의 친구 리스트 저장
        // 삽입을 용이하게 하기위해 LinkedList를 사용
        List<List<String>> userFriendsId = new LinkedList<>(); // 사용자와 함께 아는 친구 리스트 저장

        for(String id : friendsList){
            userFriendsId.add(idSearch(id, friends)); // 사용자와 함게 아는 친구 검색
            userFriendsId.get(userFriendsId.size() - 1).remove(user); // user은 제외
            visitorsArr.remove(id); // 사용자의 친구는 visitors에서 제외
        } // end for

        List<String> answer = calScore(userFriendsId, visitorsArr); // 각 이름마다 점수 부여

        return answer;
    }

    // friends의 값에서 user의 친구들을 검색
    private static List<String> idSearch(String id, List<List<String>> friends){

        List<String> result = new ArrayList<>(); // 결과 id 리스트
        List<String> idList = new ArrayList<>(); // 검색된 id 리스트
        Iterator<List<String>> friendsIter = friends.iterator(); // friends의 반복자
        boolean searchFlag = false; // 검색 여부를 판단하는 플래그 변수

        while(friendsIter.hasNext()){
            idList = friendsIter.next();
            searchFlag = idList.contains(id);

            if(searchFlag && idList.get(0).equals(id)){ // id 발견 && id가 0번째 일 때
                result.add(idList.get(1)); // 1번째를 저장
            } else if (searchFlag && idList.get(1).equals(id)) { // id 발견 && id가 1번째 일 때
                result.add(idList.get(0)); // 0번째를 저장
            } // end if
        } // end while
        
        return result;
    } // end searchId

    // Map을 이용하여 이름마다 점수 부여
    private static List<String> calScore(List<List<String>> userFriendsId, LinkedList<String> visitorsArr){

        Map<String, Integer> scoreMap = new TreeMap<>();
        scoreMap = calFriendsScore(userFriendsId, scoreMap); // 친구 점수 계산
        scoreMap = timeLineScore(visitorsArr, scoreMap); // 타임라인 점수 계산

        return sortedByScore(scoreMap); // 점수가 높은 순으로 정렬
    } // end calScore

    // 친구 점수 부여
    private static Map<String, Integer> calFriendsScore(List<List<String>> userFriendsId, Map<String, Integer> scoreMap){

        for(List<String> idList : userFriendsId){
            for(String id : idList){
                if(scoreMap.containsKey(id)){ // 해당 키값이 존재한다면 기존 값에서 + friendsScore
                    scoreMap.put(id, scoreMap.get(id) + friendsScore);
                }else { // 해당 키값이 존재하지 않는다면 friendsScore로 초기화
                    scoreMap.put(id, friendsScore);
                } // end if
            } // end for
        } // end for

        return scoreMap;
    } // end calFriendsScore

} // end class
