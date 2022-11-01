package onboarding;

import java.util.*;

class TokenGroup{
    final int NICK_NAME=1;
    final int EMAIL=0;
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
    void addDuplicatedNickName(List<String> tokens, List<String> form){
        int crewInformationKey;
        String crewInformationValue;
        for(String token:tokens){
            makeNewGroup(token);
            HashMap<Integer, String> crewInformation = tokenGroup.get(token);
            crewInformationKey=(form.get(EMAIL)+form.get(NICK_NAME)).hashCode();
            crewInformationValue=form.get(EMAIL);
            crewInformation.put(crewInformationKey, crewInformationValue);
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
    HashSet<String> getEmail(HashMap<Integer, String> crewInformation){
        HashSet<String> emails=new HashSet<>();
        Set<Integer> hashCodeKeys;
        int sizeOfGroup=crewInformation.size();

        if(isDuplicated(sizeOfGroup)){
            hashCodeKeys = crewInformation.keySet();
            for(Integer hashCodeKey: hashCodeKeys){
                emails.add(crewInformation.get(hashCodeKey));
            }
        }
        return emails;
    }
    List<String> getTotalEmails(TokenGroup tokenGroup){
        HashMap<Integer, String> tokenGroupInformation;
        HashSet<String> emails=new HashSet<>();
        Set<String> tokenKeys;
        tokenKeys = tokenGroup.getTokenKey();

        for(String tokenKey:tokenKeys){
            tokenGroupInformation = tokenGroup.getTokenGroup(tokenKey);
            emails.addAll(getEmail(tokenGroupInformation));
        }
        return new ArrayList<>(emails);
    }
}
public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }
}
