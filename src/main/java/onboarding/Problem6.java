/*
 * Problem6
 *
 * v1.1
 *
 * 2022.11.01
 *
 * 저작권 주의
 */

package onboarding;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> emailList = new ArrayList<String>();

            for(int standardIndex = 0; standardIndex <forms.size(); standardIndex++){
                String standardName= getNickname(forms, standardIndex);

                for(int strIndex = 0; strIndex <standardName.length()-1; strIndex++){
                    String standardString= makeCheckString(standardName, strIndex);

                    for(int checkIndex = standardIndex+1; checkIndex <forms.size(); checkIndex++){
                        String nameForCheck= getNickname(forms, checkIndex);

                        if(Overlaped(nameForCheck,standardString)){
                            emailList.add(getEmail(forms, standardIndex));
                            emailList.add(getEmail(forms, checkIndex));
                        }
                    }
                }
            }
        return deleteOverlapAndSort(emailList);
    }

    static String getNickname(List<List<String>> forms, int index){
        List<String> nickNames= new ArrayList<String>();
        for (List<String> form : forms) {
            nickNames.add(form.get(1));
        }
        return nickNames.get(index);
    }

    static String makeCheckString(String name, int nameIndex){
        List<String> checkStr= new ArrayList<String>();
        for(int i = 0; i <name.length()-1; i++){
            checkStr.add(name.substring(i, i+2));
        }
       return checkStr.get(nameIndex);
    }

    static boolean Overlaped( String name, String checkStr){
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
