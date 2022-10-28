package onboarding;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        //List<String> answer = List.of("answer");

        HashSet<String> emails = new HashSet<>();
        HashMap<String,String> map = new HashMap<>();
        for (int k=0;k< forms.size(); k++){
            String emailcheck = forms.get(k).get(0);
            if (emailcheck.lastIndexOf("@eamil.com")<10 && emailcheck.lastIndexOf("@email.com")>1){
                //이메일은 이메일 형식에 부합하며, 전체길이는 11자 이상 20자 미만이다/email.com 도메인제한
                for(int i=0;i< forms.size();i++){
                    String name = forms.get(i).get(1);
                    if (name.length()<1 && name.length()>20){
                        break;
                    }//닉네임의 길이가 한자리이상 20자리미만
                    for (int j=0; j<name.length()-1;j++){
                        String key = name.substring(j,j+2);
                        if (map.containsKey(key)){
                            String email = map.get(key);
                            if (!email.equals(forms.get(i).get(0))){
                                emails.add(email);
                                emails.add(forms.get(i).get(0));
                            }
                        }
                        map.put(key,forms.get(i).get(0));
                    }
                }
            }
        }
        List<String> answer = emails.stream().sorted().collect(Collectors.toList());//오름차순으로 정렬 밑 중복제거
        return answer;
    }
}
