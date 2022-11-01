package onboarding;

import java.util.*;

public class Problem6 {
    static List<String> targetName(String name)
    {
        List<String> target = new ArrayList<String>();
        for(int i = 0 ; i<name.length()-1;i++)
        {
            target.add(name.substring(i,i+2));
        }

        return target;
    }

    static List<String> saveEmails(List<List<String>> forms) {
        List<String> compareName = null;
        String email = "";
        HashSet<String> saveEmail = new HashSet<>();
        for(int i = 0; i<forms.size()-1;i++) {
            String nick = forms.get(i).get(1);
            email = forms.get(i).get(0);
            compareName = targetName(nick);
        }

            for (int j = 0; j < forms.size(); j++) {
                String email2 = forms.get(j).get(0);
                String nick2 = forms.get(j).get(1);
                for(Iterator<String>name = compareName.iterator(); name.hasNext();)
                {
                 if(nick2.contains(name.next())) {
                     saveEmail.add(email);
                     saveEmail.add(email2);
                 }

                }

            }
        List<String> answer = new ArrayList<>(saveEmail);
        return answer;
    }
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = saveEmails(forms);
        Collections.sort(answer);
        return answer;
    }
}
