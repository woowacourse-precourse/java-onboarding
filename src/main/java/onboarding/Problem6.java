package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        List<String> name=new ArrayList<>();
        int visit[]=new int[20];
        for(int i=0;i<forms.size();i++){
            name.add(forms.get(i).get(1));
        }
        for(int i=0;i<name.size()-1;i++){
            for(int j=i+1;j<name.size();j++){
                if(isTrue(name.get(i),name.get(j))){
                    if(visit[i]==0) {
                        answer.add(forms.get(i).get(0));
                        visit[i]=1;
                    }
                    if(visit[j]==0) {
                        answer.add(forms.get(j).get(0));
                        visit[j]=1;
                    }
                }
            }
        }
        Collections.sort(answer);
        return answer;
    }
    public static boolean isTrue(String str1,String str2) { // 연속적 포함 되는지 확인
        for (int i = 0; i < str1.length() - 1; i++) {
            for (int j = 0; j < str2.length() - 1; j++) {
                if (str1.substring(i, i + 2).equals(str2.substring(j, j + 2)))
                    return true;
            }
        }
        return false;
    }
}
