package onboarding;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        ArrayList<String> exFriends = new ArrayList<String>();

        for (List<String> strings : friends) {
            if (Objects.equals(strings.get(0), user)) {
                exFriends.add(strings.get(1));
            } else if (Objects.equals(strings.get(1), user)) {
                exFriends.add(strings.get(0));
            }
        }
///친구목록에서 이미 user와 친구를 exFriends로 분리///
        ArrayList<String> scoreTen = new ArrayList<String>();

        for (List<String> friend : friends) {
            for (String exFriend : exFriends) {
                if (Objects.equals(friend.get(0), exFriend) || Objects.equals(friend.get(1),
                    exFriend)) {
                    scoreTen.add(friend.get(0));
                    scoreTen.add(friend.get(1));
                }
            }
        }
//// exFriends의 친구, 10점을 받아야하는 리스트를 scoreTen으로 출력
        HashMap<String,Integer> scoreTable = new HashMap<String,Integer>();

        for (String value : scoreTen) {
            if (scoreTable.get(value) == null) {
                scoreTable.put(value, 10);
            } else {
                scoreTable.put(value, scoreTable.get(value) + 10);
            }
            ;
        }
//// HashscoreTable을활용, scoreTen내의 이름을 key로, 존재하는 개수 *10을 value로 부여하여 새로운 scoreTable을 생성
        for (String visitor : visitors) {
            if (scoreTable.get(visitor) == null) {
                scoreTable.put(visitor, 1);
            } else {
                scoreTable.put(visitor, scoreTable.get(visitor) + 1);
            }
            ;
        }
//// HashscoreTable을 활용, visitors내의 이름을 key로, 방문 횟수를 value로 부여하여 기존 scoreTable에 합산
        for (String exFriend : exFriends) {
            if (scoreTable.get(exFriend) != null)
            {
                scoreTable.remove(exFriend);
            }
        }
        scoreTable.remove(user);
//// 점수테이블에서 기존 친구들과 유저본인을 삭제
        TreeMap<String, Integer> sortKey = new TreeMap<>(scoreTable);
///////TreeMap을 활용한 키 오름차순 정렬/////////////
        Map<String, Integer> sortDescending = sortKey.entrySet()
            .stream()
            .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
            .collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue(),
            (entry1, entry2) -> entry2, LinkedHashMap::new));
//////entrySet과 stream,sort를 이용한 밸류 내림차순 정렬/////////////
        List<String> sortedKeyList = new ArrayList<>(sortDescending.keySet());
//정렬된 맵을 배열로 만들되 이제 key만있으면됨//
        ArrayList<String> answer = new ArrayList<String>();
        if(sortedKeyList.size()>5){
            for (int k=0;k<5;k++){
                answer.add(sortedKeyList.get(k));
            }
        }
        if(sortedKeyList.size()<=5){
            for (String s : sortedKeyList) {
                answer.add(s);
            }
        }
//최대 5개를 뽑아야 하므로, 배열의 길이가 5보다 작으면 배열의 사이즈를, 5보다 크면 다섯번만 for문 통해 add
        return answer;
    }
}
