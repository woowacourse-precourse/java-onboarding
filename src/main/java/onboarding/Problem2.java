package onboarding;

// 길이 제한
// 소문자 제한
//1.문자열 완탐
//2.만약 최근 문자와 탐색하는 문작 같으면
//중복 체크
//3.만약 같지 않으면
//만약 중복 체크 되어 있으면 res의 최근 문자 삭제, 중복 체크 해제
//문자열 추가
//최근 문자 갱신
public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        String res ="";
        // 길이 제한
        // 소문자 제한
        if(cryptogram.length()==0 || cryptogram.length()>1000){
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
                return answer="글자 수가 맞지 않습니다";
            }
        }
        for(int i=0;i<cryptogram.length();i++){
            if(cryptogram.charAt(i)<'a' || cryptogram.charAt(i)>'z'){
                try {
                    throw new Exception();
                } catch (Exception e) {
                    e.printStackTrace();
                    return answer="소문자 이외의 문자가 포함되었습니다";
                }
            }
        }


        res+=cryptogram.charAt(0);

        //1.문자열 완탐
        char lastCh;
        while(true){
            int cnt=0;
            boolean dup=false;
            lastCh=cryptogram.charAt(0);
            for(int i=1;i<cryptogram.length();i++){
                //2.만약 최근 문자와 탐색하는 문작 같으면
                //중복 체크
                if(lastCh == cryptogram.charAt(i)){
                    dup=true;
                    cnt++;
                }
                //3.만약 같지 않으면
                //만약 중복 체크 되어 있으면 res의 최근 문자 삭제, 중복 체크 해제
                //문자열 추가
                //최근 문자 갱신
                if(lastCh != cryptogram.charAt(i)){
                    if(dup && res.length()!=0){
                        dup=false;
                        res = res.substring(0,res.length()-1);
                    }
                    res+= String.valueOf(cryptogram.charAt(i));
                    lastCh= cryptogram.charAt(i);
                }
            }
            if(cnt==0){ // 중복이 없으면 중단
                break;
            }
            else{
                if(res.length()==1){
                    res="";
                    cryptogram = res;
                    break;
                }
            }
            if(res.length()!=0){
                cryptogram = res;
                res = String.valueOf(cryptogram.charAt(0));
            }
        }
        return answer=cryptogram;
    }
}
