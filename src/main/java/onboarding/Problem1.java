package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int pobi_max = 0;
        int crong_max = 0;
        // 펼친 페이지가 잘못되었을 경우
        if ((pobi.get(0) % 2 == 0 || pobi.get(1) % 2 == 1) || (pobi.get(1) - pobi.get(0) != 1)) return -1;
        if ((crong.get(0) % 2 == 0 || crong.get(1) % 2 == 1) || (crong.get(1) - crong.get(0) != 1)) return -1;

        for(int i=0; i<2; i++)
        {
            String pobi_page = Integer.toString(pobi.get(i)); // 페이지 int to String
            int pobi_add = 0; // 페이지 더한 결과값 초기화
            int pobi_multi = 1; // 페이지 곱한 결과값 초기화
            String crong_page = Integer.toString(crong.get(i));
            int crong_add = 0;
            int crong_multi = 1;
            for(int j=0; j<pobi_page.length(); j++) // 페이지 각 숫자를 String to int 하여 더하고, 곱함
            {
                int get_num = Character.getNumericValue(pobi_page.charAt(j));
                pobi_add += get_num;
                pobi_multi *= get_num;
            }
            for(int j=0; j<crong_page.length(); j++)
            {
                int get_num = Character.getNumericValue(crong_page.charAt(j));
                crong_add += get_num;
                crong_multi *= get_num;
            }
            // 최고값을 비교
            pobi_max = Math.max(pobi_max,pobi_add);
            pobi_max = Math.max(pobi_max,pobi_multi);
            crong_max = Math.max(crong_max, crong_add);
            crong_max = Math.max(crong_max, crong_multi);
        }
        if (pobi_max > crong_max) return 1;
        else if (pobi_max < crong_max) return 2;
        else return 0;
    }
}