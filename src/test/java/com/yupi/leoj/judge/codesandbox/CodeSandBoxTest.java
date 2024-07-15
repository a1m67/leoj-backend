package com.yupi.leoj.judge.codesandbox;

import cn.hutool.json.JSONUtil;
import com.yupi.leoj.judge.codesandbox.impl.ExampleCodeSandBox;
import com.yupi.leoj.judge.codesandbox.impl.RemoteCodeSandBox;
import com.yupi.leoj.judge.codesandbox.model.ExecuteCodeRequest;
import com.yupi.leoj.judge.codesandbox.model.ExecuteCodeResponse;
import com.yupi.leoj.judge.strategy.JudgeContext;
import com.yupi.leoj.model.dto.question.JudgeCase;
import com.yupi.leoj.model.enums.QuestionSubmitLanguageEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CodeSandBoxTest {

    @Value("${codesandbox.type:example}")
    private String type;

    @Test
    void executeCode() {
        CodeSandBox codeSandBox = new RemoteCodeSandBox();
        String code = "int main() {}";
        String language = QuestionSubmitLanguageEnum.JAVA.getValue();
        List<String> inputList = Arrays.asList("1 2","3 4");
        ExecuteCodeRequest executeCodeRequest = ExecuteCodeRequest.builder()
                .code(code)
                .language(language)
                .inputList(inputList)
                .build();
         ExecuteCodeResponse response = codeSandBox.executeCode(executeCodeRequest);
        Assertions.assertNotNull(response);
    }

    @Test
    void executeCodeByValue() {
        CodeSandBox codeSandBox = CodeSandBoxFactory.newInstance(type);
        String code = "int main() {}";
        String language = QuestionSubmitLanguageEnum.JAVA.getValue();
        List<String> inputList = Arrays.asList("1 2","3 4");
        ExecuteCodeRequest executeCodeRequest = ExecuteCodeRequest.builder()
                .code(code)
                .language(language)
                .inputList(inputList)
                .build();
        ExecuteCodeResponse response = codeSandBox.executeCode(executeCodeRequest);
        System.out.println(response);
        Assertions.assertNotNull(response);
    }

    @Test
    void executeCodeByProxy() {
        CodeSandBox codeSandbox = CodeSandBoxFactory.newInstance(type);
        codeSandbox = new CodeSandBoxProxy(codeSandbox);
        String language = QuestionSubmitLanguageEnum.JAVA.getValue();;
        String code = "questionSubmit.getCode()";
        // 获取输入用例
//        String judgeCaseStr = question.getJudgeCase();
//        List<JudgeCase> judgeCaseList = JSONUtil.toList(judgeCaseStr, JudgeCase.class);
//        List<String> inputList = judgeCaseList.stream().map(JudgeCase::getInput).collect(Collectors.toList());
        List<String> inputList = Arrays.asList("1 2","3 4");
        ExecuteCodeRequest executeCodeRequest = ExecuteCodeRequest.builder()
                .code(code)
                .language(language)
                .inputList(inputList)
                .build();
        ExecuteCodeResponse response = codeSandbox.executeCode(executeCodeRequest);
        System.out.println(response);
        System.out.println(response);
        JudgeContext judgeContext = new JudgeContext();



//        CodeSandBox codeSandBox = CodeSandBoxFactory.newInstance(type);
//        CodeSandBoxProxy proxy = new CodeSandBoxProxy(codeSandBox);
//        String code = "int main() {}";
//        String language = QuestionSubmitLanguageEnum.JAVA.getValue();
//        List<String> inputList = Arrays.asList("1 2","3 4");
//        ExecuteCodeRequest executeCodeRequest = ExecuteCodeRequest.builder()
//                .code(code)
//                .language(language)
//                .inputList(inputList)
//                .build();
//        ExecuteCodeResponse response = proxy.executeCode(executeCodeRequest);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String type = sc.next();
            CodeSandBox codeSandBox = CodeSandBoxFactory.newInstance(type);
            String code = "int main() {}";
            String language = QuestionSubmitLanguageEnum.JAVA.getValue();
            List<String> inputList = Arrays.asList("1 2","3 4");
            ExecuteCodeRequest executeCodeRequest = ExecuteCodeRequest.builder()
                    .code(code)
                    .language(language)
                    .inputList(inputList)
                    .build();
             ExecuteCodeResponse response = codeSandBox.executeCode(executeCodeRequest);
        }
    }
}