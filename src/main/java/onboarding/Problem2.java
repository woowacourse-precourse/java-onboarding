package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        StringBuffer before_string = new StringBuffer(cryptogram);

        //이전값과 현재값이 같아질떄 벗어난다.

        while(true){
            StringBuffer string = new StringBuffer(before_string);
            char before_char=string.charAt(0);

            for (int i = 1; i < string.length(); i++) {
                if (before_char == string.charAt(i)) {
                    //연속 중복 체크
                    int idx=i;
                    while(idx<string.length()-1&&before_char==string.charAt(idx+1)){
                        idx++;
                    }

                    string.delete(i - 1, idx + 1);
                    i--;
                }
                if(string.length()>1)
                    before_char=string.charAt(i);
                else
                    break;
            }

            if(string.toString().equals(before_string.toString())||string.toString().equals("")){
                before_string=string;
                break;
            }

            before_string.delete(0,before_string.length());
            before_string.append(string);

        }

        answer = before_string.toString();
        return answer;
    }
}
