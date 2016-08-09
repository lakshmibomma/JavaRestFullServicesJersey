package com.mkyong.repository;

import java.sql.SQLException;
import java.util.List;

import com.mkyong.model.Activity;
import com.mkyong.model.ActivitySearch;

public interface ActivityRepository {

	List<Activity> findAllActivities();

	Activity findActivity(String activityId);

	void create(Activity activity);


	Activity update(Activity activity);


	void delete(String activityId);


	List<Activity> findByDescription(List<String> descriptions, int durationFrom, int durationTo);

	List<Activity> findByConstraints(ActivitySearch search);


	String iterateThroughDatabase() throws SQLException;

	String insertAndUpdateToTable() throws SQLException;

	String updateTable() throws SQLException;


}