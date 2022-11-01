package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        List<Boolean> bmap = new ArrayList<Boolean>(Arrays.asList(new Boolean[21]));
        Collections.fill(bmap, false);


        for(int i=0;i<forms.size()-1 ;i++){
            for(int j=0;j<i ; j++){
                if(  bigo(  forms.get(i).get(1),  forms.get(j).get(1)  )  ){// 참인경우 즉 중복된 경우
                    bmap.set(i,true);
                    bmap.set(j, true);
                }
            }
        }
        for(int i=0;i<forms.size();i++){
            if(bmap.get(i)){
                answer.add(forms.get(i).get(0));
            }
        }
        for(int i =0; i< answer.size();i++){
            System.out.println(answer.get(i));
        }
        Collections.sort(answer);

        return answer;
    }

    public static boolean bigo(String a, String b){
        String temp = "";
        boolean check=false;
            for(int i=0;i<a.length()-1;i++){
                temp= a.substring(i,i+2);
                if(b.contains(temp)){
                    check=true;
                    return check;
                }
            }
        return check;
    }

}
