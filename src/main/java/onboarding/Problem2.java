package onboarding;

/*
 * decoder에서 해독 방식 로직만 가져와서 체크 할 수 있도록 리팩토링
 * return crypto 생각하기
 * 지우는 순서도 생각하기 aabbba a먼저 -> bbba -> a가 남음 b 먼저 -> 전부 소거
 * i부터 i+1이 아닌 같으면 전부 지우는가도 생각을 해보기
 * 40번줄 target + 2가 아닌 target + 같은 문자의 길이
 * result output << 이거 nullpointexception 날 수도 있음 안에 값 넣어줘야함
*/
public class Problem2 {
    public static String solution(String cryptogram) {

        String result = decoder(cryptogram);

        System.out.println(result);
        return result;
    }

    public static String decoder(String crypto){ //암호해독기
        String output;

        for(int check = 0; check < crypto.length() - 1; check++) { // 중복 있는지 체크
            if (crypto.charAt(check) == crypto.charAt(check + 1)) {
                crypto = remove_(crypto, check); // 삭제 완료
            }
        }
        System.out.println("문장 1 : " + crypto);
        for(int count = 0; count < crypto.length() - 1; count++){ //중복이 남아있는지 체크
            if(crypto.charAt(count) == crypto.charAt(count + 1)){
                output = decoder(crypto);
                System.out.println("아웃풋 2 : " + output);

                return output;
            }
            System.out.println("문장 3 : " + crypto);
        }
        System.out.println("문장 4 : " + crypto);
        return crypto;
    }

    public static String remove_(String array, int target){ // 암호해독기에서 걸린 문자 삭제해줌
        array = array.substring(0, target) + array.substring(target + 2);

        return array;
    }
}
