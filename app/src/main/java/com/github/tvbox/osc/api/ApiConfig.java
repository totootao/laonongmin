package com.github.tvbox.osc.bean;

import java.util.ArrayList;

/**
 * @author pj567
 * @date :2021/1/12
 * @description:
 */
public class LiveChannelItem {
    /**
     * channelIndex : 频道索引号
     * channelNum : 频道名称
     * channelSourceNames : 频道源名称
     * channelUrls : 频道源地址
     * sourceIndex : 频道源索引
     * sourceNum : 频道源总数
     */
    private int channelIndex;
    private int channelNum;
    private String channelName;
    private ArrayList<String> channelSourceNames;
    private ArrayList<String> channelUrls;
    private ArrayList<Integer> channelDurations;
    private int duration = 0;
    private int seekto = 0;
    public int sourceIndex = 0;
    public int sourceNum = 0;
    public boolean include_back = false;

    public void setinclude_back(boolean include_back) {
        this.include_back = include_back;
    }

    public boolean getinclude_back() {
        return include_back;
    }

    public void setChannelIndex(int channelIndex) {
        this.channelIndex = channelIndex;
    }

    public int getChannelIndex() {
        return channelIndex;
    }

    public void setChannelNum(int channelNum) {
        this.channelNum = channelNum;
    }

    public int getChannelNum() {
        return channelNum;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getChannelName() {
        return channelName;
    }

    public ArrayList<String> getChannelUrls() {
        return channelUrls;
    }

    public void setChannelUrls(ArrayList<String> channelUrls) {
        this.channelUrls = channelUrls;
        sourceNum = channelUrls.size();
    }
    public int getSeekto() {
        return seekto;
    }

    public void setSeekto(int seekto) {
        this.seekto = seekto;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
    public ArrayList<Integer> setChannelDurations() {
        return channelDurations;
    }

    public void setChannelDurations(ArrayList<Integer> channelDurations) {
        this.channelUrls = channelUrls;
    }
    public void preSource() {
        sourceIndex--;
        if (sourceIndex < 0) sourceIndex = sourceNum - 1;
    }
    public void nextSource() {
        sourceIndex++;
        if (sourceIndex == sourceNum) sourceIndex = 0;
    }
    public void lunboSource() {
       if(duration == 0){return;}
       int time = Math.toIntExact((System.currentTimeMillis() / 1000));
       time = time % this.duration;
       int durations =0;
       int i =0;
       while(durations < time){
           durations += channelDurations.get(i++);
       }
       sourceIndex = i;
       seekto = time + channelDurations.get(i) - durations;
       if (sourceIndex == sourceNum) sourceIndex = 0;
    }
    public void setSourceIndex(int sourceIndex) {
        this.sourceIndex = sourceIndex;
    }

    public int getSourceIndex() {
        return sourceIndex;
    }

    public String getUrl() {
        return channelUrls.get(sourceIndex);
    }

    public int getSourceNum() {
        return sourceNum;
    }

    public ArrayList<String> getChannelSourceNames() {
        return channelSourceNames;
    }

    public void setChannelSourceNames(ArrayList<String> channelSourceNames) {
        this.channelSourceNames = channelSourceNames;
    }

    public String getSourceName() {
        return channelSourceNames.get(sourceIndex);
    }
}
