package com.jk.mapper;

import com.jk.pojo.Staff;
import com.jk.pojo.Video;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface VideoMapper {

    @Select("select count(v.videoId) from T_VIDEO v,T_STAFF s where v.staffId = s.sid and s.role = 1")
    Integer queryVideoCount();

    @Select("select * from T_VIDEO v,T_STAFF s where v.staffId = s.sid and s.role = 1 limit #{start},#{pageSize}")
    List<Video> queryVideo(Integer start, Integer pageSize);

    void addVideo(Video video);

    @Select("select * from T_VIDEO v,T_STAFF s where v.staffId = s.sid and s.role = 1 limit 6")
    List<Video> queryAboutVideo();

    @Select("select * from T_VIDEO v,T_STAFF s where v.staffId = s.sid and s.role = 1 and videoId = #{videoId}")
    Video querySingleVideo(Integer videoId);

    @Select("select * from T_VIDEO where videoId = #{vid}")
    Video findVideoById(Integer vid);

    @Update("update T_VIDEO set headline = #{headline},issuer = #{issuer},introduction = #{introduction} where videoId = #{videoId}")
    void updateVideo(Video video);

    @Delete("delete from T_VIDEO where videoId = #{vid}")
    void deleteVideo(Integer vid);

    @Select("select * from t_staff where role = 1 LIMIT 5")
    List<Staff> queryAuthor();

    @Select("select * from T_VIDEO v,T_STAFF s where v.staffId = s.sid and s.role = 1")
    List<Video> queryGengDuoVideo();

    @Select("SELECT * FROM t_video v,t_staff s where v.staffId = s.sid and v.staffId = #{videoId} GROUP BY v.videoId")
    List<Video> queryAuthorVideo(Integer videoId);

    @Select("select * from T_VIDEO v,T_STAFF s where v.staffId = s.sid and s.role = 1 limit 5")
    List<Video> queryLunBo();
}
