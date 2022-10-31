package onboarding;

import java.security.KeyStore;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        ArrayList<String> userRelationShip = new ArrayList<String>();


        for(int i = 0; i<friends.size(); i++){
            for(int j =0; j<friends.get(i).size(); j++){
                if(friends.get(i).get(j) == user){
                    if(j == 0){
                        userRelationShip.add(friends.get(i).get(1));
                    } else userRelationShip.add(friends.get(i).get(0));
                }
            }
        }

        List<String> answer = Collections.emptyList();

        return answer;
    }
}
