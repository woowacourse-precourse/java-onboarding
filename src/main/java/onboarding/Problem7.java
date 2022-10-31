package onboarding;
import java.util.*;

/**
 * 유저를 제외한 모든 인원을 set에 저장한다 -> users
 * 매개변수 유저와 친구인 사람들을 알아내고 set에 저장한다 (중복이 있을수 있기때문에 set에 저장) -> friendOfUser
 * 알아낸 친구들과 친구들인 사람들 또한 알아낸다. (중복 친구명당 점수를 부여해야하기때문에 list에 저장) -> redundantMutualFriends
 * 각 유저별로 점수를 부여해야 하기때문에 key-value 인 hashmap을 사용하여 각 유저를 저장한다 (처음엔 디폴트 value로 0을 저장)
 * 유저와 친구는 아니지만 유저의 친구들과 중복되는 사람들은 중복친구 수 만큼 10점을 더해 value에 저장한다.
 * 유저를 방문했던 사람들도 횟수만큼 1점을 더해 value에 저장한다.
 * 유저와 이미 친구인 사람들은 hashmap에서 지운다.
 * Set은 un-ordered list이기 때문에 value인 점수대로 sorting 한다.
 * sort된 set를 리턴하는 list에 넣고 최대 5유저만 리턴할수 있게 한다.
 *
 * @author heeyoung lee
 * @date 2022.10.30
 */

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        Set<String> friendsOfUser = new HashSet<>();
        List<String> redundantMutualFriends = new ArrayList<>();
        Map<String, Integer> points = new HashMap<>();

        // adding users from visiting logs
        Set<String> users = new HashSet<>(visitors);

        // adding users from friends info list
        friends.forEach( temp -> {
            if(temp.contains(user)){
                friendsOfUser.add(temp.get(0));
            } else{
                users.add(temp.get(0));
                users.add(temp.get(1));
            }
        });

        // storing users that are friends with user mutual friends
        friends.forEach(temp -> {
            friendsOfUser.forEach(name -> {
                if(temp.contains(name) && !temp.contains(user)){
                    redundantMutualFriends.add(temp.get(1));
                }
            });
        });

        // 각 유저 맵에 디폴트 value 0과 저장
        users.forEach(key -> {
            points.put(key, 0);
        });

        // 유저에 친구와 친구인 사람들에게 각각 10점씩 부여
        redundantMutualFriends.forEach(mutualFriend -> {
            int currentPoint = points.get(mutualFriend);
            points.put(mutualFriend, currentPoint+10);
        });

        // 유저를 방문했던 사람들에게 1점씩 부여
        visitors.forEach(visitor -> {
            int currentPoint = points.get(visitor);
            points.put(visitor, currentPoint+1);
        });

        // 유저의 친구들은 이미 친구이기때문에 점수 map에서 제거
        friendsOfUser.forEach(points::remove);

        // sorting the map
        List<Map.Entry<String, Integer>> elem = new LinkedList<Map.Entry<String, Integer>>(points.entrySet());
        Collections.sort(elem, new Comparator<Map.Entry<String, Integer>>(){
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2){
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
        for(Map.Entry<String, Integer> a : elem){
            temp.put(a.getKey(), a.getValue());
        }

        // sort된 set
        Set<String> stringSet = temp.keySet();
        List<String> preAnswer = new ArrayList<>(stringSet);
        List<String> answer = new ArrayList<>();

        // 최대 5명까지 리턴할수 있으므로 최대 5명까지만 저장한다.
        int count = preAnswer.size();
        for (String s : preAnswer) {
            if (count >= 5) break;
            answer.add(s);
        }

        return answer;
    }
}
