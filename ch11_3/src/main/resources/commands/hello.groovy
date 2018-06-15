package commands

import org.crsh.cli.Command
import org.crsh.cli.Usage
import org.crsh.command.InvocationContext

class hello{
    @Usage("say hello")//1 使用@Usage注解解释该命令的用途
    @Command//2 使用@Command注解解释当前是一个CRash命令。
    def main(InvocationContext context){
        //3 获得Spring Boot版本，注意Groovy的方法和变量声明关键字为def
        def bootVersion = context.attributes['spring.boot.version'];
        //4 获得spring框架的版本
        def springVersion = context.attributes['spring.version'];
        //5 返回命令执行结果
        return "Hello your Spring Boot Version is"+ bootVersion+", your " +
                "Spring Framework version is "+springVersion
    }
}