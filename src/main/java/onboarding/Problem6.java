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
    public static List<String> emailList = new ArrayList<String>();
    public static List<List<String>> publicForms;
    public static List<String> solution(List<List<String>> forms) {
        publicForms= forms;

        for(int standardIndex = 0; standardIndex <forms.size(); standardIndex++){
            makeCompareStringAndAddEmail(standardIndex);
        }
        return deleteOverlapAndSort(emailList);
    }


    static void makeCompareStringAndAddEmail(int standardIndex){
        String standardName= getNickname(standardIndex);

        for(int nameIndex = 0; nameIndex <standardName.length()-1; nameIndex++){
            addOverlapedEmailList(makeCompareString(standardName, nameIndex), standardIndex);
        }
    }

    static void addOverlapedEmailList(String compareString, int standardIndex){
        for(int currnetIndex = standardIndex+1; currnetIndex < publicForms.size(); currnetIndex++){
            String compareName= getNickname(currnetIndex);

            if(Overlaped(compareName,compareString)){
                emailList.add(getEmail(standardIndex));
                emailList.add(getEmail(currnetIndex));
            }
        }
    }

    static String getNickname(int index){
        List<String> nickNames= new ArrayList<String>();
        for (List<String> form : publicForms) {
            nickNames.add(form.get(1));
        }
        return nickNames.get(index);
    }

    static String makeCompareString(String name, int nameIndex){
        List<String> compareStr= new ArrayList<String>();
        for(int i = 0; i <name.length()-1; i++){
            compareStr.add(name.substring(i, i+2));
        }
        return compareStr.get(nameIndex);
    }

    static boolean Overlaped( String name, String checkStr){
        return name.contains(checkStr);
    }

    static String getEmail(int index){
        return publicForms.get(index).get(0);
    }


    static List<String> deleteOverlapAndSort(List<String> list){
        HashSet<String> deleteOverlap = new HashSet<String>(list);
        list.clear();
        list.addAll(deleteOverlap);
        Collections.sort(list);
        return list;
    }

}