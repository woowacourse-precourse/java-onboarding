package onboarding;

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
