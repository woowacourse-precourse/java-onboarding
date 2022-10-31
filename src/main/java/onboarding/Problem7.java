package onboarding;

import java.util.*;

public class Problem7 {
	private static Map<String,Integer> relation;
	
	public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer;
        
        relation = new HashMap<>();
        ArrayList<String> fList = new ArrayList<>();
        ArrayList<List<String>> fGraph = new ArrayList<>();
        
        for (List<String> fPair : friends){
            if (fPair.contains(user)){ 
            	fList.add(getOne(fPair,user)); 
            } else { 
            	fGraph.add(fPair); 
            }
        }

        for(String myFriend : fList){
            for(List<String> fPair : fGraph){
                if (fPair.contains(myFriend)){
                    String getPointN = getOne(fPair, myFriend);
                    
                    addPoint(getPointN);
                }
            }
        }

        for (String v : visitors){
            if(!fList.contains(v))
            	addPoint(v);
        }

        answer = new ArrayList<>(relation.keySet());
        answer.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return relation.get(o1).compareTo(relation.get(o2));
            }
        });
        
        return answer;
    }

    private static void addPoint(String name){
        if (relation.containsKey(name)) 
            relation.put(name, relation.get(name)+10); 
        else
            relation.put(name, 10); 
    }
    
    private static String getOne(List<String> twoList, String name){
        if (twoList.get(0).equals(name))
            return twoList.get(1);
        else
            return twoList.get(0);
    }
    
    
}
