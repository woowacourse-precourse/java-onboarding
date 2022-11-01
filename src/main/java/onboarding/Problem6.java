package onboarding;

import java.util.*;

public class Problem6 {

    public static HashMap<String,Integer> map;
    public static boolean[] visit;

    public static List<String> solution(List<List<String>> forms) {

        map = new HashMap<String,Integer>();
        visit = new boolean[forms.size()];
        listCheck(forms);
        List<String> answer=overlapResult(forms);
        return answer;
    }

    public static void listCheck(List<List<String>> forms){

        for(int i=0;i<forms.size();i++){
            overlapCheck(forms.get(i).get(1),i);
        }

    }

    public static void overlapCheck(String nickname,int index){
        for(int i=0;i<nickname.length()-1;i++){

            if(map.containsKey(nickname.substring(i,i+2))==false){
                map.put(nickname.substring(i,i+2),index);
            }
            else{
                if(map.get(nickname.substring(i,i+2))!=index){
                    visit[index]=true;
                    visit[map.get(nickname.substring(i,i+2))]=true;
                }
                else continue;
            }
        }
    }

    public static List<String> overlapResult(List<List<String>> forms){

        List<String> result = new ArrayList<>();

        for(int i=0;i<forms.size();i++){
            if(visit[i]==true) result.add(forms.get(i).get(0));
        }

        Collections.sort(result);

        return result;
    }
}
