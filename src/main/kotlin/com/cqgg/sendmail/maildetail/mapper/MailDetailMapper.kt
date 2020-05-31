package cn.maxpeedinggrods.rms.mailServer.maildetail.mapper

import cn.maxpeedinggrods.rms.mailServer.maildetail.entity.MailDetail
import com.baomidou.mybatisplus.core.mapper.BaseMapper
import org.apache.ibatis.annotations.Param
import org.apache.ibatis.annotations.Select

/**
 * @Description: 邮件详情
 * @Author: jeecg-boot
 * @Date:   2019-09-23
 * @Version: V1.0
 */
interface MailDetailMapper : BaseMapper<MailDetail> {
    @Select("SELECT id  FROM  crm_mail_detail WHERE  box_type = #{type} and mail_account_id = #{mailShopId} and inbox_message_id=#{inboxMessageId} ")
    fun queryByMessageId(type: String, mailShopId: Int, inboxMessageId: String): Long?

    @Select(
            "<script>" +
                    "SELECT a.*,b.email_content FROM crm_mail_detail a  inner join crm_mail_detail_content b on a.id=b.detail_id where a.id in" +
                    " <foreach collection='ids' item='id' open='(' separator=',' close=')'>#{id}</foreach>" +
                    "</script>"
    )
    fun queryOutById(@Param("ids") ids: List<Long>): List<MailDetail>


    @Select("select mail_account_id ,receive_time ,inbox_message_id  from crm_mail_detail where box_type=#{type} and mail_account_id= #{id} order by id desc limit 1")
    fun getLastInfo(type:String="inbox",id: Int): MailDetail?

    //查询当天某邮箱的有记录没内容的邮件
    @Select("select id, mail_account_id ,receive_time ,inbox_message_id  from crm_mail_detail where mail_account_id=#{mailShopId} and box_type=#{type}  and TO_DAYS(created_at) = TO_DAYS(NOW()) and  id not in(select detail_id from crm_mail_detail_content)")
    fun getContentLostData(type:String,mailShopId: Int): List<MailDetail>

    @Select("select id, mail_account_id ,receive_time ,inbox_message_id  from crm_mail_detail where mail_account_id=#{mailShopId} and box_type=#{type}  and TO_DAYS(created_at) = TO_DAYS(NOW()) and  attachment_count !=(select count(*) from crm_attachment ca where crm_mail_detail.id=ca.mail_id) ")
    fun getAttachmentLostData(type:String="inbox",mailShopId: Int): List<MailDetail>

    @Select("SELECT a.*,b.email_content FROM crm_mail_detail a  inner join crm_mail_detail_content b on a.id=b.detail_id where a.box_type='outbox' and a.mail_status in (11,13) ")
    fun getToSend(): List<MailDetail>
}
