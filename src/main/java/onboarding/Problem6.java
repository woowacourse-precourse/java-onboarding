package onboarding;

import java.util.*;

class TokenGroup{
    HashMap<String, HashMap<Integer, String>> tokenGroup=new HashMap<>();
    List<String> divideToken(String nickName){
        final int WINDOW_SIZE=2;
        int nickNameLength=nickName.length()-1;

        HashSet<String> token=new HashSet<>();
        for(int position=0;position<nickNameLength;position++){
            token.add(nickName.substring(position,position+WINDOW_SIZE));
        }
        return new ArrayList<>(token);
    }
    boolean isGroupKey(String token){
        return tokenGroup.containsKey(token);
    }
    void makeNewGroup(String token){
        if(!isGroupKey(token)){
            HashMap<Integer, String> crewInformation = new HashMap<>();
            tokenGroup.put(token, crewInformation);
        }
    }
    Set<String> getTokenKey(){
        return tokenGroup.keySet();
    }
    HashMap<Integer, String> getTokenGroup(String tokenKey){
        return tokenGroup.get(tokenKey);
    }
}
class Inspection{
    boolean isDuplicated(int sizeOfTokenGroup){
        final int MINIMUM_GROUP_SIZE=1;
        return sizeOfTokenGroup > MINIMUM_GROUP_SIZE;
    }
}
public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }
}
