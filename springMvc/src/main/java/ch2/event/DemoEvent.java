package ch2.event;

import org.springframework.context.ApplicationEvent;

/**
 * Created by qilin.liu on 2018/4/11.
 */
public class DemoEvent extends ApplicationEvent {


    private static final long serialVersionUID = -482523558307405787L;

    private String msg;
    /**
     * Create a new ApplicationEvent.
     *
     * @param source the component that published the event (never {@code null})
     */
    public DemoEvent(Object source, String msg) {
        super(source);
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
