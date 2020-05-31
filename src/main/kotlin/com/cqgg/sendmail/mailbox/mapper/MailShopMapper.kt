package cn.maxpeedinggrods.rms.mailServer.mailbox.mapper


import cn.maxpeedinggrods.rms.mailServer.mailbox.entity.MailShop
import com.baomidou.mybatisplus.core.mapper.BaseMapper
import org.apache.ibatis.annotations.Select

/**
 * @Description: 店铺邮箱
 * @Author: jeecg-boot
 * @Date: 2019-09-16
 * @Version: V1.0
 */
interface MailShopMapper : BaseMapper<MailShop> {

    fun deleteByMainId(mainId: Int): Boolean
    /**
     * 查询该服务器下，所有正常状态的邮箱
     */
    @Select("select * from crm_mail_shop where mail_server_id=#{id} and mail_status=1 ")
    fun selectByMainId(mainId: Int): MutableList<MailShop>
}
