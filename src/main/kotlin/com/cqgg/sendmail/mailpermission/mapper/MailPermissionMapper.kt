package cn.maxpeedinggrods.rms.mailServer.mailtag.mapper

import cn.maxpeedinggrods.rms.mailServer.mailtag.entity.MailPermission
import cn.maxpeedinggrods.rms.mailServer.mailtag.entity.Tags
import com.baomidou.mybatisplus.core.mapper.BaseMapper
import org.apache.ibatis.annotations.Param
import org.apache.ibatis.annotations.Select

/**
 * @Description: 邮件TAG
 * @Author: jeecg-boot
 * @Date:   2019-09-30
 * @Version: V1.0
 */
interface MailPermissionMapper : BaseMapper<MailPermission> {


    @Select("SELECT userid_for_dd  FROM  crm_mail_permission WHERE  is_leader = 1 and mail_account_id = #{id}")
    fun getDingDingIdByMailAccount(id: Int): List<String>
}
