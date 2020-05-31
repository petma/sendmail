package cn.maxpeedinggrods.rms.mailServer.mailtag.service.impl

import cn.maxpeedinggrods.rms.mailServer.mailtag.entity.Tags
import cn.maxpeedinggrods.rms.mailServer.mailtag.mapper.TagsMapper
import cn.maxpeedinggrods.rms.mailServer.mailtag.service.ITagsService
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * @Description: 邮件TAG
 * @Author: jeecg-boot
 * @Date:   2019-09-30
 * @Version: V1.0
 */
@Service
class TagsServiceImpl : ServiceImpl<TagsMapper, Tags>(), ITagsService {
    @Autowired
    lateinit var mapper: TagsMapper

    override fun searchTags(tag: MutableList<String>): List<Tags> {
      return  mapper.searchTags(tag)
    }
}
