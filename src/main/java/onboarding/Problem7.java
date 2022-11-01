package onboarding;

import java.util.*;
/*
   * @version 1.0.0 2022년 11월 1일
   * @author DongWooE
 */
public class Problem7 {

    /* 친구 관게를 key(String) - value(ArrayList) 형태로 저장하는 인스턴스 변수 */
    HashMap<String, ArrayList<String>> friendGraph = new HashMap<>();
    /* 아는 사람들을 저장하는 key -value(Integer, 점수) 형태로 저장하는 인스턴스 변수 */
    Map<String, Integer> knownList = new HashMap();
    /* 나의 친구 리스트의 이름들을 저장하는 set 타입의 인스턴스 변수*/
    Set<String> friendList = new HashSet<>();
    /*
    * problem7의 메인 메소드
    * @param user 사용자
    * @param friends 2차원 배열 형태의 친구 관계들이 담긴 배열
    * @param visitors 방문 기록들이 담겨있는 배열
    * @return List<String> 친구 추천 리스트가 담긴 크기가 5이하인 배열
    */
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Problem7 p7 = new Problem7();
        p7.makeFriendGraph(friends);
        p7.findKnownPeople(user);
        p7.findVisitors(user, visitors);
        return p7.sortByValueAndReturnList();
    }
    /*
    * 친구 관계를 나타내는 인스턴스 변수 friendGraph를 생성하는 함수
    * @param friends 2차원 배열 형태의 친구 관계들이 담긴 배열
     */
    private void makeFriendGraph(List<List<String>> friends){
        for(List<String> list : friends){
            String friend1 = list.get(0);
            String friend2 = list.get(1);
            addFriendToGraph(friend1, friend2);
            addFriendToGraph(friend2, friend1);
        }
    }
    /*
    * 2가지 경우에 따라서 friendGraph에 요소를 추가하거나 새로 생성하는 함수
    * @param friend1 친구 이름
    * @param friend2 친구 이름
     */
    private void addFriendToGraph(String friend1, String friend2){
        if(friendGraph.containsKey(friend1)){
            friendGraph.get(friend1).add(friend2);
        }
        else{
            ArrayList<String> list1 = new ArrayList<>();
            list1.add(friend2);
            friendGraph.put(friend1, list1);
        }
    }
    /*
    * 친구의 친구들을 찾아서 knownList에 요소를 넣어주는 함수
    * @param user 사용자
     */
    private void findKnownPeople(String user){
        ArrayList<String> friends = friendGraph.get(user);
        friendList.addAll(friends);
        for(String friend : friends){
            for(String people : friendGraph.get(friend)){
                if(people.equals(user) || friendList.contains(people)) continue;        // 만약 본인이고 친구이면 통과
                if(knownList.containsKey(people)){
                    Integer score = knownList.get(people);
                    knownList.replace(people, score, score+10);
                }
            else{
                    knownList.put(people, 10);
                }
            }
        }
    }
    /*
    * 방문 기록 리스트를 보고 knownList에 요소를 추가하는 함수
    * @param user 사용자
    * @param List<String> visitors 방문 기록
     */
    private void findVisitors(String user, List<String> visitors){
        for(String visitor : visitors){
            if(visitor.equals(user) || friendList.contains(visitor)) continue;
            if(knownList.containsKey(visitor)){
                Integer score = knownList.get(visitor);
                knownList.replace(visitor, score, score+1);
            }
            else knownList.put(visitor, 1);
        }
    }
    /*
    * value에 따라서 knownList를 정렬하고 최종 결과값을 리턴하는 함수
    * @return 최종적으로 만들어진 결과값
     */
    private List<String> sortByValueAndReturnList() {
        List<String> keySet = new ArrayList<>(knownList.keySet());
        keySet.sort(new Comparator<>() {
            @Override
            public int compare(String o1, String o2) {
                if (knownList.get(o1).equals(knownList.get(o2))) return o1.compareTo(o2);
                else return knownList.get(o2).compareTo(knownList.get(o1));
            }
        });
        int size = Math.min(keySet.size(), 5);
        return keySet.subList(0, size);
    }
}
