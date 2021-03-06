/**
 * Copyright 2011-2013 FoundationDB, LLC
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.bj58.sql.parser;

import com.bj58.sql.types.ValueClassName;

/**
 * This node represents a binary arithmetic operator, like + or *.
 *
 */

public class BinaryBitOperatorNode extends BinaryOperatorNode
{
    /**
     * Initializer for a BinaryBitOperatorNode
     *
     * @param leftOperand The left operand
     * @param rightOperand  The right operand
     */

    public void init(Object operatorType, Object leftOperand, Object rightOperand) {
        super.init(leftOperand, rightOperand,
                   ValueClassName.NumberDataValue, ValueClassName.NumberDataValue);

        String operator = null;
        String methodName = null;

        switch ((OperatorType)operatorType) {
        case BITAND:
            operator = "&";
            methodName = "bitand";
            break;

        case BITOR:
            operator = "|";
            methodName = "bitor";
            break;

        case BITXOR:
            operator = "^";
            methodName = "bitxor";
            break;

        case LEFT_SHIFT:
            operator = "<<";
            methodName = "leftshift";
            break;

        case RIGHT_SHIFT:
            operator = ">>";
            methodName = "rightshift";
            break;

        default:
            assert false : "Unexpected operator:" + operatorType;
        }
        setOperator(operator);
        setMethodName(methodName);
    }

}
