package spittr.dao;

import org.apache.ibatis.annotations.Param;
import spittr.pojo.Spitter;
import spittr.pojo.SpitterExample;

import java.util.List;

public interface SpitterMapper {
    int countByExample(SpitterExample example);

    int deleteByExample(SpitterExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Spitter record);

    int insertSelective(Spitter record);

    List<Spitter> selectByExample(SpitterExample example);

    Spitter selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Spitter record, @Param("example") SpitterExample example);

    int updateByExample(@Param("record") Spitter record, @Param("example") SpitterExample example);

    int updateByPrimaryKeySelective(Spitter record);

    int updateByPrimaryKey(Spitter record);
}