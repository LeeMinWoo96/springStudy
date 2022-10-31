package kr.co.acomp.hello.exception;

//사용자 정의 예외는 예외를 상속받아야함
public class BizException extends RuntimeException {
    public BizException(){
        super();
    }
    public  BizException(Throwable throwable){
        super(throwable);
    }
    public BizException(String msg){
        super(msg);
    }
}
