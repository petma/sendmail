package cn.maxpeedinggrods.rms.mailServer.mailtag.service

import cn.maxpeedinggrods.rms.mailServer.mailtag.entity.Tags
import com.baomidou.mybatisplus.extension.service.IService

/**
 * @Description: 邮件TAG
 * @Author: jeecg-boot
 * @Date:   2019-09-30
 * @Version: V1.0
 */
interface ITagsService : IService<Tags> {
    fun searchTags(tag: MutableList<String>): List<Tags>
}
