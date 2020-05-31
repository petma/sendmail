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
 * @Description: 邮箱权限
 * @Author: jeecg-boot
 * @Date:   2019-09-30
 * @Version: V1.0
 */
@Data
@TableName("crm_mail_permission")
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "crm_mail_permission对象", description = "邮箱权限")
class MailPermission {


    /**inbox_id */
    @Excel(name = "mail_account_id", width = 15.0)
    @ApiModelProperty(value = "mail_account_id")


    var mailAccountId: Int=0
    /**tag_id */
    @Excel(name = "user_id", width = 15.0)
    @ApiModelProperty(value = "user_id")
    var userId: Int=0

    /**tag_id */
    @Excel(name = "is_leader", width = 15.0)
    @ApiModelProperty(value = "is_leader")
    var isLeader: Int=0
    /**tag_id */
    @Excel(name = "userid_for_dd", width = 15.0)
    @ApiModelProperty(value = "userid_for_dd")
    var useridForDd: String?=""
    /**tag_id */
    @Excel(name = "user_name", width = 15.0)
    @ApiModelProperty(value = "user_name")
    var userName: String=""
}
