package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        HashSet<String> emails = getDuplicatedEmails(forms);

        List<String> answer = new ArrayList<>(emails);
        Collections.sort(answer);

        return answer;
    }

    public static HashSet<String> getDuplicatedEmails(List<List<String>>forms){
        HashMap<String,String> partOfNameAndEmail = new HashMap<>();
        HashSet<String> mailList = new HashSet<>();

        for(int i = 0; i < forms.size(); i++){
            String name = forms.get(i).get(1);
            String email = forms.get(i).get(0);
            for(int j = 0; j < name.length()-1; j++){
                String partOfName = getPartOfName(name, j);
                if(partOfNameAndEmail.containsKey(partOfName)){
                    String targetEmail = partOfNameAndEmail.get(partOfName);
                    if(!targetEmail.equals(email)){
                        addToEmails(targetEmail,email,mailList);
                    }
                }
                partOfNameAndEmail.put(partOfName,email);
            }
        }
        return mailList;
    }

    public static String getPartOfName(String name, int index){
        String partOfName = name.substring(index, index + 2);
        return partOfName;
    }

    public static HashSet<String> addToEmails(String targetEmail, String email, HashSet<String> mailList){
        mailList.add(targetEmail);
        mailList.add(email);

        return mailList;
    }
}
