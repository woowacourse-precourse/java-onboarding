package onboarding.problem1.problem7;

/*
    유저의 id 정보를 가지고 있는 DTO 객체
 */

public class User {
    private final String id;

    public User(String id){
        this.id = id;
    };

    public String getId(){
        return id;
    }
}
