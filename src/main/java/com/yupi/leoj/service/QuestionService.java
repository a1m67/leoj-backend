package com.yupi.leoj.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yupi.leoj.model.dto.question.QuestionQueryRequest;
import com.yupi.leoj.model.entity.Question;
import com.yupi.leoj.model.entity.Question;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yupi.leoj.model.vo.QuestionVO;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 孟乐航
 * @description 针对表【question(题目)】的数据库操作Service
 * @createDate 2024-05-24 02:56:16
 */
public interface QuestionService extends IService<Question> {
    /**
     * 校验
     *
     * @param post
     * @param add
     */
    void validQuestion(Question post, boolean add);

    /**
     * 获取查询条件
     *
     * @param questionQueryRequest
     * @return
     */
    QueryWrapper<Question> getQueryWrapper(QuestionQueryRequest questionQueryRequest);

    /**
     * 获取题目封装
     *
     * @param post
     * @param request
     * @return
     */
    QuestionVO getQuestionVO(Question post, HttpServletRequest request);

    /**
     * 分页获取题目封装
     *
     * @param postPage
     * @param request
     * @return
     */
    Page<QuestionVO> getQuestionVOPage(Page<Question> postPage, HttpServletRequest request);
}
