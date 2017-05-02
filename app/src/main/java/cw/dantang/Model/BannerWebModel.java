package cw.dantang.Model;

import java.util.List;

/**
 * Created by cw on 2017/5/2.
 */

public class BannerWebModel {

    /**
     * content_url : http://dantang.liwushuo.com/posts/73/content
     * cover_image_url : http://7fvaoh.com3.z0.glb.qiniucdn.com/image/141208/xesdvgpan.jpg-w720
     * created_at : 1436148000
     * id : 73
     * label_ids : []
     * liked : false
     * likes_count : 3993
     * published_at : 1434429043
     * share_msg : 身在北京，热爱生活的小编觉得最幸福的一件事就是有宜家了，每次去到宜家都买买买根本停不下来，而且还能get&radic;到很多家居新技能，尤其是收纳和装扮。网上甚至有人把宜家比作&ldquo;成人的游乐场&rdquo;，在宜家常常能看到温馨的床上有人睡着，就算是为了一块钱的超值甜筒，都要去宜家逛一逛。今天小编特意给大家搜集了宜家的性价比好物，价格便宜又实用，而且大部分小编和小伙伴都剁手买过，良心推荐！快点买买买送给自己和身边热爱生活的Ta吧。
     * short_title : 宜家系好物
     * status : 0
     * title : 宜家性价比超值好物大盘点
     * updated_at : 1417838453
     * url : http://dantang.liwushuo.com/posts/73
     */

    private String content_url;
    private String cover_image_url;
    private int created_at;
    private int id;
    private boolean liked;
    private int likes_count;
    private int published_at;
    private String share_msg;
    private String short_title;
    private int status;
    private String title;
    private int updated_at;
    private String url;
    private List<?> label_ids;

    public String getContent_url() {
        return content_url;
    }

    public void setContent_url(String content_url) {
        this.content_url = content_url;
    }

    public String getCover_image_url() {
        return cover_image_url;
    }

    public void setCover_image_url(String cover_image_url) {
        this.cover_image_url = cover_image_url;
    }

    public int getCreated_at() {
        return created_at;
    }

    public void setCreated_at(int created_at) {
        this.created_at = created_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isLiked() {
        return liked;
    }

    public void setLiked(boolean liked) {
        this.liked = liked;
    }

    public int getLikes_count() {
        return likes_count;
    }

    public void setLikes_count(int likes_count) {
        this.likes_count = likes_count;
    }

    public int getPublished_at() {
        return published_at;
    }

    public void setPublished_at(int published_at) {
        this.published_at = published_at;
    }

    public String getShare_msg() {
        return share_msg;
    }

    public void setShare_msg(String share_msg) {
        this.share_msg = share_msg;
    }

    public String getShort_title() {
        return short_title;
    }

    public void setShort_title(String short_title) {
        this.short_title = short_title;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(int updated_at) {
        this.updated_at = updated_at;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<?> getLabel_ids() {
        return label_ids;
    }

    public void setLabel_ids(List<?> label_ids) {
        this.label_ids = label_ids;
    }
}
