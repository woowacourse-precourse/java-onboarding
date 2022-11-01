package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = NickCheck(forms);
        return answer;
    }
    public static List<String> NickCheck(List<List<String>> crew){

        if(exceptionCheck(crew)) return null;
        //중복되는 닉네임을 저장하기 위한 list
        List<String> repet = new ArrayList<>();

        for(int i = 0; i < crew.size(); i++){
            //중복을 체크하기 위한 변수
            //닉네임 중복의 기준이 되는 문자열을 중복 체크 이후에 repet에 넣기 위해 cnt 선언함
            int cnt = 0;
            //j를 이용하여 i번째 닉네임의 시작부터 2글자씩 k번째 닉네임과 비교
            for(int j = 0 ; j < crew.get(i).get(1).length()-1; j++){
                // k는 i+1 번째 부터 비교한다. 이미 검사를 했기 때문에
                for(int k = i+1 ; k < crew.size() ; k++){
                    // 그리고 i와 k가 같을 때는 비교하지 않는다. 자기 자신이므로.
                    if((i!=k) && crew.get(k).get(1).contains(crew.get(i).get(1).substring(j, j+2))){
                        cnt++;
                        //같은 글자가 연속적으로 포함된 닉네임을 사용하는 지원자의 "이메일"을 repet에 add
                        repet.add(crew.get(k).get(0));
                    }
                }
            }
            if(cnt != 0){
                //중복체크의 기준이 되었던 지원자도 중복이므로 repet에 넣는다.
                repet.add(crew.get(i).get(0));
            }

        }
        //repet을 set에 넣어 중복을 제거하고
        Set<String> delete = new HashSet<>(repet);
        //set을 다시 list 형으로 변환하여 repet에 저장한다.
        repet = new ArrayList<>(delete);
        //repet을 오름차순으로 정렬한다.
        Collections.sort(repet);
        return repet;
    }
    public static boolean exceptionCheck(List<List<String>> crew){
        //크루는 1명이상 10,000명 이하이다.
        if(crew.size() < 1 || crew.size() > 10000) return true;
        //이메일은 이메일 형식에 부합하며
        for(int i = 0 ; i < crew.size() ; i++){
            // @을 사용해야한다. 사용하지 않으면 예외처리
            if(!crew.get(i).get(0).contains("@")){
                return true;
            }
        }
        //이메일 전체 길이는 11자 이상, 20자 미만이다.
        for(int i = 0 ; i < crew.size() ; i++){
            int email_len = crew.get(i).get(0).length();
            if(email_len < 11 || email_len > 19){
                return true;
            }
        }
        //이메일은 email.com 도메인으로 제한된다.
        for(int i = 0 ; i < crew.size() ; i++){
            if(!crew.get(i).get(0).contains("email.com")){
                return true;
            }
        }
        //닉네임은 한글만 가능하고
        String kor = "^[ㄱ-ㅎ|ㅏ-ㅣ|가-힣\\s]*$";
        for(int i = 0 ; i < crew.size() ; i++){
            //한글이 아니면 예외처리
            if(!crew.get(i).get(1).matches(kor)){
                return true;
            }
        }
        //닉네임은 1자 이상 20자 미만이다.
        for(int i = 0 ; i < crew.size() ; i++){
            int nick_len = crew.get(i).get(1).length();
            if(nick_len < 1 || nick_len > 19){
                return true;
            }
        }

        return false;
    }
}
