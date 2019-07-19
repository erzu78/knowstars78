package com.jk.mapper;

import com.jk.pojo.Information;
import com.jk.pojo.Topic;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TopicMapper {
    int deleteByPrimaryKey(Integer topicid);

    int insert(Topic record);

    int insertSelective(Topic record);

    Topic selectByPrimaryKey(Integer topicid);

    int updateByPrimaryKeySelective(Topic record);

    int updateByPrimaryKey(Topic record);

    List<Topic> queryTopic();

    List<Topic> queryTopicByTid(Integer tid);

    List<Topic> topicList(@Param("start") Integer start, @Param("rows") Integer rows);

    long queryTopicCount();

    void deleteAllTopic(@Param("ids")String ids);
}