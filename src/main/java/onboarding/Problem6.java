package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

public class Problem6 {
    /**
     * 같은 글자가 연속적으로 포함된 닉네임을 사용 제한하는 매소드
     * 두 글자 이상 문자가 연속적으로 순서에 맞추어 포함되어 있는 경우 중복으로 간주.
     * 크루 인원은 1~10,000명 이하
     * List<List<String (이메일주소, 이름)>>
     * return : List<String(이메일주소)>
     * */
    public static List<String> solution(List<List<String>> forms) {

        ArrayList<String> answer = new ArrayList<>();

        // 두 글자 토큰을 저장할 HashMap을 선언한다. ( 닉네임 토큰, 닉네임 )
        HashMap<String, String> duplicationTokenMap = new HashMap<>();


        // 각 리스트별로 펼쳐서 한 form씩 진행한다.
        for (List<String> form : forms) {
            String email = form.get(0);
            String name = form.get(1);

            // 이메일 형식에 부합하고, 길이가 11 ~ 20 인지 확인한다.
            if (email.length() < 11 || email.length() > 20){
                System.out.println("해당 이메일 주소 길이가 부족합니다.\n");
                System.out.println(email);
            }
            // 이메일에 email.com이 포함되었는지 확인한다.
            if (!(email.substring(email.indexOf("@")).equals("@email.com"))) {
                System.out.println("해당 이메일 도메인을 지원하지 않습니다.\n");
                System.out.println(email);
            }

            // 닉네임이 한글인지 확인한다.
            if (!(isHangul(name))) {
                System.out.println("닉네임은 한글만 지원합니다.\n");
                System.out.println(name);
            }

            for ( int i = 0; i < ( name.length() -1 ); i++){
                // 2글자 씩 토큰을 생성한다. 해당 토큰에 이메일 리스트를 넣는다.
                String token = name.substring(i,i+2);

                // 토큰이 이미 있는 경우 "중복 이메일 결과"를 알리기 위해 list에 해당 원소를 추가한다.
                if (duplicationTokenMap.containsKey(token)) {
                    answer.add(email);
                    // 해당 토큰을 가진 닉네임의 소유주 또한 추가한다.
                    // answer에 토큰이 가진 이메일이 안들어있으면, 결과 이메일에 추가한다.
                    if (!(answer.contains(duplicationTokenMap.get(token)))){
                        answer.add(duplicationTokenMap.get(token));
                    }

                    // 이미 중복임을 확인했으므로 이름 비교를 종료한다.
                    break;
                }


                // 토큰이 없는 경우 새로 키워드를 넣는다. (토큰, 토큰을 소유한 이메일)
                if (!(duplicationTokenMap.containsKey(token))){
                    duplicationTokenMap.put(token, email);
                }
            }

        }

        // 오름차순으로 정렬한다.
        Collections.sort(answer);

        return answer;
    }

    private static boolean isHangul(String word) {
        // 정규표현식을 사용하여 한글인지 확인한다.
        return Pattern.matches("[가-힣]+", word);
    }


}
