package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    private static boolean checkTwoChar(String str1, String str2){
        int flag;
        for (int i = 0 ; i < str1.length(); i++){
            for (int j = 0; j < str2.length(); j++){
                flag = 1;
                for (int idx = 0; idx < 2; idx++){
                    if(str1.charAt(i + idx) != str2.charAt(j + idx)){
                        flag = 0;
                        break;
                    }
                    if (flag == 1){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    private static boolean checkRepeat(int i, List<List<String>> forms){
        int flag = 1;
        int length = forms.size();
        for (int j = 0; j < length ; j++){
            if (j != i && checkTwoChar(forms.get(j).get(1), forms.get(i).get(1))){
                return true;
            }
        }
        return false;
    }
    public static List<String> solution(List<List<String>> forms) {
        //ArrayList 나중에 수정할 수 있음 수정하기
        int length = forms.size();
        List<String> answer = new ArrayList<>();
        for (int i = 0; i < length; i++){
            if(checkRepeat(i, forms)){
                answer.add(forms.get(i).get(0));
            }
        }

        //checkRepeat(trace, forms);

        //answer.sort()
        //answer.add(2,"so");
        System.out.println(forms.get(0).get(1).charAt(0));
        System.out.println(forms.get(0).get(1).charAt(1));
        //forms.get(0).get(1) = "is change?";
        //System.out.println(forms);
        //System.out.println(answer);
        System.out.println(answer);
        return answer;
    }
}
