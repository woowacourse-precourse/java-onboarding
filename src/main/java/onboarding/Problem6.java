package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        List<String> emailList = valueExtraction(forms,0);
        List<String> nameList = valueExtraction(forms,1);

        return answer;
    }
    public static List<String> valueExtraction(List<List<String>> forms,int index){
        List<String> responseList = new ArrayList<>();
        for(int i=0;i<forms.size();i++){
            responseList.add(forms.get(i).get(index));
        }
        return responseList;
    }
}
