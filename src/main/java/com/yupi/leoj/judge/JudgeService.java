package com.yupi.leoj.judge;

import com.yupi.leoj.model.vo.QuestionSubmitVO;

public interface JudgeService {
    QuestionSubmitVO doJudge(long questionSubmitId);
}
