package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";

        boolean isDup;
        
        while(true) {
            isDup = false;
            String temp = "";

            for(int i=0; i<cryptogram.length(); i++) {
                //하나라도 중복되는 원소를 찾으면 연산 시작
                if(i!=cryptogram.length()-1 && cryptogram.charAt(i) == cryptogram.charAt(i+1)) {

                    //어디까지 중복되는지 확인
                    int j;
                    for(j=i+1; j<cryptogram.length(); j++) {
                        if(cryptogram.charAt(i) != cryptogram.charAt(j)) {
                            break;
                        }
                    }

                    i=j;

                    if(j==cryptogram.length()) {
                        temp="";
                    }else {
                        temp += cryptogram.charAt(i);
                    }

                }else {
                    temp += cryptogram.charAt(i);
                }

            }

            cryptogram = temp;

            //계산한 문자열에서 중복되는 문자가 있는지 확인
            for(int i=0; i<cryptogram.length()-1; i++) {
                if(cryptogram.charAt(i) == cryptogram.charAt(i+1)) {
                    isDup = true;
                    break;
                }
            }

            //더이상 없으면 종료
            if(isDup == false) {
                break;
            }
        }

        answer = cryptogram;

        return answer;
    }

}
