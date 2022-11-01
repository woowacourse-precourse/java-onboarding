package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Problem1 {

    public static Integer getAddNum(List<Integer> dataList)
    {
        int tmp=0;
        int check=-1;
        for(Integer data : dataList)
        {
            if(check == -1)
            {
                check =data;
            }else
            {
                if(data - check !=1)
                {
//                    System.out.println("data = " + (data-check));
                    return null;
                }
            }
            while(data>0)
            {
                tmp += data%10;
                data/=10;
            }
        }
        return tmp;
    }

    public static Integer getMulNum(List<Integer> dataList)
    {
        int tmp=1;
        int check=-1;
        for(Integer data : dataList)
        {
            if(check == -1)
            {
                check =data;
            }else
            {
                if(data - check !=1)
                {
//                    System.out.println("data = " + (data-check));
                    return null;
                }
            }
            while(data>0)
            {
                tmp *= data%10;
                data/=10;
            }
        }
        return tmp;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;


        Integer pobiNum= 0;
        Integer crongNum = 0;

        Integer addNum = 0;
        Integer mulNum = 0;

        addNum = getAddNum(pobi);
//        System.out.println("pobi addNum = " + addNum);

        mulNum = getMulNum(pobi);

//        System.out.println("mulNum = " + mulNum);

        try{
            pobiNum=Math.max(addNum, mulNum);
        }catch (Exception e)
        {
            return -1;
        }



        addNum = getAddNum(crong);
//        System.out.println("crong addNum = " + addNum);
        mulNum = getMulNum(crong);
//        System.out.println("mulNum = " + mulNum);
        try{
            crongNum=Math.max(addNum, mulNum);
        }catch (Exception e)
        {
            return -1;
        }

        answer=pobiNum.compareTo(crongNum);
        if(answer==0)
            return 0;
        else if(answer==1)
            return 1;
        else if(answer==-1)
            return 2;

        return answer;
    }


}