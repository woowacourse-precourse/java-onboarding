package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        final int maxNumberOfUsers = 30000;
        //index에 할당한 이름을 저장한 테이블
        String[] userNameArray = new String[maxNumberOfUsers];
        //유저 이름을 키 인덱스를 value로한 Map
        Map<String, Integer> userNameMap = new HashMap<>();
        //친구관계를 저장할 List
        List<List<Integer>> friendsNetwork = new ArrayList<>();
        //유저의 친밀도를 기록할 배열 [0] : 친밀도 [1] : indexNumber
        int[][] intimacyArray = new int[maxNumberOfUsers][2];
        //최종 제출할 추천 친구 이름을 기록할 List
        List<String> recommendedFriends = new ArrayList<>();
    }
}
