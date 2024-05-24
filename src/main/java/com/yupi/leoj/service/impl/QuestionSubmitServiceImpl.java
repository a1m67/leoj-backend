package com.yupi.leoj.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yupi.leoj.common.ErrorCode;
import com.yupi.leoj.exception.BusinessException;
import com.yupi.leoj.model.dto.questionsubmit.JudgeInfo;
import com.yupi.leoj.model.dto.questionsubmit.QuestionSubmitAddRequest;
import com.yupi.leoj.model.entity.Question;
import com.yupi.leoj.model.entity.QuestionSubmit;
import com.yupi.leoj.model.entity.QuestionSubmit;
import com.yupi.leoj.model.entity.User;
import com.yupi.leoj.model.enums.QuestionSubmitLanguageEnum;
import com.yupi.leoj.model.enums.QuestionSubmitStatusEnum;
import com.yupi.leoj.service.QuestionService;
import com.yupi.leoj.service.QuestionSubmitService;
import com.yupi.leoj.service.QuestionSubmitService;
import com.yupi.leoj.mapper.QuestionSubmitMapper;
import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
* @author 孟乐航
* @description 针对表【question_submit(题目提交)】的数据库操作Service实现
* @createDate 2024-05-24 02:57:55
*/
@Service
public class QuestionSubmitServiceImpl extends ServiceImpl<QuestionSubmitMapper, QuestionSubmit>
    implements QuestionSubmitService{


    @Resource
    private QuestionService questionService;
    
    /**
     * 提交题目
     *
     * @param QuestionId
     * @param loginUser
     * @return
     */
    @Override
    public long doQuestionSubmit(QuestionSubmitAddRequest questionSubmitAddRequest , User loginUser) {
        // todo 判断编程语言是否合法
        String language = questionSubmitAddRequest.getLanguage();
        QuestionSubmitLanguageEnum languageEnum = QuestionSubmitLanguageEnum.getEnumByValue(language);
        if (languageEnum == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR,"编程语言错误");
        }
        long questionId =questionSubmitAddRequest.getQuestionId();
        // 判断实体是否存在，根据类别获取实体
        Question question = questionService.getById(questionSubmitAddRequest.getQuestionId());
        if (question == null) {
            throw new BusinessException(ErrorCode.NOT_FOUND_ERROR);
        }
        QuestionSubmit questionSubmit = new QuestionSubmit();
        long userId = loginUser.getId();
        questionSubmit.setUserId(userId);
        questionSubmit.setQuestionId(questionId);
        questionSubmit.setCode(questionSubmitAddRequest.getCode());
        questionSubmit.setLanguage(questionSubmitAddRequest.getLanguage());
        // 设置初始状态
        questionSubmit.setStatus(QuestionSubmitStatusEnum.WAITING.getValue());
        questionSubmit.setJudgeInfo("{}");
        boolean save = this.save(questionSubmit);
        if (!save) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "数据插入失败");
        }
        return questionSubmit.getQuestionId();
    }


}




