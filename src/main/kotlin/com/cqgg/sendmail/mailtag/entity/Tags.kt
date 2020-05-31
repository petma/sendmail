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
 * @Description: 邮件TAG
 * @Author: jeecg-boot
 * @Date:   2019-09-30
 * @Version: V1.0
 */
@Data
@TableName("crm_tag")
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "crm_tag", description = "邮件TAG ")
class Tags {

    /**id */
    @TableId(type = IdType.UUID)
    @ApiModelProperty(value = "id")
    val id: Int = 0
    /**tagname */
    @Excel(name = "tagname", width = 15.0)
    @ApiModelProperty(value = "tagname")
    val tagname: String = ""
    @Excel(name = "tagtype", width = 15.0)
    @ApiModelProperty(value = "tagtype")
    val tagtype: String = ""
}
