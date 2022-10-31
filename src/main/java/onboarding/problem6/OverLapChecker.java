package onboarding.problem6;

import java.util.*;
import java.util.stream.Collectors;

public class OverLapChecker {
    public List<String> findOverLapList(List<User> userList) {
        Map<String,User> wordMap=new HashMap<>();
        Set<User> overLapUserSet=new HashSet<>();
        for(User user:userList){
            String nickName = user.getNickName();
            for(int i=2;i<=nickName.length();i++){
                String word=nickName.substring(i-2,i);
                if(wordMap.containsKey(word) && wordMap.get(word).equals(user)){
                    continue;
                }
                if(!wordMap.containsKey(word)){
                    wordMap.put(word,user);
                    continue;
                }
                overLapUserSet.add(user);
                overLapUserSet.add(wordMap.get(word));
            }
        }
        List<String> collect = overLapUserSet.stream().map(u -> u.getEmail()).sorted().collect(Collectors.toList());
        return collect;
    }
}
