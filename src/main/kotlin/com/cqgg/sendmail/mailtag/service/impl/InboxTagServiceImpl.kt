package cn.maxpeedinggrods.rms.mailServer.mailtag.service.impl

import cn.maxpeedinggrods.rms.mailServer.mailtag.entity.InboxTag
import cn.maxpeedinggrods.rms.mailServer.mailtag.mapper.InboxTagMapper
import cn.maxpeedinggrods.rms.mailServer.mailtag.service.IInboxTagService
import org.springframework.stereotype.Service

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl

/**
 * @Description: 邮件TAG关联关系
 * @Author: jeecg-boot
 * @Date:   2019-09-30
 * @Version: V1.0
 */
@Service
class InboxTagServiceImpl : ServiceImpl<InboxTagMapper, InboxTag>(), IInboxTagService
