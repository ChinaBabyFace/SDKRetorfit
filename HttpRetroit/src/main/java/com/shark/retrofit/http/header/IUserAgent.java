/**
 * IUserAgent.java 2015-4-29
 * 龙德恒方科技发展有限公司(c) 2015 - 2015 。
 */
package com.shark.retrofit.http.header;

import android.content.Context;

/**
 * <b>IUserAgent。</b>
 * <p><b>详细说明：</b></p>
 * <!-- 在此添加详细说明 -->
 * 无。
 * <p><b>修改列表：</b></p>
 * <table width="100%" cellSpacing=1 cellPadding=3 border=1>
 * <tr bgcolor="#CCCCFF"><td>序号</td><td>作者</td><td>修改日期</td><td>修改内容</td></tr>
 * <!-- 在此添加修改列表，参考第一行内容 -->
 * <tr><td>1</td><td>Renyuxiang</td><td>2015-4-29 下午2:58:19</td><td>建立类型</td></tr>
 * <p>
 * </table>
 *
 * @author Renyuxiang
 * @version 1.0
 * @since 1.0
 */
public interface IUserAgent {
    Context getContext();

    String generateUA();
}
