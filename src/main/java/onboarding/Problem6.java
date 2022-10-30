package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Map<String,String> map=new HashMap<>();
        Set<String> dupleEmail=new HashSet<String>();
        for(List<String> form:forms){
            String email=form.get(0);
            String nickname=form.get(1);
            for(int i=0;i<nickname.length()-1;i++){
                //중복키 2글자씩 비교하기위한 str
                String str=nickname.substring(i,i+2);
                //중복키값이 이미존재하면
                if(map.containsKey(str)){
                    dupleEmail.add(email);
                    //처음 넣은 중복키의 이메일이 넣어져있지 않는다면
                    if(!dupleEmail.contains(map.get(str))){
                        dupleEmail.add(map.get(str));
                    }
                }else{
                    map.put(str,email);
                }
            }
        }
        return   dupleEmail.stream().sorted().collect(Collectors.toList());
    }
}
