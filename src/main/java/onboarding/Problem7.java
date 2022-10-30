package onboarding;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        System.out.println(friends);
        System.out.println(visitors);
        ArrayList<String> exFriends = new ArrayList<String>();

        for (int k=0;friends.size()>k;k++){
            if(Objects.equals(friends.get(k).get(0), user)) {
                exFriends.add(friends.get(k).get(1));
            }
            else if(Objects.equals(friends.get(k).get(1), user)) {
                exFriends.add(friends.get(k).get(0));
            }
        }

        System.out.println("기존친구"+exFriends);
///친구목록에서 이미 user와 친구를 exFriends로 분리///

        ArrayList<String> scoreTen = new ArrayList<String>();

        for (int s=0;friends.size()>s;s++){
            for (int k=0;exFriends.size()>k;k++){
                if(Objects.equals(friends.get(s).get(0), exFriends.get(k)) || Objects.equals(friends.get(s).get(1), exFriends.get(k))){
                    scoreTen.add(friends.get(s).get(0));
                    scoreTen.add(friends.get(s).get(1));
                }
            }
        }

        System.out.println("10점리스트"+scoreTen);
//// exFriends의 친구, 10점을 받아야하는 리스트를 scoreTen으로 출력

        HashMap<String,Integer> scoreTable = new HashMap<String,Integer>();

        for (int s=0;scoreTen.size()>s;s++){
            if (scoreTable.get(scoreTen.get(s)) == null){scoreTable.put(scoreTen.get(s),10);}
            else {scoreTable.put(scoreTen.get(s),scoreTable.get(scoreTen.get(s))+10);};
        }
        System.out.println("맵의결과는"+scoreTable);
//// HashscoreTable을활용, scoreTen내의 이름을 key로, 존재하는 개수 *10을 value로 부여하여 새로운 scoreTable을 생성

        for (int s=0;visitors.size()>s;s++){
            if (scoreTable.get(visitors.get(s)) == null){scoreTable.put(visitors.get(s),1);}
            else {scoreTable.put(visitors.get(s),scoreTable.get(visitors.get(s))+1);};
        }
        System.out.println("1점까지추가한맵의결과는"+scoreTable);
//// HashscoreTable을 활용, visitors내의 이름을 key로, 방문 횟수를 value로 부여하여 기존 scoreTable에 합산

        for (int k=0;exFriends.size()>k;k++){
             if (scoreTable.get(exFriends.get(k)) != null);{
                 scoreTable.remove(exFriends.get(k));
             }
        }
        scoreTable.remove(user);
//// 점수테이블에서 기존 친구들과 유저본인을 삭제

        System.out.println("원래상태"+scoreTable);
        TreeMap<String, Integer> sortKey = new TreeMap<>(scoreTable);
        System.out.println("트리로 키정렬"+sortKey);
///////TreeMap을 활용한 키 오름차순 정렬/////////////
        Map<String, Integer> sortDescending = sortKey.entrySet()
            .stream()
            .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
            .collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue(),
            (entry1, entry2) -> entry2, LinkedHashMap::new));
        System.out.println("정렬"+sortDescending);
//////entrySet과 stream,sort를 이용한 밸류 내림차순 정렬/////////////
        List<String> sortedKeyList = new ArrayList<>(sortDescending.keySet());
        System.out.println("정렬된맵을 다시 배열로"+sortedKeyList);
//정렬된 맵을 배열로 만들되 이제 key만있으면됨//

        ArrayList<String> answer = new ArrayList<String>();
        if(sortedKeyList.size()>5){
            for (int k=0;k<5;k++){
                answer.add(sortedKeyList.get(k));
            }
        }
        if(sortedKeyList.size()<=5){
            for (int k=0;k<sortedKeyList.size();k++){
                answer.add(sortedKeyList.get(k));
            }
        }
//최대 5개를 뽑아야 하므로, 배열의 길이가 5보다 작으면 배열의 사이즈를, 5보다 크면 다섯번만 for문 통해 add

        System.out.println(answer);

        return answer;
    }
}
