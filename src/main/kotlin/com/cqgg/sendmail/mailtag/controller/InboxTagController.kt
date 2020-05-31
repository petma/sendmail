package cn.maxpeedinggrods.rms.mailServer.mailtag.controller

import cn.maxpeedinggrods.rms.mailServer.mailtag.service.IInboxTagService
import io.swagger.annotations.Api
import lombok.extern.slf4j.Slf4j

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * @Description: 邮件TAG关联关系
 * @Author: jeecg-boot
 * @Date:   2019-09-30
 * @Version: V1.0
 */
@Slf4j
@Api(tags = ["邮件TAG关联关系"])
@RestController
@RequestMapping("/mailtag/inboxTag")
class InboxTagController {
    @Autowired
    private val inboxTagService: IInboxTagService? = null

  /*  *//**
     * 分页列表查询
     * @param inboxTag
     * @param pageNo
     * @param pageSize
     * @param req
     * @return
     *//*
    @AutoLog(value = "邮件TAG关联关系-分页列表查询")
    @ApiOperation(value = "邮件TAG关联关系-分页列表查询", notes = "邮件TAG关联关系-分页列表查询")
    @GetMapping(value = "/list")
    fun queryPageList(inboxTag: InboxTag,
                      @RequestParam(name = "pageNo", defaultValue = "1") pageNo: Int?,
                      @RequestParam(name = "pageSize", defaultValue = "10") pageSize: Int?,
                      req: HttpServletRequest): Result<IPage<InboxTag>> {
        val result = Result<IPage<InboxTag>>()
        val queryWrapper = QueryGenerator.initQueryWrapper(inboxTag, req.parameterMap)
        val page = Page<InboxTag>(pageNo!!.toLong(), pageSize!!.toLong())
        val pageList = inboxTagService!!.page(page, queryWrapper)
        result.setSuccess(true)
        result.setResult(pageList)
        return result
    }

    *//**
     * 添加
     * @param inboxTag
     * @return
     *//*
    @AutoLog(value = "邮件TAG关联关系-添加")
    @ApiOperation(value = "邮件TAG关联关系-添加", notes = "邮件TAG关联关系-添加")
    @PostMapping(value = "/add")
    fun add(@RequestBody inboxTag: InboxTag): Result<InboxTag> {
        val result = Result<InboxTag>()
        try {
            inboxTagService!!.save(inboxTag)
            result.success("添加成功！")
        } catch (e: Exception) {
            log.error(e.message, e)
            result.error500("操作失败")
        }

        return result
    }

    *//**
     * 编辑
     * @param inboxTag
     * @return
     *//*
    @AutoLog(value = "邮件TAG关联关系-编辑")
    @ApiOperation(value = "邮件TAG关联关系-编辑", notes = "邮件TAG关联关系-编辑")
    @PutMapping(value = "/edit")
    fun edit(@RequestBody inboxTag: InboxTag): Result<InboxTag> {
        val result = Result<InboxTag>()
        val inboxTagEntity = inboxTagService!!.getById(inboxTag.id)
        if (inboxTagEntity == null) {
            result.error500("未找到对应实体")
        } else {
            val ok = inboxTagService.updateById(inboxTag)
            //TODO 返回false说明什么？
            if (ok) {
                result.success("修改成功!")
            }
        }

        return result
    }

    *//**
     * 通过id删除
     * @param id
     * @return
     *//*
    @AutoLog(value = "邮件TAG关联关系-通过id删除")
    @ApiOperation(value = "邮件TAG关联关系-通过id删除", notes = "邮件TAG关联关系-通过id删除")
    @DeleteMapping(value = "/delete")
    fun delete(@RequestParam(name = "id", required = true) id: String): Result<*> {
        try {
            inboxTagService!!.removeById(id)
        } catch (e: Exception) {
            log.error("删除失败", e.message)
            return Result.error("删除失败!")
        }

        return Result.ok("删除成功!")
    }

    *//**
     * 批量删除
     * @param ids
     * @return
     *//*
    @AutoLog(value = "邮件TAG关联关系-批量删除")
    @ApiOperation(value = "邮件TAG关联关系-批量删除", notes = "邮件TAG关联关系-批量删除")
    @DeleteMapping(value = "/deleteBatch")
    fun deleteBatch(@RequestParam(name = "ids", required = true) ids: String?): Result<InboxTag> {
        val result = Result<InboxTag>()
        if (ids == null || "" == ids.trim { it <= ' ' }) {
            result.error500("参数不识别！")
        } else {
            this.inboxTagService!!.removeByIds(Arrays.asList(*ids.split(",".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()))
            result.success("删除成功!")
        }
        return result
    }

    *//**
     * 通过id查询
     * @param id
     * @return
     *//*
    @AutoLog(value = "邮件TAG关联关系-通过id查询")
    @ApiOperation(value = "邮件TAG关联关系-通过id查询", notes = "邮件TAG关联关系-通过id查询")
    @GetMapping(value = "/queryById")
    fun queryById(@RequestParam(name = "id", required = true) id: String): Result<InboxTag> {
        val result = Result<InboxTag>()
        val inboxTag = inboxTagService!!.getById(id)
        if (inboxTag == null) {
            result.error500("未找到对应实体")
        } else {
            result.setResult(inboxTag)
            result.setSuccess(true)
        }
        return result
    }

    *//**
     * 导出excel
     *
     * @param request
     * @param response
     *//*
    @RequestMapping(value = "/exportXls")
    fun exportXls(request: HttpServletRequest, response: HttpServletResponse): ModelAndView {
        // Step.1 组装查询条件
        var queryWrapper: QueryWrapper<InboxTag>? = null
        try {
            val paramsStr = request.getParameter("paramsStr")
            if (oConvertUtils.isNotEmpty(paramsStr)) {
                val deString = URLDecoder.decode(paramsStr, "UTF-8")
                val inboxTag = JSON.parseObject(deString, InboxTag::class.java)
                queryWrapper = QueryGenerator.initQueryWrapper(inboxTag, request.parameterMap)
            }
        } catch (e: UnsupportedEncodingException) {
            e.printStackTrace()
        }

        //Step.2 AutoPoi 导出Excel
        val mv = ModelAndView(JeecgEntityExcelView())
        val pageList = inboxTagService!!.list(queryWrapper)
        //导出文件名称
        mv.addObject(NormalExcelConstants.FILE_NAME, "邮件TAG关联关系列表")
        mv.addObject(NormalExcelConstants.CLASS, InboxTag::class.java)
        mv.addObject(NormalExcelConstants.PARAMS, ExportParams("邮件TAG关联关系列表数据", "导出人:Jeecg", "导出信息"))
        mv.addObject(NormalExcelConstants.DATA_LIST, pageList)
        return mv
    }

    *//**
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
                val listInboxTags = ExcelImportUtil.importExcel<InboxTag>(file.inputStream, InboxTag::class.java, params)
                inboxTagService!!.saveBatch(listInboxTags)
                return Result.ok("文件导入成功！数据行数:" + listInboxTags.size)
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
