package com.longyx.admin.biz.service.log.impl;


import com.tydic.admin.api.entity.log.Log;
import com.tydic.admin.api.vo.LogVo;
import com.tydic.admin.api.vo.PageResultVo;
import com.tydic.admin.biz.mapper.log.LogMapper;
import com.tydic.admin.biz.service.log.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

/**
 * @author Mr.Longyx
 * @date 2020年01月04日 18:55
 */
@Service
public class LogServiceImpl implements LogService {
    @Autowired
    private LogMapper logMapper;

    @Override
    public int save(Log log) {
        return logMapper.addLogBySelective(log);
    }

    @Override
    public PageResultVo findLogByPage(LogVo logVo) {
        int num = logMapper.queryForNum(logVo);

        PageResultVo pageResult;
        if(num > 0){
            List<Log> logs = logMapper.queryForPage(logVo);
            pageResult = new PageResultVo(
                    logs,
                    num,
                    logVo.getCurrentPage(),
                    logVo.getPageSize());

        }else {
            pageResult = PageResultVo.blank(logVo.getPageSize());
        }
        return pageResult;
    }

    @Override
    public int deleteLog(List<Long> ids) {
        Iterator<Long> iterator = ids.iterator();
        while(iterator.hasNext()){
            Long id = iterator.next();
            if(id != null){
                logMapper.deleteLogById(id);
            }
        }
        return 1;
    }

    @Override
    public Log findLogByUsername(String username) {
        return logMapper.findLogByUsername(username);
    }
}

