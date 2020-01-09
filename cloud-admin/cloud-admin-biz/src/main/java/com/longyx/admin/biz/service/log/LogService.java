package com.longyx.admin.biz.service.log;

import com.tydic.admin.api.entity.log.Log;
import com.tydic.admin.api.vo.LogVo;
import com.tydic.admin.api.vo.PageResultVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Mr.Longyx
 * @date 2020年01月04日 18:54
 */
public interface LogService {
    int save(Log log);

    PageResultVo findLogByPage(LogVo logVo);

    int deleteLog(List<Long> ids);

    Log findLogByUsername(@Param("username") String username);
}
