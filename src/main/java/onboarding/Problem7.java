package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
//        List<String> answer = Collections.emptyList();

        HashMap<String,ArrayList<String>> map = new HashMap<>();
        HashMap<String,Integer> userDataMap = new HashMap<>();
        ArrayList<String> relationship = new ArrayList<>();


        for (int i = 0;i< friends.toArray().length;i++) {
            String key = friends.get(i).get(0);
            String value = friends.get(i).get(1);

            if(!relationship.contains(value)){
                relationship.add(value);
            }
            map.put(key, relationship);
        }

        List<String> keyList = new ArrayList<>(map.keySet());

        for(int j = 0;j< keyList.size();j++){
            String key=keyList.get(j);
            ArrayList<String> dataSet = map.get(key);
            if(dataSet.contains(user)){
                for(int k=0;k<dataSet.size();k++){
                    String innerKey = dataSet.get(k);
                    if(!user.equals(innerKey)){
                        if(userDataMap.containsKey(innerKey)){
                            userDataMap.put(innerKey,userDataMap.get(innerKey)+10);
                        }else{
                            userDataMap.put(innerKey,10);
                        }
                    }
                }
            }
        }

        for (int i = 0;i< visitors.size();i++){
            String key = visitors.get(i);
            if(!keyList.contains(key)){
                if(userDataMap.containsKey(key)){
                    userDataMap.put(key,userDataMap.get(key)+1);
                }else{
                    userDataMap.put(key,1);
                }
            }
        }

        List<String> userDataKeySet = new ArrayList<>(userDataMap.keySet());

        return userDataKeySet;
    }
}
