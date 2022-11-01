package onboarding;

import java.lang.reflect.Array;
import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        List<String> email = new ArrayList<>();
        List<String> emailall = new ArrayList<>();
        List<String> name = new ArrayList<>();
        List<String> arr = new ArrayList<>();
        HashSet<String> set = new HashSet<>();

        for(int i=0;i<forms.size();i++){
            arr = forms.get(i);
            email.add(arr.get(0).split("@")[0]);
            emailall.add(arr.get(0));
            name.add(arr.get(1));
        }
        System.out.println(email);
        System.out.println(name);


        //email
        for(int i=0;i<forms.size()-1;i++){
            String a = email.get(i);
            System.out.println("a "+ a);
            for(int j=1;j<forms.size();j++){
                String b = email.get(j)+" ";
                System.out.println("b "+b);
                for(int k=0;k<a.length();k++){
                    for(int idx=1;idx<b.length();idx++){
                        System.out.println(a.charAt(k)+"   "+b.charAt(idx));
                        if(a.charAt(k)==b.charAt(idx)){
                            if(a.charAt(k+1)==b.charAt(idx+1)){
                                set.add(emailall.get(i));
                                set.add(emailall.get(j));
                            }
                            else if(a.charAt(k+1)==b.charAt(idx-1)){
                                set.add(emailall.get(i));
                                set.add(emailall.get(j));
                            }
                        }
                    }
                }
            }
        }

//name
        for(int i=0;i<forms.size()-1;i++){
            String a = name.get(i);
            System.out.println("a "+ a);
            for(int j=1;j<forms.size();j++){
                String b = name.get(j)+" ";
                System.out.println("b "+b);
                for(int k=0;k<a.length();k++){
                    for(int idx=1;idx<b.length();idx++){
                        System.out.println(a.charAt(k)+"   "+b.charAt(idx));
                        if(a.charAt(k)==b.charAt(idx)){
                            if(a.charAt(k+1)==b.charAt(idx+1)){
                                set.add(emailall.get(i));
                                set.add(emailall.get(j));
                            }
                            else if(a.charAt(k+1)==b.charAt(idx-1)){
                                set.add(emailall.get(i));
                                set.add(emailall.get(j));
                            }
                        }
                    }
                }
            }
        }



//        for(int i=0;i<set.size();i++){
////            answer.add((String)get[i]);
//            System.out.println(get[i]);
//        }


//        Iterator<String> iter = set.iterator(); // set을 Iterator 안에 담기
//
//        while(iter.hasNext()) { // iterator에 다음 값이 있다면
//            answer.add(iter.next()); // iter에서 값 꺼내기
//        }

        List<String> in = new ArrayList<>(set);
        Collections.sort(in);
        for(String sr : in){
            answer.add(sr);
            System.out.println(sr);
        }

        return answer;
    }
//
//    public static void main(String[] args) {
//        // [ ["jm@email.com", "제이엠"], ["jason@email.com", "제이슨"], ["woniee@email.com", "워니"], ["mj@email.com", "엠제이"], ["nowm@email.com", "이제엠"] ]
//        // ["jason@email.com", "jm@email.com", "mj@email.com"]
////        System.out.println(solution());
//        List<List<String>> forms = new ArrayList<>();
//        List<String> insert = new ArrayList<>();
//        List<String> inser2 = new ArrayList<>();
//
//        insert.add("jm@email.com");
//        insert.add("제이엠");
//        forms.add(insert);
//        inser2.add("mj@email.com");
//        inser2.add("엠제이");
//        forms.add(inser2);
//        System.out.println(solution(forms));
//    }

}
