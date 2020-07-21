package cn.com.sparknet.dao;

import java.util.List;

import cn.com.sparknet.model.OmsOrderOperateHistory;

public interface OmsOrderOperateHistoryDao {
	
public void insertBatch(List<OmsOrderOperateHistory> historyList);
}
