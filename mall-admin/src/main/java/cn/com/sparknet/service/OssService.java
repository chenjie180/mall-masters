package cn.com.sparknet.service;

import cn.com.sparknet.dto.OssCallbackResult;
import cn.com.sparknet.dto.OssPolicyResult;

import javax.servlet.http.HttpServletRequest;

/**oss上传管理Service
 * @author shkstart
 * @create 2020-08-14 11:49
 */
public interface OssService {
    /**
     * oss上传策略生成
     */
    OssPolicyResult policy();

    /**
     * oss上传成功回调
     */
    OssCallbackResult callback(HttpServletRequest request);
}
