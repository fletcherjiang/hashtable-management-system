package com.longyx.admin.api.vo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mr.Longyx
 * @date 2020年01月04日 18:04
 */
@Data
public class PageResultVo {
    private List datas;
    /**数据总条数*/
    private Integer totalNum;
    private Integer currentPage;

    private Integer pagSize;

    private Integer totalPage;

    public PageResultVo(){}

    public PageResultVo(List datas, Integer totalNum, Integer currentPage, Integer pageSize){
        this.datas = datas;
        this.totalNum = totalNum;
        this.currentPage = currentPage;
        this.pagSize = pageSize;

        this.totalPage = totalNum % pageSize == 0 ? totalNum / pageSize : totalNum / pageSize + 1;
    }
    /**没有数据，默认不显示*/
    public static PageResultVo blank(Integer pagSize){
        return new PageResultVo(new ArrayList<>(), 0,1,pagSize);
    }

    public int getTotalPage(){
        return totalPage == 0 ? 1 : totalPage;
    }
}

