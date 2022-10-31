package onboarding;

import java.security.KeyStore;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        ArrayList<String> userRelationShip = new ArrayList<String>();
        ArrayList<String> friendsRelationShip = new ArrayList<String>();


        for(int i = 0; i<friends.size(); i++){
            for(int j =0; j<friends.get(i).size(); j++){
                if(friends.get(i).get(j) == user){
                    if(j == 0){
                        userRelationShip.add(friends.get(i).get(1));
                    } else userRelationShip.add(friends.get(i).get(0));
                }
            }
        }

        int m = 0;

        while(m<userRelationShip.size()) {
            for (int k = 0; k < friends.size(); k++) {
                for (int l = 0; l < friends.get(k).size(); l++) {
                    if (friends.get(k).get(l) == userRelationShip.get(m)) {
                        if (l == 0) {
                            if(friends.get(k).get(1) != user) {
                                friendsRelationShip.add(friends.get(k).get(1));
                            }
                        } else if (friends.get(k).get(0) != user) {
                            friendsRelationShip.add(friends.get(k).get(1));
                        }
                    }
                }
            }
            m++;
        }


        List<String> answer = Collections.emptyList();

        return answer;
    }
}
