package onboarding;

// 임의의 문자열 cryptogram이 매개변수로 주어질 때,     임의의 문자열 저장   
// 연속하는 중복 문자들을 삭제한 결과를 return 하도록   문자열의 중복 문자 제거
//                                                   문자열 제거 순서.문자를 비교, 다르다면 문자 저장, 같다면 다른게 나올때까지 값 비교
// solution 메서드를 완성하라.                        결과 반환


public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        answer = get_answer(cryptogram);
        return answer;
    }

    public static String get_answer(String answer) {
        if(answer.length() <2)
            return answer;
            
        StringBuilder temp = new StringBuilder();
        boolean isSame = false;
        char x = answer.charAt(0);
        int a = 0;
        for(int i = 1; i < answer.length() ;i++){

            if(x == answer.charAt(i)){
                isSame = true;
            }
            if(x != answer.charAt(i)){
                if(isSame == false){
                    temp.append(x);
                    x = answer.charAt(i);
                    a++;
                }
                if(isSame == true){
                    isSame = false;
                    x = answer.charAt(i);
                }
            }
        }
        
        if( a== answer.length()- 1)
        {
            return answer;
        }

        if(x != answer.charAt(answer.length() - 2)){
            temp.append(x);
        }

        return get_answer(temp.toString());
    }

}
