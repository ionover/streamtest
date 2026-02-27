package com.orcun.streamtraining.training;

import java.util.List;

import com.orcun.streamtraining.domain.User;

/*
 * Get count of users who are vegetarian
 */
public class TrainingB3 {
	//With for
	public long getCountOfVegetarianUsersV1(List<User> userList) {
		long count = 0;
		for(User user:userList) {
			if(user.isVegetarian()) {
				count++;
			}
		}
		return count;
	}

}
