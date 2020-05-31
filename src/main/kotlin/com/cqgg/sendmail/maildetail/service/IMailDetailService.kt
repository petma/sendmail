package cn.maxpeedinggrods.rms.mailServer.maildetail.service

import cn.maxpeedinggrods.rms.mailServer.config.Const.MAIL_INBOX_TYPE
import cn.maxpeedinggrods.rms.mailServer.maildetail.entity.MailDetail
import cn.maxpeedinggrods.rms.mailServer.maildetail.entity.MailLastInfo
import com.baomidou.mybatisplus.extension.service.IService

/**
 * @Description: 邮件详情
 * @Author: jeecg-boot
 * @Date:   2019-09-23
 * @Version: V1.0
 */
interface IMailDetailService : IService<MailDetail> {
    fun savemail(mailIn: MailDetail): Long
    fun queryByMessageId(type: String, mailShopId: Int, inboxMessageId: String): Long?
    fun getAllInfos(ids: List<Long>): List<MailDetail>
    fun getLastInfo(type:String=MAIL_INBOX_TYPE,id: Int): MailLastInfo?
    fun getContentLostData(type:String=MAIL_INBOX_TYPE,id: Int): List<MailDetail>
    fun getAttachmentLostData(type:String=MAIL_INBOX_TYPE,id: Int): List<MailDetail>
    fun getToSend(): List<MailDetail>

}
