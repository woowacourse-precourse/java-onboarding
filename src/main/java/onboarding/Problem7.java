package onboarding;

import com.sun.jdi.ArrayReference;

import java.util.*;
import java.util.Map.Entry;

public class Problem7 {
    // 그래프 클래스 구현 (이어진 정점은 친구로 판단하기 위함)
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        // 주인공 입장에서 아는 친구들 일단 구하기

        // 나머지 입장에서 주인공이랑 겹치는 친구들 구해서 점수에 더해주기

        // 방문 횟수만큼 점수에 더해주기

        // 자기 자신이나 이미 친구인 애들, 그리고 점수가 0점인 애들은 지워주기

        // entryset 정렬하되, 겹치면 알파벳 순


        return new ArrayList<>();
    }

    private static void initGraph(List<List<String>> friends) {
    }

    private static void initTables(List<List<String>> friends) {
    }

    private static void addIntersectFriendScore(String user, ArrayList<Integer> friendOfUser) {
    }

    private static void addVisitorScore(List<String> visitors) {
    }

    private static void eraseNotQualified(String user, ArrayList<Integer> friendOfUser) {
    }
}
