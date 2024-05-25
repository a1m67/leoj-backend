package com.yupi.leoj.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yupi.leoj.model.dto.question.QuestionQueryRequest;
import com.yupi.leoj.model.dto.questionsubmit.QuestionSubmitAddRequest;
import com.yupi.leoj.model.dto.questionsubmit.QuestionSubmitQueryRequest;
import com.yupi.leoj.model.entity.Question;
import com.yupi.leoj.model.entity.QuestionSubmit;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yupi.leoj.model.entity.User;
import com.yupi.leoj.model.vo.QuestionSubmitVO;
import com.yupi.leoj.model.vo.QuestionVO;

import javax.servlet.http.HttpServletRequest;

/**
* @author 孟乐航
* @description 针对表【question_submit(题目提交)】的数据库操作Service
* @createDate 2024-05-24 02:57:55
*/
public interface QuestionSubmitService extends IService<QuestionSubmit> {
    /**
     * 题目提交
     *
     * @param questionSubmitAddRequest
     * @param loginUser
     * @return
     */
    long doQuestionSubmit(QuestionSubmitAddRequest questionSubmitAddRequest, User loginUser);

    /**
     * 获取查询条件
     *
     * @param questionQueryRequest
     * @return
     */
    QueryWrapper<QuestionSubmit> getQueryWrapper(QuestionSubmitQueryRequest questionQueryRequest);

    /**
     * 获取题目封装
     *
     * @param questionSubmit
     * @param loginUser
     * @return
     */
    QuestionSubmitVO getQuestionSubmitVO(QuestionSubmit questionSubmit, User loginUser);

    /**
     * 分页获取题目封装
     *
     * @param questionSubmitPage
     * @param loginUser
     * @return
     */
    Page<QuestionSubmitVO> getQuestionSubmitVOPage(Page<QuestionSubmit> questionSubmitPage, User loginUser);



}
