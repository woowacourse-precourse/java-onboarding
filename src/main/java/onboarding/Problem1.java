package onboarding;

import java.util.List;

public class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        // 변수명 카멜케이스로 통일
        int a = sumScore(pobi.get(0), pobi.get(1));
        int b = sumScore(crong.get(0), crong.get(1));
        int c = mulScore(pobi.get(0), pobi.get(1));
        int d = mulScore(crong.get(0), crong.get(1));
        // 변수명, 메서드명

        int pobiScore = Math.max(a, c);
        int crongScore = Math.max(b, d);

        int g = pobi.get(1) - pobi.get(0);
        int h = crong.get(1) - crong.get(0);

        if ((g != 1 || h != 1) || (pobi.get(0) % 2 != 1) || (crong.get(0) % 2 != 1)) {
            return -1;
        }
        if (pobiScore > crongScore) {
            return 1;
        }
        if (pobiScore < crongScore) {
            return 2;
        }
        return 0;
    }

    private static int sumScore(Integer pobi_left, Integer crong_left) {
        String pobiStr = pobi_left.toString();
        String crongStr = crong_left.toString();

        return Math.max(asdg(pobiStr), asdg(crongStr));
    }

    private static int asdg(String result) {
        int a = 0;
        for (int i = 0; i < result.length(); i++) {
            a += Integer.parseInt(String.valueOf(result.charAt(i)));
        }
        return a;
    }

    private static int mulScore(Integer pobi_right, Integer crong_right) {
        String pobiStr = pobi_right.toString();
        String crongStr = crong_right.toString();

        return Math.max(asdf(pobiStr),asdf(crongStr));
    } // 하나로 통일

    private static int asdf(String result) {
        int a = 1;
        for (int i = 0; i < result.length(); i++) {
            a *= Integer.parseInt(String.valueOf(result.charAt(i)));
        }
        return a;
    }
}

//1. 책을 임의로 펼친다 -> 매개변수로 들어오는 값
//2. 왼쪽 페이지 번호의 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 구한다. 왼쪽 페이지 끼리 매개변수로 받아서 최대값 반환 함수
//3. 오른쪽 페이지 번호의 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 구한다. 오른쪽 페이지 끼리 매개변수로 받아서 최대값 반환 함수
//4. 2~3 값을 받아서 본인의 수로 결정
//5. 4번 값을 매개 변수로 받아서 승자값을 반환
//6. 시작면이나 마지막 면이 나오지 않는 예외처리 함수수