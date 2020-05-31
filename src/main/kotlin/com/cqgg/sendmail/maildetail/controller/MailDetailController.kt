package cn.maxpeedinggrods.rms.mailServer.maildetail.controller

import cn.maxpeedinggrods.rms.mailServer.attachment.entity.Attachment
import cn.maxpeedinggrods.rms.mailServer.attachment.service.IAttachmentService
import cn.maxpeedinggrods.rms.mailServer.config.Const.MAIL_OUT_TYPE
import cn.maxpeedinggrods.rms.mailServer.maildetail.entity.MailDetail
import cn.maxpeedinggrods.rms.mailServer.maildetail.service.IMailDetailService
import io.swagger.annotations.Api
import lombok.extern.slf4j.Slf4j
import org.apache.logging.log4j.LogManager
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


/**
 * @Description: 邮件详情
 * @Author: jeecg-boot
 * @Date:   2019-09-23
 * @Version: V1.0
 */
@Slf4j
@Api(tags = ["邮件详情"])
@RestController
@RequestMapping("/maildetail")
class MailDetailController {
    @Autowired
    lateinit var mailDetailService: IMailDetailService

    @Value(value = "\${mail.passkey}")
    lateinit var key: String

    @Autowired
    lateinit var attachmentService: IAttachmentService
    private val logger = LogManager.getLogger("MailDetailController.class")

 /*   //缓存发送邮件的队列
    var queue: BlockingQueue<MailDetail> = ArrayBlockingQueue(2000)

    //发送邮件线程状态
    private var isRunning = false
    //超时时间间隔
     val TIMEOUT_INTERVAL = (3 * 60 * 1000).toLong()*/


    /**
     * 通过邮件ID，发送这封邮件
     */
    @Deprecated("by scheduled send")
    @GetMapping(value = ["/send"])
    fun sendEmail(@RequestParam(name = "ids",required = true) ids: String): Boolean {
        try {
            mailDetailService.getAllInfos(ids.split(",").map {
                it.toLong()
            }).forEach {
                if (it.boxType == MAIL_OUT_TYPE && (it.mailStatus == 11 || it.mailStatus==13)) {

                    if (it.attachmentCount > 0) {
                        it.attachments = attachmentService.getAttachmentByMailId(it.id) as MutableList<Attachment>
                    }
                    sendEmail(it)
                }
            }

        } catch (e: Exception) {
            e.printStackTrace()
            return false
        }
        return true
    }

/*
    fun sendMail1(mail: MailDetail): Boolean {
        var rsp = false
        try {
            //阻塞3秒
            rsp = queue.offer(mail, 3, TimeUnit.SECONDS)

            if (!rsp) {
                throw Exception("服务器发送邮件繁忙，请稍后再发")
            }


            if (!isRunning) {
                startup()
                isRunning = true
            }

        } catch (e: Exception) {
            logger.error("添加发送邮件队列出错", e)
        }

        return rsp
    }*/
    /*fun startup() {
        if (isRunning) {
            return
        }

        val th = object : Thread() {

            override fun run() {
                logger.debug("邮件发送消息线程启动")

                var timestamp = System.currentTimeMillis()
                while (isRunning) {
                    val timeout = timestamp + TIMEOUT_INTERVAL
                    if (System.currentTimeMillis() > timeout) {
                        //空跑一段时间(3分钟)后线程退出
                        break
                    }

                    try {
                        if (queue.size == 0) {
                            sleep(1000)
                            continue
                        }
                        timestamp = System.currentTimeMillis()
                        val mail = queue.poll()
                        sendMail1(mail)
                        OhMyEmail.config(OhMyEmail.SMTPHost(server.smtpServer, true), it.email, it.pass)
                        //发送一个邮件休息2秒，防止发送过快，导致主油箱被锁定
                        sleep(2000)

                    } catch (e: Exception) {
                        logger.error("邮件推送线程出错", e)
                    }

                }
                isRunning = false
                logger.debug("邮件发送线程停止。")
            }
        }

        th.start()
    }*/

    fun sendEmail(mail: MailDetail) {
      /*  MailServerApplication.data.filter {
            it.deletedAt == null && mail.sender.endsWith(it.suffix)
        }.forEach({ server ->
            server.mailShopList.filter {
                it.id == mail.mailAccountId
            }.forEach({
                OhMyEmail.config(OhMyEmail.SMTPHost(server.smtpServer, true), it.email, decryptAES(it.pass, key))
            })

        })

        try {
            OhMyEmail.subject(mail.emailSubject)
                    .from(mail.sender)
                    .to(mail.receiver)
                    .cc(mail.cc)
                    .html(mail.emailContent)
                    .attach(mail.attachments)
                    .send()
            mail.sendTime = Date()
            mail.mailStatus = 12
            mailDetailService.updateById(mail)
        } catch (e: Exception) {
            e.printStackTrace()
            mail.mailStatus = 13
            mailDetailService.updateById(mail)
            throw e

        }*/


    }

/*

    */
    /**
     * 分页列表查询
     * @param mailDetail
     * @param pageNo
     * @param pageSize
     * @param req
     * @return
     *//*

    @AutoLog(value = "邮件详情-分页列表查询")
    @ApiOperation(value = "邮件详情-分页列表查询", notes = "邮件详情-分页列表查询")
    @GetMapping(value = "/list")
    fun queryPageList(mailDetail: MailDetail,
                      @RequestParam(name = "pageNo", defaultValue = "1") pageNo: Int?,
                      @RequestParam(name = "pageSize", defaultValue = "10") pageSize: Int?,
                      req: HttpServletRequest): Result<IPage<MailDetail>> {
        val result = Result<IPage<MailDetail>>()
        val queryWrapper = QueryGenerator.initQueryWrapper(mailDetail, req.parameterMap)
        val page = Page<MailDetail>(pageNo!!.toLong(), pageSize!!.toLong())
        val pageList = mailDetailService!!.page(page, queryWrapper)
        result.setSuccess(true)
        result.setResult(pageList)
        return result
    }

    */
    /**
     * 添加
     * @param mailDetail
     * @return
     *//*

    @AutoLog(value = "邮件详情-添加")
    @ApiOperation(value = "邮件详情-添加", notes = "邮件详情-添加")
    @PostMapping(value = "/add")
    fun add(@RequestBody mailDetail: MailDetail): Result<MailDetail> {
        val result = Result<MailDetail>()
        try {
            mailDetailService!!.save(mailDetail)
            result.success("添加成功！")
        } catch (e: Exception) {
            log.error(e.message, e)
            result.error500("操作失败")
        }

        return result
    }

    */
    /**
     * 编辑
     * @param mailDetail
     * @return
     *//*

    @AutoLog(value = "邮件详情-编辑")
    @ApiOperation(value = "邮件详情-编辑", notes = "邮件详情-编辑")
    @PutMapping(value = "/edit")
    fun edit(@RequestBody mailDetail: MailDetail): Result<MailDetail> {
        val result = Result<MailDetail>()
        val mailDetailEntity = mailDetailService!!.getById(mailDetail.id)
        if (mailDetailEntity == null) {
            result.error500("未找到对应实体")
        } else {
            val ok = mailDetailService.updateById(mailDetail)
            //TODO 返回false说明什么？
            if (ok) {
                result.success("修改成功!")
            }
        }

        return result
    }

    */
    /**
     * 通过id删除
     * @param id
     * @return
     *//*

    @AutoLog(value = "邮件详情-通过id删除")
    @ApiOperation(value = "邮件详情-通过id删除", notes = "邮件详情-通过id删除")
    @DeleteMapping(value = "/delete")
    fun delete(@RequestParam(name = "id", required = true) id: String): Result<*> {
        try {
            mailDetailService!!.removeById(id)
        } catch (e: Exception) {
            log.error("删除失败", e.message)
            return Result.error("删除失败!")
        }

        return Result.ok("删除成功!")
    }

    */
    /**
     * 批量删除
     * @param ids
     * @return
     *//*

    @AutoLog(value = "邮件详情-批量删除")
    @ApiOperation(value = "邮件详情-批量删除", notes = "邮件详情-批量删除")
    @DeleteMapping(value = "/deleteBatch")
    fun deleteBatch(@RequestParam(name = "ids", required = true) ids: String?): Result<MailDetail> {
        val result = Result<MailDetail>()
        if (ids == null || "" == ids.trim { it <= ' ' }) {
            result.error500("参数不识别！")
        } else {
            this.mailDetailService!!.removeByIds(Arrays.asList(*ids.split(",".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()))
            result.success("删除成功!")
        }
        return result
    }

    */
    /**
     * 通过id查询
     * @param id
     * @return
     *//*

    @AutoLog(value = "邮件详情-通过id查询")
    @ApiOperation(value = "邮件详情-通过id查询", notes = "邮件详情-通过id查询")
    @GetMapping(value = "/queryById")
    fun queryById(@RequestParam(name = "id", required = true) id: String): Result<MailDetail> {
        val result = Result<MailDetail>()
        val mailDetail = mailDetailService!!.getById(id)
        if (mailDetail == null) {
            result.error500("未找到对应实体")
        } else {
            result.setResult(mailDetail)
            result.setSuccess(true)
        }
        return result
    }

    */
    /**
     * 导出excel
     *
     * @param request
     * @param response
     *//*

    @RequestMapping(value = "/exportXls")
    fun exportXls(request: HttpServletRequest, response: HttpServletResponse): ModelAndView {
        // Step.1 组装查询条件
        var queryWrapper: QueryWrapper<MailDetail>? = null
        try {
            val paramsStr = request.getParameter("paramsStr")
            if (oConvertUtils.isNotEmpty(paramsStr)) {
                val deString = URLDecoder.decode(paramsStr, "UTF-8")
                val mailDetail = JSON.parseObject(deString, MailDetail::class.java)
                queryWrapper = QueryGenerator.initQueryWrapper(mailDetail, request.parameterMap)
            }
        } catch (e: UnsupportedEncodingException) {
            e.printStackTrace()
        }

        //Step.2 AutoPoi 导出Excel
        val mv = ModelAndView(JeecgEntityExcelView())
        val pageList = mailDetailService!!.list(queryWrapper)
        //导出文件名称
        mv.addObject(NormalExcelConstants.FILE_NAME, "邮件详情列表")
        mv.addObject(NormalExcelConstants.CLASS, MailDetail::class.java)
        mv.addObject(NormalExcelConstants.PARAMS, ExportParams("邮件详情列表数据", "导出人:Jeecg", "导出信息"))
        mv.addObject(NormalExcelConstants.DATA_LIST, pageList)
        return mv
    }

    */
    /**
     * 通过excel导入数据
     *
     * @param request
     * @param response
     * @return
     *//*

    @RequestMapping(value = "/importExcel", method = [RequestMethod.POST])
    fun importExcel(request: HttpServletRequest, response: HttpServletResponse): Result<*> {
        val multipartRequest = request as MultipartHttpServletRequest
        val fileMap = multipartRequest.fileMap
        for ((_, file) in fileMap) {
            val params = ImportParams()
            params.titleRows = 2
            params.headRows = 1
            params.isNeedSave = true
            try {
                val listMailDetails = ExcelImportUtil.importExcel<MailDetail>(file.inputStream, MailDetail::class.java, params)
                mailDetailService!!.saveBatch(listMailDetails)
                return Result.ok("文件导入成功！数据行数:" + listMailDetails.size)
            } catch (e: Exception) {
                log.error(e.message, e)
                return Result.error("文件导入失败:" + e.message)
            } finally {
                try {
                    file.inputStream.close()
                } catch (e: IOException) {
                    e.printStackTrace()
                }

            }
        }
        return Result.ok("文件导入失败！")
    }
*/

}
