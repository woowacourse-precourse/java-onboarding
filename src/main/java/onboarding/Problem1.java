package onboarding;

import java.util.List;

class Problem1 {
    public static boolean checkPage(List<Integer> pobi, List<Integer> crong){ // 예외처리.
        if(pobi.get(0) != pobi.get(1)-1 || crong.get(0) != crong.get(1)-1) return false;
        return true;
    }

    public static int findHighScore(List<Integer> person){
        int highestScore = 0;

        highestScore = checkMaxScore(person);
        return highestScore;
    }

    public static int checkMaxScore(List<Integer> person){ // 한명의 페이지를 더하여 반환.
        int sumLeftPage = 0;
        int sumRightPage = 0;
        int multiLeftScore = 1;
        int multiRightScore = 1;
        int sumMaxPage = 0;
        int multiMaxPage =0;
        int totalMaxScore = 0;

        int leftPage = person.get(0);
        int rightPage = person.get(1);

        while(leftPage != 0 && rightPage !=0){
            sumLeftPage += leftPage % 10;
            sumRightPage += rightPage % 10;
            multiLeftScore *= leftPage % 10;
            multiRightScore *= rightPage % 10;

            leftPage /= 10;
            rightPage /= 10;
        }

        sumMaxPage = Math.max(sumLeftPage,sumRightPage);
        multiMaxPage = Math.max(multiLeftScore,multiRightScore);
        totalMaxScore = Math.max(sumMaxPage,multiMaxPage);

        return totalMaxScore;
    }

    public static int findWiner(int firstPerson, int secondPerson){
        if(firstPerson == secondPerson) return 0;
        if(firstPerson > secondPerson) return 1;
        return 2;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE; // 정수의 최대값.
        int pobiScore = 0;
        int crongScore= 0;
        if(!checkPage(pobi, crong)) return -1;

        pobiScore = findHighScore(pobi);
        crongScore = findHighScore(crong);
        answer = findWiner(pobiScore,crongScore);


        return answer;
    }
}
