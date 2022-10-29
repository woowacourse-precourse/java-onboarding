package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
}
class Friend{
    String name;
    int point = 0;

    Friend(String name){
        this.name = name;
    }
    int getPoint() {
        return this.point;
    }
    void addPoint(int addpoint){
        point += addpoint;
    }
}
