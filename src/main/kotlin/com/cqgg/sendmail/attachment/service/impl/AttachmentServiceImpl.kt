package cn.maxpeedinggrods.rms.mailServer.attachment.service.impl

import cn.maxpeedinggrods.rms.mailServer.attachment.entity.Attachment
import cn.maxpeedinggrods.rms.mailServer.attachment.mapper.AttachmentMapper
import cn.maxpeedinggrods.rms.mailServer.attachment.service.IAttachmentService

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl

/**
 * @Description: 附件表
 * @Author: jeecg-boot
 * @Date:   2019-09-17
 * @Version: V1.0
 */
@Service
class AttachmentServiceImpl : ServiceImpl<AttachmentMapper, Attachment>(), IAttachmentService {
    @Autowired
    lateinit var mailShopMapper: AttachmentMapper

    override fun getAttachmentByMailId(id: Long): List<Attachment> {
        return mailShopMapper.getAttachmentByMailId(id)
    }
}
