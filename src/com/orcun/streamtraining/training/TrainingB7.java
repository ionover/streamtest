package com.orcun.streamtraining.training;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.orcun.streamtraining.domain.User;

/*
 * Print distinct user name who earns more than x dolar
 */
public class TrainingB7 {
	//With for
	public void getDistinctUserNameWhoEarnsMoreV1(List<User> userList, double salary) {
		Map<String,Boolean> userNameMap = new HashMap<>();
		for(User user:userList) {
			if(user.getSalary()>salary)
				userNameMap.put(user.getName(), true);
		}
		Iterator<String> it = userNameMap.keySet().iterator();
		while(it.hasNext())
			System.out.println(it.next());
	}

}
