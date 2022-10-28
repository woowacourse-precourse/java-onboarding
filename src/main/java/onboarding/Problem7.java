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

    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        return null;
    }
}
