package onboarding;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        ArrayList<ArrayList<String>> user= new ArrayList<ArrayList<String>>();
        ArrayList<String> term=new ArrayList<String>();
        List<String> answer =new ArrayList<String>();
        ArrayList<Integer> index=new ArrayList<Integer>();
        for(int i=0;i<forms.size();i++)
            user.add(divide(forms.get(i).get(1)));
        for(int i=0;i<user.size()-1;i++){
            search(i,user,user.get(i),index);
        }
        for(int i=0;i<index.size();i++)
            answer.add(forms.get(index.get(i)).get(0));
        Collections.sort(answer);
        return answer;
    }
    public static ArrayList<String> divide(String forms){
        StringBuilder sb=new StringBuilder();
        ArrayList<String> term=new ArrayList<String>();
        for(int i=0;i<forms.length()-1;i++) {
            sb=new StringBuilder();
            sb.append(forms.charAt(i));
            sb.append(forms.charAt(i + 1));
            term.add(sb.toString());
        }
        return term;
    }
    public static void search(int num,ArrayList<ArrayList<String>> user,ArrayList<String> term,ArrayList<Integer> index){
       for(int j=0;j< term.size();j++) {
           for (int i = num+ 1; i < user.size(); i++) {
               if(index.contains(i))
                   continue;
               if(user.get(i).contains(term.get(j))){
                   if(!index.contains(num))
                       index.add(num);
                   index.add(i);
               }
           }
       }
    }
}
