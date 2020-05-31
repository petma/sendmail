package cn.maxpeedinggrods.rms.mailServer.mailbox.controller


import cn.maxpeedinggrods.rms.mailServer.MailServerApplication
import cn.maxpeedinggrods.rms.mailServer.mailbox.MailOutUtils
import cn.maxpeedinggrods.rms.mailServer.mailbox.MailReceiveUtils
import cn.maxpeedinggrods.rms.mailServer.mailbox.entity.MailServer
import cn.maxpeedinggrods.rms.mailServer.mailbox.service.IMailServerService
import cn.maxpeedinggrods.rms.mailServer.mailbox.service.IMailShopService
import io.swagger.annotations.Api
import lombok.extern.slf4j.Slf4j
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

/**
 * @Description: 收件箱
 * @Author: jeecg-boot
 * @Date:   2019-09-17
 * @Version: V1.0
 */
@Slf4j
@Api(tags = ["邮箱"])
@RestController
@RequestMapping("/mailbox")
class MailboxController {

    @Autowired
    lateinit var mailServerService: IMailServerService
    @Autowired
    lateinit var mailShopService: IMailShopService
    @Autowired
    lateinit var mailInboxService: MailReceiveUtils
    var log4jer = LoggerFactory.getLogger(MailboxController::class.java)
   @GetMapping(value = ["/changed"])
    fun refresh(): Boolean {
       log4jer.error("哎呀")
        return true
    }

    /* @GetMapping(value = ["/check"])
    fun check(@RequestParam(name = "mail",required = true ) mail: String, @RequestParam(name = "pass",required = true) pass: String): Int {
        if(mail.contains("@")){
            var mailServer: List<MailServer>? = mailServerService.search(mail.substring(mail.indexOf("@"))) ?: return 422
            return mailInboxService.check(mail,pass,mailServer!!.get(0))
        }
        return -1

    }*/

    /* @Autowired
     private val mailInboxService: IMailInboxService? = null

     */
    /**
     * 分页列表查询
     * @param mailInbox
     * @param pageNo
     * @param pageSize
     * @param req
     * @return
     *//*
    @AutoLog(value = "收件箱-分页列表查询")
    @ApiOperation(value = "收件箱-分页列表查询", notes = "收件箱-分页列表查询")
    @GetMapping(value = "/list")
    fun queryPageList(mailInbox: MailInbox,
                      @RequestParam(name = "pageNo", defaultValue = "1") pageNo: Int?,
                      @RequestParam(name = "pageSize", defaultValue = "10") pageSize: Int?,
                      req: HttpServletRequest): Result<IPage<MailInbox>> {
        val result = Result<IPage<MailInbox>>()
        val queryWrapper = QueryGenerator.initQueryWrapper(mailInbox, req.parameterMap)
        val page = Page<MailInbox>(pageNo!!.toLong(), pageSize!!.toLong())
        val pageList = mailInboxService!!.page(page, queryWrapper)
        result.setSuccess(true)
        result.setResult(pageList)
        return result
    }

    */
    /**
     * 添加
     * @param mailInbox
     * @return
     *//*
    @AutoLog(value = "收件箱-添加")
    @ApiOperation(value = "收件箱-添加", notes = "收件箱-添加")
    @PostMapping(value = "/add")
    fun add(@RequestBody mailInbox: MailInbox): Result<MailInbox> {
        val result = Result<MailInbox>()
        try {
            mailInboxService!!.save(mailInbox)
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
     * @param mailInbox
     * @return
     *//*
    @AutoLog(value = "收件箱-编辑")
    @ApiOperation(value = "收件箱-编辑", notes = "收件箱-编辑")
    @PutMapping(value = "/edit")
    fun edit(@RequestBody mailInbox: MailInbox): Result<MailInbox> {
        val result = Result<MailInbox>()
        val mailInboxEntity = mailInboxService!!.getById(mailInbox.getId())
        if (mailInboxEntity == null) {
            result.error500("未找到对应实体")
        } else {
            val ok = mailInboxService!!.updateById(mailInbox)
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
    @AutoLog(value = "收件箱-通过id删除")
    @ApiOperation(value = "收件箱-通过id删除", notes = "收件箱-通过id删除")
    @DeleteMapping(value = "/delete")
    fun delete(@RequestParam(name = "id", required = true) id: String): Result<*> {
        try {
            mailInboxService!!.removeById(id)
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
    @AutoLog(value = "收件箱-批量删除")
    @ApiOperation(value = "收件箱-批量删除", notes = "收件箱-批量删除")
    @DeleteMapping(value = "/deleteBatch")
    fun deleteBatch(@RequestParam(name = "ids", required = true) ids: String?): Result<MailInbox> {
        val result = Result<MailInbox>()
        if (ids == null || "" == ids.trim { it <= ' ' }) {
            result.error500("参数不识别！")
        } else {
            this.mailInboxService!!.removeByIds(Arrays.asList<T>(*ids.split(",".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()))
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
    @AutoLog(value = "收件箱-通过id查询")
    @ApiOperation(value = "收件箱-通过id查询", notes = "收件箱-通过id查询")
    @GetMapping(value = "/queryById")
    fun queryById(@RequestParam(name = "id", required = true) id: String): Result<MailInbox> {
        val result = Result<MailInbox>()
        val mailInbox = mailInboxService!!.getById(id)
        if (mailInbox == null) {
            result.error500("未找到对应实体")
        } else {
            result.setResult(mailInbox)
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
        var queryWrapper: QueryWrapper<MailInbox>? = null
        try {
            val paramsStr = request.getParameter("paramsStr")
            if (oConvertUtils.isNotEmpty(paramsStr)) {
                val deString = URLDecoder.decode(paramsStr, "UTF-8")
                val mailInbox = JSON.parseObject<Any>(deString, MailInbox::class.java)
                queryWrapper = QueryGenerator.initQueryWrapper(mailInbox, request.parameterMap)
            }
        } catch (e: UnsupportedEncodingException) {
            e.printStackTrace()
        }

        //Step.2 AutoPoi 导出Excel
        val mv = ModelAndView(JeecgEntityExcelView())
        val pageList = mailInboxService!!.list(queryWrapper)
        //导出文件名称
        mv.addObject(NormalExcelConstants.FILE_NAME, "收件箱列表")
        mv.addObject(NormalExcelConstants.CLASS, MailInbox::class.java)
        mv.addObject(NormalExcelConstants.PARAMS, ExportParams("收件箱列表数据", "导出人:Jeecg", "导出信息"))
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
                val listMailInboxs = ExcelImportUtil.importExcel<MailInbox>(file.inputStream, MailInbox::class.java, params)
                mailInboxService!!.saveBatch(listMailInboxs)
                return Result.ok("文件导入成功！数据行数:" + listMailInboxs.size)
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
