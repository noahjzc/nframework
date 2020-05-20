package com.noah.nframework.demo.controller;

import com.noah.nframework.core.annotation.Action;
import com.noah.nframework.core.annotation.Controller;
import com.noah.nframework.core.annotation.Inject;
import com.noah.nframework.core.bean.Data;
import com.noah.nframework.core.bean.Param;
import com.noah.nframework.demo.model.User;
import com.noah.nframework.demo.service.UserService;

import java.util.List;

/**
 * @author : Noah.Ji
 * @date: 2020/5/20 14:17
 */
@Controller
public class UserController {
    @Inject
    private UserService userService;

    @Action("get:/user")
    public Data get(Param param) {
        return new Data(userService.get(param.getLong("id")));
    }

    @Action("get:/user_query")
    public Data query() {
        return new Data(userService.query());
    }
}
