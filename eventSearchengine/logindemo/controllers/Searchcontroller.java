package com.example.logindemo.controllers;
import com.example.logindemo.entity.Event;
import com.example.logindemo.entity.Theme;
import com.example.logindemo.service.*;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.example.logindemo.constant.*;
import com.example.logindemo.result.Result;
import com.example.logindemo.Utils.Utils;
import com.example.logindemo.constant.CrawlerConstant;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.regex.*;
@CrossOrigin
@RestController
public class Searchcontroller {

    @Autowired
    private EventService eventService;

    @Autowired
    private ThemeService themeService;



    @RequestMapping(value = "/search/{target}")
    @ResponseBody
    public JSONArray handleSearch(@PathVariable String target)throws IOException{
        List<Theme>themes=themeService.findAll();
        String thetarget=".*"+target+".*";
        int themeid=0;
        boolean needTosearch=true;
        boolean isMatch=false;
        int size=themes.size();
        System.out.println(size);
        for(int i=0;i<size;i++){
            isMatch=Pattern.matches(thetarget,themes.get(i).getTheme());
            System.out.println(isMatch);
            if(isMatch){
                needTosearch=false;
                themeid=themes.get(i).getThemeid();
                break;
            }
        }

        if(needTosearch){
          String mycookie = CrawlerConstant.TEST_COOKIE;
          int searchLength = CrawlerConstant.SEARCH_LENGTH_TEST;
          List<Result> resultUrl = new ArrayList();
          HashMap<String, String> cookies = Utils.convertCookie(mycookie);
          String Urlbase = CrawlerConstant.SOURCE_BAIDU+target+"&pn=";

          for(int j = 0; j < searchLength; ++j) {
            String Url = Urlbase + Integer.toString(j) + Integer.toString(0);
         //   System.out.println(Url);
            Document document = Jsoup.connect(Url).cookies(cookies).get();
         //   System.out.println(document);
            Elements elements = document.select(".result");
         //   System.out.println(elements.get(0));

            for(int i = 0; i < elements.size(); ++i) {
                String urli = ((Element)elements.get(i)).attr(CrawlerConstant.BAIDU_RESULT_URL_ATTR_NAME);
                Elements title = ((Element)elements.get(i)).select(CrawlerConstant.BAIDU_RESULT_TITLE_CSS_QUERY);
                Elements content = ((Element)elements.get(i)).select(CrawlerConstant.BAIDU_RESULT_CONTENT_CSS_QUERY);
                String thecontent = content.text();
                String elementTitle = title.text();
                if (urli != "") {
                   // System.out.println(((Element)elements.get(i)).attr(CrawlerConstant.BAIDU_RESULT_URL_ATTR_NAME));
                    Elements elementsTime = ((Element)elements.get(i)).select(CrawlerConstant.BAIDU_RESULT_TIME_CLASS_NAME);
                    if (elementsTime.size() == 1) {
                        String dateChinese = ((Element)elementsTime.get(0)).text();
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
                        Date urlDate = null;

                        try {
                            urlDate = simpleDateFormat.parse(dateChinese);
                        } catch (ParseException var29) {
                           // System.out.println(dateChinese);
                            String regEx = "[^0-9]";
                            Pattern pattern = Pattern.compile(regEx);
                            Matcher matcher = pattern.matcher(dateChinese);
                            int num = Integer.parseInt(matcher.replaceAll("").trim());
                           // System.out.println(num);
                            Calendar calendar = Calendar.getInstance();
                            String hour = ".*小时.*";
                            String day = ".*天.*";
                            String minute = ".*分钟.*";
                            if (Pattern.matches(hour, dateChinese)) {
                                calendar.add(10, -1 * num);
                            }

                            if (Pattern.matches(day, dateChinese)) {
                                calendar.add(5, -1 * num);
                            }

                            if (Pattern.matches(minute, dateChinese)) {
                                calendar.add(12, -1 * num);
                            }

                            urlDate = calendar.getTime();
                        }

                        resultUrl.add(new Result(urlDate, urli, elementTitle, thecontent));
                    }
                }
            }
        }

        List<Result> effectiveUrls = Utils.filterUrl(resultUrl);
     //   System.out.println(resultUrl.size());
     //   System.out.println(effectiveUrls.size());
        Collections.sort(effectiveUrls);
        effectiveUrls.forEach((r) -> {
          //  System.out.println(r.time);
          //  System.out.println(r.title);
          //  System.out.println(r.Url);
            String path = "./app.log";

            try {
                FileUtils.writeStringToFile(new File(path), r.content + "\n", StandardCharsets.UTF_8, true);
                FileUtils.writeStringToFile(new File(path), r.Url + "\n", StandardCharsets.UTF_8, true);
            } catch (IOException var3) {
                var3.printStackTrace();
            }

        });

           themeService.createTheme(target);
           Theme theme=themeService.findbyTheme(target);
            eventService.eventStore(effectiveUrls,theme.getThemeid());
            List<Event>events=eventService.findEventsbyThemeid(theme.getThemeid());
            int len=events.size();
            JSONArray array=new JSONArray();
            for(int i=0;i<len;i++){
                JSONArray array1=new JSONArray();
                Event event=events.get(i);
                array1.add(event.getTitle());
                array1.add(event.getContent());
                array1.add(event.getUrl());
                array1.add(event.getTime());
                array.add(array1);
            }
           // System.out.println(array);
            return array;
    }
    else{
        List<Event>events=eventService.findEventsbyThemeid(themeid);
        int len=events.size();
        JSONArray array=new JSONArray();
        for(int i=0;i<len;i++){
            JSONArray array1=new JSONArray();
            Event event=events.get(i);
            array1.add(event.getTitle());
            array1.add(event.getContent());
            array1.add(event.getUrl());
            array1.add(event.getTime());
            array.add(array1);
        }
           // System.out.println(array);
            return array;
        }




    }
}
