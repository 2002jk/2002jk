package com.example.logindemo.Utils;

import com.example.logindemo.result.Result;
import com.example.logindemo.constant.CrawlerConstant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {
    public Utils() {
    }

    public static HashMap<String, String> convertCookie(String cookie) {
        HashMap<String, String> cookiesMap = new HashMap();
        String[] items = cookie.trim().split(";");
        String[] var3 = items;
        int var4 = items.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            String item = var3[var5];
            cookiesMap.put(item.split("=")[0], item.split("=")[1]);
        }

        return cookiesMap;
    }

    public static List<Result> filterUrl(List<Result> resultUrl) {
        List<Result> effectiveUrls = new ArrayList();
        List<String> patterns = CrawlerConstant.FILTER_PATTERNS;

        for(int i = 0; i < resultUrl.size(); ++i) {
            boolean isMatch = false;

            for(int j = 0; j < patterns.size() && !isMatch; ++j) {
                isMatch = isMatch || Pattern.matches((String)patterns.get(j), ((Result)resultUrl.get(i)).Url);
            }

            if (!isMatch) {
                effectiveUrls.add(resultUrl.get(i));
            }
        }

        Collections.sort(effectiveUrls);
        return effectiveUrls;
    }

    public static String urlRegexGoogle(String line) {
        String pattern = "(http|https)://(www.)?(\\w+(\\.)?)+";
        String result = "";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(line);
        if (m.find()) {
            result = m.group(0);
            result = line.substring(m.start());
        }

        return result;
    }
}