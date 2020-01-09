package com.longyx.admin.biz.controller;

import com.longyx.admin.api.vo.LogVo;
import com.longyx.admin.api.vo.PageResultVo;
import com.longyx.admin.biz.service.log.LogService;
import com.longyx.common.base.constants.GlobalsConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Mr.Longyx
 * @date 2020年01月04日 18:25
 */
@RestController
@RequestMapping("/log")
public class LogController {
    @Autowired
    private LogService logService;

    @PostMapping("/findPage")
    @PreAuthorize("hasAuthority('log:view')")
    public PageResultVo findPage(@RequestBody LogVo logVo){
        return logService.findLogByPage(logVo);
    }


    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('log:delete')")
    public String delete(@RequestBody List<Long> ids){

        int flag = logService.deleteLog(ids);
        if(flag == 1){
            return GlobalsConstants.SUCCESS;
        }
        return GlobalsConstants.FAIL;
    }

}

