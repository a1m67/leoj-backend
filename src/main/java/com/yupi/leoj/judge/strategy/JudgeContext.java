package com.yupi.leoj.judge.strategy;

import com.yupi.leoj.model.dto.question.JudgeCase;
import com.yupi.leoj.model.dto.questionsubmit.JudgeInfo;
import com.yupi.leoj.model.entity.Question;
import com.yupi.leoj.model.entity.QuestionSubmit;
import lombok.Data;

import java.util.List;
@Data
public class JudgeContext {
    private JudgeInfo judgeInfo;

    private List<String> inputList;

    private List<String> outputList;

    private List<JudgeCase> judgeCaseList;

    private Question question;

    private QuestionSubmit questionSubmit;
}
