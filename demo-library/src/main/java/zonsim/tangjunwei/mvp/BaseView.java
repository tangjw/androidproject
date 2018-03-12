package zonsim.tangjunwei.mvp;

/**
 * BaseView
 * Created by tang-jw on 10/27.
 */

public interface BaseView {
    
    void toastMsg(String message);
    
    void showProgressView(String message);
    
    void hideProgressView();
    
}
