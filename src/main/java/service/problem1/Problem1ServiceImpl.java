package service.problem1;

import java.util.List;

public class Problem1ServiceImpl implements Problem1Serviceable {
    // 승자 판별 메소드 -> player1 승리하면 1, player2 승리하면 2, 비기면 0, 예외상황인 경우 -1을 반환합니다.
    public Integer getWinner(List<Integer> player1Pages, List<Integer> player2pages){
        // 제한 사항을 체크하고, 제한 사항에 걸린다면 -1을 리턴합니다.
        if(isRestrict(player1Pages, player2pages)) return -1;
        return isWinner(player1Pages, player2pages);

    }

    // Winner를 가립니다.
    public Integer isWinner(List<Integer> player1pages, List<Integer> player2pages){
        String[] player1StrPages = new String[player1pages.size()];
        String[] player2StrPages = new String[player2pages.size()];
        Integer[] winner = new Integer[2];

        for(int i = 0; i < player1StrPages.length; i++){
            player1StrPages[i] = String.valueOf(player1pages);
            player2StrPages[i] = String.valueOf(player2pages);
        }

        for(int i = 0; i < player1StrPages.length; i++){
            int sum = 0;
            int multi = 1;

            for(int j = 0; j < player1StrPages[i].length(); j++){
                int playerCharNumber = Character.getNumericValue(player1StrPages[i].charAt(j));
                sum = sum + playerCharNumber;
                multi = multi * playerCharNumber;
                winner[0] = Integer.max(sum, multi);
            }

            sum = 0;
            multi = 1;
            for(int j = 0; j < player2StrPages[i].length(); j++){
                int playerCharNumber = Character.getNumericValue(player2StrPages[i].charAt(j));
                sum = sum + playerCharNumber;
                multi = multi * playerCharNumber;
                winner[1] = Integer.max(sum, multi);
            }
        }

        if(winner[0] > winner[1]){
            return 1;
        } else if(winner[0] < winner[1]) {
            return 2;
        } else {
            return 0;
        }

    }

    // 모든 제한사항을 판별하는 메소드
    public boolean isRestrict(List<Integer> player1pages, List<Integer> player2pages){
        boolean isRestrictPage = isRestrictPage(player1pages, player2pages);
        boolean isWrongPageNumber = isWrongPageInputNumber(player1pages, player2pages);

        return isRestrictPage || isWrongPageNumber;
    }

    // 나올수 없는 페이지 판별 메소드 -> [짝, 홀]인 경우, arr[0] + 1 == arr[1]이 아닌 경우 true를 반환합니다.
    public boolean isWrongPageInputNumber(List<Integer> player1pages, List<Integer> player2pages){
        // page번호가 [홀, 짝]이 아닌 경우 true 반환
        boolean test =  player1pages.get(0) % 2 != 1;
        boolean test2 = player2pages.get(0) % 2 != 0;
        if(player1pages.get(0) % 2 != 1 || player2pages.get(0) % 2 != 1) return true;
        if(player1pages.get(1) % 2 != 0 || player2pages.get(1) % 2 != 0) return true;

        // arr[0] + 1 == arr[1]이 아닌 경우 true 반환
        if(player1pages.get(0) + 1 != player1pages.get(1)) return true;
        if(player2pages.get(0) + 1 != player2pages.get(1)) return true;

        return false;
    }

    // 제한된 페이지 판별 메소드 -> 음수 및 {1,2,399,400}페이지라면 true를 반환합니다.
    public boolean isRestrictPage(List<Integer> player1pages, List<Integer> player2pages){
        for(int i = 0; i < player1pages.size(); i++){
            boolean player1Page = (3 <= player1pages.get(i)) && (player1pages.get(i) <= 398);
            boolean player2Page = (3 <= player2pages.get(i)) && (player2pages.get(i) <= 398);

            if(!(player1Page && player2Page)) return true;
        }

        return false;
    }
}
