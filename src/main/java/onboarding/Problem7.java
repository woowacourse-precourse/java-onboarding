package onboarding;

import java.util.*;

public class Problem7 {
    // 점수별 내림차순 정렬 함수
    public static List<String> sortByValue(HashMap<String, Integer> map) {
        List<String> result = new ArrayList<String>();
        List<String> keyList = new ArrayList<String>(map.keySet());
        Collections.sort(keyList, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return map.get(o2).compareTo(map.get(o1));
            }
        });

        // 최대 5명 return
        if(keyList.size()>5){
            result = keyList.subList(0,5);
        }
        else {
            result = keyList;
        }

        return result;
    }

    public static List<String> makeFriend(List<List<String>> listD, String user){
        // Friend 명단 만들기
        List<String> result = new ArrayList<String>();
        for (int i = 0; i < listD.size(); i++){
            if(listD.get(i).contains(user)){
                for(int j = 0; j < 2; j++){
                    if(!listD.get(i).get(j).equals(user)){
                        result.add(listD.get(i).get(j));
                    }
                }
            }
        }
        return result;
    }
    // 함께 아는 친구 리스트 (중복 허용) 생성 함수
    public static List<String> make_together(List<List<String>> listD, String user , List<String> Friend){
        // 함께 아는 친구 리스트
        List<String> result = new ArrayList<String>();
        for (int i = 0; i < listD.size(); i++){
            for (int j = 0; j < Friend.size(); j++){
                String name_f = Friend.get(j);
                if(listD.get(i).contains(name_f)){
                    for(int k = 0; k < 2; k++){
                        if(!listD.get(i).get(k).equals(name_f) &&
                                !listD.get(i).get(k).equals(user)){
                            result.add(listD.get(i).get(k));
                        }
                    }
                }
            }
        }
        return result;
    }
    // 함께 아는 친구 점수 배정
    public static void count_together(HashMap<String, Integer> score, List<String> togehter){
        Set<String> set = new HashSet<String>(togehter);
        for (String str : set){
            score.put(str, 10*(Collections.frequency(togehter,str)));
        }
    }
    // 방문자 리스트 (중복허용) 생성 함수
    public static List<String> make_visitor(List<String> l, List<String> Friend){
        // 방문자 리스트
        List<String> result = new ArrayList<String>();
        for (int i = 0; i < l.size(); i++){
            if(!Friend.contains(l.get(i))){
                result.add(l.get(i));
            }
        }
        return result;
    }
    // 방문 점수 배정
    public static void count_visit(HashMap<String, Integer> score, List<String> visitor){
        Set<String> set = new HashSet<String>(visitor);
        for (String str : set){
            if(score.keySet().contains(str)){
                score.replace(str, score.get(str) + (Collections.frequency(visitor,str)));
            }
            else {
                score.put(str, (Collections.frequency(visitor,str)));
            }
        }
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<String>();

        HashMap<String, Integer> FriendScore = new HashMap<String, Integer>();
        List<String> Friend = makeFriend(friends, user);

        List<String> Together = make_together(friends, user, Friend);
        count_together(FriendScore, Together);

        List<String> Visitor = make_visitor(visitors,Friend);
        count_visit(FriendScore, Visitor);

        // 점수 높은 순으로 sort
        answer = sortByValue(FriendScore);

        return answer;
    }
}
