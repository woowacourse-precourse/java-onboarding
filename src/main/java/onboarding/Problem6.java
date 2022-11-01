package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        List<String> mail = new ArrayList<String>();

        for (int i = 0; i < forms.size()-1; i++){

            List<String> crew1 = forms.get(i);
            String crew1Name = crew1.get(1);

            for (int j = i+1; j < forms.size(); j++){
                List<String> crew2 = forms.get(j);
                String crew2Name = crew2.get(1);

                if (sameName(crew1Name, crew2Name)){
                    mail.add(crew1.get(0));
                    mail.add(crew2.get(0));
                }
            }

        }
        Collections.sort(mail);

        Set<String> set = new HashSet<String>(mail);
        mail =new ArrayList<String>(set);

        answer = mail;
        return answer;
    }

    public static boolean sameName(String name1, String name2){
        boolean result = false;



        for (int i = 0; i < name1.length()-1; i++){
            String name1Str1 = name1.substring(i, i+1);
            String name1Str2 = name1.substring(i+1, i+2);


            for (int j = 0; j < name2.length()-1; j++){
                String name2Str1 = name2.substring(j, j+1);
                String name2Str2 = name2.substring(j+1, j+2);

                if(name1Str1.equals(name2Str1) && name1Str2.equals(name2Str2)){
                    result = true;
                }
            }
        }
        return result;
    }


}
