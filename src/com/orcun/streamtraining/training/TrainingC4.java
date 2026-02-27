package com.orcun.streamtraining.training;

import java.util.Comparator;
import java.util.List;

import com.orcun.streamtraining.domain.User;
import com.orcun.streamtraining.util.StreamConstans.Language;

/*
 * Get user who knows English and has the highest salary among the users who knows English
 */
public class TrainingC4 {
	//With for
	public User getUserWhoEarnsHighSalaryAmongUsersV1(List<User> userList) {
		User highestEarningUser = null;
		for(User user:userList) {
			boolean knowsEnglish = user.getLanguages().contains(Language.ENGILISH);
			if(!knowsEnglish)
				continue;
			
			if(highestEarningUser==null || highestEarningUser.getSalary()<user.getSalary()) {
				highestEarningUser = user;
			}				
		}
		return highestEarningUser;
	}
	

}
