package onboarding;

import problem6.ExtractNickName;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        //List<String> answer = List.of("answer");
        
        ExtractNickName extractNickName = new ExtractNickName();
        
        //nickName만을 추출하기
        List<String> nickNameList = extractNickName.extractNickName(forms);

        //중복 허용하고 이메일을 담기
        List<String> dupEmailList = new ArrayList<>();

        for(int i=0; i<nickNameList.size(); i++) {
            String nickName = nickNameList.get(i);

            for(int j=0; j<nickName.length()-1; j++) {
                String word = nickName.substring(j, j+2);
                boolean isContain = false;

                for(int k=i+1; k<nickNameList.size(); k++) {
                    if(nickNameList.get(k).contains(word)) {
                        dupEmailList.add(forms.get(k).get(0));

                        isContain=true;
                    }
                }

                //다른 크루와 닉네임이 포함되는 부분이 있는경우
                if(isContain) {
                    //본인의 이메일도 추가
                    dupEmailList.add(forms.get(i).get(0));
                }
            }
        }
        
        //TreeSet을 이용한 중복제거, 오름차순 정렬
        TreeSet<String> emailList = new TreeSet<>(dupEmailList);

        List<String> answer = new ArrayList<>(emailList);

        return answer;
    }

}
