package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.LinkedHashSet;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Arrays;



public class Problem7 {

    public static List<String> solution(String user, List<List<String>> friends,
        List<String> visitors) {

        String[] alreadyFriends = CheckAlreadyFriend(user, friends); // 이미 친구인 유저들 목록
        String[] candidates = AddCandidate(user, alreadyFriends, friends, visitors); // 친구 후보 목록
        int[] scores = CalculateInvitationScore(user, candidates, alreadyFriends, friends, visitors);
        List<String> answer = null;
        return answer;
    }


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
        for(int i = 0; i < candidates.length; i ++ ){
            System.out.println(candidates[i] + ": " + tempScore[i]);
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
        String[] tempArray = tempSet.toArray(new String[0]); // 문자열 배열로 전달
        return tempArray;
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

        String[] tempArray = tempHashSet.toArray(new String[0]); // 문자열배열로 전달
        return tempArray;
    }
}

