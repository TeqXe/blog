package top.yuyg.blog.modules.sys.service.impl;

import top.yuyg.blog.common.utils.Constant;
import top.yuyg.blog.modules.sys.dao.SysMenuDao;
import top.yuyg.blog.modules.sys.dao.SysUserDao;
import top.yuyg.blog.modules.sys.dao.SysUserTokenDao;
import top.yuyg.blog.modules.sys.entity.SysMenuEntity;
import top.yuyg.blog.modules.sys.entity.SysUserEntity;
import top.yuyg.blog.modules.sys.entity.SysUserTokenEntity;
import top.yuyg.blog.modules.sys.service.ShiroService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ShiroServiceImpl implements ShiroService {

	@Autowired
	private SysMenuDao sysMenuDao;

	@Autowired
	private SysUserDao sysUserDao;

	@Autowired
	private SysUserTokenDao sysUserTokenDao;

	@Override
	public SysUserTokenEntity queryByToken(String token) {
		return sysUserTokenDao.queryByToken(token);
	}

	@Override
	public SysUserEntity queryUser(Long userId) {
		return sysUserDao.queryObject(userId);
	}
}
