package com.longyx.admin.biz.controller;

import com.tydic.admin.api.entity.notice.Notice;
import com.tydic.admin.api.vo.NoticeVo;
import com.tydic.admin.api.vo.PageResultVo;
import com.tydic.admin.biz.service.notice.NoticeService;
import com.tydic.common.base.constants.GlobalsConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Mr.Longyx
 * @date 2020年01月04日 18:27
 */
@RestController
@RequestMapping("/notice")
public class NoticeController {
    @Autowired
    private NoticeService noticeService;

    /**分页查询公告*/
    @PostMapping("/findPage")
    @PreAuthorize("hasAuthority('notice:view')")
    public PageResultVo findPage(@RequestBody NoticeVo noticeVo){
        return noticeService.findNoticeByPage(noticeVo);
    }

    /**新增公告*/
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('notice:add')")
    public String save(@RequestBody Notice notice){

        int flag = noticeService.save(notice);
        if(flag == 1){
            return GlobalsConstants.SUCCESS;
        }
        return GlobalsConstants.FAIL;
    }

    /**删除公告*/
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('notice:delete')")
    public String delete(@RequestBody List<Long> ids){

        int flag = noticeService.delete(ids);
        if(flag == 1){
            return GlobalsConstants.SUCCESS;
        }
        return GlobalsConstants.FAIL;
    }

    /**更新公告*/
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('notice:edit')")
    public String update(@RequestBody Notice notice){
        int flag = noticeService.updateNotice(notice);
        if(flag == 1 ){
            return GlobalsConstants.SUCCESS;
        }
        return GlobalsConstants.FAIL;
    }

}

