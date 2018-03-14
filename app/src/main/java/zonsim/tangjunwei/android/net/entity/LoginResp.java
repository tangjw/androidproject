package zonsim.tangjunwei.android.net.entity;

/**
 * ^-^
 * Created by tang-jw on 11/16.
 */

public class LoginResp {
    
    /**
     * id : 2主键ID
     * userId : 16用户ID
     * identityType : 01登录类型，C103
     * identifier : 18519721520标识(手机号，账号或第三方唯一标识)
     * credential : null站内密码或站外token
     * appSecret : a9dade314b81c3590636ba6ff1759bb6	手机和手机号摘要加密
     * appUuid : 5CF41C916762343D5F28D5D5E534C31C 手机唯一识别码
     * remark : null 备注
     * gmtCreate : null 创建时间
     * gmtModify : null 最后修改时间
     */
    
    private int id;
    private int userId;
    private String identityType;
    private String identifier;
    private String credential;
    private String appSecret;
    private String appToken;
    private String appUuid;
    private String remark;
    private String gmtCreate;
    private String gmtModify;
    
    public String getAppToken() {
        return appToken;
    }
    
    public void setAppToken(String appToken) {
        this.appToken = appToken;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public int getUserId() {
        return userId;
    }
    
    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    public String getIdentityType() {
        return identityType;
    }
    
    public void setIdentityType(String identityType) {
        this.identityType = identityType;
    }
    
    public String getIdentifier() {
        return identifier;
    }
    
    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }
    
    public String getCredential() {
        return credential;
    }
    
    public void setCredential(String credential) {
        this.credential = credential;
    }
    
    public String getAppSecret() {
        return appSecret;
    }
    
    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }
    
    public String getAppUuid() {
        return appUuid;
    }
    
    public void setAppUuid(String appUuid) {
        this.appUuid = appUuid;
    }
    
    public String getRemark() {
        return remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
    }
    
    public String getGmtCreate() {
        return gmtCreate;
    }
    
    public void setGmtCreate(String gmtCreate) {
        this.gmtCreate = gmtCreate;
    }
    
    public String getGmtModify() {
        return gmtModify;
    }
    
    public void setGmtModify(String gmtModify) {
        this.gmtModify = gmtModify;
    }
}
