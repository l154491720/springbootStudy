package ch2.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * Created by qilin.liu on 2018/4/10.
 */
@Service
@Scope("prototype") //1声明Scope为Prototype
public class DemoPrototypeService {
}
