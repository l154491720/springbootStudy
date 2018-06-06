package ch2.el;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by qilin.liu on 2018/4/10.
 */
@Service
public class DemoService {

    @Value("其他类的属性") //1此处为注入普通字符串
    private String another;

    public String getAnother() {
        return another;
    }

    public void setAnother(String another) {
        this.another = another;
    }
}
