package com.longyx.common.security.util;

import com.longyx.common.security.model.LoginUser;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author: Longyx
 * @Package: com.longyx.common.security.util
 * @ClassName: UserUtils
 * @Date: 2019/11/5 09:09
 */
public class UserUtils {

    public static LoginUser getLoginUser() {
        return (LoginUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
