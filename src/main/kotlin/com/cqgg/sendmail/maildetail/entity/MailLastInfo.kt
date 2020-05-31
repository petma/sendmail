package cn.maxpeedinggrods.rms.mailServer.maildetail.entity

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import com.fasterxml.jackson.annotation.JsonFormat
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import lombok.Data
import lombok.EqualsAndHashCode
import lombok.experimental.Accessors
import org.jeecgframework.poi.excel.annotation.Excel
import org.springframework.format.annotation.DateTimeFormat
import java.util.*

/**
 * @Description: 邮箱的最后一条记录
 * @Author: jeecg-boot
 * @Date:   2019-09-20
 * @Version: V1.0
 */
@Data
@TableName("crm_mail_shop_last")
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "crm_mail_shop_last对象", description = "邮箱的最后一条记录")
class MailLastInfo {

    /**记录id */
    @TableId(type = IdType.UUID)
    @ApiModelProperty(value = "记录id")
    val id: Int = 0
    /**邮箱id */
    @Excel(name = "邮箱id", width = 15.0)
    @ApiModelProperty(value = "邮箱id")
    var mailShopId: Int = 0
    /**最后一条邮件的ID */
    @Excel(name = "最后一条邮件的ID", width = 15.0)
    @ApiModelProperty(value = "最后一条邮件的ID")
    var messageId: String = ""
    /**最后一条邮件的收件时间 */

    @Excel(name = "最后一条邮件的收件时间", width = 20.0, format = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "最后一条邮件的收件时间")
    var receiveTime:  Date = Date()

    @TableField(exist = false)
    var hint=false
}
