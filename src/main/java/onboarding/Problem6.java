package onboarding;

import java.util.*;

public class Problem6 {

    private static final int NAME_IDX = 1;
    private static final int EMAIL_IDX = 0;

    Map<String,String> usersInfo = new HashMap<>();
    Map<String, ArrayList<String>> namesMappedToEachSubstringInfo = new HashMap<>();

    Set<String> substringsOfLength2 = new HashSet<>();
    Set<String> AlerterEmails = new TreeSet<>();
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    private void putUsersInfoInMapExceptForIsName1LengthCase(List<List<String>> forms){
        for(List<String> form : forms){
            String UserName = form.get(NAME_IDX);

            if(UserName.length()==1) continue;

            String UserEmail = form.get(EMAIL_IDX);

            if(usersInfo.containsKey(UserName)){
                AlerterEmails.add(UserEmail);
                String existUserEmail = usersInfo.get(UserName);
                AlerterEmails.add(existUserEmail);
            }else{
                usersInfo.put(UserName, UserEmail);

            }
        }
    }

    private void findAllSubstringOfLength2InUserNames(){
        Set<String> userNames = usersInfo.keySet();
        for(String str : userNames){
            for(int i=0;i<str.length()-1;i++){
                substringsOfLength2.add(str.substring(i,i+2));
            }
        }
    }
}
