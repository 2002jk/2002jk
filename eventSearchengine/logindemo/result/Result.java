package com.example.logindemo.result;

import java.util.Date;

public class Result implements Comparable<Result> {
    public Date time = null;
    public String Url = " ";
    public String title = "";
    public String content = "";

    public Result(Date thetime, String theUrl, String thetitle, String thecontent) {
        this.time = thetime;
        this.Url = theUrl;
        this.title = thetitle;
        this.content = thecontent;
    }

    public int compareTo(Result result) {
        return this.time.after(result.time) ? 1 : -1;
    }
}
