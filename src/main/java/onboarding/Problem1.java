package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        int pobiPageMax = allPageMax(pobi);
        int crongPageMax = allPageMax(crong);

        if(pobiPageMax == -1 || crongPageMax == -1){
            return -1;
        }
        else if(pobiPageMax > crongPageMax){
            return 1;
        }
        else if(pobiPageMax < crongPageMax){
            return 2;
        }
        else return 0;
    }

    private static int pageMax(String[] pageList){
        int plusPage = 0;
        int multiPage = 1;
        for (String number:
                pageList) {
            int num = Integer.parseInt(number);
            plusPage += num;
            multiPage *= num;
        }
        return plusPage>multiPage?plusPage:multiPage;
    }

    private static int allPageMax(List<Integer> playerPages){
        if (playerPages.get(0)+1 != playerPages.get(1)){
            return -1;
        }
        String[] leftPageList = String.valueOf(playerPages.get(0)).split("(?<=.)");
        String[] rightPageList = String.valueOf(playerPages.get(1)).split("(?<=.)");

        int leftPageMax = pageMax(leftPageList);
        int rightPageMax = pageMax(rightPageList);

        return leftPageMax>rightPageMax?leftPageMax:rightPageMax;

    }


    }