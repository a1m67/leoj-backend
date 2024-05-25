package com.yupi.leoj.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yupi.leoj.annotation.AuthCheck;
import com.yupi.leoj.common.BaseResponse;
import com.yupi.leoj.common.ErrorCode;
import com.yupi.leoj.common.ResultUtils;
import com.yupi.leoj.constant.UserConstant;
import com.yupi.leoj.exception.BusinessException;
import com.yupi.leoj.model.dto.question.QuestionQueryRequest;
import com.yupi.leoj.model.dto.questionsubmit.QuestionSubmitAddRequest;
import com.yupi.leoj.model.dto.questionsubmit.QuestionSubmitQueryRequest;
import com.yupi.leoj.model.entity.Question;
import com.yupi.leoj.model.entity.QuestionSubmit;
import com.yupi.leoj.model.entity.User;
import com.yupi.leoj.model.vo.QuestionSubmitVO;
import com.yupi.leoj.service.QuestionSubmitService;
import com.yupi.leoj.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 题目提交接口
 *
 * @author <a href="https://github.com/liyupi">程序员鱼皮</a>
 * @from <a href="https://yupi.icu">编程导航知识星球</a>
 */
@RestController
@RequestMapping("/question_submit")
@Slf4j
public class QuestionSubmitController {

    @Resource
    private QuestionSubmitService questionSubmitService;

    @Resource
    private UserService userService;

    /**
     * 提交题目
     *
     * @param questionSubmitAddRequest
     * @param request
     * @return resultNum 本次点赞变化数
     */
    @PostMapping("/")
    public BaseResponse<Long> doQuestionSubmit(@RequestBody QuestionSubmitAddRequest questionSubmitAddRequest,
                                               HttpServletRequest request) {
        if (questionSubmitAddRequest == null || questionSubmitAddRequest.getQuestionId() <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        // 登录才能点赞
        final User loginUser = userService.getLoginUser(request);
        long questionSubmitId = questionSubmitService.doQuestionSubmit(questionSubmitAddRequest, loginUser);
        return ResultUtils.success(questionSubmitId);
    }

    /**
     * 分页获取题目提交列表（除管理员外，普通用户只能看到非答案、提交代码等公开信息）
     *
     * @param questionQueryRequest
     * @return
     */
    @PostMapping("/list/page")
    public BaseResponse<Page<QuestionSubmitVO>> listQuestionSubmitByPage(@RequestBody QuestionSubmitQueryRequest questionQueryRequest,
                                                                         HttpServletRequest request) {
        long current = questionQueryRequest.getCurrent();
        long size = questionQueryRequest.getPageSize();
        // 查询到提交信息
        Page<QuestionSubmit> questionSubmitPage = questionSubmitService.page(new Page<>(current, size),
                questionSubmitService.getQueryWrapper(questionQueryRequest));
        User loginUser = userService.getLoginUser(request);
        // 脱敏处理
        return ResultUtils.success(questionSubmitService.getQuestionSubmitVOPage(questionSubmitPage, loginUser));
    }

}
