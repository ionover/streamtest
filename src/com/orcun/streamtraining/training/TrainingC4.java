package com.orcun.streamtraining.training;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.orcun.streamtraining.domain.User;
import com.orcun.streamtraining.util.StreamConstans.Language;
import com.orcun.streamtraining.util.StreamConstans.Title;

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

	//TODO: Найти пользователя знающего английский с максимальной зарплатой (используйте filter по языкам + max по зарплате + orElse)
	public User getUserWhoEarnsHighSalaryAmongUsersV2(List<User> userList) {
		return null; // Replace with your stream implementation
	}

	public static void main(String[] args) {
		List<User> userList = createTestData();
		TrainingC4 training = new TrainingC4();
		
		User expected = training.getUserWhoEarnsHighSalaryAmongUsersV1(userList);
		User actual = training.getUserWhoEarnsHighSalaryAmongUsersV2(userList);
		
		if ((expected == null && actual == null) || (expected != null && expected.equals(actual))) {
			System.out.println("✓ Test passed!");
			System.out.println("Result: " + actual);
		} else {
			System.out.println("✗ Test failed!");
			System.out.println("Expected: " + expected);
			System.out.println("Actual: " + actual);
		}
	}

	private static List<User> createTestData() {
		List<User> userList = new ArrayList<>();
		userList.add(new User("Jane", "Lawrence", 21, 5600, Title.SOFTWARE_ENGINEER, true, 2011, new Language[]{Language.ENGILISH, Language.GERMAN}));
		userList.add(new User("Kate", "Winston", 23, 6560, Title.ACCOUNTED, false, 2012, new Language[]{Language.ENGILISH, Language.TURKISH}));
		userList.add(new User("John", "Gordan", 25, 3500, Title.SECURTY, true, 2013, new Language[]{Language.ENGILISH}));
		userList.add(new User("Kate", "Marvel", 29, 8000, Title.POD_LEADER, false, 2011, new Language[]{Language.GERMAN}));
		userList.add(new User("Jane", "Marvel", 32, 8000, Title.PROJECT_LEADER, true, 2010, new Language[]{Language.TURKISH}));
		userList.add(new User("Visnu", "Sarej", 22, 4000, Title.SOFTWARE_ENGINEER, false, 2008, new Language[]{Language.GERMAN}));
		userList.add(new User("Mike", "Denis", 21, 3500, Title.SOFTWARE_ENGINEER, true, 2011, new Language[]{Language.ENGILISH}));
		userList.add(new User("Rajess", "Visnu", 22, 4000, Title.SOFTWARE_ENGINEER, true, 2009, new Language[]{Language.ENGILISH}));
		return userList;
	}
}
