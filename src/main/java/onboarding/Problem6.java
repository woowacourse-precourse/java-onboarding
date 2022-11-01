package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");

        Set<String> name = new HashSet<>();

        for(int i = 0; i < forms.size(); i++){

            //기준
            List<String> A = forms.get(i);

            String A_email = A.get(0);
            String A_name = A.get(1);

            // A 닉네임 기준(한 글자인 경우) ex: 가
            if(A_name.length() == 1){

                // A 닉네임이 두 번 중복되도록 만듦(최소, 글자가 두 번이상 같아야 하기 때문) ex: 가가
                String temp_A_name = A_name + A_name;

                // 다른 닉네임들과 비교하기 ex: 가가 찾기
                for(int k = 0; k < forms.size(); k++){

                    List<String> B = forms.get(k); // 비교 기준

                    String B_email = B.get(0);
                    String B_name = B.get(1);

                    // 비교 닉네임에, 같은 연속 글자가 있다면 ex: '가가' 포함된 것 찾기
                    if(B_name.contains(temp_A_name)){
                        name.add(A_email);
                        name.add(B_email);
                    }

                }

            }

            // A 닉네임 기준(두 글자 이상인 경우)
            for(int j = 0; j < A_name.length() - 1; j++){

                // A 닉네임 두 글자씩 자르기
                String temp_A_name = A_name.substring(j, j+2);

                // 다른 닉네임들과 비교하기
                for(int k = i+1; k < forms.size(); k++){

                    List<String> B = forms.get(k); // 비교 기준

                    String B_email = B.get(0);
                    String B_name = B.get(1);

                    // 비교 닉네임에, 같은 연속 글자가 있다면
                    if(B_name.contains(temp_A_name)){
                        name.add(A_email);
                        name.add(B_email);
                    }

                }

            }

            List<String> temp = new ArrayList<>(name);
            // 이메일 오름차순 정렬
            Collections.sort(temp);

            //정답
            answer = temp;
        }

        return answer;
    }
}