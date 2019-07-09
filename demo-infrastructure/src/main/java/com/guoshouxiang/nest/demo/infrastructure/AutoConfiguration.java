package com.guoshouxiang.nest.demo.infrastructure;

import com.guohuoxiang.nest.mybatis.pagination.PageListPlugin;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Configuration
@ComponentScan
@MapperScan("com.guoshouxiang.nest.demo.infrastructure")
public class AutoConfiguration {

    @Bean
    public PageListPlugin getPageListPlugin() {
        return new PageListPlugin();
    }

    @Bean
    public Mapper mapper(@Value(value = "classpath*:dozer/*mapper.xml") Resource[] resourceArray) throws IOException {
        List<String> mappingFileUrlList = new ArrayList<>();
        for (Resource resource : resourceArray) {
            mappingFileUrlList.add(String.valueOf(resource.getURL()));
        }
        DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();
        dozerBeanMapper.setMappingFiles(mappingFileUrlList);
        return dozerBeanMapper;
    }

}
