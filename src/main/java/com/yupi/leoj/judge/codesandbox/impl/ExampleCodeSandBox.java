package com.yupi.leoj.judge.codesandbox.impl;

import com.yupi.leoj.judge.codesandbox.CodeSandBox;
import com.yupi.leoj.judge.codesandbox.model.ExecuteCodeRequest;
import com.yupi.leoj.judge.codesandbox.model.ExecuteCodeResponse;
import com.yupi.leoj.model.dto.questionsubmit.JudgeInfo;
import com.yupi.leoj.model.entity.Question;
import com.yupi.leoj.model.enums.JudgeInfoMessageEnum;
import com.yupi.leoj.model.enums.QuestionSubmitStatusEnum;

import java.util.List;

/**
 * 示例代码沙箱
 */
public class ExampleCodeSandBox implements CodeSandBox {
    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest request) {

        List<String> inputList = request.getInputList();
        ExecuteCodeResponse response = new ExecuteCodeResponse();
        response.setOutputList(inputList);
        response.setMessage("代码执行成功");
        response.setStatus(QuestionSubmitStatusEnum.SUCCEED.getText());
        JudgeInfo judgeInfo = new JudgeInfo();
        judgeInfo.setMessage(JudgeInfoMessageEnum.ACCEPTED.getValue());
        judgeInfo.setMemory(100L);
        judgeInfo.setTime(100L);
        response.setJudgeInfo(judgeInfo);
        return response;
    }
}
