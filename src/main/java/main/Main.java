package main;

import com.google.gson.Gson;
import org.podcast2.Channel;
import org.podcast2.Item;
import org.podcast2.Podcast2;

import java.util.List;

public class Main implements Podcast2 {

    /**
     * 将对象转换成json字符串
     */
    private Gson gson;
    /**
     * 主页链接
     */
    private String url;

    /**
     * video 或 audio
     */
    private String type;

    /**
     * 根据集合首个元素进行判断：
     * -1：最近30集
     *  0：最新一集
     *  1：自定义剧集
     *
     *
     */
    private List<Integer> selectEpisode;

    public Main(String url, String type) {
        this.url = url;
        this.type = type;
        this.gson = new Gson();
    }

    public Main(String url, String type, List<Integer> selectEpisode) {
        this.url = url;
        this.type = type;
        this.selectEpisode = selectEpisode;
        this.gson = new Gson();
    }

    /**
     * 节目列表
     * @return
     */
    @Override
    public List<String> items() {
        return null;
    }

    /**
     * 封装频道的信息
     * @return json字符串
     */
    @Override
    public String channel() {
        //封装频道信息
        Channel channel = new Channel();
        channel.setTitle("频道名称");
        channel.setStatus(1);//状态码1和0，用于判断频道是否还继续更新
        channel.setImage("频道头像");
        channel.setLink("频道主页链接");
        channel.setCategory("频道类别");
        channel.setDescription("频道描述");
        channel.setAuthor("频道作者");

        //转换成json字符串并返回
        return gson.toJson(channel);
    }

    /**
     * 最新的节目
     * @return json字符串
     */
    @Override
    public String latestItem() {
        //封装节目信息
        Item latestitem = new Item();
        latestitem.setLink("该页面链接");
        latestitem.setImage("节目封面");
        latestitem.setDescription("节目描述");
        latestitem.setTitle("节目标题");
        latestitem.setEnclosure("视频资源链接");
        latestitem.setCreateTime(System.currentTimeMillis());//时间毫秒值
        latestitem.setCount(1021);//用于比较是否有新内容更新
        latestitem.setDuration(600);//节目时长，单位秒

        //转换成json字符串并返回
        return gson.toJson(latestitem);
    }
}


