package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        String[][] newFrinedList = makeFriendList(user,friends); // 친구리스트를 정리
        String[] people = sortPeople(friends, visitors);
        int minusPeopleCnt = 0;

        for(int i = 0; i < people.length; i++){
            if(people[i].equals(user)){
                people[i] = " ";
            }
            for(int j= 0; j < newFrinedList.length; j++) {
                if (people[i].equals(newFrinedList[j][0])){
                    people[i] = " ";
                    break;
                }
            }
        }

        int[] score = new int[people.length-minusPeopleCnt];
        for(int i = 0; i < score.length; i++){
            score[i] = scoreCal(people[i], newFrinedList, visitors);
        }



        int[] temp = sortToScore(score,people);

        int num = 0;
        for(int i = 0; i < temp.length; i++ ){
            if (score[temp[i]] == 0) {
                continue;
            }else {
                num += 1;
            }
        }
        String[] tempAnswer = new String[num];
        for(int i = 0; i <tempAnswer.length; i++){
            if(score[temp[i]] == 0) {
                break;
            }
            else if(score[temp[i]] != 0) {
                tempAnswer[i] = people[temp[i]];
            }
        }

        answer = List.of(tempAnswer);

        return answer;
    }
//점수 높은대로 정렬하고 같은 점수이면 오름차순으로 정렬하기
    public static int[] sortToScore(int[] score , String[] people){
        int[][] scoreToIndex = new int[score.length][2];  // 스코어 인데스
        for(int i = 0; i < score.length; i++){
            scoreToIndex[i][0] = score[i];
            scoreToIndex[i][1] = i;
        }
        for (int i = 0; i < scoreToIndex.length; i++) {
            for (int j = i + 1; j < scoreToIndex.length; j++) {
                if (scoreToIndex[i][0] < scoreToIndex[j][0]) {
                    int tmepScore = scoreToIndex[i][0];
                    int tmepIndex = scoreToIndex[i][1];
                    scoreToIndex[i][0] = scoreToIndex[j][0];
                    scoreToIndex[i][1] = scoreToIndex[j][1];
                    scoreToIndex[j][0] = tmepScore;
                    scoreToIndex[j][1] = tmepIndex;
                }
            }
        }
        int[] hightScoreIndexList = new int[score.length];

        for (int i = 0; i < scoreToIndex.length; i++) {
            for (int j = i + 1; j < scoreToIndex.length; j++) {
                if (scoreToIndex[i][0] == scoreToIndex[j][0]) {
                    if((int)people[scoreToIndex[i][1]].charAt(0) > (int)people[scoreToIndex[j][1]].charAt(0)){
                        int tmepScore = scoreToIndex[i][0];
                        int tmepIndex = scoreToIndex[i][1];
                        scoreToIndex[i][0] = scoreToIndex[j][0];
                        scoreToIndex[i][1] = scoreToIndex[j][1];
                        scoreToIndex[j][0] = tmepScore;
                        scoreToIndex[j][1] = tmepIndex;
                    }
                }
            }
        }


        for(int i = 0; i < scoreToIndex.length; i++){
            hightScoreIndexList[i] = scoreToIndex[i][1];
        }

        return hightScoreIndexList;
    }

// 친구리스트를 넣어주면 [[a,d,f],[b,e,r,t]]리턴 자기 0번지에 친구랑 나머지 번지에 친구의 친구를 정리.
    public static String[][] makeFriendList(String user, List<List<String>> friends) {

//유저의 친구가 몇명인지 확인하는과정
        String[] userFriendList = findFriend(user, friends);
        String[][] friendOfFriendList = new String[userFriendList.length][friends.size()];
//유저의 친구의 친구가 최대 몇명인지 확인하는과정
        for(int i = 0; i < userFriendList.length; i++){
            friendOfFriendList[i] = findFriend(userFriendList[i],friends);
        }

        String[][] resultList = new String[userFriendList.length][friends.size()];

        for(int i = 0; i < userFriendList.length; i++){
            resultList[i][0] = userFriendList[i];
            for(int j = 1; j<= friendOfFriendList[i].length; j++){
                resultList[i][j] = friendOfFriendList[i][j-1];
            }
        }
        return resultList;
    }

//유저의 친구를 배열로 반환 ex) 영광친구 찾아줘 [성현,산천]  flag 0은 메인유저의 친구 찾기 1은 친구의 친구찾기
    public static String[] findFriend(String user, List<List<String>> friends) {
        int userFriend = 0;
        for(int i = 0; i<friends.size(); i++){
            for(int j = 0; j < friends.get(i).size(); j++){
                if(user.equals(friends.get(i).get(j))){
                    userFriend +=1;
                }
            }
        }
        String[] friendList = new String[userFriend];

        int k = 0;
        for(int i = 0; i<friends.size(); i++){
            for(int j = 0; j < friends.get(i).size(); j++){
                if(user.equals(friends.get(i).get(j))){
                    if (j == 0) {
                        friendList[k] = friends.get(i).get(1);
                        k += 1;
                    } else {
                        friendList[k] = friends.get(i).get(0);
                        k += 1;
                    }
                }
            }
        }
        return friendList;
    }

    public static String[] sortPeople(List<List<String>> friends, List<String> visitors) {
        int num = 0;
        for(int i = 0; i < friends.size(); i++){
            for(int j = 0; j < friends.get(i).size(); j++){
                num += 1;
            }
        }
        num += visitors.size();
        String[] tempresult = new String[num];
        int k = 0;
        for(int i = 0; i < friends.size(); i++){
            for(int j = 0; j < friends.get(i).size(); j++){
                if(checkArray(friends.get(i).get(j), tempresult) && checkArray(friends.get(i).get(j), tempresult)){
                    tempresult[k] = friends.get(i).get(j);
                    k += 1;
                }
            }
        }
        for(int i = 0; i < visitors.size(); i++){
            if(checkArray(visitors.get(i), tempresult) && checkArray(visitors.get(i), tempresult)){
                tempresult[k] = visitors.get(i);
                k += 1;
            }
        }
        num = 0;
        for(int i = 0; i < tempresult.length; i++){
            if(tempresult[i] != null) {
                num += 1;
            }
        }
        String[] result = new String[num];
        for(int i = 0; i < result.length; i++){
            result[i] = tempresult[i];
        }

        return result;
    }
    public static boolean checkArray(String checkPoint, String[] checkList){
        for(int i = 0; i < checkList.length; i++){
            if(checkList[i] == checkPoint){
                return false;
            }
        }
        return true;
    }
    public static boolean checkArray(int checkPoint, int[] checkList){
        for(int i = 0; i < checkList.length; i++){
            if(checkList[i] == checkPoint){
                return false;
            }
        }
        return true;
    }
    public static int scoreCal (String name,String[][] friendList, List<String> visitor ){
        int score = 0;
//친구의 친구인지 확인하는 과정
        for(int i = 0; i < friendList.length; i++){
            for(int j = 0; j<friendList[i].length; j++) {
                if(name.equals(friendList[i][j])){
                    score += 10;
                }
            }
        }
//방문횟수 체크
        for(int i = 0; i < visitor.size(); i++){
            if(name.equals(visitor.get(i))){
                score += 1;
            }
        }

        return score;
    }
    public static boolean checkArray(String checkPoint, List<String> checkList){
        for(int i = 0; i < checkList.size(); i++){
            if(checkList.get(i) == checkPoint){
                return false;
            }
        }
        return true;
    }

}
