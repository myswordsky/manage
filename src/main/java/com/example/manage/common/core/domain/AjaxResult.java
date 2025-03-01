package com.example.manage.common.core.domain;

import lombok.Data;
import java.util.HashMap;

@Data
public class AjaxResult extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;

    public static final String CODE_TAG = "code";
    public static final String MSG_TAG = "msg";
    public static final String DATA_TAG = "data";

    public AjaxResult() {
    }

    public static AjaxResult success() {
        return success("操作成功");
    }

    public static AjaxResult success(Object data) {
        return success("操作成功", data);
    }

    public static AjaxResult success(String msg, Object data) {
        AjaxResult ret = new AjaxResult();
        ret.put(CODE_TAG, 200);
        ret.put(MSG_TAG, msg);
        if (data != null) {
            ret.put(DATA_TAG, data);
        }
        return ret;
    }

    public static AjaxResult error() {
        return error("操作失败");
    }

    public static AjaxResult error(String msg) {
        return error(500, msg);
    }

    public static AjaxResult error(int code, String msg) {
        AjaxResult ret = new AjaxResult();
        ret.put(CODE_TAG, code);
        ret.put(MSG_TAG, msg);
        return ret;
    }
} 