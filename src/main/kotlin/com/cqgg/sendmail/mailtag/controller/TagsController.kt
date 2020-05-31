package cn.maxpeedinggrods.rms.mailServer.mailtag.controller

import cn.maxpeedinggrods.rms.mailServer.mailtag.service.ITagsService
import io.swagger.annotations.Api
import lombok.extern.slf4j.Slf4j

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * @Description: 邮件TAG
 * @Author: jeecg-boot
 * @Date:   2019-09-30
 * @Version: V1.0
 */
@Slf4j
@Api(tags = ["邮件TAG "])
@RestController
@RequestMapping("/mailtag/tags")
class TagsController {
    @Autowired
    private val tagsService: ITagsService? = null

   /* *//**
     * 分页列表查询
     * @param tags
     * @param pageNo
     * @param pageSize
     * @param req
     * @return
     *//*
    @AutoLog(value = "邮件TAG -分页列表查询")
    @ApiOperation(value = "邮件TAG -分页列表查询", notes = "邮件TAG -分页列表查询")
    @GetMapping(value = "/list")
    fun queryPageList(tags: Tags,
                      @RequestParam(name = "pageNo", defaultValue = "1") pageNo: Int?,
                      @RequestParam(name = "pageSize", defaultValue = "10") pageSize: Int?,
                      req: HttpServletRequest): Result<IPage<Tags>> {
        val result = Result<IPage<Tags>>()
        val queryWrapper = QueryGenerator.initQueryWrapper(tags, req.parameterMap)
        val page = Page<Tags>(pageNo!!.toLong(), pageSize!!.toLong())
        val pageList = tagsService!!.page(page, queryWrapper)
        result.setSuccess(true)
        result.setResult(pageList)
        return result
    }

    *//**
     * 添加
     * @param tags
     * @return
     *//*
    @AutoLog(value = "邮件TAG -添加")
    @ApiOperation(value = "邮件TAG -添加", notes = "邮件TAG -添加")
    @PostMapping(value = "/add")
    fun add(@RequestBody tags: Tags): Result<Tags> {
        val result = Result<Tags>()
        try {
            tagsService!!.save(tags)
            result.success("添加成功！")
        } catch (e: Exception) {
            log.error(e.message, e)
            result.error500("操作失败")
        }

        return result
    }

    *//**
     * 编辑
     * @param tags
     * @return
     *//*
    @AutoLog(value = "邮件TAG -编辑")
    @ApiOperation(value = "邮件TAG -编辑", notes = "邮件TAG -编辑")
    @PutMapping(value = "/edit")
    fun edit(@RequestBody tags: Tags): Result<Tags> {
        val result = Result<Tags>()
        val tagsEntity = tagsService!!.getById(tags.id)
        if (tagsEntity == null) {
            result.error500("未找到对应实体")
        } else {
            val ok = tagsService.updateById(tags)
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
    @AutoLog(value = "邮件TAG -通过id删除")
    @ApiOperation(value = "邮件TAG -通过id删除", notes = "邮件TAG -通过id删除")
    @DeleteMapping(value = "/delete")
    fun delete(@RequestParam(name = "id", required = true) id: String): Result<*> {
        try {
            tagsService!!.removeById(id)
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
    @AutoLog(value = "邮件TAG -批量删除")
    @ApiOperation(value = "邮件TAG -批量删除", notes = "邮件TAG -批量删除")
    @DeleteMapping(value = "/deleteBatch")
    fun deleteBatch(@RequestParam(name = "ids", required = true) ids: String?): Result<Tags> {
        val result = Result<Tags>()
        if (ids == null || "" == ids.trim { it <= ' ' }) {
            result.error500("参数不识别！")
        } else {
            this.tagsService!!.removeByIds(Arrays.asList(*ids.split(",".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()))
            result.success("删除成功!")
        }
        return result
    }

    *//**
     * 通过id查询
     * @param id
     * @return
     *//*
    @AutoLog(value = "邮件TAG -通过id查询")
    @ApiOperation(value = "邮件TAG -通过id查询", notes = "邮件TAG -通过id查询")
    @GetMapping(value = "/queryById")
    fun queryById(@RequestParam(name = "id", required = true) id: String): Result<Tags> {
        val result = Result<Tags>()
        val tags = tagsService!!.getById(id)
        if (tags == null) {
            result.error500("未找到对应实体")
        } else {
            result.setResult(tags)
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
        var queryWrapper: QueryWrapper<Tags>? = null
        try {
            val paramsStr = request.getParameter("paramsStr")
            if (oConvertUtils.isNotEmpty(paramsStr)) {
                val deString = URLDecoder.decode(paramsStr, "UTF-8")
                val tags = JSON.parseObject(deString, Tags::class.java)
                queryWrapper = QueryGenerator.initQueryWrapper(tags, request.parameterMap)
            }
        } catch (e: UnsupportedEncodingException) {
            e.printStackTrace()
        }

        //Step.2 AutoPoi 导出Excel
        val mv = ModelAndView(JeecgEntityExcelView())
        val pageList = tagsService!!.list(queryWrapper)
        //导出文件名称
        mv.addObject(NormalExcelConstants.FILE_NAME, "邮件TAG 列表")
        mv.addObject(NormalExcelConstants.CLASS, Tags::class.java)
        mv.addObject(NormalExcelConstants.PARAMS, ExportParams("邮件TAG 列表数据", "导出人:Jeecg", "导出信息"))
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
                val listTagss = ExcelImportUtil.importExcel<Tags>(file.inputStream, Tags::class.java, params)
                tagsService!!.saveBatch(listTagss)
                return Result.ok("文件导入成功！数据行数:" + listTagss.size)
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
