// package onboarding.problem7;
//
// import static org.assertj.core.api.Assertions.*;
//
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
//
// public class UserTest {
//
// 	User userMike;
// 	User userJack;
// 	UserID userIDMike;
// 	UserID userIDJack;
// 	@BeforeEach
// 	void setUser(){
// 		userMike = new User("mike");
// 		userJack = new User("jack");
// 		userIDMike = new UserID("mike");
// 		userIDJack = new UserID("jack");
// 	}
//
// 	@Test
// 	void add_friend_and_is_Friend() {
//
// 		userMike.addFriend(userIDJack);
// 		assertThat(userMike.isFriends(new UserID("jack"))).isTrue();
// 	}
//
// 	@Test
// 	void is_same_id(){
// 		assertThat(userJack.isSameID(new UserID("jack"))).isTrue();
// 	}
//
// 	@Test
// 	void second_friend(){
// 		User userJerry = new User("jerry");
// 		UserID userIDJerry = new UserID("jerry");
// 		userMike.addFriend(new UserID("kara"));
// 		userMike.addFriend(userIDJerry);
// 		userJack.addFriend(userIDJerry);
//
// 		userJerry.addFriend(userIDJack);
// 		assertThat(userMike.isSecondFriend(userJack)).isTrue();
// 		assertThat(userMike.isSecondFriend(userJerry)).isFalse();
// 	}
// }
