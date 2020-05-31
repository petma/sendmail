package cn.maxpeedinggrods.rms.mailServer.mailbox.service

import cn.maxpeedinggrods.rms.mailServer.mailbox.entity.MailServer
import cn.maxpeedinggrods.rms.mailServer.mailbox.entity.MailShop
import com.baomidou.mybatisplus.extension.service.IService

/**
 * @Description: 邮箱服务器
 * @Author: jeecg-boot
 * @Date:   2019-09-16
 * @Version: V1.0
 */
interface IMailServerService : IService<MailServer> {

    /**
     * 添加一对多
     *
     */
    fun saveMain(mailServer: MailServer, mailShopList: List<MailShop>)

    /**
     * 修改一对多
     *
     */
    fun updateMain(mailServer: MailServer, mailShopList: List<MailShop>)

    /**
     * 删除一对多
     */
    fun delMain(id: Int)

    /**
     * 批量删除一对多
     */
    fun delBatchMain(idList: List<Int>)

      fun getByAccoountId(id: Int): MailServer?


}
