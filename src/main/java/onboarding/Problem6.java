package onboarding;

import java.util.*;

public class Problem6 {
    // 기능 구현 목록
    // 1. 예외처리
    //  (1) 크루의 수가 1명 이상 10000명 이하가 아닌 경우
    //  (2) 이메일형식(email.com)에 부합하지 않거나 이메일의 길이가 11자 이상 20자 미만이 아닌 경우
    //  (3) 닉네임의 길이가 1자 이상 20자 미만이 아닌 경우.
    //  (4) 닉네임이 한글이 아닌 경우.
    // 2. 같은 글자가 연속으로 포함되는 크루들을 찾아내기
    public static List<String> solution(List<List<String>> forms) {

        // 예외 처리
        // 1. 크루의 수가 1명 이상 10000명 이하가 아닌 경우
        if (!(1 <= forms.size() && 10000 >= forms.size())){
            List<String> answer = List.of("크루의 수가 1명 이상 10000명 이하가 아닌 경우");
            return answer;
        }
        for (int c = 0; c < forms.size(); c++) {

            String email = forms.get(c).get(0);
            String [] email_arr = email.split("@",2);
            String email_type = email_arr[1];


            String name = forms.get(c).get(1);

            // 2. 이메일형식(email.com)에 부합하지 않거나 이메일의 길이가 11자 이상 20자 미만이 아닌 경우
            if ((!(11 <= email.length() && 20 > email.length())) || (!(email_type.equals("email.com")))){

                List<String> answer = List.of("이메일형식(email.com)에 부합하지 않거나 이메일의 길이가 11자 이상 20자 미만이 아닌 경우");
                return answer;
            }
            // 3. 닉네임의 길이가 1자 이상 20자 미만이 아닌 경우.
            else if ((!(1 <= name.length() && 20 > name.length())) ) {

                List<String> answer = List.of("닉네임의 길이가 1자 이상 20자 미만이 아닌 경우");
                return answer;
            }
            // 4. 닉네임이 한글이 아닌 경우.

            else if (!(name.matches("[ㄱ-ㅎㅏ-ㅣ가-힣]+"))) {
                List<String> answer = List.of("닉네임이 한글이 아닌 경우");
                return answer;
            }

        }


        Set<String> result_set = new HashSet<String>(); // 중복을 제거하기 위해서 Set 선언

        // 같은 글자가 연속으로 포함되는 크루들을 찾아내기
        for (int i = 0; i < forms.size() - 1; i++){
            for (int j = i; j < forms.size(); j++){
                if ((i != j) && ((forms.get(i)).get(1).length() > 1)){ // 같은 원소가 아니고, 닉네임이 1글자 이상일 때
                    String source = forms.get(i).get(1); // 닉네임
                    String target = forms.get(j).get(1); // 비교할 닉네임
                    for (int a = 0; a < source.length()- 1; a++){
                        int check = 0; // 반복문 빠져나가기 위한 변수
                        for (int b = 0; b < target.length() -1; b++){
                            if (source.charAt(a) == target.charAt(b)){ // 문자가 같다면
                                if (source.charAt(a + 1) == target.charAt(b + 1)){ // 그다음 문자도 같다면 같은 글자가 연속적으로 포함된 것
                                    result_set.add(forms.get(i).get(0)); // 해당 크루의 이메일주소를 결과 set에 추가
                                    result_set.add(forms.get(j).get(0)); // 해당 크루의 이메일주소를 결과 set에 추가
                                    check += 1;
                                    break;
                                }
                            }
                        }
                        if (check != 0){
                            break;
                        }
                    }
                }
            }
        }


        // 결과 반환
        List<String> result = new ArrayList<String>(result_set); // List로 변환
        Collections.sort(result); // 결과 List를 오름차순으로 정렬
        return result;
    }
}

        //if(!(result.contains(forms.get(i))){
        //result.add();