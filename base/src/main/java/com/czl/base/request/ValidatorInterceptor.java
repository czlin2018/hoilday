package com.czl.base.request;

import com.czl.base.response.enums.ApiResponseEnum;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Path;
import javax.validation.Valid;
import javax.validation.Validator;
import java.util.Arrays;
import java.util.Optional;
import java.util.Set;

/**
 * //todo 尚未完成
 *
 * @author: czl
 * @date: 2019/11/11
 * @description:
 */
@Component
@Aspect
public class ValidatorInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(ValidatorInterceptor.class);

    @Autowired
    private Validator validator;

    @Around ( value = "execution(* com.czl.*Controller.*(..)) && @args(javax.validation.Valid)" )
    public Object validate (ProceedingJoinPoint joinPoint) throws Throwable {
        String joinPointString = joinPoint.toString();

        // 找出标记了@Valid的JavaBean
        Optional<Object> optional = Arrays.stream(joinPoint.getArgs())
                .filter(arg -> arg.getClass().isAnnotationPresent(Valid.class))
                .findFirst();

        // 参数校验
        optional.ifPresent(arg -> validate(arg, joinPointString));
        return joinPoint.proceed();
    }

    private void validate (Object arg, String joinPoint) {
        if (arg == null) {
            return;
        }
        Set<ConstraintViolation<Object>> constraintViolations = validator.validate(arg);
        if (constraintViolations.isEmpty()) {
            return;
        }
        for (ConstraintViolation<Object> constraintViolation : constraintViolations) {
            validate(constraintViolation, joinPoint);
        }
    }

    private void validate (ConstraintViolation<Object> constraintViolation, String joinPoint) {
        Path property = constraintViolation.getPropertyPath();
        String name = property.iterator().next().getName();
        String errorMsg = "[" + name + "]" + constraintViolation.getMessage();
        LOGGER.error("{}---validator不符合规则校验----{}", joinPoint, errorMsg);
        throw new BizException(ApiResponseEnum.PARAMETER_INVALID, errorMsg);
    }
}
