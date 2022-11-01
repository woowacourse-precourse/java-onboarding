package service.problem3;

public class Problem3ServiceImpl implements  Problem3Serviceable{
    // 3, 6. 9 박수 카운트를 세는 함수
    public int getClapCount(int number) {
        int cnt = 0;

        for(int i =0; i<=number; i++) {
            String strNumber = String.valueOf(i);
            String[] list = strNumber.split("");

            for(String e : list) {
                if( e.equals("3") || e.equals("6") || e.equals("9")) {
                    cnt ++;
                }
            }
        }

        return cnt;
    }
}

