package top.yuyg.blog.modules.sys.controller;

import com.alibaba.fastjson.JSON;
import top.yuyg.blog.common.utils.PageUtils;
import top.yuyg.blog.common.utils.Query;
import top.yuyg.blog.common.utils.R;
import top.yuyg.blog.modules.sys.service.SysGeneratorService;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/sys/generator")
public class SysGeneratorController extends AbstractController {

	@Autowired
	private SysGeneratorService sysGeneratorService;

	@ResponseBody
	@RequestMapping("/list")
	public R list(@RequestParam Map<String, Object> params) {
		Query query = new Query(params);
		List<Map<String, Object>> list = sysGeneratorService.queryList(query);
		int total = sysGeneratorService.queryTotal(query);
		PageUtils pageUtil = new PageUtils(list, total, query.getLimit(), query.getPage());
		logger.info(list.toString());
		return R.ok().put("page", pageUtil);
	}

	@RequestMapping("/code")
	public void code(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String[] tableNames = new String[] {};
		String tables = request.getParameter("tables");
		tableNames = JSON.parseArray(tables).toArray(tableNames);
		byte[] data = sysGeneratorService.generatorCode(tableNames);
		response.reset();
		response.setHeader("Content-Disposition", "attachment; filename=\"代码生成.zip\"");
		response.addHeader("Content-Length", "" + data.length);
		response.setContentType("application/octet-stream; charset=UTF-8");
		IOUtils.write(data, response.getOutputStream());
	}
}
