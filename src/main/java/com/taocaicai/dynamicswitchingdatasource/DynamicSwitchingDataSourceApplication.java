package com.taocaicai.dynamicswitchingdatasource;

import com.taocaicai.dynamicswitchingdatasource.aop.DynamicDataSourceAnnotationAdvisor;
import com.taocaicai.dynamicswitchingdatasource.aop.DynamicDataSourceAnnotationInterceptor;
import com.taocaicai.dynamicswitchingdatasource.register.DynamicDataSourceRegister;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Import(DynamicDataSourceRegister.class)
@MapperScan("com.taocaicai.dynamicswitchingdatasource.dao")
@EnableTransactionManagement
@SpringBootApplication
public class DynamicSwitchingDataSourceApplication {

  @Bean
  public DynamicDataSourceAnnotationAdvisor dynamicDatasourceAnnotationAdvisor() {
    return new DynamicDataSourceAnnotationAdvisor(new DynamicDataSourceAnnotationInterceptor());
  }
  public static void main(String[] args) {
    SpringApplication.run(DynamicSwitchingDataSourceApplication.class, args);
  }
}
