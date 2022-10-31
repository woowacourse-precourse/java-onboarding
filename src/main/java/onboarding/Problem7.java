package onboarding;

import java.util.Collections;
import java.util.List;

class Friend implements Comparable<Friend>{
    private String name;
    private int score;

    public Friend(String name, int score){
        this.name = name;
        this.score = score;
    }

    public boolean isScoreLarger(int otherScore){
        return this.score > otherScore;
    }

    public boolean isScoreEqual(int otherScore){
        return this.score == otherScore;
    }

    public int compareName(String otherName){
        return otherName.compareTo(this.name);
    }
    @Override
    public int compareTo(Friend otherFriend){ //if thisFriend > otherFriend return 1
        if(otherFriend.isScoreEqual(this.score)){
            return otherFriend.compareName(this.name);
        }
        if(otherFriend.isScoreLarger(this.score)){
            return -1;
        }
        return 1;
    }
}
public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
}
