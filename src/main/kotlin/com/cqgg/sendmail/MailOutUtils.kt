package com.cqgg.sendmail


import cn.maxpeedinggrods.rms.mailServer.decryptAES
import cn.maxpeedinggrods.rms.mailServer.mailbox.service.IMailServerService
import cn.maxpeedinggrods.rms.mailServer.mailbox.service.IMailShopService
import cn.maxpeedinggrods.rms.mailServer.maildetail.entity.MailDetail

import cn.maxpeedinggrods.rms.mailServer.maildetail.send.SendMailException
import cn.maxpeedinggrods.rms.mailServer.maildetail.service.IMailDetailService

import com.sun.mail.util.MailSSLSocketFactory
import jakarta.activation.DataHandler
import jakarta.activation.DataSource
import jakarta.activation.FileDataSource

import jakarta.mail.*
import jakarta.mail.internet.*
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.io.File
import java.io.FileOutputStream
import java.util.*




import kotlin.math.absoluteValue

/**
 * 发送邮件
 * https://javaee.github.io/javamail/docs/api//com/sun/mail/smtp/package-summary.html
 */
/*
@Component
class MailOutUtils {
    @Autowired
    lateinit var mailDetailService: IMailDetailService

    @Autowired
    lateinit var mailShopService: IMailShopService

    @Autowired
    lateinit var mailServerService: IMailServerService

    */
/*  @Autowired
      lateinit var prxoyService: IMailProxyService
  *//*

    @Value(value = "\${mail.attachment.path}")
    lateinit var uploadpath: String

    @Value(value = "\${mail.passkey}")
    lateinit var key: String


    @Value(value = "\${mail.proxy.enable}")
    lateinit var proxySet: String

    @Value(value = "\${mail.proxy.host}")
    lateinit var proxyHost: String

    @Value(value = "\${mail.proxy.port}")
    lateinit var proxyPort: String
    var log4jer = LoggerFactory.getLogger(MailOutUtils::class.java)
    fun sendEmail(mail: MailDetail) {
        log4jer.debug("in MailOutUtils sendEmail")
        var mailBox = mailShopService.getById(mail.mailAccountId)
        if (mailBox.mailStatus == 1 && mailBox.deletedAt == null && mailBox.pass.isNotBlank()) {


            try {
                //  var mailproxy=prxoyService.getProxyByMailId(it.id)

                var server = mailServerService.getByAccoountId(mailBox.id)
                if (server != null) {
                    log4jer.debug("in MailOutUtils Server :" + server.smtpServer + ",mail:" + mailBox.email + ",id:" + mail.id)
                    var staticurl = uploadpath + File.separator + mail.mailAccountId + File.separator + mail.id + File.separator + "static" + File.separator
                    var session = getMySession(server.smtpServer, server.smtpPort, mailBox.email, decryptAES(mailBox.pass, key), mailBox.email.toLowerCase().contains("gmail") || mailBox.email.toLowerCase().contains("hotmail") || mailBox.email.toLowerCase().contains("outlook"), true, proxySet, proxyHost, proxyPort)
                    var message = getMyMessage(session, mail.emailSubject, mail.sender)
                    to(mail.receiver, message)
                    if (!mail.cc.isNullOrBlank()) {
                        cc(mail.cc!!, message)
                    }
                    var html = mail.emailContent
                    var attachments = ArrayList<MimeBodyPart>()
                    for (f in mail.attachments) {

                        val attachmentPart = MimeBodyPart()
                        var parpath = if (!uploadpath.endsWith(File.separator)) {
                            uploadpath + File.separator
                        } else {
                            uploadpath
                        }
                        val file = File(parpath + f.filePath)
                        val fds = FileDataSource(file)
                        try {
                            attachmentPart.dataHandler = DataHandler(fds )
                            attachmentPart.fileName = MimeUtility.encodeText(f.fileName)
                        } catch (e: Exception) {
                            throw SendMailException(e)
                        }
                        attachments.add(attachmentPart)

                    }
                    send(html, attachments, staticurl, message)
                    mail.sendTime = Date()
                    mail.mailStatus = 12
                    mailDetailService.updateById(mail)

                }

            } catch (e: Exception) {
                e.printStackTrace()
                log4jer.error("in MailOutUtils error :" + "id:" + mail.id + ",error:" + e.message)
                mail.mailStatus = 13
                mailDetailService.updateById(mail)
                throw e

            }
        }


    }

    private fun send(html1: String?, attachments: ArrayList<MimeBodyPart>, staticUrl: String, msg: MimeMessage) {

        if (html1 == null) {
            throw IllegalArgumentException("At least one context has to be provided:  Html")
        }
        var html = html1

        val cover: MimeMultipart
        var usingAlternative = false
        val hasAttachments = attachments.size > 0

        try {
            val staticMap = mutableMapOf<String, MimeBodyPart>()

            val key = "<img src=\"data:image/png;base64,"
            while (html!!.contains(key)) {
                var name = Random().nextInt().absoluteValue.toString()
                if (staticMap.containsKey(name)) {
                    name = Random().nextInt().absoluteValue.toString()
                }
                val start = html.indexOf(key)
                val end = html.indexOf("\">", start)

                val contnet = html.substring(start + key.length, end)
                generateImage(staticUrl, contnet, name)
                val part = MimeBodyPart()
                part.dataHandler = DataHandler(FileDataSource(staticUrl + name + ".jpg"))
                part.contentID = name
                staticMap[name] = part
                html = html.replace(key + contnet + "\">", "<img src='cid:" + name + "'/>")
            }

            */
/*    if (text != null && html == null) {
                    // TEXT ONLY
                    cover = MimeMultipart("mixed")
                    cover.addBodyPart(textPart())
                } else if (text == null && html != null) {*//*

            // HTML ONLY
            if (staticMap.isNotEmpty()) {
                val textImageBody = MimeBodyPart()

                val textHtml = MimeMultipart("related")
                textHtml.addBodyPart(htmlPart(html))
                for (v in staticMap.values) {
                    textHtml.addBodyPart(v)
                }
                textImageBody.setContent(textHtml)
                cover = MimeMultipart("mixed")
                cover.addBodyPart(textImageBody)

            } else {
                cover = MimeMultipart("mixed")
                cover.addBodyPart(htmlPart(html))
            }

            */
/*   } else {
                   // HTML + TEXT
                   cover = MimeMultipart("alternative")
                   cover.addBodyPart(textPart())
                   cover.addBodyPart(htmlPart())
                   usingAlternative = true
               }*//*



            var content = cover
            if (usingAlternative && hasAttachments) {
                content = MimeMultipart("mixed")
                content.addBodyPart(toBodyPart(cover))
            }

            for (attachment in attachments) {
                content.addBodyPart(attachment)
            }


            msg.setContent(content)
            msg.sentDate = Date()
            Transport.send(msg)
        } catch (e: Exception) {
            throw SendMailException(e)
        }


    }


    @Throws(MessagingException::class)
    private fun toBodyPart(cover: MimeMultipart): MimeBodyPart {
        val wrap = MimeBodyPart()
        wrap.setContent(cover)
        return wrap
    }

    @Throws(MessagingException::class)
    private fun htmlPart(html: String): MimeBodyPart {
        val bodyPart = MimeBodyPart()
        bodyPart.setContent(html, "text/html; charset=utf-8")
        return bodyPart
    }

    fun to(vararg to: String, msg: MimeMessage) {
        try {
            addRecipients(to, Message.RecipientType.TO, msg)
        } catch (e: MessagingException) {
            throw SendMailException(e)
        }

    }

    @Throws(SendMailException::class)
    fun to(to: String, msg: MimeMessage) {
        try {
            addRecipient(to, Message.RecipientType.TO, msg)
        } catch (e: MessagingException) {
            throw SendMailException(e)
        }
    }

    fun cc(vararg to: String, msg: MimeMessage) {
        try {
            addRecipients(to, Message.RecipientType.CC, msg)
        } catch (e: MessagingException) {
            throw SendMailException(e)
        }

    }

    @Throws(SendMailException::class)
    fun cc(to: String, msg: MimeMessage) {
        try {
            addRecipient(to, Message.RecipientType.CC, msg)
        } catch (e: MessagingException) {
            throw SendMailException(e)
        }

    }

    private fun getMyMessage(session: Session, subject: String, from: String): MimeMessage {
        var msg = MimeMessage(session)
        try {
            msg!!.setSubject(subject, "UTF-8")
        } catch (e: Exception) {
            throw SendMailException(e)
        }
        try {

            msg!!.setFrom(InternetAddress(from))
        } catch (e: Exception) {
            throw SendMailException(e)
        }

        return msg

    }

    @Throws(MessagingException::class)
    private fun addRecipients(recipients: Array<out String>, type: Message.RecipientType, msg: MimeMessage) {
        val result = Arrays.asList(*recipients).toString().replace("(^\\[|\\]$)", "").replace(", ", ",")
        msg!!.setRecipients(type, InternetAddress.parse(result))

    }

    @Throws(MessagingException::class)
    private fun addRecipient(recipient: String, type: Message.RecipientType, msg: MimeMessage) {
        msg!!.setRecipients(type, InternetAddress.parse(recipient.replace(";", ",")))

    }

    private fun getMySession(server: String, port: Int, email: String, password: String, type: Boolean, debug: Boolean, proxySet: String, proxyHost: String, proxyPort: String): Session {
        val props = Properties()
        props["mail.smtp.auth"] = "true"
        props["mail.transport.protocol"] = "smtp"
        props["mail.smtp.port"] = port
        if (type) {
            props["mail.smtp.starttls.enable"] = "true"
            props["mail.smtp.socketFactory.fallback"] = "true"

        } else {
            props["mail.smtp.ssl.enable"] = "true"

            var sslf = MailSSLSocketFactory()
            sslf.isTrustAllHosts = true
            props.put("mail.smtp.ssl.socketFactory", sslf)
        }
       // props["mail.debug"] = debug.toString()
        props["mail.smtp.timeout"] = "60000"
        props["mail.smtp.connectiontimeout"] = "5000"
        props["mail.smtp.host"] = server

        if ("true" == proxySet) {
            //  props.setProperty("proxySet", proxySet)
            //   props.setProperty("socksProxyHost",proxyHost)
            //    props.setProperty("socksProxyPort", proxyPort)
            props.setProperty("mail.smtp.socks.host", proxyHost)
            props.setProperty("mail.smtp.socks.port", proxyPort)
            */
/*       props.setProperty("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory")
                   props.setProperty("mail.smtp.socketFactory.fallback","false")
                   props.setProperty("mail.smtp.socketFactory.port","465")*//*


        }
        val session = Session.getInstance(props, object : Authenticator() {
            override fun getPasswordAuthentication(): PasswordAuthentication {
                return PasswordAuthentication(email, password)
            }
        })
        return session
    }

    private fun generateImage(staticUrl: String, imgStr: String, name: String = Random().nextInt().absoluteValue.toString()): Boolean {  //对字节数组字符串进行Base64解码并生成图片

        val decoder = Base64.getDecoder()
        try {
            //Base64解码
            val b = decoder.decode(imgStr)
            for (i in b.indices) {
                if (b[i] < 0) {//调整异常数据
                    b[i] = (b[i] + 256).toByte()
                }
            }
            val file = File(staticUrl)
            if (!file.exists()) {
                file.mkdirs()
            }
            //生成jpeg图片
            val imgFilePath = if (name.contains(".")) staticUrl + name else {
                staticUrl + name + ".jpg"
            }//新生成的图片

            */
/*  File file=new File(imgFilePath);
            if(!file.exists()){
                file.getParentFile().mkdirs();
                file.createNewFile();
            }*//*



            val out = FileOutputStream(imgFilePath)
            out.write(b)
            out.flush()
            out.close()
            return true
        } catch (e: Exception) {
            e.printStackTrace()
            return false
        }
    }


}*/
