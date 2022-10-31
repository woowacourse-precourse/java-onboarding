package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<List<String>> nickname_slice = part_of_nickname(forms);
        boolean[] slice_check = duplication_check(nickname_slice);
        List<String> answer = process(forms,slice_check);

        return answer;
    }

    //닉네임을 두글자씩 슬라이싱
    static List<List<String>> part_of_nickname(List<List<String>> forms){
        List<List<String>> part = new ArrayList<>();

        for(int i=0;i<forms.size();i++){
            String tmp = forms.get(i).get(1);
            List<String> tmp_part = new ArrayList<>();
            for(int j=0;j<tmp.length()-1;j++) {
                if(tmp.length()>=2) {
                    tmp_part.add(tmp.substring(j, j + 2));
                }
            }
            part.add(tmp_part);
        }

        return part;
    }

    //닉네임 조각을 비교해서 중복체크를 하는 함수
    static boolean[] duplication_check(List<List<String>> part){
        boolean[] check = new boolean[part.size()];

        for (int i=0;i< part.size();i++){
            boolean flag = false;
            for (int j=0;j<part.get(i).size();j++){
                for (int k=0;k< part.size();k++){
                    if(i==k) continue;
                    if(part.get(k).contains(part.get(i).get(j))){
                        flag = true;
                        check[k] = true;
                    }
                }
            }

            if(flag){
                check[i]= true;
            }
        }

        return check;
    }


    //실행을 위한 process 함수
    static List<String> process(List<List<String>> forms, boolean[] check) {
        List<String> ans = new ArrayList<>();

        for (int i=0;i<check.length;i++){
            if(check[i] && forms.get(i).get(0).contains("@email.com")){
                ans.add(forms.get(i).get(0));
            }
        }

        Collections.sort(ans);

        return ans;
    }

}

