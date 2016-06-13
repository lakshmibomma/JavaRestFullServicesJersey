package com.mkyong.repository;

import java.util.List;

import com.mkyong.model.Activity;

public interface ActivityRepository {

	List<Activity> findAllActivities();

	Activity findActivity(String activityId);

	void create(Activity activity);

}