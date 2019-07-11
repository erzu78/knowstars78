package com.jk.mapper;

import com.jk.pojo.Video;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface VideoMapper {

    @Select("select count(v.videoId) from T_VIDEO v")
    Integer queryVideoCount();

    @Select("select * from T_VIDEO limit #{start},#{pageSize}")
    List<Video> queryVideo(Integer start, Integer pageSize);

    @Insert("insert into T_VIDEO values ('111','111',now(),'111','http://gaokangle.oss-cn-beijing.aliyuncs.com/gaoakngle/1562772504954.jpg','video/512f3ef61ab7b989-20.mp4'")
    void addVideo(Video video);

    @Select("select * from T_VIDEO")
    List<Video> queryAboutVideo();

    @Select("select * from T_VIDEO where videoId = #{videoId}")
    Video querySingleVideo(Integer videoId);

}
