package onboarding;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class TestProtocol {

    public static void main(String[] args){
        List<List<String>> forms = List.of(
                List.of("jm@email.com", "제이엠"),
                List.of("jason@email.com", "제이슨"),
                List.of("woniee@email.com", "워니"),
                List.of("mj@email.com", "엠제이"),
                List.of("nowm@email.com", "이제엠")
        );
        for(int i = 0;i<forms.size();i++) {
            if ((forms.get(i).get(0)).substring((forms.get(i).get(0)).lastIndexOf("@") + 1).equals("email.com")) {

            }
        }
        HashMap<String,String> map = new HashMap<>();
        for(int i = 0;i<forms.size();i++) {
            map.put(forms.get(i).get(1), forms.get(i).get(0));
        }
        Iterator<String> iter = map.keySet().iterator();
        List<String> name = new ArrayList<>();
        while(iter.hasNext()) {
            String key = iter.next();
            name.add(key);
        }
        List<Integer> list = new ArrayList<>();
        List<String> resultname = new ArrayList<>();

        String[] cut = name.get(0).split("");


        for(int i =0;i<name.size();i++) {
            int count = 0;

            for (int j = 0; j <cut.length; j++) {
                    if (((name.get(i)).indexOf(cut[j]) >= 0 && count == 0) || ((name.get(i)).indexOf(cut[j]) >= 0 && count == 1)) {
                        list.add((name.get(i)).indexOf(cut[j]));

                        count++;
                    }
                }


           if(count == 2){
               resultname.add(name.get(i));
           }

        }

       List<Integer> num = new ArrayList<>();
       for(int i = 1;i<=list.size();i=i+2){
            if((list.get(i) - list.get(i-1)) == 1) {
                System.out.println((list.get(i) - list.get(i-1)));
                num.add(i/2);
            }

        }
        List<String> result = new ArrayList<>();
        for(int i = 0;i<num.size();i++){
            result.add(map.get(resultname.get(i)));
        }
        for(String email : result){
            System.out.println(email);
        }
        String[] re = new String[result.size()];
        for(int i =0;i<result.size();i++){
             re[i] = result.get(i);
        }
        Arrays.sort(re);
        System.out.println(Arrays.toString(re));






        }










    }

