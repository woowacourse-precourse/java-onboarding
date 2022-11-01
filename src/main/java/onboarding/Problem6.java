package onboarding;

import java.util.List;
import java.util.ArrayList;
public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {

        ArrayList<String> answer = new ArrayList<>();
        ArrayList<String> names = new ArrayList<>();
        ArrayList<String> emails = new ArrayList<>();

        for(List<String> sets : forms){
            for(String info : sets){
                if (info.contains("@email.com")){
                    emails.add(info);
                }
                else {
                    names.add(info);
                }
            }
        }

        for(int i = 1; i < names.size(); i++){
            String namep = names.get(i-1);
            for (int j = 1; j < namep.length(); j++){
                String compare = "" + namep.charAt(j-1) + namep.charAt(j);
                for (int k = i; k < names.size(); k++){
                    if (names.get(k).contains(compare)){
                        if(answer.contains(emails.get(i-1)) == false){
                            answer.add(emails.get(k));
                            answer.add(emails.get(k-1));
                        }
                        if(answer.contains(emails.get(k)) == false){
                            answer.add(emails.get(k));
                        }
                    }
                }
            }
        }

        return answer;
    }
}
