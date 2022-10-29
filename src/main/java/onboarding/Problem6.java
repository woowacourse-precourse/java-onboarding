package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
//        List<String> name=new ArrayList<>();
//        for(int i=0;i<forms.size();i++){
//            name.add(forms.get(i).get(1));
//        }
//        for(int i=0;i<name.size()-1;i++){
//            for(int j=1;j<name.size();j++){
//
//            }
//        }
        return answer;
    }
    public static boolean isTrue(String str1,String str2){ // 연속적 포함 되는지 확인
        for(int i=0;i<str1.length()-1;i++){
            for(int j=0;j<str2.length()-1;j++){
                if(str1.substring(i,i+2).equals(str2.substring(j,j+2)))
                    return true;
            }
        }
        return false;
    }
}
