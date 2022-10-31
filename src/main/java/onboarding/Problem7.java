package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static void catchException(String user, List<List<String>> friends, List<String> visitors){
        assert user.length()>=1;
        assert user.length()<=30;
        assert friends.size()>=1;
        assert friends.size()<=10000;
        for(int i=0;i<friends.size();i++){
            assert friends.get(i).size()==2;
            assert friends.get(i).get(0).length()>=1;
            assert friends.get(i).get(0).length()<=30;
            assert friends.get(i).get(1).length()>=1;
            assert friends.get(i).get(1).length()<=30;
            assert friends.get(i).get(0).matches("^[a-z]*$");
        }
        assert visitors.size()>=0;
        assert visitors.size()<=10000;
    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        catchException(user,friends,visitors);
        List<String> answer = Collections.emptyList();
        return answer;
    }
}
