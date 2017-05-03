package cw.dantang.Model;

/**
 * Created by cw on 2017/5/3.
 */

public class CategoryModel {


    /**
     * group_id : 1
     * icon_url : http://7fvaoh.com3.z0.glb.qiniucdn.com/image/150715/rvgzyw5sm.png-pw144
     * id : 12
     * items_count : 23
     * name : 创意
     * order : 0
     * status : 0
     */

    private int group_id;
    private String icon_url;
    private int id;
    private int items_count;
    private String name;
    private int order;
    private int status;

    public int getGroup_id() {
        return group_id;
    }

    public void setGroup_id(int group_id) {
        this.group_id = group_id;
    }

    public String getIcon_url() {
        return icon_url;
    }

    public void setIcon_url(String icon_url) {
        this.icon_url = icon_url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getItems_count() {
        return items_count;
    }

    public void setItems_count(int items_count) {
        this.items_count = items_count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
