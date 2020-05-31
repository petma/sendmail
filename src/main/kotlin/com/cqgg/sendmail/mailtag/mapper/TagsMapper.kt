package cn.maxpeedinggrods.rms.mailServer.mailtag.mapper

import cn.maxpeedinggrods.rms.mailServer.mailtag.entity.Tags
import com.baomidou.mybatisplus.core.mapper.BaseMapper
import org.apache.ibatis.annotations.Param
import org.apache.ibatis.annotations.Select

/**
 * @Description: 邮件TAG
 * @Author: jeecg-boot
 * @Date:   2019-09-30
 * @Version: V1.0
 */
interface TagsMapper : BaseMapper<Tags> {

    @Select(
            "<script>" +
                    "SELECT  *  FROM crm_tag  where tagtype='mails' and tagname in" +
                    " <foreach collection='tags' item='tag' open='(' separator=',' close=')'>#{tag}</foreach>" +
                    "</script>"
    )
    fun searchTags(@Param("tags")tags: MutableList<String>):List<Tags>
}
