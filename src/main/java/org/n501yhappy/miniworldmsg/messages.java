package org.n501yhappy.miniworldmsg;

import java.util.ArrayList;
import java.util.List;

public class messages {
    public static List<String> server_stop;
    public static List<String> kick;
    public static void full_list(){
        server_stop = new ArrayList<>();
        kick = new ArrayList<>();
        server_stop.add("麻麻叫房主吃饭了,关闭了房间");
        server_stop.add("房主被外星人掳走了，断开连接！");
        kick.add("房主好像不喜欢你，把你请出了房间!!");
        kick.add("你被房主请离了当前房间(0)");
    }
}
