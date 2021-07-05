package com.taocaicai.dynamicswitchingdatasource.conf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author: Oakley
 * @version: 1.0.0
 * @description: 动态数据源路由配置
 */
public class DynamicRoutingDataSource extends AbstractRoutingDataSource {

  private static Logger logger = LoggerFactory.getLogger(DynamicRoutingDataSource.class);

  @Override
  protected Object determineCurrentLookupKey() {
    String dataSourceName = DynamicDataSourceContextHolder.getDataSourceRouterKey();
    logger.info("当前数据源是:{}", dataSourceName);
    return DynamicDataSourceContextHolder.getDataSourceRouterKey();
  }
}
