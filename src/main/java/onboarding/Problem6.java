package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<String>();
        answer = checkString(forms);
        //answer.addAll(reverse_checkString(forms));
        answer = List_set_List(answer);

        Collections.sort(answer);

        return answer;
    }
    //정순으로 2글자씩 비교
    public static List<String> checkString(List<List<String>> forms){
        List<String> strlist = new ArrayList<>();
        String strtemp = "";
        String check2word = "";

        for(int i=0; i<forms.size(); i++){
            strtemp = forms.get(i).get(1);
            for(int j = 0; j<strtemp.length()-1; j++){
                check2word = "";
                check2word += strtemp.charAt(j);
                check2word += strtemp.charAt(j+1);
                for(int k = 0; k<forms.size(); k++){
                    if(k == i)
                        continue;
                    if(forms.get(k).get(1).contains(check2word)){
                        strlist.add(forms.get(k).get(0));
                    }
                }
            }
        }

        return strlist;
    }
//    //역순으로 2글자씩 비교
//    public static List<String> reverse_checkString(List<List<String>> forms){
//        List<String> strlist = new ArrayList<>();
//        String strtemp = "";
//        String check2word = "";
//
//        for(int i=0; i<forms.size(); i++){
//            strtemp = forms.get(i).get(1);
//            for(int j = 0; j<strtemp.length()-1; j++){
//                check2word = "";
//                check2word += strtemp.charAt(j+1);
//                check2word += strtemp.charAt(j);
//                for(int k = 0; k<forms.size(); k++){
//                    if(k == i)
//                        continue;
//                    if(forms.get(k).get(1).contains(check2word)){
//                        strlist.add(forms.get(k).get(0));
//                    }
//                }
//            }
//        }
//
//        return strlist;
//    }

    public static List<String> List_set_List(List<String> SList){
        HashSet<String> set = new HashSet<String>(SList);
        List<String> return_list = new ArrayList<String>(set);

        return return_list;
    }

}
