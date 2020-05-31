package cn.maxpeedinggrods.rms.mailServer.attachment.service

import cn.maxpeedinggrods.rms.mailServer.attachment.entity.Attachment
import com.baomidou.mybatisplus.extension.service.IService

/**
 * @Description: 附件表
 * @Author: jeecg-boot
 * @Date:   2019-09-17
 * @Version: V1.0
 */
interface IAttachmentService : IService<Attachment> {

    fun getAttachmentByMailId(id: Long): List<Attachment>
}
