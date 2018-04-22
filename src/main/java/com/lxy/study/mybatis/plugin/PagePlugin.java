package com.lxy.study.mybatis.plugin;

import com.lxy.study.mybatis.util.PageInfo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;
import java.util.Properties;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.DefaultReflectorFactory;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

/**
 * Project: mybatis.study 分页插件
 *
 * @author Luo.xiaoyi
 * @date 2018/04/21
 *
 * 定义需要被拦截的对象，方法，以及方法的相关参数
 */
@Intercepts(@Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class,
    Integer.class}))
public class PagePlugin implements Interceptor {

  /**
   * 数据库类型
   */
  private static String dialect;
  /**
   * 针对哪些sql进行分页
   */
  private static String pageSqlId;

  @Override
  public Object intercept(Invocation invocation) throws Throwable {
    // 获取 StatementHandler 对象
    StatementHandler statementHandler = null;
    if (invocation.getTarget() instanceof StatementHandler) {
      statementHandler = StatementHandler.class.cast(invocation.getTarget());
    }

    // 获取元数据对象
    MetaObject metaObject = MetaObject
        .forObject(statementHandler, SystemMetaObject.DEFAULT_OBJECT_FACTORY,
            SystemMetaObject.DEFAULT_OBJECT_WRAPPER_FACTORY, new DefaultReflectorFactory());

    // 获取 MappedStatement
    MappedStatement mappedStatement = (MappedStatement) metaObject
        .getValue("delegate.mappedStatement");

    // 拿到sql的唯一标识
    String sqlId = mappedStatement.getId();

    // 匹配上了，才进行分页
    if (sqlId.matches(pageSqlId)) {
      // 获取原始的sql语句
      BoundSql boundSql = statementHandler.getBoundSql();
      String sql = boundSql.getSql();

      // 获取分页参数map.put("",PageInfo)
      Map<String, Object> params = (Map<String, Object>) boundSql.getParameterObject();
      if (params != null) {
        PageInfo pageInfo = (PageInfo) params.get("pageInfo");

        // 查询总数的sql
        String countSql = "select count(*) from (" + sql + ") a";

        // 查询总数执行
        Connection connection = (Connection) invocation.getArgs()[0];
        PreparedStatement ps = connection.prepareStatement(countSql);

        ParameterHandler ph = (ParameterHandler) metaObject.getValue("delegate.parameterHandler");
        ph.setParameters(ps);

        ResultSet rs = ps.executeQuery();
        if(rs.next()){
          pageInfo.setTotalNumber(rs.getInt(1));
        }

        // 拼接selectPage
        String pageSql = buildPageSql(sql,pageInfo);

        // 替换原来的sql
        metaObject.setValue("delegate.boundSql.sql",pageSql);

      }
    }

    // 继续执行下面的程序
    return invocation.proceed();
  }

  private String buildPageSql(String sql, PageInfo pageInfo) {
    if("mysql".equals(dialect)){
      return sql + " LIMIT " + pageInfo.getCurrentPageIndex() * pageInfo.getPageSize() + ", " + pageInfo.getPageSize();
    }

    return "";
  }

  @Override
  public Object plugin(Object target) {
    return Plugin.wrap(target, this);
  }

  @Override
  public void setProperties(Properties properties) {
    dialect = properties.getProperty("dialect");
    pageSqlId = properties.getProperty("pageSqlId");
  }
}
