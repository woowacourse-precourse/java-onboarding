package onboarding;
import java.util.*;

public class Problem7 {

    public static class SolutionClass {

        private String user;
        private List<List<String>> friends;
        private List<String> visitors;

        private Map<String, ArrayList<String>> map = new HashMap<>(); // 친구관계를 나타내는 map
        private Map<String, Integer> result = new HashMap<>(); // 결과를 담을 map
        private List<String> answer = new ArrayList<>(); // map 에서 이름 저장할 list

        public SolutionClass(String user, List<List<String>> friends, List<String> visitors) {
            this.user = user;
            this.friends = friends;
            this.visitors = visitors;
        }

        public void saveFriend(List<List<String>> friends) {
            int f1 = 0, f2 = 1;

            for(int i=0; i<2; i++) {
                for (List<String> friend : friends) {
                    if (map.containsKey(friend.get(f1))) {
                        map.get(friend.get(f1)).add(friend.get(f2));
                    } else {
                        map.put(friend.get(f1), new ArrayList<>());
                        map.get(friend.get(f1)).add(friend.get(f2));
                    }
                }

                int temp = f1;
                f1 = f2;
                f2 = temp;
            }
        }
        public void isFriendOfUser(ArrayList<String> userFriends){
            for (String userFriend : userFriends) {
                ArrayList<String> friendsFriendsList = map.get(userFriend);

                for (String friendsFriend : friendsFriendsList) {
                    if(!(userFriends.contains(friendsFriend)) && friendsFriend != user){
                        if(!(result.containsKey(friendsFriend))){
                            result.put(friendsFriend, 10);
                        } else{
                            result.put(friendsFriend, result.get(friendsFriend) + 10);
                        }
                    }
                }
            }
        }
        public void visitorScore(ArrayList<String> userFriends){
            for (String visitor : visitors) {
                if(!(userFriends.contains(visitor))) {
                    if (!(result.containsKey(visitor))) {
                        result.put(visitor, 1);
                    } else {
                        result.put(visitor, result.get(visitor) + 1);
                    }
                }
            }
        }
        public List<Map.Entry<String, Integer>> desendingByScore(){
            List<Map.Entry<String, Integer>> entryList = new ArrayList<>(result.entrySet());
            Collections.sort(entryList, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));
            return entryList;
        }
        public List<String> getTopFive(List<Map.Entry<String, Integer>> entryList){
            for (Map.Entry<String, Integer> stringIntegerEntry : entryList) {
                if(answer.size() == 5) break;
                answer.add(String.valueOf(stringIntegerEntry.getKey()));
            }
            return answer;
        }
        public List<String> inSolution(){

            saveFriend(friends); // map에 친구목록 저장
            ArrayList<String> userFriends = map.get(user); // user 의 친구목록 가져옴
            isFriendOfUser(userFriends); // 친구의 친구 -> 10점을 더해줌
            visitorScore(userFriends); // 방문자 -> 1점을 더해줌
            List<Map.Entry<String, Integer>> entryList = desendingByScore(); // 스코어 기준 내림차순

            return getTopFive(entryList); // 상위 점수 5명 리스트 반환
        }
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        return new SolutionClass(user, friends, visitors).inSolution();
    }
}
