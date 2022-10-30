package onboarding;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Problem6 {


    public static String[] solution(String[][] forms){
        String[] answer = new String[forms.length];
        HashSet<String> emails = new HashSet<>();
        final Map<String, String > hashMap = new HashMap<>();
        for (int i = 0; i < forms.length; i++) {
            final String name = forms[i][1];
            if(name.length() < 2){
                break;
            }
            for (int j = 0; j < name.length() - 1; j++) {
                final String key = name.substring(j, j+2);
                if(hashMap.containsKey(key)){
                    final String email = hashMap.get(key);
                    if(!email.equals(forms[i][0])){
                        emails.add(email);
                        emails.add(forms[i][0]);
                    }
                }
                hashMap.put(key, forms[i][0]);
            }
        }
        final List<String> collect = emails.stream()
                .sorted()
                .collect(Collectors.toList());
        final String[] results = collect.toArray(new String[0]);
        return results;
    }

    public static void main(String[] args) {
        String[][] forms ={{"jm@email.com", "제이엠"},{"jason@email.com","제이슨"},{"woniee@email.com","워니"},{"mj@email.com","엠제이"},{"nowm@email.com","이제엠"}};
        String[] result = solution(forms);
        for (String value : result)
            System.out.println(value);
    }
}


      /*  public static List<String> solution(List<List<String>> forms) {
        int i,j,k,l;
        List<String> answer = List.of("answer");
        List<String> stack = new ArrayList<>();
        String temp =  forms.toString();
        String[] name = new String[forms.size()];
        String[] mail = new String[forms.size()];
        temp = temp.replace(String.valueOf('['),  "");
        temp = temp.replace(String.valueOf(']'),  "");
        temp = temp.replace(String.valueOf(','),  "");
        String remove = "";
        String compare1;
        String compare2 = null;
        int cnt =0;
        String[] res = temp.split(" ");

        int[] idx = new int[forms.size()];
        for(i =0; i< forms.size(); i++){
                mail[i] = res[i*2];
                name[i] = res[i*2+1];
        } //mail & name 배열에 각각 값 넣어줌!! 서로 비교해서 뽑아내는 과정 필요!
        *//*for(i =0; i< forms.size(); i++) {
            System.out.print(mail[i]+ " ");

        }
        System.out.println();
        for(i =0; i< forms.size(); i++) {
            System.out.print(name[i]+ " ");
        }*//*

        for(i =0; i< mail.length;i++){
            remove = mail[i].toString();
            remove = remove.replace("@email.com", "");
            mail[i] = remove;
        }
        for(i =0; i<mail.length-1; i++){
            compare1 = mail[i].toString();
            for(j = i+1; j< mail.length; j++){
                compare2 = mail[j].toString();
                for(k =0; k<compare1.length(); k++){
                    for(l = 0; l<compare2.length()-1; l++){
                        if(compare1.charAt(k) == compare2.charAt(l) || compare1.charAt(k) == compare2.charAt(l+1)){
                            if(compare1.charAt(k) == compare2.charAt(l) || compare1.charAt(k) == compare2.charAt(l+1))
                            cnt++;
                        }

                    }
                }
            }
            if(cnt >= 2){
                stack.add(compare1);
                stack.add(compare2);
            }
            cnt = 0;
        }
        System.out.println(stack);
        return answer;
    }

    public static void main(String[] args) {
        List<List<String>> forms = Arrays.asList(Arrays.asList("jm@email.com", "제이엠"), Arrays.asList("jason@email.com", "제이슨"), Arrays.asList("woniee@email.com", "워니"),  Arrays.asList("mj@email.com", "엠제이"), Arrays.asList("nowm@email.com", "이제엠"));
        //forms.forEach(System.out::println);
        List<String> result = new ArrayList<>();
        result = solution(forms);
        //System.out.println(forms.size());*/