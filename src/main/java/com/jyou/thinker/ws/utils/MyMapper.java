package com.jyou.thinker.ws.utils;

import tk.mybatis.mapper.common.ExampleMapper;
import tk.mybatis.mapper.common.Marker;
import tk.mybatis.mapper.common.RowBoundsMapper;
import tk.mybatis.mapper.common.base.BaseDeleteMapper;
import tk.mybatis.mapper.common.base.BaseSelectMapper;
import tk.mybatis.mapper.common.base.BaseUpdateMapper;

/**
 * TODO: 继承自己的MyMapper
 * @author wgbing
 * @date 2019-08-29 22:19
 */
public interface MyMapper<T> extends BaseSelectMapper<T>, /*MyInsertMapper<T>,*/ BaseUpdateMapper<T>,
        BaseDeleteMapper<T>, ExampleMapper<T>, RowBoundsMapper<T>, Marker {
    //TODO
    //FIXME 特别注意，该接口不能被扫描到，否则会出错

    /**
     * 新增
     * @param t
     * @return
     */
    int save(T t);

    /**
     * 批量删除
     * @param id
     * @return
     */
    int batchRemove(Object[] id);
}