package xyz.superinterface.daoshicha.common.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import xyz.superinterface.daoshicha.common.bean.BsContextData;
import xyz.superinterface.daoshicha.common.bean.BsContextNum;
import xyz.superinterface.daoshicha.common.bean.BsHtmlParam;

import java.util.List;

@Mapper
public interface BaseMapper {

    /**
     * 根据名称查询导师基本信息
     * @param param
     * @return
     */
    public BsHtmlParam findBsHtmlParamByName(@Param(value = "p") BsHtmlParam param);

    /**
     * 根据导师code查询 p2 data
     * @param code
     * @return
     */
    public List<BsContextNum> findBsContextNumListByCdeo(@Param(value = "code") String code);

    /**
     * 根据导师code查询 xx-xx年第一作者文章数据 ppt 6
     * @param code
     * @return
     */
    public List<BsContextData> findBsContextDataListByCode(@Param(value = "code") String code);

}
