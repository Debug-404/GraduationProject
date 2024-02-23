package com.utils;

import com.model.Student;
import lombok.Data;

@Data
public class DataRuleRequest extends PageParam {
    /**
     * 条件name
     */
    private Student student;

}
