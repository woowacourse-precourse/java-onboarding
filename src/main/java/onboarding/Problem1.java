package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        int p1 = pobi.get(0); //포비 왼쪽 페이지
        int p2 = pobi.get(1); //포비 오른쪽 페이지
        int c1 = crong.get(0); //크롱 왼쪽 페이지
        int c2 = crong.get(1); //크롱 오른쪽 페이지
        int n1, n2, n3, sum, mul, lNum, rNum, pNum, cNum = 0;

        if (p1 == (p2 - 1)) {//연속 페이지인 경우

            ////포비
            if (p1 >= 100) {//포비 왼쪽 페이지가 100이상
                n1 = p1 / 100;
                n2 = (p1 % 100) / 10;
                n3 = p1 % 10;
                sum = n1 + n2 + n3;
                mul = n1 * n2 * n3;
                if (sum >= mul) {//합이 큰 경우
                    lNum = sum;
                } else {//곱이 큰 경우
                    lNum = mul;
                }
            } else if (100 > p1 && p1 >= 10) {//두자리 수인 경우
                n1 = p1 / 10;
                n2 = p1 % 10;
                sum = n1 + n2;
                mul = n1 * n2;
                if (sum >= mul) {//합이 큰 경우
                    lNum = sum;
                } else {//곱이 큰 경우
                    lNum = mul;
                }
            } else {//한자리인 경우
                lNum = p1;
            }

            if (p2 >= 100) {//포비 오른쪽 페이지가 100이상
                n1 = p2 / 100;
                n2 = (p2 % 100) / 10;
                n3 = p2 % 10;
                sum = n1 + n2 + n3;
                mul = n1 * n2 * n3;
                if (sum >= mul) {//합이 큰 경우
                    rNum = sum;
                } else {//곱이 큰 경우
                    rNum = mul;
                }
            } else if (100 > p2 && p2 >= 10) {//두자리 수인 경우
                n1 = p2 / 10;
                n2 = p2 % 10;
                sum = n1 + n2;
                mul = n1 * n2;
                if (sum >= mul) {//합이 큰 경우
                    rNum = sum;
                } else {//곱이 큰 경우
                    rNum = mul;
                }
            } else {//한자리인 경우
                rNum = p2;
            }

            if (lNum > rNum) {
                pNum = lNum;
            } else {
                pNum = rNum;
            }


            ////크롱
            if (c1 >= 100) {//크롱 왼쪽 페이지가 100이상
                n1 = c1 / 100;
                n2 = (c1 % 100) / 10;
                n3 = c1 % 10;
                sum = n1 + n2 + n3;
                mul = n1 * n2 * n3;
                if (sum >= mul) {//합이 큰 경우
                    lNum = sum;
                } else {//곱이 큰 경우
                    lNum = mul;
                }
            } else if (100 > c1 && c1 >= 10) {//두자리 수인 경우
                n1 = c1 / 10;
                n2 = c1 % 10;
                sum = n1 + n2;
                mul = n1 * n2;
                if (sum >= mul) {//합이 큰 경우
                    lNum = sum;
                } else {//곱이 큰 경우
                    lNum = mul;
                }
            } else {//한자리 수인 경우
                lNum = c1;
            }

            if (c2 >= 100) {//크롱 오른쪽 페이지가 100이상
                n1 = c2 / 100;
                n2 = (c2 % 100) / 10;
                n3 = c2 % 10;
                sum = n1 + n2 + n3;
                mul = n1 * n2 * n3;
                if (sum >= mul) {//합이 큰 경우
                    rNum = sum;
                } else {//곱이 큰 경우
                    rNum = mul;
                }
            } else if (100 > c2 && c2 >= 10) {//두자리 수인 경우
                n1 = c2 / 10;
                n2 = c2 % 10;
                sum = n1 + n2;
                mul = n1 * n2;
                if (sum >= mul) {//합이 큰 경우
                    rNum = sum;
                } else {//곱이 큰 경우
                    rNum = mul;
                }
            } else {//한자리 수인 경우
                rNum = c2;
            }

            if (lNum > rNum) {
                cNum = lNum;
            } else {
                cNum = rNum;
            }

            if (pNum > cNum) {//포비>크롱
                answer = 1;
            } else if (pNum < cNum) {//포비<크롱
                answer = 2;
            } else {//포비=크롱
                answer = 0;
            }
            return answer;

        }else {//불연속 페이지인 경우
            answer=-1;
            return answer;
        }
    }
}