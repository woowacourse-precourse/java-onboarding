package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        List<String> alreadyFriends = new ArrayList<>();
        List<ScoreList> scoreLists = new ArrayList<>();
        HashMap<String, Integer> candidates = new HashMap<>();
        
        return answer;
    }
    public static class ScoreList {
        String name;
        private Integer score;
        public ScoreList(String name, Integer score) {
            this.name = name;
            this.score = score;
        }
        public String getName() {
            return name;
        }
        public Integer getScore() {
            return score;
        }
    }

}
