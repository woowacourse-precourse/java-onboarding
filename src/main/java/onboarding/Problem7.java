package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer=Collections.EMPTY_LIST;
        Map<String,List<String>> relation=relationFriends(friends);
        if(checkLimit(user,friends,visitors,relation)) {
            Map<String, Integer> score = addScoreFriends(relation, user, visitors);
            answer = orderFriends(score);
        }
        return answer;
    }

    /*
    문제사항 체크
     */
    private static boolean checkLimit(String user,List<List<String>> friends,List<String> visitors,Map<String,List<String>> relation){
        //사용자 아이디 길이 1부터 30
        if(!(user.length()>=1)&&user.length()<=30) return false;
        //사용자 아이디 소문자
        if(!user.matches("^[a-z]+$")) return false;
        //리스트최대길이 10000
        if(!(friends.size()>=1&&friends.size()<=10000)) return false;

        for(List<String> string:friends){
            String friend1=string.get(0);
            String friend2=string.get(1);
            //친구 아이디 길이 1부터 30 그리고 소문자
            if(!friend1.matches("^[a-z]+$")) return false;
            if(!friend1.matches("^[a-z]+$")) return false;
            if(!(friend1.length()>=1&&friend1.length()<=30)) return false;
            if(!(friend1.length()>=1&&friend1.length()<=30)) return false;
        }
        if(!(visitors.size()>=0&&visitors.size()<=10000)) return false;

        // 친구 관계 중복 체크
        for(List<String> list:relation.values()){
            Set<String> cntSet=new HashSet<>(list);
            if(list.size()!=cntSet.size()) return false;
        }
        return true;
    }
    /*
    모든 유저별로 점수 초기화 하기
     */
    private static Map<String,Integer> initScore(Map<String,List<String>> relation, String user, List<String> visitors){
        Map<String,Integer> score=new HashMap<>();
        for(String friend:relation.keySet()){
            score.put(friend,0);
        }
        for(String visitor:visitors){
            if(!score.containsKey(visitor)){
                score.put(visitor,0);
            }
        }
        return score;
    }
    /*
    친구 관계 매핑
     */
    private static Map<String,List<String>> relationFriends(List<List<String>> friends) {
        Map<String,List<String>> relation=new HashMap<>();
        for(List<String> friend:friends){
            String friend1=friend.get(0);
            String friend2=friend.get(1);
            List<String> list1=relation.getOrDefault(friend1,new ArrayList<>());
            list1.add(friend2);
            relation.put(friend1,list1);
            List<String> list2=relation.getOrDefault(friend2,new ArrayList<>());
            list2.add(friend1);
            relation.put(friend2,list2);
        }
        return relation;
    }
    /*
    사용자의 직접적인 친구 구하기
     */
    private static List<String> getUserFriends(Map<String,List<String>> relation,String user){
        List<String> userFriends=new ArrayList<>();
        for(String friend :relation.get(user)){
            userFriends.add(friend);
        }
        return userFriends;
    }

    /*
    사용자 추천시스템에 따라 점수 더하기
     */
    private static Map<String,Integer> addScoreFriends(Map<String,List<String>> relation,String user,List<String> visitors){
        Map<String,Integer> score=initScore(relation,user,visitors);
        List<String> userFriends=getUserFriends(relation,user);
        //사용자의 친구의 친구 점수 더하기
        for(String friend:userFriends){
            List<String> list = relation.get(friend);
            for(String scorefriend:list){
                score.put(scorefriend, score.get(scorefriend)+10);
            }

        }
        //방문자 점수 더하기
        for(String visitor:visitors){
            if(score.containsKey(visitor)) {
                score.put(visitor, score.get(visitor) + 1);
            }
        }

        //user 친구 제거하기
        for(String friend:userFriends){
            score.remove(friend);
        }
        //user 제거 하기
        score.remove(user);

        return score;
    }

    /*
    정렬 조건에 따라 정렬하기
     */
    private static List<String> orderFriends(Map<String,Integer> map){
        List<Map.Entry<String,Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue() < o2.getValue()) return 1;
                else if (o1.getValue() == o2.getValue()) return o1.getKey().compareTo(o2.getKey());
                else return -1;
            }
        });
        List<String> answer=new ArrayList<>();
        int size=0;
        for(Map.Entry<String,Integer> li:list){
            answer.add(li.getKey());
            size++;
            if(size==5){
                break;
            }
        }
        return answer;
    }

}
