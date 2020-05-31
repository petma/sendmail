package cn.maxpeedinggrods.rms.mailServer.attachment.entity

import com.baomidou.mybatisplus.annotation.IdType
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
 * @Description: 附件表
 * @Author: jeecg-boot
 * @Date:   2019-09-17
 * @Version: V1.0
 */
@Data
@TableName("crm_attachment")
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "crm_attachment对象", description = "附件表")
class Attachment {

    /**id */
    @TableId(type = IdType.UUID)
    @ApiModelProperty(value = "id")
    var  id: Long  = 0
    /**名称 */
    @Excel(name = "名称", width = 15.0)
    @ApiModelProperty(value = "名称")
    var  fileName: String = ""
    /**地址 */
    @Excel(name = "地址", width = 15.0)
    @ApiModelProperty(value = "地址")
    var  filePath: String = ""

    /**归属ID */
    @Excel(name = "归属ID", width = 15.0)
    @ApiModelProperty(value = "归属ID")
    var  mailId: Long? = null
    /**附件的文件扩展名 */
    @Excel(name = "附件的文件扩展名", width = 15.0)
    @ApiModelProperty(value = "附件的文件扩展名")
    var  extensionName: String? = null
    /**创建时间 */
    @Excel(name = "创建时间", width = 20.0, format = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建时间")
    var  createdAt: Date? = null
    /**fileSize */
    @Excel(name = "fileSize", width = 15.0)
    @ApiModelProperty(value = "fileSize")
    var  fileSize: Int? = null
}
