package cn.huhuiyu.demo.springboot.mybatis.exception;

/**
 * 
 * @author huhuiyu
 *
 */
public class MyException extends Exception {

    private static final long serialVersionUID = -9218716733248057869L;

    private int code;

    public MyException() {
        this("服务器忙，请稍候重试");
    }

    public MyException(String message) {
        this(message, 500);
    }

    public MyException(String message, int code) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }

}
