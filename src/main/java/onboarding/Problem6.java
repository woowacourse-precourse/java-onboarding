package onboarding;

import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        if(input_exception(forms)) return List.of("input error");
//        List<String> answer = List.of("");
//        System.out.println(forms.get(0).get(0));
        List<String> answer=getList(forms);
        return List.of("true");
    }

    private static List<String> getList(List<List<String>> forms){
        List<String> find_overlap=getOverlap(forms);
        List<String> result=sort_find_overlap(find_overlap);
        return result;
    }

    private static List<String> getOverlap(List<List<String>> forms){

    }

    private static List<String> sort_find_overlap(List<String> list){

    }


    private static boolean input_exception(List<List<String>> forms){
        //true is 'exception excution'
        return false;
    }
}
