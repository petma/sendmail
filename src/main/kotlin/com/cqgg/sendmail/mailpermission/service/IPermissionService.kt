package cn.maxpeedinggrods.rms.mailServer.mailtag.service


import cn.maxpeedinggrods.rms.mailServer.mailtag.entity.MailPermission
import com.baomidou.mybatisplus.extension.service.IService

/**
 * @Description: 邮件TAG关联关系
 * @Author: jeecg-boot
 * @Date:   2019-09-30
 * @Version: V1.0
 */
interface IPermissionService : IService<MailPermission> {
    fun getDingDingIdByMailAccount(id: Int): List<String>
}
