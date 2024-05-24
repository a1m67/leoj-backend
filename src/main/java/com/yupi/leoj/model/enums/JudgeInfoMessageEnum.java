package com.yupi.leoj.model.enums;

import org.apache.commons.lang3.ObjectUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum JudgeInfoMessageEnum {

    ACCEPTED("成功","Accept"),
    WRONG_ANSWER("答案错误","Wrong"),
    COMPILE_ERROR("编译错误","CompileError"),
    MEMORY_LIMIT_EXCEEDED("内存溢出","MemoryLimitExceeded"),
    TIME_LIMIT_EXCEEDED("超时","TimeLimitExceeded"),
    PRESENTATION_ERROR("展示错误","PresentationError"),
    OUTPUT_LIMIT_EXCEEDED("输出溢出","OutputLimitExceeded"),
    WAITING("等待中","Waiting"),
    DANGEROUS_OPERATION("危险操作","Accept"),
    RUNTIME_ERROR("运行错误","Accept"),
    SYSTEM_ERROR("系统错误","Accept");

    private final String text;

    private final String value;


    JudgeInfoMessageEnum(String text, String value) {
        this.text = text;
        this.value = value;
    }

    /**
     * 获取值列表
     *
     * @return
     */
    public static List<String> getValues() {
        return Arrays.stream(values()).map(item -> item.value).collect(Collectors.toList());
    }


    /**
     * 根据 value 获取枚举
     *
     * @param value
     * @return
     */
    public static JudgeInfoMessageEnum getEnumByValue(Integer value) {
        if (ObjectUtils.isEmpty(value)) {
            return null;
        }
        for (JudgeInfoMessageEnum anEnum : JudgeInfoMessageEnum.values()) {
            if (anEnum.value.equals(value)) {
                return anEnum;
            }
        }
        return null;
    }

    public String getValue() {
        return value;
    }

    public String getText() {
        return text;
    }

}
