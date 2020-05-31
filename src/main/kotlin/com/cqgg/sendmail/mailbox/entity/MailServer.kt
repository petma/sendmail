package cn.maxpeedinggrods.rms.mailServer.mailbox.entity

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import com.fasterxml.jackson.annotation.JsonFormat
import io.swagger.annotations.ApiModelProperty

import lombok.Data
import org.jeecgframework.poi.excel.annotation.Excel
import org.springframework.format.annotation.DateTimeFormat

import java.io.Serializable
import java.util.*

/**
 * @Description: 邮箱服务器
 * @Author: jeecg-boot
 * @Date:   2019-09-17
 * @Version: V1.0
 */
@Data
@TableName("crm_mail_server")
class MailServer : Serializable {

    /**id */
    @TableId(type = IdType.UUID)
    var id: Int = 0

    @Excel(name = "店铺邮箱id", width = 15.0)
    @ApiModelProperty(value = "店铺邮箱id")
    var mailAccountId: Int  = 0



    /**imap服务器 */
    var imapServer: String = ""

    /**imap端口 */
    var imapPort: Int = 993

    /**smtp服务器 */
    var smtpServer: String = ""

    /**smtpSsl端口465 或587 */
    var smtpPort: Int = 465





    companion object {
        private const val serialVersionUID = 1L

    }
}
