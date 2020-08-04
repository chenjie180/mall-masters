package cn.com.sparknet.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageHelper;

import cn.com.sparknet.dto.UmsMenuNode;
import cn.com.sparknet.mapper.UmsMenuMapper;
import cn.com.sparknet.model.UmsAdmin;
import cn.com.sparknet.model.UmsAdminExample;
import cn.com.sparknet.model.UmsMenu;
import cn.com.sparknet.model.UmsMenuExample;
import cn.com.sparknet.service.UmsMenuService;
@Service
public class UmsMenuServiceImpl implements UmsMenuService {
    @Autowired
    private UmsMenuMapper umsMenuMapper;
	@Override
	public int insertUmsMenuInfo(UmsMenu umsMenu) {
		Long parentId = umsMenu.getParentId();
		if(0==parentId) {
			umsMenu.setLevel(0);
		}else {
			umsMenu.setLevel(1);
		}
		umsMenu.setCreateTime(new Date());
		int insertSelective = umsMenuMapper.insertSelective(umsMenu);
		return insertSelective;
	}
	@Override
	public List<UmsMenu> selectUmsMenuByPage(Integer pageNum, Integer pageSize,Long parentId) {
		PageHelper.startPage(pageNum,pageSize);
		UmsMenuExample umsAdminExample=new UmsMenuExample();
        if(!StringUtils.isEmpty(parentId)){
            umsAdminExample.createCriteria().andParentIdEqualTo(parentId);
        }
        List<UmsMenu> umsAdmins = umsMenuMapper.selectByExample(umsAdminExample);
        return umsAdmins;
	}
	@Override
	public int updateUmsMenuHiddenById(Long id, int hidden) {
		UmsMenu umsMenu=new UmsMenu();
		umsMenu.setId(id);
		umsMenu.setHidden(hidden);
	        int i = umsMenuMapper.updateByPrimaryKeySelective(umsMenu);
	        return i;
	}
	@Override
	public int deleteUmsMenuById(Long id) {
		int i = umsMenuMapper.deleteByPrimaryKey(id);
        return  i;
	}
	@Override
	public UmsMenu selectUmsMenuById(Long id) {
		UmsMenu umsAdmin = umsMenuMapper.selectByPrimaryKey(id);
	        return umsAdmin;
	}
	@Override
	public int updateUmsMenuById(UmsMenu umsMenu) {
		int i = umsMenuMapper.updateByPrimaryKeySelective(umsMenu);
        return i;
	}
	
	 /**
     *方法三
     * @param list
     * @return
     */
    private static List<UmsMenuNode> toTree(List<UmsMenuNode> list) {
        List<UmsMenuNode> treeList = new ArrayList<UmsMenuNode>();
        for (UmsMenuNode tree : list) {
            if(tree.getParentId() == 0){
                treeList.add(tree);
            }
        }
        for (UmsMenuNode tree : list) {
            toTreeChildren(treeList,tree);
        }
        return treeList;
    }
 
    private static void toTreeChildren(List<UmsMenuNode> treeList, UmsMenuNode tree) {
        for (UmsMenuNode node : treeList) {
            if(tree.getParentId() == node.getId()){
                if(node.getChildren()== null){
                    node.setChildren(new ArrayList<UmsMenuNode>());
                }
                node.getChildren().add(tree);
            }
            if(node.getChildren() != null){
                toTreeChildren(node.getChildren(),tree);
            }
        }
    }
	@Override
	public List<UmsMenuNode> selectTreeNodeUmsMenu() {
		UmsMenuExample example=new UmsMenuExample();
		List<UmsMenu> selectByExample = umsMenuMapper.selectByExample(example);
		List<UmsMenuNode> UmsMenuNodeList=new ArrayList<>();
		BeanUtils.copyProperties(selectByExample, UmsMenuNodeList);
		List<UmsMenuNode> tree = toTree(UmsMenuNodeList);
		return tree;
	}


}
