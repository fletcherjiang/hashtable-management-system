package com.longyx.admin.biz.mapper.notice;

import com.longyx.admin.api.entity.notice.Notice;
import com.longyx.admin.api.vo.NoticeVo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Mr.Longyx
 * @date 2020年01月04日 19:32
 */
@Mapper
@Repository
public interface NoticeMapper {
    @Select("select count(id) from sys_notice where title=#{title}")
    int queryForNum(NoticeVo noticeVo);

    @Select("select id,title,content,enable,create_by,create_time,update_by,update_time from sys_notice where title=#{title} limit #{start},#{pageSize} ")
    List<Notice> queryForPage(NoticeVo noticeVo);

    @Delete("delete from sys_notice where id=#{id}")
    int deleteNoticeById(Long id);


    int addNoticeBySelective(Notice notice);

    int updateNoticeByIdSelective(Notice notice);
}


