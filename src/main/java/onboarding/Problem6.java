package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {

    private static final int NAME_IDX = 1;
    private static final int EMAIL_IDX = 0;

    Map<String,String> usersInfo = new HashMap<>();
    Map<String, ArrayList<String>> namesMappedToEachSubstringInfo = new HashMap<>();

    Set<String> substringsOfLength2 = new HashSet<>();
    Set<String> AlerterEmails = new TreeSet<>();


    public static List<String> solution(List<List<String>> forms) {

        Problem6 problem6 = new Problem6();

        List<String> answer = List.of("answer");

        problem6.putUsersInfoInMapExceptForIsName1LengthCase(forms);
        problem6.findAllSubstringOfLength2InUserNames();
        problem6.connectNamesContainingItToFoundSubstrings();
        problem6.putEmailInAlerterEmailListWhenTwoOrMoreNamesConnectedToFoundSubstring();

        return problem6.getAlerterEmails();
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

    private void  connectNamesContainingItToFoundSubstrings(){
        Set<String> userNames = usersInfo.keySet();

        for(String substring : substringsOfLength2){
            for(String name : userNames){
                if(name.contains(substring)){
                    ArrayList<String> listMappedThisSubstring = namesMappedToEachSubstringInfo.getOrDefault(substring,new ArrayList<>());
                    listMappedThisSubstring.add((usersInfo.get(name)));

                    namesMappedToEachSubstringInfo.put(substring,listMappedThisSubstring);
                }
            }
        }
    }

    private void putEmailInAlerterEmailListWhenTwoOrMoreNamesConnectedToFoundSubstring(){
        Set<String> substrings = namesMappedToEachSubstringInfo.keySet();
        for(String substring : substrings){
            ArrayList<String> namesMappedToThisSubstring = namesMappedToEachSubstringInfo.get(substring);

            if(namesMappedToThisSubstring.size()>1){
                for(String s : namesMappedToThisSubstring){
                    AlerterEmails.add(s);
                }
            }
        }
    }

    public ArrayList<String> getAlerterEmails() {

        ArrayList<String> result = AlerterEmails.stream().collect(Collectors.toCollection(ArrayList::new));

        return result;
    }
}
