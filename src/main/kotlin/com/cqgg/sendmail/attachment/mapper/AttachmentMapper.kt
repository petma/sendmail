package cn.maxpeedinggrods.rms.mailServer.attachment.mapper

import cn.maxpeedinggrods.rms.mailServer.attachment.entity.Attachment


import com.baomidou.mybatisplus.core.mapper.BaseMapper
import org.apache.ibatis.annotations.Select

/**
 * @Description: 附件表
 * @Author: jeecg-boot
 * @Date:   2019-09-17
 * @Version: V1.0
 */
interface AttachmentMapper : BaseMapper<Attachment> {
    @Select("SELECT *  FROM  crm_attachment WHERE  mail_Id = #{id} ")
    fun getAttachmentByMailId(id: Long): List<Attachment>
}
