package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        answer = duplicated(cryptogram);

        return answer;
    }

    /**
     * cryptogram으로 들어온 값들을 나누어서 배열에 담고
     * 순서대로 현재값과 다음값을 비교해서 같으면 잘라 내도록 작업하도록 하자
     */

    static String duplicated(String cryptogram) {
        for (int i = 0; i < cryptogram.length()-1; i++){
            if (cryptogram.substring(i, i+1).equals(cryptogram.substring(i+1, i+2))){
                if (i == 0){
                    cryptogram = cryptogram.substring(i+2);
                    return duplicated(cryptogram);
                }
                cryptogram = cryptogram.substring(0, i) + cryptogram.substring(i+2);
                return duplicated(cryptogram);
            }
        }
        return cryptogram;
    }
    /**
     * "browoanoommnaon"
     * 연속된 부분 제거 -> oomm 제거
     * "browoannaon"
     * 연속된 부분 제거 -> nn제거
     * "browoaaon"
     * 연속된 부분 제거 -> aa제거
     * "browoon"
     * 연속된 부분 제거 -> oo제거
     * "brown"
     *
     * "zyelleyz"
     * "zyeeyz"
     * "zyyz"
     * "zz"
     * ""가 남게 된다.
     */
    /**
     * 원하는 데이터를 입력하면 duplicated 함수를 재귀식으로 동작하게 되면
     * return 을 타고 쭉 들어가서 마지막에 연속된 중복값이 나오지 않는 순간 해당 값을 return 하게 된다.
     */
}
