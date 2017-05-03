package cw.dantang.Model;

/**
 * Created by cw on 2017/5/3.
 */

public class CategoryBannerModel {


    /**
     * banner_image_url : http://7fvaoh.com3.z0.glb.qiniucdn.com/image/150809/a5h1ygeaz.jpg-w300
     * cover_image_url : http://7fvaoh.com3.z0.glb.qiniucdn.com/image/150809/xcfrysr3i.jpg-w720
     * created_at : 1439086194
     * id : 4
     * posts_count : 3
     * status : 0
     * subtitle : 实用神器合辑
     * title : 生活中的实用神器
     * updated_at : 1439086194
     */

    private String banner_image_url;
    private String cover_image_url;
    private int created_at;
    private int id;
    private int posts_count;
    private int status;
    private String subtitle;
    private String title;
    private int updated_at;

    public String getBanner_image_url() {
        return banner_image_url;
    }

    public void setBanner_image_url(String banner_image_url) {
        this.banner_image_url = banner_image_url;
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

    public int getPosts_count() {
        return posts_count;
    }

    public void setPosts_count(int posts_count) {
        this.posts_count = posts_count;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
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
}
