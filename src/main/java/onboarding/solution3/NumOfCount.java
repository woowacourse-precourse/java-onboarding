package onboarding.solution3;

public class NumOfCount {
    private static int Count (int num, int target){
        int cnt = 0;
        while (target < num){
            int digit = (int)(Math.log10(target) + 1);
            int comDigit = (int)(num % (Math.pow(10,digit)));
            int resNum = (int)(num / (Math.pow(10,digit)));
            if (target > comDigit){
                cnt = (int) (cnt + (resNum - 1) * (Math.pow(10,digit)));
            }
            else if (target < comDigit){
                cnt = (int) (cnt + (resNum) * (Math.pow(10,digit)));
            }
            target += 10;
        }
        return cnt;
    }
    private static int countTarget(int num, int target){
        int cnt = 0;
        cnt += Count(num, target);
        cnt -= Count(num, target + target *10);
        cnt -= Count(num, target + target*100);
        cnt -= Count(num, target + target*1000);
        cnt += Count(num, target + target*10 + target*100);
        cnt += Count(num, target + target*10 + target*1000);
        cnt += Count(num, target + target*100 + target*1000);
        cnt -= Count(num, target + target*10 + target*100 + target*1000);
        return cnt;

    }
    public static int count369(int num){
        int res = 0;
        res += countTarget(num, 3);
        res += countTarget(num, 6);
        res += countTarget(num, 9);
        return res;
    }
}
