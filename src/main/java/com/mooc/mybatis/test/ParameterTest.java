package com.mooc.mybatis.test;

import com.mooc.mybatis.bean.Yuer;
import com.mooc.mybatis.dao.YuerMapper;
import com.mooc.mybatis.service.YuerService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.Jedis;

import java.io.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-mybatis.xml" })
public class ParameterTest {

    @Autowired
    private YuerService yuerService;

    public void dealJSONObject(JSONObject jsonObject) throws IOException {
        String question_answer_author = jsonObject.getString("question_answer_author");
        String question_answer_content = jsonObject.getString("question_answer_content");
        if (question_answer_author.contains("*")){
            question_answer_author = question_answer_author.replace("*", "");
        }
        if (question_answer_author.contains("?")){
            question_answer_author = question_answer_author.replace("?", "");
        }
        if (question_answer_author.contains("/")){
            question_answer_author = question_answer_author.replace("/", "");
        }
        if (question_answer_author.contains(":")){
            question_answer_author = question_answer_author.replace(":", "");
        }
        if (question_answer_author.contains("{")){
            question_answer_author = question_answer_author.replace("{", "");
        }
        File file = new File("H:\\实验数据\\专家回答问题集\\" + question_answer_author + ".txt");
        FileWriter fw = new FileWriter(file,true);
        PrintWriter pw = new PrintWriter(fw);
        try {
            if (!file.exists()){
                file.createNewFile();
                fw.write(question_answer_content);
                fw.flush();
            }else {
                pw.print(question_answer_content);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (fw != null){
                try {
                    fw.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }

            if (pw != null){
                try {
                    pw.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }

    }


    public void dealCategoryJSONObject(JSONObject jsonObject, String question_title, String question_detail, String question_categories){

    }

//    @Test
//    public void test1() throws IOException {
//        for (int id = 400000; id < 449695; id++){
//            Yuer yuer = yuerService.getFromYuerById(id);
//            String questionAnswer = yuer.getQuestionAnswer();
//            JSONArray jsonArray = JSONArray.fromObject(questionAnswer);
//            for (Object object : jsonArray){
//                JSONObject jsonObject = JSONObject.fromObject(object);
//                dealJSONObject(jsonObject);
//            }
//        }
//    }

    @Test
    public void test2() throws IOException {
        for (int id = 1; id <= 449694; id ++){
            Yuer yuer = yuerService.getFromYuerById(id);
            String question_title = yuer.getQuestionTitle();
            String question_detail = yuer.getQuestionDetail();
            String questionAnswer = yuer.getQuestionAnswer();
            String question_categories = yuer.getQuestionCategories();
            JSONArray jsonArray = JSONArray.fromObject(questionAnswer);
            String categorieString = null;
            String question_answer_content = null;
            for (Object object : jsonArray){
                JSONObject jsonObject = JSONObject.fromObject(object);
                question_answer_content += jsonObject.getString("question_answer_content");
            }
            categorieString = question_title + question_detail + question_answer_content;

            if (question_categories.contains("[")){
                question_categories = question_categories.replace("[", "");
            }
            if (question_categories.contains("]")){
                question_categories = question_categories.replace("]", "");
            }
            if (question_categories.contains("\"")){
                question_categories = question_categories.replace("\"", "");
            }

            File file = new File("H:\\实验数据\\分类数据\\" + question_categories + ".txt");
            FileWriter fw = new FileWriter(file,true);
            PrintWriter pw = new PrintWriter(fw);
            try {
                if (!file.exists()){
                    file.createNewFile();
                    fw.write(categorieString);
                    fw.flush();
                }else {
                    pw.print(categorieString);
                }
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                if (fw != null){
                    try {
                        fw.close();
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }

                if (pw != null){
                    try {
                        pw.close();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }

        }
    }

    @Test
    public void jedisTest(){
        Jedis jedis= new Jedis("106.15.181.94" ,6379);
        jedis.auth("Feng1995312");
        System.out.println(jedis.ping());
    }



}
