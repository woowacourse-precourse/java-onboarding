package onboarding;

/*
 * decoder에서 해독 방식 로직만 가져와서 체크 할 수 있도록 리팩토링
 * return crypto 생각하기
 * 지우는 순서도 생각하기 aabbba a먼저 -> bbba -> a가 남음 b 먼저 -> 전부 소거
 * aaa(bbb)a 이 되면 bbb먼저 지우도록 유도?
 * i부터 i+1이 아닌 같으면 전부 지우는가도 생각을 해보기
 * 40번줄 target + 2가 아닌 target + 같은 문자의 길이
 * result output << 이거 nullpointexception 날 수도 있음 안에 값 넣어줘야함
*/
public class Problem2 {
    public static String solution(String cryptogram) {

        String result = "";

        return result = decoder(cryptogram);
    }

    public static String decoder(String crypto) { //암호해독기
        while (!overLap(crypto)) {
            for (int check = 0; check < crypto.length() - 1; check++) { // 중복 있는지 체크
                if (crypto.charAt(check) == crypto.charAt(check + 1)) {
                    crypto = remove_(crypto, check); // 삭제 완료
                }
            }
            System.out.println("crypto : " + crypto);
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



