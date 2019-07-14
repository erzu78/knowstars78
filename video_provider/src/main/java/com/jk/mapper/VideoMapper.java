package com.jk.mapper;

import com.jk.pojo.Video;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface VideoMapper {

    @Select("select count(v.videoId) from T_VIDEO v")
    Integer queryVideoCount();

    @Select("select * from T_VIDEO limit #{start},#{pageSize}")
    List<Video> queryVideo(Integer start, Integer pageSize);

    void addVideo(Video video);

    @Select("select * from T_VIDEO")
    List<Video> queryAboutVideo();

    @Select("select * from T_VIDEO where videoId = #{videoId}")
    Video querySingleVideo(Integer videoId);

    @Select("select * from T_VIDEO where videoId = #{vid}")
    Video findVideoById(Integer vid);

    @Update("update T_VIDEO set headline = #{headline},issuer = #{issuer},introduction = #{introduction} where videoId = #{videoId}")
    void updateVideo(Video video);

    @Delete("delete from T_VIDEO where videoId = #{vid}")
    void deleteVideo(Integer vid);
}
