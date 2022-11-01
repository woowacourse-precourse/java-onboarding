package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        /*
            하나의 신청 닉네임을 연속된 두 글자로 추출하여 키 값으로 Map에 넣는다.
            이 때, Value는 해당 닉네임을 신청한 사람의 메일 주소로 넣는다.

            신청 닉네임에서 추출한 글자와 Map에 저장된 데이터 간에 중복이 있으면,
            해당 신청자의 메일 주소와 Map에 있는 사람의 메일 주소를 반환하도록 한다.
        */
        HashMap<String, List<String>> name_table = new HashMap<>();

        for(List<String> crew : forms){
            // 닉네임에서 연속된 두 글자들을 추출
            for(String word : split_word(crew.get(1))){
                // 추출한 글자가 반환 리스트 혹은 이름 테이블에 존재하면
                if(name_table.containsKey(word)){
                    if(!answer.contains(name_table.get(word).get(0)))
                        answer.add(name_table.get(word).get(0));
                    answer.add(crew.get(0));
                }
                // 추출한 글자가 어디에도 없으면 이름 테이블에 넣는다
                else name_table.put(word, crew);
            }
        }
        Collections.sort(answer);
        return answer;
    }

    /*
        주어진 문자열을 연속된 두 글자로 분할하여 추출한다.
        예를 들어, "가나다라" 라는 문자열을 추출하게 되면
        "가나", "나다", "다라" 의 세 가지로 추출된다.
     */
    private static ArrayList<String> split_word(String str){
        ArrayList<String> result = new ArrayList<>();
        int index = 0, end_index = 2;

        while(true){
            if(str.length() <= end_index){
                result.add(str.substring(index));
                break;
            }
            result.add(str.substring(index++, end_index++));
        }

        return result;
    }
}
