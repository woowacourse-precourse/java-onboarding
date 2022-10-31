package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        String tmp = cryptogram;
        while(true){
            //중복된 값이 연속적으로 나오는지 확인
            boolean ctn = false;
            //모든 문자가 중복으로 사라진 상황
            if(tmp.length() == 0) break;

            //다음 문자와 중복되는지 비교하기 위한 문자
            char lst = tmp.charAt(0);
            answer = "";

            for(int i=1; i < tmp.length(); i++){
                //마지막 문자와 중복이 되면 ctn = true; 로 연속됨을 저장
                if(lst == tmp.charAt(i)){
                    ctn = true;
                    continue;
                }
                //연속으로 중복된 숫자가 나오다가 다른 문자가 나온 경우 lst 를 갱신
                if(ctn && tmp.charAt(i) != lst){
                    lst = tmp.charAt(i);
                    ctn = false;
                    continue;
                }
                //lst 문자와 다른 문자를 발견하면 answer 에 문자를 넣어주고 lst를 갱신
                if(!ctn && tmp.charAt(i) != lst){
                    answer += lst;
                    lst = tmp.charAt(i);
                }
            }
            //마지막 문자는 연속으로 중복된 숫자가 진행 중이지 않으면 answer 에 문자를 넣어줌
            if(!ctn){
                answer += lst;
            }
            //더 이상 중복되는 문자가 없어서 문자 그대로 보존이 되면 break;
            if(tmp.equals(answer)) break;
            tmp = answer;
        }
        return answer;
    }
}
