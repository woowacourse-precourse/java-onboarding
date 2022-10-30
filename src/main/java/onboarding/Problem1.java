package onboarding;

import java.util.List;

public class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        int a = leftsumScore(pobi.get(0), pobi.get(1));
        int b = rightsumScore(crong.get(0), crong.get(1));
        int c = leftmulScore(pobi.get(0), pobi.get(1));
        int d = rightmulScore(crong.get(0), crong.get(1));
        int pobiScore = Math.max(a, c);
        int crongScore = Math.max(b, d);

        int g = pobi.get(1) - pobi.get(0);
        int h = crong.get(1) - crong.get(0);

        if ((g == 1 && h == 1) && (pobi.get(0) % 2 == 1) && (crong.get(0) % 2 == 1)) {
            if (pobiScore > crongScore) {
                return 1;
            } else if (pobiScore < crongScore) {
                return 2;
            } else if (pobiScore == crongScore) {
                return 0;
            }
        }else{
            return -1;
        }
        return 0;
    }

    private static int leftsumScore(Integer pobi_left, Integer crong_left) {
        int result1 = 0;
        int result2 = 0;
        String pobiStr = pobi_left.toString();
        String crongStr = crong_left.toString();
        for(int i=0; i<pobiStr.length(); i++){
            result1 += Integer.parseInt(String.valueOf(pobiStr.charAt(i)));
        }
        for(int i=0; i<crongStr.length(); i++){
            result2 += Integer.parseInt(String.valueOf(crongStr.charAt(i)));
        }
        return Math.max(result1, result2);
    }

    private static int rightsumScore(Integer pobi_right, Integer crong_right) {
        int result1 = 0;
        int result2 = 0;
        String pobiStr = pobi_right.toString();
        String crongStr = crong_right.toString();
        for(int i=0; i<pobiStr.length(); i++){
            result1 += Integer.parseInt(String.valueOf(pobiStr.charAt(i)));
        }
        for(int i=0; i<crongStr.length(); i++){
            result2 += Integer.parseInt(String.valueOf(crongStr.charAt(i)));
        }
        return Math.max(result1, result2);
    }
    private static int leftmulScore(Integer pobi_left, Integer crong_left) {
        int result1 = 1;
        int result2 = 1;
        String pobiStr = pobi_left.toString();
        String crongStr = crong_left.toString();
        for(int i=0; i<pobiStr.length(); i++){
            result1 *= Integer.parseInt(String.valueOf(pobiStr.charAt(i)));
        }
        for(int i=0; i<crongStr.length(); i++){
            result2 *= Integer.parseInt(String.valueOf(crongStr.charAt(i)));
        }
        return Math.max(result1, result2);
    }
    private static int rightmulScore(Integer pobi_right, Integer crong_right) {
        int result1 = 1;
        int result2 = 1;
        String pobiStr = pobi_right.toString();
        String crongStr = crong_right.toString();
        for(int i=0; i<pobiStr.length(); i++){
            result1 *= Integer.parseInt(String.valueOf(pobiStr.charAt(i)));
        }
        for(int i=0; i<crongStr.length(); i++){
            result2 *= Integer.parseInt(String.valueOf(crongStr.charAt(i)));
        }
        return Math.max(result1, result2);
    }
}

//1. 책을 임의로 펼친다 -> 매개변수로 들어오는 값
//2. 왼쪽 페이지 번호의 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 구한다. 왼쪽 페이지 끼리 매개변수로 받아서 최대값 반환 함수
//3. 오른쪽 페이지 번호의 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 구한다. 오른쪽 페이지 끼리 매개변수로 받아서 최대값 반환 함수
//4. 2~3 값을 받아서 본인의 수로 결정
//5. 4번 값을 매개 변수로 받아서 승자값을 반환
//6. 시작면이나 마지막 면이 나오지 않는 예외처리 함수수