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

        List<String> answer = null;
        return answer;
    }

    /**
     * 이미 유저와 친구인 사람들은 점수계산과 결과목록에서 제외하기위해 따로 저장.
     * @param user 유저 이름
     * @param friends 친구 관계 정보
     * @return 이미 유저와 친구인 사람들
     */
    public static String[] CheckAlreadyFriend(String user, List<List<String>> friends) {
        HashSet<String> tempSet = new HashSet<>();

        for (List<String> i : friends) {
            if (user.equals(i.get(0))) {
                tempSet.add(i.get(1));
            } else if (user.equals(i.get(1))) {
                tempSet.add(i.get(0));
            }
        }
        String[] tempArray = tempSet.toArray(new String[0]);
        return tempArray;
    }

    /**
     * 친구 후보 목록을 문자열 배열로 저장.
     * @param user 유저 이름
     * @param alreadyFriends 이미 친구인 사람들
     * @param friends 친구 관계 정보
     * @return 친구 후보 목록
     */
    public static String[] AddCandidate(String user, String[] alreadyFriends, List<List<String>> friends, List<String> visitors){
        LinkedHashSet<String> tempHashSet = new LinkedHashSet<>();
        for(List<String> i : friends){
            for(String j : i){
                tempHashSet.add(j);
            }
        }
        for(String i : visitors){
            tempHashSet.add(i);
        }

        tempHashSet.remove(user);
        for(String i : alreadyFriends){
            tempHashSet.remove(i);
        }

        String[] tempArray = tempHashSet.toArray(new String[0]);
        return tempArray;
    }
}

