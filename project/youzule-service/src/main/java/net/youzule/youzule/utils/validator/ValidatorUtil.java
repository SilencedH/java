package net.youzule.youzule.utils.validator;

import net.youzule.youzule.common.exception.BusiException;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

/**
 * @title:校验工具
 * @description:
 * @company:
 * @author:zhaodahai
 * @date:2018/5/17 17:41
 **/

public class ValidatorUtil {
    private static final Validator VALIDATOR = Validation.buildDefaultValidatorFactory().getValidator();

    /**
     *  1 @NotEmpty :不能为null，且Size>0
     *  2  @NotNull:不能为null，但可以为empty,没有Size的约束
     *  3  @NotBlank:只用于String,不能为null且trim()之后size>0
     */

    /**
     * @Description: 校验参数实体
     * @Param:
     * @return:
     * @Author: zhaodahai
     * @Date: 2018/5/17
     */

    public static void validate(Object request) throws BusiException {
        Set<ConstraintViolation<Object>> constraintViolationSet = VALIDATOR.validate(request);
        if (constraintViolationSet.size() > 0) {
            throw new BusiException(400, constraintViolationSet.iterator().next().getMessage());
        }
    }
}
