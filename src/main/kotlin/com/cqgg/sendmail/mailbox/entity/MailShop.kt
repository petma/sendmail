package cn.maxpeedinggrods.rms.mailServer.mailbox.entity

import cn.maxpeedinggrods.rms.mailServer.maildetail.entity.MailLastInfo
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

/**
 * @Description: 店铺邮箱
 * @Author: jeecg-boot
 * @Date:   2019-09-17
 * @Version: V1.0
 */
@Data
@TableName("crm_mail_shop")
class MailShop : Serializable {


    /**邮箱id */
    @TableId(type = IdType.UUID)
    var id: Int = 0

    /**1:客服，2运维 */
    @Excel(name = "0:客服", width = 15.0)
    var mailBusiness: Int = 0
    /**渠道 */
    @Excel(name = "渠道", width = 15.0)
    var saleChannel: String = "ebay"
    /**别名 */
    @Excel(name = "别名", width = 15.0)
    var alias: String? = null

    /**所属站点 */
    @Excel(name = "所属站点", width = 15.0)
    var site_name: String? = null

    /**所属店铺id */
    @Excel(name = "所属店铺id", width = 15.0)
    var storeId: String? = null

    /**所属店铺名 */
    @Excel(name = "所属店铺名", width = 15.0)
    var storeName: String? = null

    /**邮箱 */
    @Excel(name = "邮箱", width = 15.0)
    var email: String = ""

    /**密码 */
    @Excel(name = "密码", width = 15.0)
    var pass: String = ""
    /**状态1正常 */
    @Excel(name = "状态", width = 15.0)
    var mailStatus: Int? = null

    /**创建人 */
    @Excel(name = "创建人", width = 15.0)
    @ApiModelProperty(value = "创建人")
    var createdBy: Int? = null
    /**创建时间 */
    @Excel(name = "创建时间", width = 20.0, format = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建时间")
    var createdAt: java.util.Date? = null
    /**修改人 */
    @Excel(name = "修改人", width = 15.0)
    @ApiModelProperty(value = "修改人")
    var updatedBy: Int? = null
    /**最后修改时间 */
    @Excel(name = "最后修改时间", width = 20.0, format = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "最后修改时间")
    var updatedAt: java.util.Date? = null
    /**删除时间 */
    @Excel(name = "删除时间", width = 20.0, format = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "删除时间")
    var deletedAt: java.util.Date? = null
    @TableField(exist = false)
    var lastInfo: MailLastInfo? = null

    @TableField(exist = false)
    var junkOne: MailLastInfo? = null

    @TableField(exist = false)
    var hasNewInboxMessage: Boolean = true //默认为有新消息
    @TableField(exist = false)
    var hasNewJunkMessage: Boolean = true

    companion object {
        private const val serialVersionUID = 1L
    }
}
