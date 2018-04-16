package com.ifi.models;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CourseRepo extends CrudRepository<CourseModel, Integer>,JpaRepository<CourseModel,Integer>{
	@Query("select size(u.stModels) from CourseModel u where u.courseid=:courseid")
	int findAllChildrenCount(@Param("courseid")Integer courseid);
}
