package cn.maxpeedinggrods.rms.mailServer.mailbox.mapper


import cn.maxpeedinggrods.rms.mailServer.mailbox.entity.MailServer
import com.baomidou.mybatisplus.core.mapper.BaseMapper
import org.apache.ibatis.annotations.Select

/**
 * @Description: 邮箱服务器
 * @Author: jeecg-boot
 * @Date:   2019-09-16
 * @Version: V1.0
 */
interface MailServerMapper : BaseMapper<MailServer> {


    @Select("select *  FROM  crm_mail_server where  mail_account_id= #{id}    ")
    fun getByAccoountId(id: Int): MailServer?
}
