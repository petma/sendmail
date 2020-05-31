package cn.maxpeedinggrods.rms.mailServer.mailtag.entity

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import lombok.Data
import lombok.EqualsAndHashCode
import lombok.experimental.Accessors
import org.jeecgframework.poi.excel.annotation.Excel

/**
 * @Description: 邮件TAG关联关系
 * @Author: jeecg-boot
 * @Date:   2019-09-30
 * @Version: V1.0
 */
@Data
@TableName("crm_mail_tag")
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "crm_mail_tag", description = "邮件TAG关联关系")
class InboxTag {

    /**id */
    @TableId(type = IdType.UUID)
    @ApiModelProperty(value = "id")
    var id:Long = 0
    /**inbox_id */
    @Excel(name = "mail_id", width = 15.0)
    @ApiModelProperty(value = "mail_id")
    var mailId: Long=0
    /**tag_id */
    @Excel(name = "tag_id", width = 15.0)
    @ApiModelProperty(value = "tag_id")
    var tagId: Int=0
}
