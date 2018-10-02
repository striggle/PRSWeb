package com.prs;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import com.prs.business.user.User;
import com.prs.business.user.UserRepository;

@RunWith(SpringRunner.class)
public class PRSUserTests extends PrsWebApplicationTests {

	@Autowired 
	private UserRepository userRepository;
	
	@Test
	public void testUserCrudFunctions() {
		
		// get all users
		Iterable<User> users = userRepository.findAll();
		assertNotNull(users);
		
		// add a user
		User u1 = new User("username", "pwd", "fname", "lname", "phone", "email", true, true);
		assertNotNull(userRepository.save(u1));
		int id = u1.getId();
		
		// get user and validate username is correct
		Optional<User> u2 = userRepository.findById(id);
		assertEquals(u2.get().getUserName(), "username");
		
		// update user
		u2.get().setUserName("newUserName");
		assertNotNull(userRepository.save(u2.get()));
		
		// delete user
		userRepository.delete(u2.get());
		assertThat(!(userRepository.findById(id)).isPresent());
	}
}
