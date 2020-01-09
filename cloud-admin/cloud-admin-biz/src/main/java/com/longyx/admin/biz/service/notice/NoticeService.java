package com.longyx.admin.biz.service.notice;

import com.tydic.admin.api.entity.notice.Notice;
import com.tydic.admin.api.vo.NoticeVo;
import com.tydic.admin.api.vo.PageResultVo;

import java.util.List;

/**
 * @author Mr.Longyx
 * @date 2020年01月04日 18:50
 */
public interface NoticeService {
    PageResultVo findNoticeByPage(NoticeVo noticePage);

    int delete(List<Long> ids);

    int save(Notice notice);

    int updateNotice(Notice notice);
}
