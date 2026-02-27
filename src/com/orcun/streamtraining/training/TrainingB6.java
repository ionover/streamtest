package com.orcun.streamtraining.training;

import java.util.List;

import com.orcun.streamtraining.domain.User;

/*
 * Get any user who earns more than x dolar
 */
public class TrainingB6 {
	//With for
	public User getUsersWhoEarnsMoreV1(List<User> userList, double salary) {
		for(User user:userList) {
			if(user.getSalary()>salary)
				return user;
		}
		return null;
	}

}
