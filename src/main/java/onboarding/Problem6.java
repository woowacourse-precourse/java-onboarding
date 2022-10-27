package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List <String> list = new LinkedList<>();
        List <String> duplicate = new LinkedList<>();

        for(List<String> form : forms){
            char[] arr = form.get(1).toCharArray();
            for(int i = 0; i < arr.length - 1 ; i++) {
                String str = "";
                str += arr[i];
                str += arr[i + 1];
                list.add(str);
            }
        }
//        System.out.println(list);
        for(String s : list){
            if(Collections.frequency(list, s) > 1 && !duplicate.contains(s))    duplicate.add(s);
        }
//        System.out.println(duplicate);

        List <String> result = new LinkedList<>();
        for(List <String> form : forms){
            for(String dup : duplicate) {
                if (form.get(1).contains(dup)){
                    result.add(form.get(0));
                    break;
                }
            }
        }
//        System.out.println(result);
        result = result.stream().distinct().collect(Collectors.toList());
        Collections.sort(result);

        return result;
    }
}
