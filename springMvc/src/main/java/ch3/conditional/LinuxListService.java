package ch3.conditional;

/**
 * Created by qilin.liu on 2018/4/12.
 */
public class LinuxListService implements ListService {
    @Override
    public String showListCmd() {
        return "ls";
    }
}
