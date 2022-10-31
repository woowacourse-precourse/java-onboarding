package onboarding;

import java.util.*;

public class Problem7 {
    private static Map<String, ArrayList<String>> friendRelation;

    private static final Map<String,Integer> score = new HashMap<>();
    private static List<String> res;

    /**
     * user는 길이가 1 이상 30 이하인 문자열이다.
     * friends는 길이가 1 이상 10,000 이하인 리스트/배열이다. --> List 최대 크기 10000
     * friends의 각 원소는 길이가 2인 리스트/배열로 [아이디 A, 아이디 B] 순으로 들어있다.
     * A와 B는 친구라는 의미이다.
     * 아이디는 길이가 1 이상 30 이하인 문자열이다.
     * visitors는 길이가 0 이상 10,000 이하인 리스트/배열이다.
     * 사용자 아이디는 알파벳 소문자로만 이루어져 있다.
     *
     * 동일한 친구 관계가 중복해서 주어지지 않는다.
     * 추천할 친구가 없는 경우는 주어지지 않는다.
     */
    public static List<String> solution(String user, List<List<String>> friends,List<String> visitors){
        makeRelation(friends);
        //친구가 없다면 빈 list 반환
        if(!friendRelation.containsKey(user)) return List.of();
        getScore(user, visitors);
        res = new ArrayList<>(score.keySet());
        /**
         * 1. 추천 점수 기준으로 정렬한다
         * 2. 추천 점수가 같으면 이름 순으로 정렬한다.
         * Map의 키값을 통해 List 정렬
         */
        res.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // score Map에서 value(추천 점수)를 가져옴
                int s1 = score.get(o1);
                int s2 = score.get(o2);
                //추천 점수가 같다면 이름으로 정렬
                if(s1 == s2){
                    return o1.compareTo(o2);
                }
                //추천 점수로 오름차순 정렬
                return score.get(o2).compareTo(score.get(o1));
            }
        });
        return res;
    }

    /**
     * 사용자를 추천하기 위한 점수를 구함
     * @param user
     * @param visitors
     */
    private static void getScore(String user, List<String> visitors) {
        //관계 점수 계산
        relationScore(user);
        //방문 점수 계산
        visitScore(user, visitors);
    }

    /**
     * 방문자 점수 계산
     * # 점수를 부여할 사람이 user와 친구 관계면 건너 뛴다.
     * @param user
     * @param visitors
     */
    private static void visitScore(String user, List<String> visitors) {
        for (String visitor : visitors) {
            if(checkFriend(user,visitor)){
                continue;
            }
            int s = score.containsKey(visitor) ? score.get(visitor) : 0;
            score.put(visitor,s+1);
        }
    }

    /**
     * 친구 관계로 점수 계산 --> user의 친구의 친구인 경우 + 10
     * @param user
     */
    private static void relationScore(String user) {
        ArrayList<String> userFriends = friendRelation.get(user);
        for (String userFriend : userFriends) {
            ArrayList<String> friendf = friendRelation.get(userFriend);
            for (String friend : friendf) {
                if(friend.equals(user) || checkFriend(user,friend)){
                    continue;
                }
                int s = score.containsKey(friend) ? score.get(friend) : 0;
                score.put(friend,s+10);
            }
        }
    }
    /**
     * user와 친구인지를 확인
     */
    private static boolean checkFriend(String user, String person){
        ArrayList<String> userFriends = friendRelation.get(user);
        if(userFriends.contains(person)) return true; //이미 친구라면 return true;
        return false;
    }

    /**
     * 친구 관계를 만들어줌
     * ex)  mrko는 donut과 shakevan 과 친구라면
     *      mrko라는 key로 [donut,shakevan] value로 구성
     * @param friends
     * @return
     */
    private static void makeRelation(List<List<String>> friends) {
        friendRelation = new HashMap<>();
        for (List<String> friend : friends) {
            if(!friendRelation.containsKey(friend.get(0))){
                ArrayList<String> myFriends = new ArrayList<>();
                myFriends.add(friend.get(1));
                friendRelation.put(friend.get(0),myFriends);
            }
            else{
                ArrayList<String> myFriends = friendRelation.get(friend.get(0));
                myFriends.add(friend.get(1));
                friendRelation.put(friend.get(0),myFriends);
            }
            if(!friendRelation.containsKey(friend.get(1))){
                ArrayList<String> myFriends = new ArrayList<>();
                myFriends.add(friend.get(0));
                friendRelation.put(friend.get(1),myFriends);
            }
            else{
                ArrayList<String> myFriends = friendRelation.get(friend.get(1));
                myFriends.add(friend.get(0));
                friendRelation.put(friend.get(1),myFriends);
            }
        }
    }

}
