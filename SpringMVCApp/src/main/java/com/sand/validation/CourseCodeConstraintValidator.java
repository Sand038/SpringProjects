package com.sand.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String>
{

  private String coursePrefix;

  public void initialize(CourseCode constraint)
  {
    this.coursePrefix = constraint.value();
  }

  public boolean isValid(String obj, ConstraintValidatorContext context)
  {
    return obj == null || obj.startsWith(coursePrefix);
  }
}
