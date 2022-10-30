package onboarding;

/*
 * oomm이 한번에 지워지도록 로직 변경해야됨
*/
public class Problem2 {
    public static String solution(String cryptogram) {

        String result = "";

        return result = decoder(cryptogram);
    }

    public static String decoder(String crypto) { //암호해독기
        while (!overLap(crypto)) {
            System.out.println("crypto1 : " + crypto);
            for (int check = 0; check < crypto.length() - 1; check++) { // 중복 있는지 체크
                if (crypto.charAt(check) == crypto.charAt(check + 1)) {
                    crypto = remove_(crypto, check); // 삭제 완료
                }
            }
            System.out.println("crypto2 : " + crypto);
            overLap(crypto);
        }

        return crypto;
        }

    public static String remove_(String s,int target){ // 암호해독기에서 걸린 문자 삭제해줌
        s = s.substring(0, target) + s.substring(target + 2);

        return s;
    }

    public static boolean overLap(String array){ //중복이 있는지 확인
        for(int i = 0; i < array.length()-1; i++){
            if (array.charAt(i) == array.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }
}



