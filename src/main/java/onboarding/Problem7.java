package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
       Problem7 problem7= new Problem7();
       
       List<String> answer = Collections.emptyList();
       List<String> userFriends = problem7.makeFriendList(friends,user);
       Map<String,Integer> userScore = new HashMap<String,Integer>();
        
       problem7.enterFirendScore(user,userScore, friends, userFriends);
       problem7.enterVisitorScore(user,userScore, visitors, userFriends);
       answer = problem7.sortUserScore(userScore);
       return answer;
    }// solution
    
    private List<String> makeFriendList(List<List<String>> friends,String user){
       List<String> userFriends = new ArrayList<String>();
       for(List<String> relation :friends){
          relation = new ArrayList<String>(relation);
          if(relation.remove(user)) userFriends.add(relation.get(0));
       }//for
       return userFriends;
    }// makeFriendList
    
    private Map<String,Integer> enterFirendScore(
    		String user,Map<String,Integer> userScore,List<List<String>> friends,List<String> userFriends){
       for(String friendName :userFriends) {
          for(List<String> relation:friends) {
	          relation = new ArrayList<String>(relation);
	          int score = userScore.containsKey(relation.get(0))?userScore.get(relation.get(0))+10:10;
	          if(relation.remove(friendName) && !(relation.contains(user))) userScore.put(relation.get(0), score);
          }//for
       }// for 
       return userScore;
    }// enterFirendScore
    
    private Map<String,Integer> enterVisitorScore(
    		String user,Map<String,Integer> userScore,List<String> visitors,List<String> userFriends) {
       for(String visitName:visitors) {
    	   if(visitName.equals(user) || userFriends.contains(visitName)) continue;
    	   int score = userScore.containsKey(visitName)?userScore.get(visitName)+1:1;
    	   userScore.put(visitName,score);
       }//for
       return userScore;
    }// enterVisitorScore
    
    private List<String> sortUserScore(Map<String,Integer> userScore){
    	List<String> answer = new ArrayList<String>(userScore.keySet());
    	answer.sort(new Comparator<String>() {
            @Override
            public int compare(String name1, String name2) {
            	if(0==userScore.get(name2).compareTo(userScore.get(name1))) return name1.compareTo(name2);
                return userScore.get(name2).compareTo(userScore.get(name1));
            }//compare
    	});//sort
    	return answer;
    }//sortUserScore
}// end class