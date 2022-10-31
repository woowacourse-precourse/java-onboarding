package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms)
    {
        List<String> answer = new ArrayList<>();
        checkEmail(forms,answer) ;
        System.out.println(answer);
        return answer;
    }

    //email.com 인지 확인
    public static List<String> checkEmail(List<List<String>> forms,List<String> answer)
    {
        List<List<String>>validate_forms = forms;
        List<String> nickname_origin = new ArrayList<>();
        List<Integer> nickname_index= new ArrayList<>();

        for(int i =0 ; i < validate_forms.size();i++) {
            nickname_origin.add(forms.get(i).get(1));
        }

        for(int i =0 ; i < validate_forms.size();i++) {
            checkDuplicate(nickname_origin,nickname_index,forms.get(i).get(1),i);
        }
        Collections.sort(nickname_index); // 번호 정렬
        List<Integer> listWithoutDuplicates = nickname_index.stream()
                .distinct()
                .collect(Collectors.toList());

        // 중복 제거된 인덱스 정렬 후 nickname 담기
        for (Integer listWithoutDuplicate : listWithoutDuplicates) {
            answer.add(validate_forms.get(listWithoutDuplicate).get(0));
        }

        return answer;
    }

    //한국어 닉네임인지 확인
    // 중복이름 검색
    public static void checkDuplicate(List<String> nickname_origin,List<Integer> index_list,String nick_name,int number){

        for(int i = 0 ;i<nick_name.length()-1;i++)
        {
            // 확인할 문자열 추출 -> regex 사용 해보고 싶음
            String sub= nick_name.substring(i,i+2); // 부분 문자열 추출
            for(int j = 0 ; j < nickname_origin.size();j++)
            {
                if(j != number) {
                    if(nickname_origin.get(j).contains(sub)){
                        index_list.add(j);
                    }
                }
            }

        }

    }

}

