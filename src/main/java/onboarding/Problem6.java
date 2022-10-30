package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        int i,j;
        List<String> answer = List.of("answer");
        String temp =  forms.toString();
        String[] name = new String[forms.size()];
        String[] mail = new String[forms.size()];
        temp = temp.replace(String.valueOf('['),  "");
        temp = temp.replace(String.valueOf(']'),  "");
        temp = temp.replace(String.valueOf(','),  "");
        String[] res = temp.split(" ");
        for(i =0; i< forms.size(); i++){
                mail[i] = res[i*2];
                name[i] = res[i*2+1];
        } //mail & name 배열에 각각 값 넣어줌!! 서로 비교해서 뽑아내는 과정 필요!
        /*for(i =0; i< forms.size(); i++) {
            System.out.print(mail[i]+ " ");

        }
        System.out.println();
        for(i =0; i< forms.size(); i++) {
            System.out.print(name[i]+ " ");
        }*/

        /*List<String> temp = new ArrayList<>();
        for(i =0; i< forms.size();i++){
            int idx = forms.get(i).split("@");
            temp.add(String.valueOf(forms.get(i).substring(0,idx)));
            System.out.print(temp.get(i));
        }*/
        return answer;
    }

    public static void main(String[] args) {
        List<List<String>> forms = Arrays.asList(Arrays.asList("jm@email.com", "제이엠"), Arrays.asList("jason@email.com", "제이슨"), Arrays.asList("woniee@email.com", "워니"),  Arrays.asList("mj@email.com", "엠제이"), Arrays.asList("nowm@email.com", "이제엠"));
        //forms.forEach(System.out::println);
        List<String> result = new ArrayList<>();
        result = solution(forms);
        //System.out.println(forms.size());
    }
}
