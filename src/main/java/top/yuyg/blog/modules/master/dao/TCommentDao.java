package top.yuyg.blog.modules.master.dao;

import org.apache.ibatis.annotations.Param;
import top.yuyg.blog.modules.master.entity.TCommentEntity;
import top.yuyg.blog.modules.sys.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author yuyugang
 * @webSite ${webSite}
 * @date 2018-05-13 00:22:07
 */
@Mapper
public interface TCommentDao extends BaseDao<TCommentEntity> {

    TCommentEntity queryObject(Integer id);

    List<TCommentEntity> queryList(Map<String, Object> map);

    int queryTotal(Map<String, Object> map);

    void save(TCommentEntity tComment);

    int update(TCommentEntity tComment);

    void delete(Integer id);

    void deleteBatch(Integer[] ids);

    void verify(@Param("id") Integer id,@Param("state") Integer state);

    void verifyPassBatch(Integer[] ids);

    void verifyDenyBatch(Integer[] ids);
}
