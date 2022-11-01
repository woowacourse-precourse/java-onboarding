package onboarding;

import org.assertj.core.internal.Iterators;

import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        HashSet<String> answer = new HashSet<>();
        HashMap<String,Object> map=new HashMap<>();
        HashMap<String,Integer> count=new HashMap<>();

        for(int i=0;i<friends.size();i++){
            for(int j=0;j<2;j++){
                String f=friends.get(i).get(j);
                List<String> list=new ArrayList<>();

                    if(!map.containsKey(f)){
                        if(j==0) {
                            list.add(friends.get(i).get(1));
                            map.put(friends.get(i).get(0),list);
                        }
                        else {
                            list.add(friends.get(i).get(0));
                            map.put(friends.get(i).get(1), list);
                        }
                    }else{
                        List<String> fs= (List<String>) map.get(f);
                        if(j==0) {
                            fs.add(friends.get(i).get(1));
                            map.put(friends.get(i).get(0),fs);
                        }
                        else {
                            fs.add(friends.get(i).get(0));
                            map.put(friends.get(i).get(1), fs);
                        }

                    }

            }

        }

        Iterator<String> keys=map.keySet().iterator();
        List<String> user_friends= (List<String>) map.get(user);
        while(keys.hasNext()){
            String key=keys.next();
            List<String> list= (List<String>) map.get(key);
            int c=0;
            if(!key.equals(user)) {
                for (String s : list) {
                    for (String us : user_friends) {
                        if (us.equals(s)) {
                            c++;
                        }
                    }
                }
                count.put(key, c * 10);
            }
        }

        for(String v:visitors){
            if(!count.containsKey(v)){
                count.put(v,1);
            }else{
                if(count.get(v)!=0) {
                    count.put(v, count.get(v) + 1);
                }
            }
        }

        List<Integer> valueList=new ArrayList<>(count.values());
        Collections.sort(valueList,Collections.reverseOrder());

        for(String key:count.keySet()){
            int value=count.get(key);
            for(int i=0;i<valueList.size();i++){
                if(value==valueList.get(i)&&value!=0) {
                    answer.add(key);
                    break;
                }
            }
        }


        List<String> result=answer.stream().collect(Collectors.toList());
        return result;
    }

}
