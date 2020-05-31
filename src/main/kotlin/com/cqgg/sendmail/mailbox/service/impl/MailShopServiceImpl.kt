package cn.maxpeedinggrods.rms.mailServer.mailbox.service.impl


import cn.maxpeedinggrods.rms.mailServer.mailbox.entity.MailShop
import cn.maxpeedinggrods.rms.mailServer.mailbox.mapper.MailShopMapper
import cn.maxpeedinggrods.rms.mailServer.mailbox.service.IMailShopService
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * @Description: 店铺邮箱
 * @Author: jeecg-boot
 * @Date:   2019-09-16
 * @Version: V1.0
 */
@Service
class MailShopServiceImpl : ServiceImpl<MailShopMapper, MailShop>(), IMailShopService {

    @Autowired
    lateinit var  mailShopMapper: MailShopMapper

    override fun selectByMainId(mainId: Int): MutableList<MailShop> {
        return mailShopMapper.selectByMainId(mainId)
    }
}
