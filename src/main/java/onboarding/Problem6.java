package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem6 {
    public static boolean is_same(String name_1, String name_2){
        //두글자 이상이므로 두글자까지만 체크하면 됨
        int size_1 = name_1.length();
        int size_2 = name_2.length();
        String sub1 = "";
        String sub2 = "";
        for(int i = 0; i < size_1 -1 ; i++) {
            sub1 = name_1.substring(i, i + 2);
            for (int k = 0; k < size_2 - 1; k++) {
                sub2 = name_2.substring(k, k + 2);
                //System.out.println("sub1 = " + sub1 + "sub2 = " + sub2);
                if (sub1.equals(sub2)) {
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean is_repeat(List<String> Email_list, String Email){
        if(Email_list.contains(Email)){
            return false;
        }
        return true;

    }
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        int size = forms.size();
        String Email = "";
        String name = "";
        String Email_2 = "";
        String name_2 = "";

        List<String> Email_list =new ArrayList<String>();

        for(int i = 0 ; i < size ; i++){
            //비교할 첫번째 원소
            Email = forms.get(i).get(0);//이메일
            name = forms.get(i).get(1);

            for(int k = i+1; k < size; k++){
                //비교할 두번째 원소
                Email_2 = forms.get(k).get(0);
                name_2 = forms.get(k).get(1);

                if(is_same(name,name_2)){
                    //중복체크
                    if(is_repeat(Email_list,Email_2)) {
                        Email_list.add(Email_2);
                    }
                    if(is_repeat(Email_list,Email)){
                        Email_list.add(Email);
                    }
                }
            }
        }
        System.out.println(Email_list);
        answer = Email_list;
        return answer;
    }

}
