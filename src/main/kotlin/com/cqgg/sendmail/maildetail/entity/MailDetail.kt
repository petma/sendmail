package cn.maxpeedinggrods.rms.mailServer.maildetail.entity

import cn.maxpeedinggrods.rms.mailServer.attachment.entity.Attachment
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
 * @Description: 邮件详情
 * @Author: jeecg-boot
 * @Date:   2019-09-23
 * @Version: V1.0
 */
@Data
@TableName("crm_mail_detail")
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "crm_mail_detail对象", description = "邮件详情")
class MailDetail {

    /**id */
    @TableId(type = IdType.UUID)
    @ApiModelProperty(value = "id")
    var id:  Long  = 0
    /**inbox,outbox */
    @Excel(name = "inbox,outbox,junkbox", width = 15.0)
    @ApiModelProperty(value = "inbox,outbox,junkbox")
    var boxType: String = ""
    /**店铺邮箱id */
    @Excel(name = "店铺邮箱id", width = 15.0)
    @ApiModelProperty(value = "店铺邮箱id")
    var mailAccountId: Int  = 0

    /**收件箱发件人别名*/
    @Excel(name="别名")
    @ApiModelProperty(value = "别名")
    var alias: String  = ""

    /**发件人 */
    @Excel(name = "发件人", width = 15.0)
    @ApiModelProperty(value = "发件人")
    var sender: String  = ""
    /**发件时间 */
    @Excel(name = "发件时间", width = 20.0, format = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "发件时间")
    var sendTime: Date? = null
    /**收件人 */
    @Excel(name = "收件人", width = 15.0)
    @ApiModelProperty(value = "收件人")
    var receiver: String = ""
    /**收件时间 */
    @Excel(name = "收件时间", width = 20.0, format = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "收件时间")
    var receiveTime: Date? = null
    /**抄送人 */
    @Excel(name = "抄送人", width = 15.0)
    @ApiModelProperty(value = "抄送人")
    var cc: String? = null
    /**标题 */
    @Excel(name = "标题", width = 15.0)
    @ApiModelProperty(value = "标题")
    var emailSubject: String = ""
    /**附件数量 */
    @Excel(name = "附件数量", width = 15.0)
    @ApiModelProperty(value = "附件数量")
    var attachmentCount: Int = 0
    /**等级(1：紧急 3 普通 5低) */
    @Excel(name = "等级(1：紧急 3 普通 5低)", width = 15.0)
    @ApiModelProperty(value = "等级(1：紧急 3 普通 5低)")
    var emailPriority: Int = 3
    /**是否需要回执 0不需要，1需要 */
    @Excel(name = "是否需要回执 0不需要，1需要", width = 15.0)
    @ApiModelProperty(value = "是否需要回执 0不需要，1需要")
    var notification: Int = 0
    /**是否重要邮件 0 不重要，1重要 收件箱用到 */
    @Excel(name = "是否重要邮件 0 不重要，1重要 收件箱用到", width = 15.0)
    @ApiModelProperty(value = "是否重要邮件 0 不重要，1重要 收件箱用到")
    var inboxIsImportant: Int = 0
    /**状态(0,未读 1，已读 10 草稿 11待发送 12发送成功 13 发送失败) */
    @Excel(name = "状态(0,未读 1，已读 10 草稿 11待发送 12发送成功 13 发送失败)", width = 15.0)
    @ApiModelProperty(value = "状态(0,未读 1，已读 10 草稿 11待发送 12发送成功 13 发送失败)")
    var mailStatus: Int = 0
    /**是否有tag(收件箱用到) */
    @Excel(name = "是否有tag(收件箱用到)", width = 15.0)
    @ApiModelProperty(value = "是否有tag(收件箱用到)")
    var inboxTag: Int = 0
    /**源邮件服务器ID(收件箱用到) */
    @Excel(name = "源邮件服务器ID(收件箱用到)", width = 15.0)
    @ApiModelProperty(value = "源邮件服务器ID(收件箱用到)")
    var  inboxMessageId: String? = null
    /**回复的邮件ID，发件箱用到 */
    @Excel(name = "回复的邮件ID，发件箱用到", width = 15.0)
    @ApiModelProperty(value = "回复的邮件ID，发件箱用到")
    var  outboxReplayId: Int? = null
    /**创建人 */
    @Excel(name = "创建人", width = 15.0)
    @ApiModelProperty(value = "创建人")
    var  createdBy: Int? = null
    /**创建时间 */
    @Excel(name = "创建时间", width = 20.0, format = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建时间")
    var  createdAt: Date? = null
    /**修改人 */
    @Excel(name = "修改人", width = 15.0)
    @ApiModelProperty(value = "修改人")
    var  updatedBy: Int? = null
    /**最后修改时间 */
    @Excel(name = "最后修改时间", width = 20.0, format = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "最后修改时间")
    var  updatedAt: Date? = null
    /**删除时间 */
    @Excel(name = "删除时间", width = 20.0, format = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "删除时间")
    var  deletedAt: Date? = null
    /**是否已处理 0未处理，1已处理 */
    @Excel(name = "是否已处理 0未处理，1已处理", width = 15.0)
    @ApiModelProperty(value = "是否已处理 0未处理，1已处理")
    var  inboxIsHandled: Int = 0
    //邮件内容
    @TableField(exist = false)
    var emailContent=""
    //邮件源
    @TableField(exist = false)
    var emailSourceContent=""
    //邮件附件
    @TableField(exist = false)
    var attachments:MutableList<Attachment> = mutableListOf()
    //根据内容打标签
    @TableField(exist = false)
    var tag:MutableList<Int> = mutableListOf()

    //所属业务系统id
    @TableField(exist = false)
    var busId:Int=1
    @TableField(exist = false)
    var inlineCount=0
}
