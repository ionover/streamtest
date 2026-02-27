package com.orcun.streamtraining.training;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.orcun.streamtraining.domain.User;

/*
 * Get oldest user
 */
public class TrainingB2 {
	//With for
	public User getOldestUserV1(List<User> userList) {
		int age = 0;
		User oldestUser = null;
		for (User user : userList) {
			if (age < user.getAge()) {
				age = user.getAge();
				oldestUser = user;
			}
		}
		return oldestUser;
	}

	public User getOldestUserV111(List<User> userList) {
		return userList.stream()
				.sorted(Comparator.comparing(User::getAge).reversed())
				.toList()
				.getFirst();
	}
}