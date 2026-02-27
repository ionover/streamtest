package com.orcun.streamtraining.training;

import java.util.List;

import com.orcun.streamtraining.domain.User;
import com.orcun.streamtraining.util.StreamConstans.Title;

/*
 * Print all users name who are software engineers
 */
public class TrainingB4 {
	//With for
	public void printSoftwareEngineersNameV1(List<User> userList) {
		for(User user:userList) {
			if(user.getTitle().equals(Title.SOFTWARE_ENGINEER))
				System.out.println(user.getName());
		}
	}
	

}
