package onboarding;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {

            return ReturnSimilarNameCandidates(forms);
    }

    public static List<String> splitName(String name){
        List<String> splitedNames = new ArrayList<>();
        StringBuffer sb = new StringBuffer();
        sb.append(name);
        for(int i=0; i<name.length()-1; i++) {
            splitedNames.add(sb.substring(i,i+2));
        }
        return splitedNames;
    }
    public static List<String> ReturnSimilarNameCandidates( List<List<String>> forms){
        List<String> result = new ArrayList<>();
        HashSet<String> result_set = new HashSet<>();
        for(int i=0; i<forms.size(); i++) {
            String main_name = forms.get(i).get(1);
            List<String> splited_main_name = splitName(main_name); //main 네임을 두글자씩 분리한 단어들 리스트
            for(int j=i+1; j<forms.size();j++) {
                List<String> splited_compare_name = splitName(forms.get(j).get(1));

                if(CompareName(splited_main_name, splited_compare_name)) {
                    result_set.add(forms.get(i).get(0));
                    result_set.add(forms.get(j).get(0));
                }
            }
        }
        result = List.copyOf(result_set);
        return result;
    }
    public static boolean CompareName(List<String> splited_main_name, List<String> splited_compare_name) {
        for(int i=0; i<splited_main_name.size(); i++) {
            for(int j=0; j<splited_compare_name.size(); j++) {

                if(splited_main_name.get(i).equals(splited_compare_name.get(j))) {
                    return true;
                }
            }
        }
        return false;
    }
}
