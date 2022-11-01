package onboarding;

import java.security.KeyStore;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        ArrayList<String> userRelationShip = new ArrayList<String>();
        ArrayList<String> friendsRelationShip = new ArrayList<String>();
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        visitors = new ArrayList<String>(visitors);

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

        Set<String> set = new HashSet<String>(friendsRelationShip);
        for (String str : set) {
            map.put(str,Collections.frequency(friendsRelationShip, str)*10);
        }

        for(int p=0; p<visitors.size(); p++){
            for(int q=0; q<userRelationShip.size(); q++){
                if(visitors.get(p) == userRelationShip.get(q)){
                    visitors.remove(p);
                }
            }
        }

        Map<String, Integer> visitorMap = new HashMap<String, Integer>();
        Set<String> visitorSet = new HashSet<String>(visitors);
        for(String str : visitorSet){
            visitorMap.put(str, Collections.frequency(visitors, str));
        }

        visitorMap.forEach((key, value) -> map.merge(key, value, (v1,v2) -> v1+v2));

        List<Map.Entry<String, Integer>> list_entries = new LinkedList<Map.Entry<String, Integer>>(map.entrySet());

        Collections.sort(list_entries, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> obj1, Map.Entry<String, Integer> obj2)
            {
                return obj2.getValue().compareTo(obj1.getValue());
            }
        });

        List<String> answer = Collections.emptyList();

        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> aa : list_entries) {
            temp.put(aa.getKey(), aa.getValue());
        }

        answer = new ArrayList<>(temp.keySet());

        return answer;
    }
}
