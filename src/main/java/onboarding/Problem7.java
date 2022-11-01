package onboarding;

import java.util.Collections;
import java.util.Hashtable;
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
        List <String> friendPoint = new LinkedList<>();
        for(List <String> list : friends){
            if(friendList.contains(list.get(0)) && !list.get(1).equals(user)) { 
            	friendPoint.add(list.get(1));
            }else if(friendList.contains(list.get(1)) && !list.get(0).equals(user)) {
            	friendPoint.add(list.get(0));
            }
        }
        Hashtable <String, Integer> scoreBoard = new Hashtable<>();
        for(String id : friendPoint){
            if(!scoreBoard.keySet().contains(id)) {
            	scoreBoard.put(id, 10);
            }else {
            	scoreBoard.put(id, scoreBoard.get(id) + 10);
            }
        }
        for(String id : visitors){
            if(friendList.contains(id))  continue;
            if(!scoreBoard.keySet().contains(id)) scoreBoard.put(id, 1);
            else
            	scoreBoard.put(id, scoreBoard.get(id) + 1);
        }
        List <String> result = new LinkedList<>();
        for(String key : scoreBoard.keySet())    result.add(key);
        Collections.sort(result, (id1, id2) ->{
            if(scoreBoard.get(id1) == scoreBoard.get(id2)){
                return id1.compareTo(id2);
            }
            else{
                return -(scoreBoard.get(id1) - scoreBoard.get(id2));
            }
        });

        return result;
    }
}

