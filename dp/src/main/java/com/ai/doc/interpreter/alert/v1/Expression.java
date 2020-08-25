package com.ai.doc.interpreter.alert.v1;

import java.util.Map;

/**
 * @Description: TODO
 * @Author:
 * @Date: 2020/8/19
 * @Version:
 **/
public interface Expression {
    boolean interpret(Map<String,Long> stats);
}
