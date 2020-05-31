package cn.maxpeedinggrods.rms.mailServer.maildetail.service.impl

import cn.maxpeedinggrods.rms.mailServer.maildetail.entity.MailDetailContent
import cn.maxpeedinggrods.rms.mailServer.maildetail.mapper.MailDetailContentMapper
import cn.maxpeedinggrods.rms.mailServer.maildetail.service.IMailDetailContentService
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * @Description: 邮件详情表
 * @Author: jeecg-boot
 * @Date:   2019-09-23
 * @Version: V1.0
 */
@Service
class MailDetailContentServiceImpl : ServiceImpl<MailDetailContentMapper, MailDetailContent>(), IMailDetailContentService {
    @Autowired
    lateinit var mailDetailContentMapper: MailDetailContentMapper

    override fun updateByDetailId(id: Long, emailContent: String) {
        mailDetailContentMapper.updateByDetailId(id,emailContent)
    }
}
