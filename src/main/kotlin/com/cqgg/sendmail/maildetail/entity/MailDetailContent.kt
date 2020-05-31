package cn.maxpeedinggrods.rms.mailServer.maildetail.entity

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
 * @Description: 邮件详情表
 * @Author: jeecg-boot
 * @Date:   2019-09-23
 * @Version: V1.0
 */
@Data
@TableName("crm_mail_detail_content")
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "crm_mail_detail_content对象", description = "邮件详情表")
class MailDetailContent {

    /**id */
    @TableId(type = IdType.UUID)
    @ApiModelProperty(value = "id")
    var id: Long = 0
    /**详情id */

    @ApiModelProperty(value = "详情id")
    var detailId: Long = 0
    /**内容 */

    @ApiModelProperty(value = "内容")
    var emailContent: String = ""

    @ApiModelProperty(value = "原始内容")
    var emailSourceContent:String=""
}
