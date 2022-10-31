package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<String>();

            for(int formIndex = 0; formIndex <forms.size(); formIndex++){
                String name= getNickname(forms, formIndex);// 비교문자를 추출하는 이름

                for(int strNum = 0; strNum <name.length()-1; strNum++){
                    String str= makeCheckStr(name, strNum);// 비교문자

                    for(int checkIndex = formIndex+1; checkIndex <forms.size(); checkIndex++){
                        String checkName= getNickname(forms, checkIndex);//비교할 이름

                        if(checkOverlap(checkName,str)){
                                answer.add(getEmail(forms, formIndex));// 현재 인덱스에 해당하는 이메일
                                answer.add(getEmail(forms, checkIndex));// 비교하는 인덱스에 해당하는 이메일
                        }
                    }

                }

            }
        return deleteOverlapAndSort(answer);
    }

    static String getNickname(List<List<String>> forms, int index){
        List<String> nickNames= new ArrayList<String>();
        for (List<String> form : forms) {
            nickNames.add(form.get(1));
        }
        return nickNames.get(index);
    }

    static String makeCheckStr(String name, int nameIndex){
        List<String> checkStr= new ArrayList<String>();
        for(int i = 0; i <name.length()-1; i++){
            checkStr.add(name.substring(i, i+2));
        }
       return checkStr.get(nameIndex);
    }

    static boolean checkOverlap( String name, String checkStr){
        return name.contains(checkStr);
    }

    static String getEmail(List<List<String>> forms, int index){
        return forms.get(index).get(0);
    }

    static List<String> deleteOverlapAndSort(List<String> list){
        HashSet<String> deleteOverlap = new HashSet<String>(list);
        list.clear();
        list.addAll(deleteOverlap);
        Collections.sort(list);

        return list;
    }

}
