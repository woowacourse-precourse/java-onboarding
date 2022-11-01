package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        try {
            if (cryptogram.length() < 1 || cryptogram.length() > 1000)
                throw new Exception("글자 수가 맞지 않습니다");
            for (int i = 0; i < cryptogram.length(); i++) {
                if(97 > (int)cryptogram.charAt(i))
                    throw new Exception("소문자 이외의 문자가 포함되었습니다");
            }
        } catch (Exception e) {
            System.out.println("예외 발생 : " + e.getMessage());
            return e.getMessage();
        }

        String answer = duplicated(cryptogram);
        return answer;
    }
    static String duplicated(String cryptogram) {
        for (int i = 0; i < cryptogram.length()-1; i++){
            int j = 2;
            if (cryptogram.substring(i, i+1).equals(cryptogram.substring(i+1, i+2))){
                while(i+j+1 <= cryptogram.length() &&
                        cryptogram.substring(i, i+1).equals(cryptogram.substring(i+j, i+j+1))) {
                    j++;
                }
                if (i == 0){
                    cryptogram = cryptogram.substring(i+j);
                    return duplicated(cryptogram);
                }
                cryptogram = cryptogram.substring(0, i) + cryptogram.substring(i+j);
                return duplicated(cryptogram);
            }
        }
        return cryptogram;
    }
}

