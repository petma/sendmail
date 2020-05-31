package cn.maxpeedinggrods.rms.mailServer.maildetail.service.impl


import cn.maxpeedinggrods.rms.mailServer.maildetail.entity.MailDetail
import cn.maxpeedinggrods.rms.mailServer.maildetail.entity.MailLastInfo
import cn.maxpeedinggrods.rms.mailServer.maildetail.mapper.MailDetailMapper

import cn.maxpeedinggrods.rms.mailServer.maildetail.service.IMailDetailService
import org.springframework.stereotype.Service

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
import org.springframework.beans.factory.annotation.Autowired

/**
 * @Description: 邮件详情
 * @Author: jeecg-boot
 * @Date:   2019-09-23
 * @Version: V1.0
 */
@Service
class MailDetailServiceImpl : ServiceImpl<MailDetailMapper, MailDetail>(), IMailDetailService {
    override fun savemail(mailIn: MailDetail): Long {
        return 0
    }
    @Autowired
    lateinit var  mailShopMapper: MailDetailMapper

    override fun queryByMessageId(type: String, mailShopId:Int,inboxMessageId: String): Long? {
        return mailShopMapper.queryByMessageId(type,mailShopId,inboxMessageId)
    }

    override fun getAllInfos(ids: List<Long>):List<MailDetail> {
        return mailShopMapper.queryOutById(ids)
    }

    override fun getLastInfo(type:String, id: Int): MailLastInfo? {

        val mailDetal= mailShopMapper.getLastInfo(type,id)
        if(mailDetal!=null){
            val lastInfo= MailLastInfo()
            lastInfo.mailShopId=mailDetal.mailAccountId
            lastInfo.messageId=mailDetal.inboxMessageId!!
            lastInfo.receiveTime=mailDetal.receiveTime!!
            return lastInfo
        }
        return null
    }

    override fun getContentLostData(type:String,id: Int): List<MailDetail> {
        return mailShopMapper.getContentLostData(type,id)
    }

    override fun getAttachmentLostData(type:String,id: Int): List<MailDetail> {
        return mailShopMapper.getAttachmentLostData(type,id)
    }

    override fun getToSend(): List<MailDetail> {
        return mailShopMapper.getToSend()
    }
}
