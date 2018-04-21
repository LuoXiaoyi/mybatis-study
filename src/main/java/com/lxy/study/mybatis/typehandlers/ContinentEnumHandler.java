package com.lxy.study.mybatis.typehandlers;

import com.lxy.study.mybatis.domain.models.Continent;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

/**
 * Project: mybatis.study
 *
 * @author Luo.xiaoyi
 * @date 2018/04/21
 */
public class ContinentEnumHandler implements TypeHandler<Continent> {

  @Override
  public void setParameter(PreparedStatement ps, int i, Continent parameter, JdbcType jdbcType)
      throws SQLException {
    if (parameter != null) {
      ps.setString(i, parameter.toString());
    }
  }

  @Override
  public Continent getResult(ResultSet rs, String columnName) throws SQLException {
    String c = rs.getString(columnName);
    if (c != null && !c.isEmpty()) {
      return Continent.fromName(c);
    }
    return null;
  }

  @Override
  public Continent getResult(ResultSet rs, int columnIndex) throws SQLException {
    String c = rs.getString(columnIndex);
    if (c != null && !c.isEmpty()) {
      return Continent.fromName(c);
    }
    return null;
  }

  @Override
  public Continent getResult(CallableStatement cs, int columnIndex) throws SQLException {
    String c = cs.getString(columnIndex);
    if (c != null && !c.isEmpty()) {
      return Continent.fromName(c);
    }
    return null;
  }
}
