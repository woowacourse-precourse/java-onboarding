package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
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

                num.add(i/2);
            }

        }
        List<String> result1 = new ArrayList<>();
        for(int i = 0;i<num.size();i++){
            result1.add(map.get(resultname.get(i)));
        }

        String[] re = new String[result1.size()];
        for(int i =0;i<result1.size();i++){
            re[i] = result1.get(i);
        }
        Arrays.sort(re);
        List<String> result = new ArrayList<>();
        for(int i = 0;i<re.length;i++){
            result.add(i,re[i]);
        }
        return result;
    }
}

