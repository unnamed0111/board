package com.board.app.domain;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.regex.Pattern;

public class UserValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userId", "required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userPwd", "required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userEmail", "required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userBirth", "required");

        // userId
        // 오직 영문(소/대)자와 숫자로만 이루어져있어야한다. : ^[a-zA-Z0-9]*$
        // 길이는 6글자 ~ 30글자 사이

        boolean match = Pattern.matches("^[a-zA-Z0-9]*$", user.getUserId());

        if(!errors.hasFieldErrors("userId")) {
            if (!match) {
                errors.rejectValue("userId", "invalid");
            } else if (user.getUserId() == null || user.getUserId().length() < 6 || user.getUserId().length() > 30) {
                errors.rejectValue("userId", "length");
            }
        }

        // userPwd
        // 길이는 8글자 ~ 50글자 사이

        if(!errors.hasFieldErrors("userPwd")) {
            if (user.getUserPwd() == null || user.getUserPwd().length() < 8 || user.getUserPwd().length() > 50) {
                errors.rejectValue("userPwd", "length");
            }
        }

        // userName
        // 특수문자, 이모티콘, 숫자를 제외한 국제언어로 이루어져야함 : [\p{L}]+
        // 길이는 최대 30글자

        match = Pattern.matches("^[\\p{L}]*$", user.getUserName());

        if(!errors.hasFieldErrors("userName")) {
            if (!match) {
                errors.rejectValue("userName", "invalid");
            } else if (user.getUserName() == null || user.getUserName().length() > 30) {
                errors.rejectValue("userName", "length");
            }
        }

        // userEmail
        // 이메일 형식으로 이루어져야함 : ^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$
        // 길이는 최대 30글자

        match = Pattern.matches("^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$", user.getUserEmail());

        if(!errors.hasFieldErrors("userEmail")) {
            if (!match) {
                errors.rejectValue("userEmail", "invalid");
            } else if (user.getUserEmail() == null || user.getUserEmail().length() > 30) {
                errors.rejectValue("userEmail", "length");
            }
        }
    }
}
