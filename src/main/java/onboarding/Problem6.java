package onboarding;

import java.util.*;
import java.util.regex.Pattern;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        // 중복 문자열 검사 , 결과 값 저장
        HashMap<String , String> map = new LinkedHashMap();
        HashSet<String> result = new LinkedHashSet<>();

        loop:
        for (int i=0; i<forms.size(); i++) {

            List<String> form = forms.get(i);

            String email = form.get(0);
            String nickName = form.get(1);

            // 이메일 형식에 문제가 있다면
            if(emailValidation(email)){
                System.out.println("문제 발생 " + email);
                continue loop;
            }

            // 닉네임 형식에 문제가 있다면
            if(nickNameValidation(nickName)){
                continue loop;
            }

            // 모든 연결된 문자열 조합을 구하기 위해 슬라이딩 윈도우 전략 + stand 값으로 전체 문자열까지 while문 수행할 수 있도록 함
            int left = 0;
            int right = 1;
            int stand = 1;

            while (true) {

                String word = nickName.substring(left++, right++);

                // 현재 단어가 2글자 이상이며 map 자료구조 안에 현재 문자열이 있을 때
                if(map.containsKey(word) && word.length() >= 2){
                    // set 으로 중복 제거 , 현재 이메일 값과 map 자료구조에 먼저 저장해놓은 이메일 값을 등록
                    result.add(email);
                    result.add(map.get(word));
                }

                map.put(word , email);

                // stand 값이 현재 별명 길이보다 커지면 종료
                if (stand > nickName.length()) {
                    break;
                }

                // stand 값을 이용하여 슬라이딩 윈도우 진행
                if(right > nickName.length()){
                    left = 0;
                    right = stand++;
                }
            }
        }

        // 스트림을 통해 반복후 set 의 값을 list 에 넣어줌
        result.stream().forEach((val) -> {
            answer.add(val);
        });

        return answer;
    }

    private static boolean nickNameValidation(String nickName) {

        // 닉네임이 공백이거나 닉네임 길이가 1 미만이거나 20 이상일 시 에러
        if (nickName.equals("") || nickName.length() < 1 || nickName.length() >= 20) {
            return true;
        }
        String pattern = "^[가-힣]*$";
        boolean matches = Pattern.matches(pattern, nickName);
        // 정규 표현식에 해당하지 않는다면 에러
        if (!matches) {
            return true;
        }
        // 모든 기준 충족시 false 값 반환
        return false;
    }

    private static boolean emailValidation(String email) {

        //  이메일이 공백이거나 이메일의 길이가 11 미만 , 20 이상 시
        if( email.equals("") || 11 > email.length() || email.length() >= 20){
            return true;
        }

        // 문자열 내 골뱅이가 없다면 에러
        if(!email.contains("@")){
            return true;
        }

        // 이메일 형식 출력을 위한 인덱스 값 추출
        int index = email.indexOf("@");

        String substring = email.substring(index, email.length());
        String VALIDATION_EMAIL = "@email.com";

        // 추출한 이메일 형식과 신청 가능 이메일 비교
        if (substring.equals(VALIDATION_EMAIL)) {
            return false;
        }else{
            return true;
        }

    }

    public static void main(String[] args) {

        String[][] forms = {{"jm@email.com", "제이엠"}, {"jason@email.com", "제이슨"}, {"woniee@email.com", "워니"}, {"mj@email.com", "엠제이"}, {"nowm@email.com", "이제엠"}};

        List<List<String>> list = new ArrayList<>();
        for (String[] form : forms) {
            list.add(List.of(form));
        }

        solution(list);

        String[][] errorForms = {{"jm@@email.com", "제이엠"}, {"jason@email.com", "제이슨1"}, {"@email.com", "워니"}, {"12345678901234567@email.com", "엠제이"}, {"nowm@email.com", ""} , {"nowm@email.com", "일이삼사오육칠팔구십일이삼사오육칠팔구십일이삼사"} , {"nowmnemail.com", "일이삼사오육칠팔구십일"}};

        List<List<String>> errorList = new ArrayList<>();
        for (String[] errorFrom : errorForms) {
            errorList.add(List.of(errorFrom));
        }

        System.out.println("실행" + errorList);
        solution(errorList);


    }
}
