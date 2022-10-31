package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {

        HashSet<String> mails=new HashSet<String>();

        int formSize=forms.size();
        int[] visited=new int[formSize];
        Arrays.fill(visited,0);

        for(int i=0;i<forms.size()-1;i++){
            for(int j=i+1;j<forms.size();j++){
                if(visited[i]==0 && visited[j]==0){
                    String name1=forms.get(i).get(1);
                    String name2=forms.get(j).get(1);
                    if(isDuplicate(name1,name2)){
                        visited[i]=0;
                        visited[j]=0;
                        mails.add(forms.get(i).get(0));
                        mails.add(forms.get(j).get(0));
                    }
                }
            }
        }

        ArrayList<String> answer= new ArrayList<>(mails);

        return answer;
    }

    public static boolean isDuplicate(String name1,String name2){

        return false;
    }
    //두 닉네임이 중복되는 경우가 있으면 True를 리턴한다.
}
