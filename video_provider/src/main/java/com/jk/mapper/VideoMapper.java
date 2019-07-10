package com.jk.mapper;

import com.jk.pojo.Video;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface VideoMapper {

    @Select("select count(v.videoId) from T_VIDEO v")
    Integer queryVideoCount();

    @Select("select * from T_VIDEO limit #{start},#{pageSize}")
    List<Video> queryVideo(Integer start, Integer pageSize);

    void saveVideo(Video video);

    @Select("select * from T_VIDEO")
    List<Video> queryAboutVideo();
}
