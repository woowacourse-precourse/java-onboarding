package onboarding;

import java.util.*;

public class Problem7 {
    public static ArrayList sortByValue(HashMap<String, Integer> map) {
        ArrayList<String> keyList = new ArrayList(map.keySet());
        Collections.sort(keyList, new Comparator() {
            public int compare(Object o1, Object o2) {

                return map.get(o2).compareTo(map.get(o1));

            }
        });
// 나중에 하기 -> 5개만 뽑기
//        if (keyList.size() > 5){
//            ArrayList<String> keyList = keyList.subList(0,5);
//        }
        return keyList;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<String>();

        String user1 = "mrko";
        List<List<String>> friends1 = List.of(
                List.of("donut", "andole"),
                List.of("donut", "jun"),
                List.of("donut", "mrko"),
                List.of("shakevan", "andole"),
                List.of("shakevan", "jun"),
                List.of("shakevan", "mrko")
        );
        List<String> visitors1 = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
        List<String> result = List.of("andole", "jun", "bedi");

        HashMap<String, Integer> FriendScore = new HashMap<String, Integer>();
        List<String> Friend = new ArrayList<String>();
        List<String> NotFriend = new ArrayList<String>();
        List<String> Visitor = new ArrayList<String>();

        // Friend 명단 만들기
        for (int i = 0; i < friends.size(); i++){
            if(friends1.get(i).contains(user1)){
                for(int j = 0; j < 2; j++){
                    if(!friends1.get(i).get(j).equals(user1)){
                        Friend.add(friends1.get(i).get(j));
                    }
                }
            }
        }

        // 함께 아는 친구 수 계산
        for (int i = 0; i < friends1.size(); i++){
            for (int j = 0; j < Friend.size(); j++){
                String name_f = Friend.get(j);
                if(friends1.get(i).contains(name_f)){
                    for(int k = 0; k < 2; k++){
                        if(!friends1.get(i).get(k).equals(name_f) &&
                                !friends1.get(i).get(k).equals(user1)){
                            NotFriend.add(friends1.get(i).get(k));
                        }
                    }
                }
            }
        }
        Set<String> set = new HashSet<String>(NotFriend);
        for (String str : set){
            FriendScore.put(str, 10*(Collections.frequency(NotFriend,str)));
        }

        // 방문자 수 계산
        for (int i = 0; i < visitors1.size(); i++){
            if(!Friend.contains(visitors1.get(i))){
                Visitor.add(visitors1.get(i));
            }
        }

        Set<String> set1 = new HashSet<String>(Visitor);
        for (String str : set1){
            if(FriendScore.keySet().contains(str)){
                FriendScore.replace(str, FriendScore.get(str) + (Collections.frequency(Visitor,str)));
            }
            else {
                FriendScore.put(str, (Collections.frequency(Visitor,str)));
            }
        }

        // 점수 높은 순으로 sort
        answer = sortByValue(FriendScore);

        return answer;
    }
}
