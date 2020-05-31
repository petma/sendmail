package cn.maxpeedinggrods.rms.mailServer.mailtag.service.impl

import cn.maxpeedinggrods.rms.mailServer.maildetail.mapper.MailDetailContentMapper
import cn.maxpeedinggrods.rms.mailServer.mailtag.entity.InboxTag
import cn.maxpeedinggrods.rms.mailServer.mailtag.entity.MailPermission
import cn.maxpeedinggrods.rms.mailServer.mailtag.mapper.InboxTagMapper
import cn.maxpeedinggrods.rms.mailServer.mailtag.mapper.MailPermissionMapper
import cn.maxpeedinggrods.rms.mailServer.mailtag.service.IInboxTagService
import cn.maxpeedinggrods.rms.mailServer.mailtag.service.IPermissionService
import org.springframework.stereotype.Service

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
import org.springframework.beans.factory.annotation.Autowired

/**
 * @Description: 邮件TAG关联关系
 * @Author: jeecg-boot
 * @Date:   2019-09-30
 * @Version: V1.0
 */
@Service
class PermissionServiceImpl : ServiceImpl<MailPermissionMapper, MailPermission>(), IPermissionService {
    @Autowired
    lateinit var mailDetailContentMapper: MailPermissionMapper
    override fun getDingDingIdByMailAccount(id: Int): List<String> {
        return mailDetailContentMapper.getDingDingIdByMailAccount(id)
    }
}
