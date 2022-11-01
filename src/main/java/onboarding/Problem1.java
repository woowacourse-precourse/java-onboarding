package onboarding;

import java.util.List;



class Problem1 {
    public static int findMaxSum(List<Integer> person) {
        int leftSum = 0, rightSum = 0;
        int left = person.get(0);
        int right = person.get(1);

        while(left != 0)
        {
            leftSum = leftSum + (left % 10);
            left = left / 10;
        }
        while(right != 0)
        {
            rightSum = rightSum + (right % 10);
            right = right / 10;
        }
        return Math.max(leftSum,rightSum);
    }

    public static int findMaxMultiple(List<Integer> person) {
        int leftMultiple = 1, rightMultiple = 1;
        int left = person.get(0);
        int right = person.get(1);

        while(left != 0)
        {
            leftMultiple = leftMultiple * (left % 10);
            left = left / 10;
        }
        while(right != 0)
        {
            rightMultiple = rightMultiple * (right % 10);
            right = right / 10;
        }
        return Math.max(leftMultiple,rightMultiple);
    }

    public static int findMaxResult(List<Integer> person) {
        int sum = findMaxSum(person);
        int multiple = findMaxMultiple(person);
        return Math.max(sum,multiple);
    }

    public static int pageCount(List<Integer> person) {
        int left = person.get(0);
        int right = person.get(1);
        //case 1 page 1 ~ 400
        if(left >= 1 && left <= 400 && right >= 1 && right <= 400)
        {
            return 1;
        }
        else
        {
            return -1;
        }
    }

    public static int pageOddEven(List<Integer> person) {
        int left = person.get(0);
        int right = person.get(1);
        //case2 left -> odd , right -> even
        if(left % 2 == 1 && right % 2 == 0)
        {
            return 1;
        }
        else
        {
            return -1;
        }
    }

    public static int pageCondition(List<Integer> person) {
        int left = person.get(0);
        int right = person.get(1);
        //case3 left + 1 = right
        if(left + 1 == right)
        {
            return 1;
        }
        else
        {
            return -1;
        }
    }

    public static int pageException(List<Integer> person) {
        int left = person.get(0);
        int right = person.get(1);
        if(pageCount(person) == -1)
        {
            return -1;
        }

        if(pageOddEven(person) == -1)
        {
            return -1;
        }

        if(pageCondition(person) == -1)
        {
            return -1;
        }

        return 1;

    }

    public static int compareResult(List<Integer> pobi,List<Integer> crong) {
        if(pageException(pobi) == -1)
        {
            return -1;
        }

        if(pageException(crong) == -1)
        {
            return -1;
        }

        int pobiResult = findMaxResult(pobi);
        int crongResult = findMaxResult(crong);

        if(pobiResult > crongResult)
        {
            return 1;
        }
        else if(pobiResult < crongResult)
        {
            return 2;
        }
        else
        {
            return 0;
        }
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = compareResult(pobi,crong);
        return answer;
    }
}