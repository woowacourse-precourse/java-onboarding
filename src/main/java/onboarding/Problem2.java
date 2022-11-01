package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        char [] arrOfCryptogram = cryptogram.toCharArray();
        int i;
        int j = 0;
       
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
