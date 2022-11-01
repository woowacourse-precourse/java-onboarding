package onboarding;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
    	List <String> friendList = new LinkedList<>();

        for(List <String> friend : friends){
            if(friend.get(0).equals(user)) {    
            	friendList.add(friend.get(1));
            }else if(friend.get(1).equals(user))  {  
            	friendList.add(friend.get(0));
            }
        }
}
