package com.yupi.leoj.judge.codesandbox.impl;

import com.yupi.leoj.judge.codesandbox.CodeSandBox;
import com.yupi.leoj.judge.codesandbox.model.ExecuteCodeRequest;
import com.yupi.leoj.judge.codesandbox.model.ExecuteCodeResponse;

/**
 * 远程代码沙箱
 */
public class RemoteCodeSandBox implements CodeSandBox {
    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest request) {
        System.out.println("远程代码沙箱");
        return null;
    }
}
