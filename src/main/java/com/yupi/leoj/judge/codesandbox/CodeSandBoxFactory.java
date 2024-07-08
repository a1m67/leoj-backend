package com.yupi.leoj.judge.codesandbox;

import com.yupi.leoj.judge.codesandbox.impl.ExampleCodeSandBox;
import com.yupi.leoj.judge.codesandbox.impl.RemoteCodeSandBox;
import com.yupi.leoj.judge.codesandbox.impl.ThirdPartyCodeSandBox;

public class CodeSandBoxFactory {
    /**
     * 创建代码沙箱实例
     * @param type
     * @return
     */
    public static CodeSandBox newInstance(String type) {
        switch (type) {
            case "example":
                return new ExampleCodeSandBox();
            case "remote":
                return new RemoteCodeSandBox();
            case "thirdParty":
                return new ThirdPartyCodeSandBox();
            default:
                return new ExampleCodeSandBox();
        }
    }
}
