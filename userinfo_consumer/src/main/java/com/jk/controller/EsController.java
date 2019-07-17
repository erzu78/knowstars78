package com.jk.controller;

import com.jk.repository.CurRepository;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * @author Administrator
 * @title: EsController
 * @projectName knowstars78
 * @description: TODO
 * @date 2019/7/16 001616:49
 */
@RestController
public class EsController {

    @Autowired
    private CurRepository curRepository;


    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @GetMapping("queryInf")
    public List queryCurr(String inftitle){
        //获取到当前es的客户端 相当于jdbc加载驱动创建连接
        Client client = elasticsearchTemplate.getClient();

        //创建es查询对象 相当于jdbc中创建preparestatement类似
        SearchRequestBuilder searchRequestBuilder = client.prepareSearch("information").setTypes("action");
        //为当前查询添加where条件
        if(inftitle!=null&&inftitle!=""){
            //为当前查询添加where条件
            //matchQuery 第一个参数为要查询的字段 第二个为查询条件的值
            searchRequestBuilder.setQuery(QueryBuilders.matchQuery("inftitle",inftitle));

            //创建一个高亮对象
            HighlightBuilder highlightBuilder = new HighlightBuilder();

            highlightBuilder.field("inftitle").preTags("<span style='color:red;font-weight:bold;font-size:15px;'>").postTags("</span>");

            //为searchRequestBuilder设置高亮对象
            searchRequestBuilder.highlighter(highlightBuilder);
        }
        //执行当前查询命令 获取到查询结果
        SearchResponse searchResponse = searchRequestBuilder.get();
        //获取到查询命中结果集
        SearchHits hits = searchResponse.getHits();
        //获取到结果集迭代器 对结果集遍历输出
        Iterator<SearchHit> iterator = hits.iterator();
        List dataList = new ArrayList();
        //判断集合中有无下一个元素
        while (iterator.hasNext()){

            SearchHit next = iterator.next();

            //把返回结果转成一个map集合
            Map<String, Object> sourceAsMap = next.getSourceAsMap();



            if(inftitle!=null&&inftitle!=""){
                //获取到所有高亮字段转为一个map集合 key高亮的字段 值为高亮之后的结果
                Map<String, HighlightField> highlightFields = next.getHighlightFields();

                //获取到高亮显示之后的内容
                HighlightField userName = highlightFields.get("inftitle");


                //拿到高亮内容 获取到的是一个数组 取下标为0的
                Text[] fragments = userName.fragments();


                //获取到结果集的json字符串
                //next.getSourceAsString();

                //使用高亮内容 替换非高亮内容
                sourceAsMap.put("inftitle",String.valueOf(fragments[0]));
            }

            //把查询出的内容转入list集合中
            dataList.add(sourceAsMap);
        }





        return dataList;
    }


}
