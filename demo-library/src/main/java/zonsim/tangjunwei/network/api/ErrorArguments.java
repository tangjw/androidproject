package zonsim.tangjunwei.network.api;

/**
 * ^-^
 * Created by tang-jw on 2017/12/18.
 */

public class ErrorArguments {
    
    /**
     * message : 电子邮箱地址有误
     * messageTemplate : 电子邮箱地址有误
     * path : SignUpResource$$EnhancerBySpringCGLIB$$4bc0de30.submitorder.arg2.billBean.email
     * invalidValue : jfjfj
     */
    
    private String message;
    private String messageTemplate;
    private String path;
    private String invalidValue;
    
    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    
    public String getMessageTemplate() {
        return messageTemplate;
    }
    
    public void setMessageTemplate(String messageTemplate) {
        this.messageTemplate = messageTemplate;
    }
    
    public String getPath() {
        return path;
    }
    
    public void setPath(String path) {
        this.path = path;
    }
    
    public String getInvalidValue() {
        return invalidValue;
    }
    
    public void setInvalidValue(String invalidValue) {
        this.invalidValue = invalidValue;
    }
    
    @Override
    public String toString() {
        return "ErrorArguments{" +
                "message='" + message + '\'' +
                ", messageTemplate='" + messageTemplate + '\'' +
                ", path='" + path + '\'' +
                ", invalidValue='" + invalidValue + '\'' +
                '}';
    }
}
