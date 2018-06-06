package com.wisely.highlight_springmvc4.domain;

/**
 * Created by qilin.liu on 2018/4/14.
 */
public class DemoObj {
    private Long id;
    private String name;

    public DemoObj() { //1 jackson对象和json对象做转换时一定需要此空构造函数
        super();
    }

    public DemoObj(Long id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
