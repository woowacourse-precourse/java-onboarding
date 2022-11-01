package onboarding;

import java.util.*;

public class Problem6 {
    static Map<String,String> map = new HashMap<>();
    static Set<String> set = new TreeSet<>();

    public static void main(String[] args) {
        List<List<String>> test = new ArrayList<>();
        List<String> test1 = new ArrayList<>();
        test1.add("jm@email.com");
        test1.add("제이엠");
        List<String> test2 = new ArrayList<>();
        test2.add("jason@email.com");
        test2.add("제이슨");
        List<String> test3 = new ArrayList<>();
        test3.add("woniee@email.com");
        test3.add("워니");
        List<String> test4 = new ArrayList<>();
        test4.add("mj@email.com");
        test4.add("엠제이");
        List<String> test5 = new ArrayList<>();
        test5.add("nowm@email.com");
        test5.add("이제엠");
        test.add(test1);
        test.add(test2);
        test.add(test3);
        test.add(test4);
        test.add(test5);
        System.out.println(solution(test));
    }
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer;

        for(List<String> list : forms){
            String str = list.get(1);
            String email = list.get(0);
            for(int i=0;i<str.length()-1;i++){
                String substring = str.substring(i, i + 2);
                if(!map.containsKey(substring)){
                    map.put(substring,email);
                }else{
                    set.add(email);
                    set.add(map.get(substring));
                }
            }
        }
        answer = new ArrayList<>(set);
        return answer;
    }
}
