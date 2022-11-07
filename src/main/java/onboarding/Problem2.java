package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        StringBuilder cryptoBuilder = new StringBuilder(cryptogram);
        boolean loop = true;
        int continueIdx = 0;

        while(loop) {
            loop = false;
            for (int i = continueIdx; i < cryptoBuilder.length() - 1; i++) { // 중복되어 삭제된 인덱스-1부터 시작
                if (cryptoBuilder.charAt(i) == cryptoBuilder.charAt(i + 1)) { // 잘못된 코드 : 연속되는거 딱 두개만 제거됨.
                    cryptoBuilder.delete(i, i + 2);
                    loop = true;
                    if (continueIdx > 0)
                        continueIdx -= 1;
                }
            }
        }

        return cryptoBuilder.toString();
    }
}
