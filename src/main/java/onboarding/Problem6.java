package onboarding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Problem6 {

//    public static int Find(String str, List<String> name){
//        int index = 0;
//
//        for(int i=0; i< name.size(); i++){
//            if(name.get(i).contains(str) && )
//        }
//
//
//        return index;
//    }

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        List<String> address = new ArrayList<>();
        List<String> name = new ArrayList<>();
        int [] number = new int [forms.size()];
        String keyword = "";
        int count = 0;

        for(int i=0; i<forms.size(); i++) {
            address.add(forms.get(i).get(0));
            name.add(forms.get(i).get(1));
        }

        for(int j=0; j<name.size(); j++) {
            for(int i = 0; i < name.get(j).length() - 1; i++) {
                count = 0;
                keyword = name.get(j).substring(i, i + 2);
                for(int k=0; k< name.size(); k++){
                    if(count != j){
                        if(name.get(k).contains(keyword)) {
                            System.out.println(name.get(k));
                            number[k]++;
                        }
                    }
                    count++;
                }
            }
        }

        for(int i=0; i<number.length; i++){
            if(number[i]>0) answer.add(address.get(i));
        }

        answer.sort(Comparator.naturalOrder());
        return answer;
    }

    public static void main (String [] args) {

        List<List<String>> forms = List.of(
                        List.of("jm@email.com", "제이엠"),
                        List.of("jason@email.com", "제이슨"),
                        List.of("woniee@email.com", "워니"),
                        List.of("mj@email.com", "엠제이"),
                        List.of("nowm@email.com", "이제엠")
        );
        System.out.println(forms);

        Problem6 prob = new Problem6();
        System.out.println(prob.solution(forms));
    }

}
