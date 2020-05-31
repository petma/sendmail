package cn.maxpeedinggrods.rms.mailServer.mailbox.service


import cn.maxpeedinggrods.rms.mailServer.mailbox.entity.MailShop
import com.baomidou.mybatisplus.extension.service.IService

/**
 * @Description: 店铺邮箱
 * @Author: jeecg-boot
 * @Date:   2019-09-16
 * @Version: V1.0
 */
interface IMailShopService : IService<MailShop> {
    @Deprecated("不存在这种关系了")
    fun selectByMainId(mainId: Int): MutableList<MailShop>
}
