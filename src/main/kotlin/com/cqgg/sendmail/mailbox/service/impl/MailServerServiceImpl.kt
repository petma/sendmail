package cn.maxpeedinggrods.rms.mailServer.mailbox.service.impl


import cn.maxpeedinggrods.rms.mailServer.mailbox.entity.MailServer
import cn.maxpeedinggrods.rms.mailServer.mailbox.entity.MailShop
import cn.maxpeedinggrods.rms.mailServer.mailbox.mapper.MailServerMapper
import cn.maxpeedinggrods.rms.mailServer.mailbox.mapper.MailShopMapper
import cn.maxpeedinggrods.rms.mailServer.mailbox.service.IMailServerService
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 * @Description: 邮箱服务器
 * @Author: jeecg-boot
 * @Date:   2019-09-16
 * @Version: V1.0
 */
@Service
class MailServerServiceImpl : ServiceImpl<MailServerMapper, MailServer>(), IMailServerService {

    @Autowired
    private val mailServerMapper: MailServerMapper? = null
    @Autowired
    private val mailShopMapper: MailShopMapper? = null

    @Transactional
    override fun saveMain(mailServer: MailServer, mailShopList: List<MailShop>) {
        mailServerMapper!!.insert(mailServer)
        for (entity in mailShopList) {
            //外键设置

            mailShopMapper!!.insert(entity)
        }
    }

    @Transactional
    override fun updateMain(mailServer: MailServer, mailShopList: List<MailShop>) {
        mailServerMapper!!.updateById(mailServer)

        //1.先删除子表数据
        mailShopMapper!!.deleteByMainId(mailServer.id)

        //2.子表数据重新插入
        for (entity in mailShopList) {
            //外键设置

            mailShopMapper.insert(entity)
        }
    }

    @Transactional
    override fun delMain(id: Int) {
        mailShopMapper!!.deleteByMainId(id)
        mailServerMapper!!.deleteById(id)
    }

    @Transactional
    override fun delBatchMain(idList: List<Int>) {
        for (id in idList) {
            mailShopMapper!!.deleteByMainId(id)
            mailServerMapper!!.deleteById(id)
        }
    }

    override fun getByAccoountId(id: Int): MailServer? {
        return mailServerMapper!!.getByAccoountId(id)
    }
}
