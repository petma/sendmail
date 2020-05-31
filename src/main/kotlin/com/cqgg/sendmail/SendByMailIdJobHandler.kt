package com.cqgg.sendmail

import cn.maxpeedinggrods.rms.mailServer.attachment.entity.Attachment
import cn.maxpeedinggrods.rms.mailServer.attachment.service.IAttachmentService
import cn.maxpeedinggrods.rms.mailServer.mailbox.MailOutUtils
import cn.maxpeedinggrods.rms.mailServer.maildetail.service.IMailDetailService
import cn.maxpeedinggrods.rms.mailServer.xxljobexecutor.MailId
import com.alibaba.fastjson.JSON
import com.xxl.job.core.biz.model.ReturnT
import com.xxl.job.core.handler.IJobHandler

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@JobHandler("sendByMailIdHandler")
@Component
class SendByMailIdJobHandler : IJobHandler() {
    var log4jer = LoggerFactory.getLogger(SendByMailIdJobHandler::class.java)


    @Autowired
    lateinit var mailDetailService: IMailDetailService

    @Autowired
    lateinit var attachmentService: IAttachmentService
    @Autowired
    lateinit var mailSendService: MailOutUtils

    override fun init() {
        super.init()
    }

    override fun execute(p0: String?): ReturnT<String> {

        try {
            log4jer.info("SendByMailIdJobHandler  start: params:"+p0)
            var mailids = JSON.parseObject(p0, MailId::class.java)
            mailDetailService.getToSend()
                    .filter {
                        it.id == mailids.mailId
                    }
                    .forEach {
                        log4jer.info("in send start to send: " + it.id)

                        if (it.attachmentCount > 0) {
                            it.attachments = attachmentService.getAttachmentByMailId(it.id) as MutableList<Attachment>
                        }
                        mailSendService.sendEmail(it)

                    }
        } catch (e: Exception) {
            e.printStackTrace()
            log4jer.error("SendByMailIdJobHandler fail: params:"+p0+",e:"+e)
            return ReturnT.FAIL
        }

        return ReturnT.SUCCESS
    }
}
