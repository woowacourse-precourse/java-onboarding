package onboarding;

import java.util.*;

public class Problem6 {
    /*
    @param forms : 지원자 이름, 이메일 리스트
    @return 중복으로 간주된 지원자 이메일 반환
     */
    public static List<String> solution(List<List<String>> forms) {
        Map<String, String> applicant = new HashMap<>(); //KEY : name, Value : email
        Set<String> resendEmail = new HashSet<>();

        for (List<String> form: forms) {
            String email = form.get(0);
            String name = form.get(1);

            List<String> list = getNameSubset(name);

            if(name.length() > 1 && name.length() < 20){ //한자리 이름은 중복 불가능
                for(String word : list){
                    if(applicant.containsKey(word)){ //연속된 글자 존재할 경우
                        resendEmail.add(email); //이번에 추가되던 지원자
                        resendEmail.add(applicant.get(word)); //먼저 추가되었던 지원자
                    }
                    else{
                        applicant.put(word, email); //지원자 목록에 반영
                    }
                }
            }
        }

        List<String> resendEmailSet = new ArrayList<>(resendEmail);
        Collections.sort(resendEmailSet);

        return resendEmailSet;
    }

    /*
    지원자 이름의 부분집합 구하기
    @param name : 지원자 이름
    @return 지원자 이름 두글자씩 나눈 집합 반환
     */

    public static List<String> getNameSubset(String name){
        List<String> list = new ArrayList<>();

        for (int i = 0; i < name.length() - 1; i++) { //두글자만 연속해도 중복으로 제외
            String subset = name.substring(i, i+2);
            list.add(subset);
        }

        return list;
    }
}
