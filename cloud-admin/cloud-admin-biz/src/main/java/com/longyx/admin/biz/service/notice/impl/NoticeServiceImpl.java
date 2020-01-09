package com.longyx.admin.biz.service.notice.impl;

import com.tydic.admin.api.entity.notice.Notice;
import com.tydic.admin.api.vo.NoticeVo;
import com.tydic.admin.api.vo.PageResultVo;
import com.tydic.admin.biz.mapper.notice.NoticeMapper;
import com.tydic.admin.biz.service.notice.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

/**
 * @author Mr.Longyx
 * @date 2020年01月04日 18:50
 */
@Service
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    private NoticeMapper noticeMapper;

    @Override
    public PageResultVo findNoticeByPage(NoticeVo noticeVo) {
        int num = noticeMapper.queryForNum(noticeVo);
        PageResultVo pageResult = null;
        if(num > 0){
            List<Notice> notices = noticeMapper.queryForPage(noticeVo);
            pageResult = new PageResultVo(notices,num,noticeVo.getCurrentPage(),noticeVo.getPageSize());
        }else{
            pageResult = PageResultVo.blank(noticeVo.getPageSize());
        }
        return pageResult;
    }

    @Override
    public int delete(List<Long> ids) {
        Iterator<Long> iterator = ids.iterator();
        while(iterator.hasNext()){
            Long  id = iterator.next();
            if(id != null){
                noticeMapper.deleteNoticeById(id);
            }
        }
        return 1;
    }

    @Override
    public int save(Notice notice) {
        return noticeMapper.addNoticeBySelective(notice);
    }

    @Override
    public int updateNotice(Notice notice) {
        return noticeMapper.updateNoticeByIdSelective(notice);
    }
}

