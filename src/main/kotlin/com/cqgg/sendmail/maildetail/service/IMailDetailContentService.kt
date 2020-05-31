package cn.maxpeedinggrods.rms.mailServer.maildetail.service


import cn.maxpeedinggrods.rms.mailServer.maildetail.entity.MailDetailContent
import com.baomidou.mybatisplus.extension.service.IService

/**
 * @Description: 邮件详情表
 * @Author: jeecg-boot
 * @Date:   2019-09-23
 * @Version: V1.0
 */
interface IMailDetailContentService : IService<MailDetailContent> {

    fun updateByDetailId(id: Long, emailContent: String)


}
