package onboarding.problem6;

import java.util.List;

public class DuplicateChecker {
    UserRepository userRepository = new UserRepository();
    //입력받은 정보 저장 리스트 클래스


    //데이터 배열입력받아 각요소별로 중복된지 확인하고 허가되면 리스트 클래스에 추가하는 함수
    public void inputDatas(List<List<String>> datas){
        for(var data: datas)this.userRepository.create(data);
    }

    //리스트 클래스를 반환하는 함수
    public List<String> getUsers(){
        return this.userRepository.getDuplicatedUsers();
    }
}
