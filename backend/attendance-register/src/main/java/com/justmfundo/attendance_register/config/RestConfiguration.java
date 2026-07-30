package com.justmfundo.attendance_register.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.justmfundo.attendance_register.models.ClassBundleType;
import com.justmfundo.attendance_register.models.DanceLesson;
import com.justmfundo.attendance_register.models.Student;
import com.justmfundo.attendance_register.models.StudentBundleInfo;

@Configuration
public class RestConfiguration implements RepositoryRestConfigurer {

    @Override
    public void configureRepositoryRestConfiguration(
      RepositoryRestConfiguration config, CorsRegistry cors) {
        config.exposeIdsFor(DanceLesson.class, Student.class, ClassBundleType.class, StudentBundleInfo.class);
    }
}
