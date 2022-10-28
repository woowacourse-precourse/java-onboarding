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

    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        return null;
    }
}
