package com.longyx.admin.biz.mapper.log;

import com.tydic.admin.api.entity.log.Log;
import com.tydic.admin.api.vo.LogVo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Mr.Longyx
 * @date 2020年01月04日 19:31
 */
@Mapper
@Repository
public interface LogMapper {

    int addLogBySelective(Log log);

    @Select("select id,username,uri,method_name,params,class_name,times,user_id,ip,method from sys_api_log where username=#{username,jdbcType=BIGINT}")
    int queryForNum(LogVo logVo);

    @Select("select id,username,uri,method_name,params,class_name,times,user_id,ip,method from sys_api_log where username=#{username,jdbcType=VARCHAR} limit #{start},#{pageSize}")
    List<Log> queryForPage(LogVo logVo);

    @Delete("delete from sys_api_log where id=#{id}")
    int deleteLogById(Long id);

    @Select("select id,username,uri,method_name,params,class_name,times,user_id,ip,method from sys_api_log where username=#{username,jdbcType=VARCHAR}")
    Log findLogByUsername(String username);
}
