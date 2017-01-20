package xyz.codingmentor.webshop.dto;

/**
 *
 * @author Ádám
 * @param <T>
 */
public class ResultDTO<T> {
    private ResultType result;
    private T message;

    public ResultDTO() {
        //default constructor
    }

    public ResultDTO(ResultType result, T message) {
        this.result = result;
        this.message = message;
    }

    public ResultType getResult() {
        return result;
    }

    public void setResult(ResultType result) {
        this.result = result;
    }

    public T getMessage() {
        return message;
    }

    public void setMessage(T message) {
        this.message = message;
    }
}
