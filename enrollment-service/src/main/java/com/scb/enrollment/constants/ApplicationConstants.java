package com.scb.enrollment.constants;

public class ApplicationConstants {

    private  ApplicationConstants(){
        throw new IllegalAccessError("constant class");
    }

    public static final String ENROLLED = "Enrolled";
    public static final String COURSES_NOT_FOUND = "course not found";
    public static final String STUDENT_NOT_FOUND = "student not found";
    public static final String ENROLLMENT_NOT_FOUND = "Enrollment not found";
    public static final String INVALID_ENROLLMENT_ID = "entered id is invalid";

}
