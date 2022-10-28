package onboarding;

public class Problem2 {

    //현재 주어진 문자열에서 중복된 문자들 제거하는 함수
    static String getString(String string){
        StringBuffer result = new StringBuffer(string);
        boolean isDelete = true;
        while (isDelete){
            StringBuffer temp = new StringBuffer("");
            for (int i=0; i<result.length(); i++){

                if(i>0 &&result.charAt(i) == result.charAt(i-1))
                    continue;
                if (i<result.length()-1 && result.charAt(i) == result.charAt(i+1)){
                    continue;
                }
                temp.append(result.charAt(i));
            }
            if (temp.toString().equals(result.toString()))
                isDelete = false;

            result = temp;
        }
        return result.toString();
    }
    public static String solution(String cryptogram) {
        String answer = "answer";

        //함수호출
        answer = getString(cryptogram);
        return answer;
    }
}
