package com.xiaoxiannv.books.mapper;

import com.xiaoxiannv.books.po.Dict;
import com.xiaoxiannv.books.po.DictExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DictMapper {
    long countByExample(DictExample example);

    int deleteByExample(DictExample example);

    int deleteByPrimaryKey(Integer dictId);

    int insert(Dict record);

    int insertSelective(Dict record);

    List<Dict> selectByExample(DictExample example);

    Dict selectByPrimaryKey(Integer dictId);

    int updateByExampleSelective(@Param("record") Dict record, @Param("example") DictExample example);

    int updateByExample(@Param("record") Dict record, @Param("example") DictExample example);

    int updateByPrimaryKeySelective(Dict record);

    int updateByPrimaryKey(Dict record);
}