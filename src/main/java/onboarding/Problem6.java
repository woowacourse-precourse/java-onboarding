package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        int cnt=0;
        //닉네임담기
        ArrayList<String> list = new ArrayList<String>();
        boolean check=false;

        for(int i=0;i<forms.size();i++){
            System.out.println(i);
            for(int j=0;j<forms.size();j++){
                if(check==true){
                    check=false;
                    break;
                }
                for(int k=0;k< forms.get(i).get(1).length()-1;k++){
                    System.out.println(forms.get(i).get(1).substring(k,k+2));
                    if(i==j){
                        continue;
                    }
                    if(forms.get(j).get(1).contains(forms.get(i).get(1).substring(k,k+2))){
                        System.out.println("중복");
                        cnt+=1;
                        list.add(forms.get(i).get(0));
                        check=true;
                        break;
                    }
                }
            }


        }
        Collections.sort(list);

        System.out.println(list);
        return list;
    }
}
