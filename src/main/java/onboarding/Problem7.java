package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Problem7 {

    final static int friendsScore = 10; // 사용자와 함께 아는 친구의 점수
    final static int visitTimeLineScore = 1; //사용자의 타임라인에 방문한 점수
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();



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
}
