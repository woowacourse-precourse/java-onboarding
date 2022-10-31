package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int[] po = pobi.stream().mapToInt(Integer::intValue).toArray();
        int[] cr = crong.stream().mapToInt(Integer::intValue).toArray();
        int po1;
        int cr1;
        if (equals(po[0], po[1]) && equals(cr[0], cr[1])) {
            po1 = com(cul(po[0]),cul(po[1]));
            cr1 = com(cul(cr[0]),cul(cr[1]));


            return po1 == cr1 ? 0 : po1 > cr1 ? 1 : 2;

        }

        return -1;
    }

    public static boolean equals(int arr0, int arr1) { // 책 페이지가 조건에 만족하는지 구하는 메소드

        return (arr0 + 1 == arr1 && arr0 % 2 != 0 && arr1 % 2 == 0);

    }

    public static int cul(int arr0) { // 모두 더하거나 모두 곱해서 큰 수 구하는 메소드
        int[] a = {1, 1, 1};
        int i=0;
        while(arr0>0) {
            a[i] = arr0 % 10;
            arr0/=10;
            i++;
        }

        return (a[0]+a[1]+a[2])>(a[0]*a[1]*a[2]) ? (a[0]+a[1]+a[2]) : (a[0]*a[1]*a[2]);
    }
    public static int com(int num1,int num2) { // 더 큰 수를 점수로 정하는 메소드

        return num1 > num2 ? num1 : num2;
    }
}