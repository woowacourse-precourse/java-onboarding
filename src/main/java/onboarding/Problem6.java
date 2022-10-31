package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * 1.신청받은 닉네임을 두글자 단위로 자른다.
 * 2.두글자 단위로 자른 닉네임을 키로하고 자른 닉네임을 가지는 이메일을 값으로 가지는 맵을 만들어준다.
 * 3.모든 닉네임에 대해서 1~2번을 반복후 특정 단어를 포함하는 이메일이 2개이상인 단어를 찾아준다.
 */

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        //특정 단어를 가지고있는 이메일리스트
        HashMap<String, List<String>> checkDuplicateWord = new HashMap<>();

        /*
        1.각 닉네임을 분할해서 단어를 만든다.
        2.각 단어를 키로하고 단어를 포함하는 이메일을 값으로 만들어준다.
        3.모든 닉네임을 반복해서 돌린후 특정단어를 포함하는 이메일이 2개이상인 단어를 찾아준다.
         */
        for(int i = 0 ; i < forms.size() ; i++){
            String email = forms.get(i).get(0);
            String name = forms.get(i).get(1);

            for(int j = 0 ; j < name.length() - 1 ; j++){
                String tempStr = name.substring(j,j+2);

                //특정 단어를 포함한 다른 문자열이 있을경우
                if(checkDuplicateWord.containsKey(tempStr)){
                    List<String> emailList = checkDuplicateWord.get(tempStr);
                    emailList.add(email);
                    checkDuplicateWord.put(tempStr,emailList);
                }
                //특정 단어를 포함한 다른 문자열이 없을경우
                else{
                    List<String> tempList = new ArrayList<>();
                    tempList.add(email);
                    //특정 단어를 키로 하고 이메일을 값으로 넣어준다.
                    checkDuplicateWord.put(tempStr , tempList);
                }
            }
        }


        //Hashmap의 key를 모두가져온후 key에 해당하는 값이 2개이상인 key를 찾는다.
        for (String key : checkDuplicateWord.keySet()) {
            //특정 단어(key)값을 포함하는 이메일 리스트
            List<String> emailList = checkDuplicateWord.get(key);

            //이메일리스트 사이즈가 2이상일시 같은 글자가 연속적으로 포함되는 닉네임이 존재한다는 뜻이므로
            //해당 이메일을 답에 추가해준다.
            if(emailList.size() >= 2){
                for (String email : emailList) {
                    if(!answer.contains(email))
                        answer.add(email);
                }
            }

        }
        Collections.sort(answer);
        return answer;
    }
}
