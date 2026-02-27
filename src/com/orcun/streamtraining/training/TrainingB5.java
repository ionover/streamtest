package com.orcun.streamtraining.training;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.orcun.streamtraining.domain.User;

/*
 * Get two users who are vegetarian
 */
public class TrainingB5 {
	//With for
	public List<User> getTwoVegeterianUserV1(List<User> userList) {
		List<User> list = new ArrayList<>();
		for(User user:userList) {
			if(user.isVegetarian())
				list.add(user);
			if(list.size()==2)
				break;
		}
		return list;
	}

}
