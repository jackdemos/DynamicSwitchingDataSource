package com.taocaicai.dynamicswitchingdatasource.conf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class DynamicDataSourceContextHolder {
  private static Logger logger = LoggerFactory.getLogger(DynamicDataSourceContextHolder.class);
  /** 存储已经注册的数据源的key */
  public static List<String> dataSourceIds = new ArrayList<>();

  private static ThreadLocal<String> currentDataSource = new ThreadLocal<>();

  public static String getDataSourceRouterKey() {
    return currentDataSource.get();
  }

  public static void setDataSourceRouterKey(String dataSourceRouterKey) {
    logger.info("切换至{}数据源", dataSourceRouterKey);
    currentDataSource.set(dataSourceRouterKey);
  }
  /** 设置数据源之前一定要先移除 */
  public static void removeDataSourceRouterKey() {
    currentDataSource.remove();
  }

  /**
   * 判断指定DataSrouce当前是否存在
   *
   * @param dataSourceId
   * @return
   */
  public static boolean containsDataSource(String dataSourceId) {
    return dataSourceIds.contains(dataSourceId);
  }
}
