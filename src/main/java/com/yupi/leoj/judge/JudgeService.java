package com.yupi.leoj.judge;

import com.yupi.leoj.model.entity.QuestionSubmit;
import com.yupi.leoj.model.vo.QuestionSubmitVO;

public interface JudgeService {
    QuestionSubmit doJudge(long questionSubmitId);

}
