package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.LinkedHashSet;
import java.util.HashSet;
import java.util.ArrayList;



public class Problem7 {

    public static List<String> solution(String user, List<List<String>> friends,
        List<String> visitors) {
        String[] alreadyFriends = CheckAlreadyFriend(user, friends); // 이미 친구인 유저들 목록
        String[] candidates = AddCandidate(user, alreadyFriends, friends, visitors); // 친구 후보 목록
        int[] scores = CalculateInvitationScore(user, candidates, alreadyFriends, friends, visitors); // 친구 추천 알고리즘 계산
        List<String> answer = AddAnswer(candidates, scores); // 결과값 추가

        return answer;
    }

    /**
     * 점수가 높은 순서대로 문자열 리스트에 넣기
     * @param candidates 친구 후보
     * @param scores 친구 후보들의 점수
     * @return 친구 추천 리스트
     */
    public static ArrayList<String> AddAnswer(String[] candidates, int[] scores) {
        ArrayList<String> tempList = new ArrayList<>();
        ArrayList<String> tempSortList = new ArrayList<>(); // 동점이 발생했을 경우 임시로 저장할 문자열 리스트
        int maxScore = 0;
        int index = -1;
        boolean isFull = false;

        for (int i = 0; i < 5; i++) {
            tempSortList.clear(); // 동점발생 시 정렬할 리스트 초기화
            maxScore = 0; // 최고 점수 초기화
            if (isFull) { // 5명이 다 찼으면 종료
                break;
            }
            // 가장 높은 점수 찾기
            for(int j = 0; j < scores.length; j ++){
                if(maxScore < scores[j]){
                    maxScore = scores[j];
                    index = j;
                }
            }

            if(maxScore == 0 ) break; // 추천할 친구가 없을 경우 종료
            if(!CheckTie(scores, maxScore)){ // 동점이 없다면?
                tempList.add(candidates[index]); // 결과값에 등록
                scores[index] = 0;
            }
            else{ // 동점이 존재한다면?
                for(int j = 0; j < scores.length; j ++){
                    if(maxScore == scores[j]){ // 동점인가?
                        tempSortList.add(candidates[j]); // 정렬될 리스트에 등록
                    }
                }
                Collections.sort(tempSortList); // 오름차순 정렬
                for(int j = 0; j < tempSortList.size(); j ++){
                    if(tempList.size() == 5){ // 결과값이 이미 5개라면
                        return tempList; // 리턴 후 종료
                    }
                    tempList.add(tempSortList.get(j));
                    for(int k = 0; k < candidates.length; k ++ ){
                        if(candidates[k].equals(tempSortList.get(j))){
                            scores[k] = 0;
                        }
                    }
                }
            }
        }
        return tempList;
    }

    /**
     * 동점 여부 검사
     * @param scores 점수 목록
     * @param score 찾을 점수
     * @return 동점있으면 true, 없으면 false.
     */
    public static boolean CheckTie(int[] scores, int score){
        int count = 0;
        for(int i = 0; i < scores.length; i ++ ) {
            if (score == scores[i]) {
                count++;
            }
        }
        boolean isTie = count > 1 ? true : false;
        return isTie;
    }
    /**
     * 친구 찾기 알고리즘에 따른 점수 계산
     * @param user 유저 아이디
     * @param candidates 친구 후보 아이디
     * @param alreadyFriends 이미 친구인 아이디
     * @param friends 친구 관계 목록
     * @param visitors 타임라인 방문자 목록
     * @return 후보군들의 점수
     */

    public static int[] CalculateInvitationScore(String user, String[] candidates, String[] alreadyFriends, List<List<String>> friends, List<String> visitors){
        int[] tempScore = new int[candidates.length];

        //타임라인에 방문한 횟수 계산
        for(String i : visitors){
            for(int j = 0; j < candidates.length; j ++){
                if(candidates[j].equals(i)){
                    tempScore[j]++; // 1점 증가
                }
            }
        }

        //사용자와 함께 하는 친구의 수 계산
        for(List<String> i : friends){
            if(user.equals(i.get(0)) || user.equals(i.get(1))){ // 유저가 들어있는 관계면 그냥 넘어감
                continue;
            }
            for(String j : alreadyFriends){
                if(i.get(0).equals(j)){ // 1번째 아이디가 유저와 이미 친구라면
                    tempScore[findIndex(candidates, i.get(1))] += 10; // 2번째 아이디와 일치하는 후보의 점수 +10.
                } else if(i.get(1).equals(j)){ // 2번째 아이디가 유저와 이미 친구라면
                    tempScore[findIndex(candidates, i.get(0))] += 10; // 1번째 아이디와 일치하는 후보의 점수 +10.
                }
            }
        }

        return tempScore;
    }

    /**
     * 배열에서 몇번째가 타겟 문자열과 일치하는지 구하는 메서드
     * @param tempArray 문자열 배열
     * @param target 목표 문자열
     * @return 배열의 몇번째에 있는지 찾기. 없으면 -1
     */
    public static int findIndex(String[] tempArray, String target){
        for(int i = 0; i < tempArray.length; i ++ ){
            if(target.equals(tempArray[i])){
                return i;
            }
        }
        return -1;
    }
    /**
     * 이미 유저와 친구인 사람들은 점수계산과 결과목록에서 제외하기위해 따로 저장.
     * @param user 유저 아이디
     * @param friends 친구 관계 정보
     * @return 이미 유저와 친구인 사람들
     */
    public static String[] CheckAlreadyFriend(String user, List<List<String>> friends) {
        HashSet<String> tempSet = new HashSet<>();

        for (List<String> i : friends) {
            if (user.equals(i.get(0))) { // 첫번째 아이디가 유저면
                tempSet.add(i.get(1)); // 두번째 아이디 저장
            } else if (user.equals(i.get(1))) { // 두번째 아이디가 유저면
                tempSet.add(i.get(0)); // 첫번째 아이디 저장
            }
        }
        return tempSet.toArray(new String[0]); // 문자열로 반환
    }

    /**
     * 친구 후보 목록을 문자열 배열로 저장.
     * @param user 유저 아이디
     * @param alreadyFriends 이미 친구인 사람들
     * @param friends 친구 관계 정보
     * @return 친구 후보 목록
     */
    public static String[] AddCandidate(String user, String[] alreadyFriends, List<List<String>> friends, List<String> visitors){
        LinkedHashSet<String> tempHashSet = new LinkedHashSet<>();

        //주어진 모든 아이디를 저장
        for(List<String> i : friends){
            for(String j : i){
                tempHashSet.add(j);
            }
        }
        for(String i : visitors){
            tempHashSet.add(i);
        }

        tempHashSet.remove(user); // 유저 아이디는 삭제
        for(String i : alreadyFriends){
            tempHashSet.remove(i); // 유저와 이미 친구인 아이디도 삭제
        }

        return tempHashSet.toArray(new String[0]); // 문자열로 반환
    }
}

