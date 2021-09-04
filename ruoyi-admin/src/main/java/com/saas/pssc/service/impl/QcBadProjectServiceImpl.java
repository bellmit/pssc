package com.saas.pssc.service.impl;

import java.util.List;

import com.saas.common.annotation.DataScope;
import com.saas.common.core.text.Convert;
import com.saas.common.utils.DateUtils;
import com.saas.common.utils.uuid.IdUtils;
import com.saas.pssc.domain.QcBadProject;
import com.saas.pssc.mapper.QcBadProjectMapper;
import com.saas.pssc.service.IQcBadProjectService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 不良项目汇总Service业务层处理
 * 
 * @author admin
 * @date 2021-09-04
 */
@Service
public class QcBadProjectServiceImpl implements IQcBadProjectService 
{
    @Autowired
    private QcBadProjectMapper qcBadProjectMapper;

    /**
     * 查询不良项目汇总
     * 
     * @param id 不良项目汇总ID
     * @return 不良项目汇总
     */
    @Override
    public QcBadProject selectQcBadProjectById(String id)
    {
        return qcBadProjectMapper.selectQcBadProjectById(id);
    }

    /**
     * 查询不良项目汇总列表
     * 
     * @param qcBadProject 不良项目汇总
     * @return 不良项目汇总
     */
    @Override
    @DataScope(userAlias = "su")
    public List<QcBadProject> selectQcBadProjectList(QcBadProject qcBadProject)
    {
        return qcBadProjectMapper.selectQcBadProjectList(qcBadProject);
    }

    /**
     * 新增不良项目汇总
     * 
     * @param qcBadProject 不良项目汇总
     * @return 结果
     */
    @Override
    public int insertQcBadProject(QcBadProject qcBadProject)
    {
        qcBadProject.setId(IdUtils.fastUUID());
        qcBadProject.setCreateTime(DateUtils.getNowDate());
        return qcBadProjectMapper.insertQcBadProject(qcBadProject);
    }

    /**
     * 修改不良项目汇总
     * 
     * @param qcBadProject 不良项目汇总
     * @return 结果
     */
    @Override
    public int updateQcBadProject(QcBadProject qcBadProject)
    {
        qcBadProject.setUpdateTime(DateUtils.getNowDate());
        return qcBadProjectMapper.updateQcBadProject(qcBadProject);
    }

    /**
     * 删除不良项目汇总对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteQcBadProjectByIds(String ids)
    {
        return qcBadProjectMapper.updateQcBadProjectByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除不良项目汇总信息
     * 
     * @param id 不良项目汇总ID
     * @return 结果
     */
    @Override
    public int deleteQcBadProjectById(String id)
    {
        return qcBadProjectMapper.updateQcBadProjectById(id);
    }
}
