package com.longyx.admin.api.vo;

import lombok.Data;

/**
 * @author Mr.Longyx
 * @date 2020年01月04日 18:03
 */
@Data
public class PageVo {
    /**起始页*/
    private int currentPage = 1;
    /**每页数*/
    private int pageSize = 10;


    public int homePage() {
        return (currentPage - 1) * pageSize;
    }

}
