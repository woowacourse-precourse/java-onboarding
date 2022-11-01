package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        char [] arrOfCryptogram = cryptogram.toCharArray();
        int i;
        int j = 0;
        //예외 처리 길이가 2이면서 둘이 같으면 오류가 나기 때문에 빈문자열로 삭제해서 리턴 한다
        if(arrOfCryptogram.length == 2) {
            if(arrOfCryptogram[0] == arrOfCryptogram[1])
                return "";
        }
        for(i = 1; i < arrOfCryptogram.length; i++) {
            if(arrOfCryptogram[i] != arrOfCryptogram[i - 1]) {
                arrOfCryptogram[j++] = arrOfCryptogram[i - 1];
            }else {
                while (i < arrOfCryptogram.length && arrOfCryptogram[i - 1] == arrOfCryptogram[i])
                    i++;
            }
        }
        //뒷 자리는 비교하지 않기에 배열에 넣어준다
        arrOfCryptogram[j++] = arrOfCryptogram[i - 1];
        //그 길이 만큼 다시 substring 해서 문자열 비교
        String answer = new String(arrOfCryptogram).substring(0, j);
        // 탈출 조건
        if(j != arrOfCryptogram.length)
            return solution(answer);
        return answer;
    }
}
