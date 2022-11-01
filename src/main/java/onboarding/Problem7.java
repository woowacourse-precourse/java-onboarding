package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        //친구 추천 점수를 받을 수 있는 인물의 이름만 모아둔 리스트를 생성
        List<String> nameList = extractNameList(user,friends,visitors);
        System.out.println("nameList : " + nameList);

        //인물별 점수가 포함된 2차원 배열을 생성
        String[][] scoreInNameArr = new String[nameList.size()][2];
        for (int i = 0; i < nameList.size(); i++) {
            scoreInNameArr[i][0] = nameList.get(i);
            scoreInNameArr[i][1] = "0";
            checkScoreBasedFriends(friends, nameList, scoreInNameArr, i);
            checkScoreBasedvisitors(visitors, nameList, scoreInNameArr, i);
        }

        //점수를 기준으로 내림차순 정렬
        scoreBasedReverseSort(scoreInNameArr);
        //만일 점수가 같은 인물이 있다면 사전순으로 정렬
        nameBasedSort(scoreInNameArr);

        //추천할 인물 이름 리스트. 이때, 최대 5명까지 반환되도록 한다.
        List<String> answer = new ArrayList<>();
        for (int j = 0; j < scoreInNameArr.length; j++) {
            answer.add(scoreInNameArr[j][0]);
            if (answer.size() == 5) {
                return answer;
            }
        }
        return answer;
    }

    private static void nameBasedSort(String[][] scoreInNameArr) {
        String temp;
        for (int x = 1; x < scoreInNameArr.length; x++) {
            if (Integer.parseInt(scoreInNameArr[x-1][1]) == Integer.parseInt(scoreInNameArr[x][1])) {
                if (scoreInNameArr[x-1][0].compareToIgnoreCase(scoreInNameArr[x][0]) > 0) {
                    temp = scoreInNameArr[x][0];
                    scoreInNameArr[x][0] = scoreInNameArr[x-1][0];
                    scoreInNameArr[x-1][0] = temp;
                }
            }
        }
    }

    private static void scoreBasedReverseSort(String[][] scoreInNameArr) {
        String score;
        String name;
        for (int j = 0; j < scoreInNameArr.length-1; j++){
            for (int x = j+1; x < scoreInNameArr.length; x++) {
                if (Integer.parseInt(scoreInNameArr[x][1]) > Integer.parseInt(scoreInNameArr[j][1])) {
                    score = scoreInNameArr[x][1];
                    scoreInNameArr[x][1] = scoreInNameArr[j][1];
                    scoreInNameArr[j][1] = score;
                    name = scoreInNameArr[x][0];
                    scoreInNameArr[x][0] = scoreInNameArr[j][0];
                    scoreInNameArr[j][0] = name;
                }
            }
        }
    }

    private static void checkScoreBasedvisitors(List<String> visitors, List<String> nameList, String[][] scoreInNameArr, int i) {
        for (int x = 0; x < visitors.size(); x++) {
            if (nameList.get(i).equals(visitors.get(x))) {
                scoreInNameArr[i][1] = String.valueOf(Integer.parseInt(scoreInNameArr[i][1]) + 1);
            }
        }
    }

    private static void checkScoreBasedFriends(List<List<String>> friends, List<String> nameList, String[][] scoreInNameArr, int i) {
        for (int j = 0; j < friends.size(); j++) {
            if (nameList.get(i).equals(friends.get(j).get(0)) || nameList.get(i).equals(friends.get(j).get(1))) {
                scoreInNameArr[i][1] = String.valueOf(Integer.parseInt(scoreInNameArr[i][1]) + 10);
            }
        }
    }

    private static List<String> extractNameList(String user, List<List<String>> friends, List<String> visitors) {
        List<String> nameList = new ArrayList<>();
        for (int i = 0; i < friends.size(); i++) {
            nameList.add(friends.get(i).get(0));
            nameList.add(friends.get(i).get(1));
        }
        nameList.addAll(visitors);

        for (int j = 0; j < friends.size(); j++) {
            String name;
            if (friends.get(j).get(1).equals(user)) {
                name = friends.get(j).get(0);
                nameList.removeAll(Collections.singleton(name));
            }
        }

        nameList.removeAll(Collections.singleton(user));

        Set<String> set = new HashSet<String>(nameList);
        List<String> result = new ArrayList<String>(set);
        return result;
    }
}