package com.yupi.leoj.service;

import com.yupi.leoj.model.dto.questionsubmit.QuestionSubmitAddRequest;
import com.yupi.leoj.model.entity.QuestionSubmit;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yupi.leoj.model.entity.User;

/**
* @author 孟乐航
* @description 针对表【question_submit(题目提交)】的数据库操作Service
* @createDate 2024-05-24 02:57:55
*/
public interface QuestionSubmitService extends IService<QuestionSubmit> {
    /**
     * 题目提交
     *
     * @param questionSubmitId
     * @param loginUser
     * @return
     */
    long doQuestionSubmit(QuestionSubmitAddRequest questionSubmitAddRequest, User loginUser);

    /**
     * 帖子点赞（内部服务）
     *
     * @param userId
     * @param postId
     * @return
     */
}
