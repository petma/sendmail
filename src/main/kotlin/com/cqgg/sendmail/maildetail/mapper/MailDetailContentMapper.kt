package cn.maxpeedinggrods.rms.mailServer.maildetail.mapper


import cn.maxpeedinggrods.rms.mailServer.maildetail.entity.MailDetailContent
import com.baomidou.mybatisplus.core.mapper.BaseMapper
import org.apache.ibatis.annotations.Update

/**
 * @Description: 邮件详情表
 * @Author: jeecg-boot
 * @Date:   2019-09-23
 * @Version: V1.0
 */
interface MailDetailContentMapper : BaseMapper<MailDetailContent> {

    @Update("update crm_mail_detail_content set email_content=#{emailContent} where detail_id =#{id}")
    fun updateByDetailId(id: Long, emailContent: String)
}
