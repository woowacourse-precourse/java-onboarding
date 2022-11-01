package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem6 {
    public static HashMap<String , ArrayList<String>> nicknameDic(List<List<String>> forms){
        HashMap<String , ArrayList<String>> dicNickname = new HashMap<>();
        for(int i=0;i<forms.size();i++){
            String nickname =forms.get(i).get(1);
            for(int j = 1; j< nickname.length(); j++){
                String tmp = nickname.charAt(j-1)+""+nickname.charAt(j);
                if (dicNickname.containsKey(tmp)){
                    ArrayList<String> list = dicNickname.get(tmp);
                    list.add(forms.get(i).get(0));
                    dicNickname.put(tmp,list);
                }
                else{
                    ArrayList<String> list = new ArrayList<>();
                    list.add(forms.get(i).get(0));
                    dicNickname.put(tmp,list);
                }
            }
        }
        return dicNickname;
    }
    public static List<String> repeatedEmails(HashMap<String , ArrayList<String>> dicNickname,ArrayList<String> answer){
        for ( ArrayList emails:dicNickname.values()){
            if(emails.size()>1){

                answer.addAll(emails);
            }
        }
        return answer;
    }
    public static List<String> solution(List<List<String>> forms) {
        ArrayList<String> answer = new ArrayList<>();

        answer = (ArrayList<String>) repeatedEmails(nicknameDic(forms),answer);
        Collections.sort(answer);
        return answer;
    }
}
