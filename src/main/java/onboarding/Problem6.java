package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>(); // 닉네임이 중복된 e-mail을 보관하는 곳
        HashMap<String, String> mapping = new HashMap<>();
        for (List<String> profile: forms){
            String name = profile.get(1);
            String email = profile.get(0);
            int already = 0; // 이미 해당되는 이메일을 넣었다면 already를 바꿔줌
            for (int i = 0; i < name.length() -1; i++){
                String sub_name = name.substring(i, i+2);// 문자를 2개씩 쪼개서 생각해봄
                /* 또한 2개씩 쪼갠 것 중 처음 등장하면 value로 e-mail을 넣고,
                * 동일한 문자가 나오게 되면 해당 value를 -1로 바꾸고 원래 있던 e-mail을 넣는다.
                * -1 인데도 동일한 문자면 새롭게 등장한 e-mail만 넣어준다.*/

                if (!mapping.containsKey(sub_name)) {
                    mapping.put(sub_name, email);
                } else {
                    String state = mapping.get(sub_name);
                    if (state != "-1"){
                        answer.add(state);
                        mapping.put(sub_name, "-1");
                        if (already == 0){
                            answer.add(email);
                            already = 1;
                        }
                    } else {
                        if (already == 0) {
                            answer.add(email);
                            already = 1;
                        }
                    }

                }


            }
        }
        Collections.sort(answer);


        return answer;
    }
}
